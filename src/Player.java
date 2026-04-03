
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
  private double timeAvail;
  private Job job;
  private ClassSchedule classSchedule;
  private Grades grades;
  private double weeklyExpenses;
  private double hoursOfSleep;
  private String name;
  private int age;
  private ArrayList<HighSchoolClass> completedClasses =
    new ArrayList<HighSchoolClass>();

  // Player constructor
  public Player(int age, double moneySaved, double weeklyIncome,
    double timeAvail, Job job, ClassSchedule classSchedule, Grades grades,
    double weeklyExpenses, double hoursOfSleep, String name)
  {
    this.age = age;
    this.moneySaved = moneySaved;
    this.weeklyIncome = weeklyIncome;
    this.timeAvail = timeAvail;
    this.job = job;
    this.classSchedule = classSchedule;
    this.grades = grades;
    this.weeklyExpenses = weeklyExpenses;
    this.hoursOfSleep = hoursOfSleep;
    this.name = name;

  }

  // name
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  // year
  public int getAge()
  {
    return age;
  }

  public void setYear(int age)
  {
    this.age = age;
  }

  // moneySaved
  public double getMoneySaved()
  {
    return moneySaved;
  }

  public void setMoneySaved(double moneySaved)
  {
    this.moneySaved = moneySaved;
  }

  // weeklyIncome
  public double getWeeklyIncome()
  {
    return weeklyIncome;
  }

  public void setWeeklyIncome(double weeklyIncome)
  {
    this.weeklyIncome = weeklyIncome;
  }

  // timeAvail
  public double getTimeAvail()
  {
    return timeAvail;
  }

  public void setTimeAvail(double timeAvail)
  {
    this.timeAvail = timeAvail;
  }

  // job
  public Job getJob()
  {
    return job;
  }

  public void setJob(Job job)
  {
    this.job = job;
  }

  // classSchedule
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

  public void setHoursOfSleep(int newSleep)
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

  public ArrayList<HighSchoolClass> getCompletedClasses()
  {
    return completedClasses;
  }

  // call this at the end of each school year to add the classes they finished
  public void addCompletedClass(HighSchoolClass c)
  {
    completedClasses.add(c);
  }

  // useful for displaying their transcript
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

  public static void runOption(Player player)
  {
    String name = player.getName();

    Scanner scan = new Scanner(System.in);
    Typer.print("What would you like to view in Player Stats?");
    Typer.print("Profile - (a)");
    Typer.print("Return to Actions - (b)");

    String letter = scan.next();
    scan.nextLine();
    if (letter.equals("a") || letter.equals("A"))
    {
      Grades grades = player.getGrades();
      int age = player.getAge();
      double weeklyIncome = player.getWeeklyIncome();
      double timeAvail = player.getTimeAvail();
      Job job = player.getJob();
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
      if (job == null)
      {
        Typer.print("Job:                 Unemployed\n");
      }
      else
      {
        Typer.print("Job:                 " + job.toString() + "\n");
      }

      // Academics
      Typer.print("--- ACADEMICS ---");
      if (grades == null)
      {
        Typer.print("Grades:              No grades yet\n");
      }
      else
      {
        Typer.print("Grades:              " + grades.toString() + "\n");
      }

      // Lifestyle
      Typer.print("--- LIFESTYLE ---");
      Typer.print("Hours of Sleep:      " + hoursOfSleep + " hrs/night");
      Typer.print("Free Time:           " + timeAvail + " hrs/week\n");

      Typer.print("=============================");
      Typer.print("Press enter to return:");
      scan.nextLine();
      runOption(player);

    }

    else if (letter.equals("b") || letter.equals("B"))
    {
      FirstYear.run(player);
    }
    else
    {
      Typer.print("I am sorry I did not understand that. Please try again.");
      runOption(player);
    }

    scan.close();

  }

}
