
/**
 * Preference file version 110624
 * 
 * @author: JaneElliot
 */
import java.util.Scanner;

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
    return moneySaved;
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

  public static void runOption(Player player)
  {
    String name = player.getName();

    Scanner scan = new Scanner(System.in);
    Typer.print("What would you like to view in Player Info?");
    Typer.print("Profile - (a)");
    Typer.print("Time Available - (b)");
    Typer.print("Return to Actions - (c)");

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

    }
    else if (letter.equals("b") || letter.equals("B"))
    {
      scan.nextLine();
      runOption(player);
    }
    else if (letter.equals("e") || letter.equals("E"))
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
