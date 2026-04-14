
/**
 * Preference file version 110624
 * 
 * @author: Your First and Last name goes here!
 *          VHS Learning
 */
import java.util.*;

public class ClassSchedule
{
  // the classes the player has selected for the current year
  private ArrayList<HighSchoolClass> currentSchedule =
    new ArrayList<HighSchoolClass>();

  // max hours per week a student can take
  private static final int MAX_HOURS = 30;

  public ClassSchedule()
  {
    currentSchedule = new ArrayList<HighSchoolClass>();
  }

  // starts with a premade schedule
  public ClassSchedule(ArrayList<HighSchoolClass> schedule)
  {
    this.currentSchedule = schedule;
  }

  // --- GETTERS ---

  public ArrayList<HighSchoolClass> getCurrentSchedule()
  {
    return currentSchedule;
  }

  public int getTotalHours()
  {
    int total = 0;
    for (HighSchoolClass c : currentSchedule)
      total += c.getClassTime();
    return total;
  }

  public int getTotalCredits()
  {
    int total = 0;
    for (HighSchoolClass c : currentSchedule)
      total += c.getCredits();
    return total;
  }

  // --- ADD / REMOVE ---

  public boolean addClass(HighSchoolClass c)
  {
    // check if adding this class would exceed max hours
    if (getTotalHours() + c.getClassTime() > MAX_HOURS)
    {
      Typer.print("You don't have enough time in your schedule for "
        + c.getName() + ".");
      return false;
    }
    // check if class is already in schedule
    if (currentSchedule.contains(c))
    {
      Typer.print(c.getName() + " is already in your schedule.");
      return false;
    }
    currentSchedule.add(c);
    Typer.print(c.getName() + " added to your schedule!");
    return true;
  }

  public boolean removeClass(HighSchoolClass c)
  {
    if (currentSchedule.remove(c))
    {
      Typer.print(c.getName() + " removed from your schedule.");
      return true;
    }
    Typer.print(c.getName() + " was not found in your schedule.");
    return false;
  }

  // --- CREDIT TRACKING ---

  public int getCreditsBySubject(String subject)
  {
    int total = 0;
    for (HighSchoolClass c : currentSchedule)
    {
      if (c.getType().equals(subject))
        total += c.getCredits();
    }
    return total;
  }

  public void printCreditSummary()
  {
    Typer.print("\n--- CREDIT SUMMARY ---");
    Typer.print("Math:     " + getCreditsBySubject("math"));
    Typer.print("English:  " + getCreditsBySubject("english"));
    Typer.print("Science:  " + getCreditsBySubject("science"));
    Typer.print("History:  " + getCreditsBySubject("history"));
    Typer.print("Gym:      " + getCreditsBySubject("gym"));
    Typer.print("Art:      " + getCreditsBySubject("art"));
    Typer.print("Tech:     " + getCreditsBySubject("tech"));
    Typer.print("Lang:     " + getCreditsBySubject("lang"));
    Typer.print("Total Credits: " + getTotalCredits());
    Typer.print("Total Hours/Week: " + getTotalHours() + "/" + MAX_HOURS);
  }

  // --- DISPLAY SCHEDULE ---

  public void printSchedule()
  {
    if (currentSchedule.isEmpty())
    {
      Typer.print("Your schedule is empty.");
      return;
    }
    Typer.print("\n--- CURRENT SCHEDULE ---");
    for (int i = 0; i < currentSchedule.size(); i++)
    {
      HighSchoolClass c = currentSchedule.get(i);
      Typer
        .print((i + 1) + ". " + c.getName() + " | " + c.getType().toUpperCase()
          + " | Difficulty: " + c.getDifficultyLevel() + "/10" + " | "
          + c.getClassTime() + " hrs/week" + " | Teacher: " + c.getTeacher());
    }
    printCreditSummary();
  }

  public void setHomeworkHours(Scanner scan)
  {
    if (currentSchedule.isEmpty())
    {
      Typer.print("Your schedule is empty.");
      return;
    }

    // calculate how many free hours the player has
    // assuming a 168 hr week: sleep(56) + school hours + meals/hygiene(21)
    int freeHours = 168 - 56 - 21 - getTotalHours();

    Typer.print("\n--- SET HOMEWORK HOURS ---");
    Typer
      .print("You have approximately " + freeHours + " free hours per week.");
    Typer.print("Distribute your study time wisely across your classes.\n");

    int hoursAssigned = 0;

    for (HighSchoolClass c : currentSchedule)
    {
      int hoursLeft = freeHours - hoursAssigned;
      Typer.print("Class: " + c.getName() + " | Difficulty: "
        + c.getDifficultyLevel() + "/10" + " | Class hours/week: "
        + c.getClassTime());
      Typer.print("Recommended homework: "
        + String.format("%.1f",
                        (c.getDifficultyLevel() / 10.0) * c.getClassTime())
        + " hrs/week");
      Typer.print("Hours remaining to assign: " + hoursLeft);
      Typer
        .print("How many hours per week do you want to study for this class? (0-"
          + hoursLeft + "):");

      int hours = -1;
      while (hours < 0 || hours > hoursLeft)
      {
        try
        {
          hours = scan.nextInt();
          if (hours < 0 || hours > hoursLeft)
            Typer
              .print("Please enter a number between 0 and " + hoursLeft + ":");
        }
        catch (Exception e)
        {
          Typer.print("Please enter a valid number:");
          scan.nextLine();
        }
      }
      scan.nextLine();

      c.setHomeworkWeeklyHours(hours);
      hoursAssigned += hours;
      Typer.print("Set " + hours + " hrs/week for " + c.getName() + "\n");
    }

    Typer.print("Total homework hours assigned: " + hoursAssigned + "/"
      + freeHours);
    Typer.print("Unassigned free hours: " + (freeHours - hoursAssigned)
      + " (used for rest, extracurriculars, eating, etc)");
  }

  public void calculateAllGrades()
  {
    for (HighSchoolClass c : currentSchedule)
    {
      c.calculateGrade();
    }
  }

  public void printGradeReport()
  {
    Typer.print("\n--- END OF YEAR GRADE REPORT ---");
    double totalPoints = 0;
    int totalClasses = 0;
    for (HighSchoolClass c : currentSchedule)
    {
      Typer.print(c.getName() + " | Grade: " + c.getLetterGrade() + " ("
        + c.getNumericalGrade() + ")" + " | Homework: "
        + c.getHomeworkWeeklyHours() + " hrs/week");
      totalPoints += c.getNumericalGrade();
      totalClasses++;
    }
    if (totalClasses > 0)
    {
      double avg = totalPoints / totalClasses;
      Typer.print("\nFinal Average: " + String.format("%.1f", avg));
      Typer.print("Letter: " + calculateOverallLetter(avg));
    }
  }

  private String calculateOverallLetter(double avg)
  {
    if (avg >= 93)
      return "A+";
    else if (avg >= 90)
      return "A";
    else if (avg >= 87)
      return "B+";
    else if (avg >= 83)
      return "B";
    else if (avg >= 80)
      return "B-";
    else if (avg >= 77)
      return "C+";
    else if (avg >= 73)
      return "C";
    else if (avg >= 70)
      return "C-";
    else if (avg >= 67)
      return "D+";
    else if (avg >= 63)
      return "D";
    else
      return "D-";
  }
}
