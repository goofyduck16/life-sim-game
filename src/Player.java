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
  private String name;

  // Player constructor
  public Player(int year, double moneySaved, double weeklyIncome,
    double timeAvail, Job job, ClassSchedule classSchedule, Grades grades,
    String familyInfo, double weeklyExpenses, double hoursOfSleep, String name)
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
  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
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

  public ClassFamilyInfo getFamilyInfo()
  {
    return classFamilyInfo;
  }

  public void setFamilyInfo(ClassFamilyInfo classFamilyInfo)
  {
    this.familyInfo = familyInfo;
  }

}
