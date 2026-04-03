
/**
 * Preference file version 110624
 * 
 * @author: Your First and Last name goes here!
 *          VHS Learning
 */
import java.util.*;

public class HighSchoolClass
{
  private String name;
  private String description;
  private String teacher;
  private String letterGrade;
  private int difficultyLevel;
  private int year;
  private int numericalGrade;
  private int credits;
  private int prerequisiteAge;
  private int classTime;
  private int homeworkWeeklyHours;
  private String prerequisitesClass;
  private String type;

  public HighSchoolClass(String name, String description, String teacher,
    String type, int difficultyLevel, int year, int credits,
    int prerequisiteAge, String prerequisitesClass, int classTime)
  {
    this.name = name;
    this.description = description;
    this.teacher = teacher;
    this.type = type;
    this.difficultyLevel = difficultyLevel;
    this.year = year;
    this.credits = credits;
    this.prerequisiteAge = prerequisiteAge;
    this.prerequisitesClass = prerequisitesClass;
    this.classTime = classTime;
  }

  // Getters
  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public String getTeacher()
  {
    return teacher;
  }

  public String getType()
  {
    return type;
  }

  public String getLetterGrade()
  {
    return letterGrade;
  }

  public int getDifficultyLevel()
  {
    return difficultyLevel;
  }

  public int getYear()
  {
    return year;
  }

  public int getNumericalGrade()
  {
    return numericalGrade;
  }

  public int getCredits()
  {
    return credits;
  }

  public int getPrerequisiteAge()
  {
    return prerequisiteAge;
  }

  public String getPrerequisitesClass()
  {
    return prerequisitesClass;
  }

  public int getClassTime()
  {
    return classTime;
  }

  public int getHomeworkWeeklyHours()
  {
    return homeworkWeeklyHours;
  }

  // Setters
  public void setNumericalGrade(int numericalGrade)
  {
    this.numericalGrade = numericalGrade;
  }

  public void setLetterGrade(String letterGrade)
  {
    this.letterGrade = letterGrade;
  }

  public void setHomeworkWeeklyHours(int newHour)
  {
    homeworkWeeklyHours = newHour;
  }

  public boolean meetsPrerequisite(ArrayList<HighSchoolClass> completedClasses)
  {
    // if no prerequisite, always eligible
    if (prerequisitesClass.equals("None"))
      return true;

    // split by " or " to handle multiple options ex "Algebra 1 or Honors
    // Algebra 1"
    String[] options = prerequisitesClass.split(" or ");

    // check if the player has completed at least one of the options
    for (String option : options)
    {
      option = option.trim();
      for (HighSchoolClass completed : completedClasses)
      {
        if (completed.getName().equals(option))
          return true;
      }
    }

    // none of the prerequisites were met
    return false;
  }

}
