
/**
 * Preference file version 110624
 * 
 * @author: JaneElliot
 */
import java.util.Scanner;
import java.util.*;

public class Player
{
  // Instance variables
  private double moneySaved;
  private double weeklyIncome;
  private ArrayList<Job> jobs = new ArrayList<Job>();
  private ClassSchedule classSchedule;
  private Grades grades;
  private double weeklyExpenses;
  private double hoursOfSleep;
  private String name;
  private int age;
  private ArrayList<HighSchoolClass> completedClasses =
    new ArrayList<HighSchoolClass>();
  private ArrayList<Clubs> joinedClubs = new ArrayList<Clubs>();
  private Sports currentSport = null;
  private ArrayList<SummerJob> summerJobs = new ArrayList<SummerJob>();
  private int summerJobHours = 0;
  private double loanBalance = 0;

  // --- TIME MANAGEMENT ---
  private static final int TOTAL_WEEKLY_HOURS = 168;
  private static final int SLEEP_HOURS = 56; // 8hrs x 7 nights
  private static final int AMENITY_HOURS = 21; // 3hrs x 7 days
  private static final int SCHOOL_HOURS = 30; // 6hrs x 5 days
  private static final int BASE_FREE_HOURS = 61; // 168 - 56 - 21 - 30

  private int homeworkHours = 0;
  private int extracurricularHours = 0;
  private int jobHours = 0;

  // Player constructor
  public Player(int age, double moneySaved, double weeklyIncome,
    ClassSchedule classSchedule, Grades grades, double weeklyExpenses,
    double hoursOfSleep, String name)
  {
    this.age = age;
    this.moneySaved = moneySaved;
    this.weeklyIncome = weeklyIncome;
    this.classSchedule = new ClassSchedule(); // always starts fresh
    this.grades = grades;
    this.weeklyExpenses = weeklyExpenses;
    this.hoursOfSleep = hoursOfSleep;
    this.name = name;
  }

  // school hours are ALWAYS 30, never stored or changed

  public int getFreeHours()
  {
    return BASE_FREE_HOURS - homeworkHours - extracurricularHours - jobHours;
  }

  public int getHomeworkHours()
  {
    return homeworkHours;
  }

  public int getExtracurricularHours()
  {
    return extracurricularHours;
  }

  public ArrayList<Job> getJobs()
  {
    return jobs;
  }

  public int getJobHours()
  {
    return jobHours;
  }

  public void addJob(Job j)
  {
    jobs.add(j);
    setJobHours(getJobHours() + j.getTimeWeekly());
    setWeeklyIncome(getWeeklyIncome() + j.getWeeklyPay());
  }

  public void removeJob(Job j)
  {
    jobs.remove(j);
    setJobHours(getJobHours() - j.getTimeWeekly());
    setWeeklyIncome(getWeeklyIncome() - j.getWeeklyPay());
  }

  public boolean hasJob(Job j)
  {
    return jobs.contains(j);
  }

  public void setHomeworkHours(int hours)
  {
    homeworkHours = hours;
  }

  public void setExtracurricularHours(int hours)
  {
    extracurricularHours = hours;
  }

  public void setJobHours(int hours)
  {
    jobHours = hours;
  }

  public void resetTimeAllocation()
  {
    homeworkHours = 0;
    extracurricularHours = 0;
    jobHours = 0;
  }

  public void printTimeBreakdown()
  {
    Typer.print("\n--- WEEKLY TIME BUDGET ---");
    Typer.print("Total hours in a week:         168 hrs");
    Typer.print("Sleep (8 hrs/night):           -56 hrs");
    Typer.print("Eating/hygiene/amenities:      -21 hrs");
    Typer.print("School (6 hrs/day, 5 days):    -30 hrs");
    Typer.print("--------------------------------");
    Typer.print("Starting free hours:            61 hrs");
    Typer.print("");
    Typer.print("Homework:                      -" + homeworkHours + " hrs");
    Typer.print("Extracurriculars/clubs/sports: -" + extracurricularHours
      + " hrs");
    Typer.print("Job:                           -" + jobHours + " hrs");
    Typer.print("--------------------------------");
    Typer
      .print("Free time remaining:            " + getFreeHours() + " hrs/week");
  }
  // --- STANDARD GETTERS AND SETTERS ---

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public void incrementAge()
  {
    this.age++;
  }

  public double getMoneySaved()
  {
    return moneySaved;
  }

  public void setMoneySaved(double moneySaved)
  {
    this.moneySaved = moneySaved;
  }

  public double getWeeklyIncome()
  {
    return weeklyIncome;
  }

  public void setWeeklyIncome(double weeklyIncome)
  {
    this.weeklyIncome = weeklyIncome;
  }

  public ClassSchedule getClassSchedule()
  {
    return classSchedule;
  }

  public void setClassSchedule(ClassSchedule classSchedule)
  {
    this.classSchedule = classSchedule;
  }

  public double getWeeklyExpenses()
  {
    return weeklyExpenses;
  }

  public void setWeeklyExpenses(double newExpenses)
  {
    weeklyExpenses = newExpenses;
  }

  public double getHoursOfSleep()
  {
    return hoursOfSleep;
  }

  public void setHoursOfSleep(double newSleep)
  {
    hoursOfSleep = newSleep;
  }

  public Grades getGrades()
  {
    return grades;
  }

  public void setGrades(Grades newGrade)
  {
    grades = newGrade;
  }

  public Sports getCurrentSport()
  {
    return currentSport;
  }

  public void setCurrentSport(Sports sport)
  {
    currentSport = sport;
  }

  public ArrayList<HighSchoolClass> getCompletedClasses()
  {
    return completedClasses;
  }

  public void addCompletedClass(HighSchoolClass c)
  {
    completedClasses.add(c);
  }

  public void printCompletedClasses()
  {
    if (completedClasses.isEmpty())
    {
      Typer.print("No completed classes yet.");
      return;
    }
    Typer.print("\n--- COMPLETED CLASSES ---");
    for (HighSchoolClass c : completedClasses)
    {
      Typer.print(c.getName() + " | Grade: " + c.getLetterGrade() + " ("
        + c.getNumericalGrade() + ")" + " | Credits: " + c.getCredits()
        + " | Subject: " + c.getType());
    }
  }

  public ArrayList<Clubs> getJoinedClubs()
  {
    return joinedClubs;
  }

  public ArrayList<SummerJob> getSummerJobs()
  {
    return summerJobs;
  }

  public int getSummerJobHours()
  {
    return summerJobHours;
  }

  public void setSummerJobHours(int hours)
  {
    summerJobHours = hours;
  }

  // summer free hours - 91 base minus whatever summer jobs take up
  public int getSummerFreeHours()
  {
    return SummerJob.SUMMER_BASE_FREE_HOURS - summerJobHours;
  }

  public double getLoanBalance()
  {
    return loanBalance;
  }

  public void setLoanBalance(double amount)
  {
    loanBalance = amount;
  }

  // --- RUN OPTION ---

  public static void runOption(Player player)
  {
    String name = player.getName();

    Scanner scan = new Scanner(System.in);
    Typer.print("\nWhat would you like to view in Player Stats?");
    Typer.print("Profile - (a)");
    Typer.print("Time Budget - (b)");
    Typer.print("Return to Actions - (c)");

    String letter = scan.next();
    scan.nextLine();

    if (letter.equals("a") || letter.equals("A"))
    {
      Grades grades = player.getGrades();
      int age = player.getAge();
      double weeklyIncome = player.getWeeklyIncome();
      double moneySaved = player.getMoneySaved();
      double weeklyExpenses = player.getWeeklyExpenses();
      double hoursOfSleep = player.getHoursOfSleep();

      Typer.print("\n=============================");
      Typer.print("       PLAYER STATS");
      Typer.print("=============================\n");

      // Basic Info
      Typer.print("--- BASIC INFO ---");
      Typer.print("Name:                " + name);
      Typer.print("Age:                 " + age + " years old\n");

      // Finances
      Typer.print("--- FINANCES ---");
      Typer.print("Money Saved:         $" + String.format("%.2f", moneySaved));
      Typer
        .print("Weekly Income:       $" + String.format("%.2f", weeklyIncome));
      Typer.print("Weekly Expenses:     $"
        + String.format("%.2f", weeklyExpenses));
      Typer.print("Weekly Net:          $"
        + String.format("%.2f", weeklyIncome - weeklyExpenses) + "\n");

      // Job
      Typer.print("--- EMPLOYMENT ---");
      Job.printJobList(player.getJobs());

      // Academics
      Typer.print("--- ACADEMICS ---");
      if (grades == null)
        Typer.print("Scheldule:           No scheldule yet\n");
      else
        player.getClassSchedule().printSchedule();

      // Lifestyle
      Typer.print("--- LIFESTYLE ---");
      Typer.print("Hours of Sleep:      " + hoursOfSleep + " hrs/night");
      Typer
        .print("Free Time:           " + player.getFreeHours() + " hrs/week\n");

      Typer.print("=============================");
      Typer.print("Press enter to return:");
      scan.nextLine();
      runOption(player);
    }

    else if (letter.equals("b") || letter.equals("B"))
    {
      player.printTimeBreakdown();
      Typer.print("\nPress enter to return:");
      scan.nextLine();
      runOption(player);
    }

    else if (letter.equals("c") || letter.equals("C"))
    {
      FirstYear.run(player);
    }

    else
    {
      Typer.print("I am sorry I did not understand that. Please try again.");
      runOption(player);
    }
  }
}