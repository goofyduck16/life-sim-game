
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

  public void calculateGrade()
  {
    Random rand = new Random();

    // base effort ratio - how many hours recommended vs how many they put in
    // a difficulty 5 class with classTime 5 should need about 2-3 hrs homework
    double recommendedHours = (difficultyLevel / 10.0) * classTime;
    double effortRatio = homeworkWeeklyHours / recommendedHours;

    // cap effort ratio so putting in way more hours doesnt guarantee 100
    if (effortRatio > 1.5)
      effortRatio = 1.5;

    // roll a random number 1-100
    int roll = rand.nextInt(100) + 1;

    // grade thresholds shift based on effort ratio
    // at full effort (1.0+): A=70%, B=20%, C=7%, D=3%
    // at half effort (0.5): A=20%, B=35%, C=30%, D=15%
    // at no effort (0.0): A=5%, B=15%, C=40%, D=40%

    int aThreshold = (int) (effortRatio * 70);
    int bThreshold = aThreshold + (int) (20 + (1 - effortRatio) * 15);
    int cThreshold = bThreshold + (int) (7 + (1 - effortRatio) * 23);

    // cap thresholds
    if (aThreshold > 90)
      aThreshold = 90;
    if (bThreshold > 97)
      bThreshold = 97;
    if (cThreshold > 99)
      cThreshold = 99;

    // assign numerical grade based on roll
    if (roll <= aThreshold)
    {
      // A range: 90-100
      numericalGrade = 90 + rand.nextInt(11);
    }
    else if (roll <= bThreshold)
    {
      // B range: 80-89
      numericalGrade = 80 + rand.nextInt(10);
    }
    else if (roll <= cThreshold)
    {
      // C range: 70-79
      numericalGrade = 70 + rand.nextInt(10);
    }
    else
    {
      // D range: 60-69
      numericalGrade = 60 + rand.nextInt(10);
    }

    // now set letter grade
    letterGrade = calculateLetterGrade(numericalGrade);
  }

  private String calculateLetterGrade(int numericalGrade)
  {
    if (numericalGrade >= 93)
      return "A+";
    else if (numericalGrade >= 90)
      return "A";
    else if (numericalGrade >= 87)
      return "B+";
    else if (numericalGrade >= 83)
      return "B";
    else if (numericalGrade >= 80)
      return "B-";
    else if (numericalGrade >= 77)
      return "C+";
    else if (numericalGrade >= 73)
      return "C";
    else if (numericalGrade >= 70)
      return "C-";
    else if (numericalGrade >= 67)
      return "D+";
    else if (numericalGrade >= 63)
      return "D";
    else
      return "D-";
  }

}
