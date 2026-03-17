/**
 * Preference file version 110624
 * 
 * @author: JaneElliot
 */

public class Player
{

  // Instance variables
  private int year;
  private double moneySaved;
  private double weeklyIncome;
  private double timeAvail;
  private Job job;
  private ClassSchedule classSchedule;
  private Grades grades;
  private String familyInfo;
  private double weeklyExpenses;
  private double hoursOfSleep;

  // Player constructor
  public Player(int year, double moneySaved, double weeklyIncome,
    double timeAvail, Job job, ClassSchedule classSchedule, Grades grades,
    String familyInfo, double weeklyExpenses, double hoursOfSleep)
  {
    this.year = year;
    this.moneySaved = moneySaved;
    this.weeklyIncome = weeklyIncome;
    this.timeAvail = timeAvail;
    this.job = job;
    this.classSchedule = classSchedule;
    this.grades = grades;
    this.familyInfo = familyInfo;
    this.weeklyExpenses = weeklyExpenses;
    this.hoursOfSleep = hoursOfSleep;
  }

  // year
  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  // moneySaved
  public double moneySaved()
  {
    return moneySaved;
  }

  public void moneySaved(double moneySaved)
  {
    this.moneySaved = moneySaved;
  }

  // weeklyIncome
  public double weeklyIncome()
  {
    return moneySaved;
  }

  public void weeklyIncome(double weeklyIncome)
  {
    this.weeklyIncome = weeklyIncome;
  }

  // timeAvail
  public double timeAvail()
  {
    return timeAvail;
  }

  public void timeAvail(double timeAvail)
  {
    this.timeAvail = timeAvail;
  }

  // job
  public Job job()
  {
    return job;
  }

  public void job(Job job)
  {
    this.job = job;
  }

  // classSchedule
  public ClassSchedule classSchedule()
  {
    return classSchedule;
  }

  public void classSchedule(ClassSchedule classSchedule)
  {
    this.classSchedule = classSchedule;
  }

}
