
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
}
