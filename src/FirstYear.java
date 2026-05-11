
/**
 * Preference file version 110624
 * 
 * @author: Your First and Last name goes here!
 *          VHS Learning
 */
import java.util.Scanner;

public class FirstYear
{
  public static void run(Player player)
  {
    Scanner scan = new Scanner(System.in);

    Typer.print("\nYear one-\n");
    actionPrompt();
    String choice = scan.next();
    moveToCorrectClass(choice, player, scan);

    scan.close();
  }

  public static void actionPrompt()
  {
    Typer.print("Actions:");
    Typer.print("Access Family Information-(a)");
    Typer.print("Access Player Stats-(b)");
    Typer.print("Access School-(c)");
    Typer.print("Access Extracurriculars-(d)");
    Typer.print("Access Finicials-(e)");
    Typer.print("Access Game Information-(f)");
    Typer.print("Access Summer Job-(g)");
    Typer.print("End year-(h)");

  }

  public static void moveToCorrectClass(String letter, Player player,
                                        Scanner scan)
  {
    if (letter.equals("a") || letter.equals("A"))
    {
      FamilyInfo.runOption(player);
    }
    else if (letter.equals("b") || letter.equals("B"))
    {
      Player.runOption(player);
    }
    else if (letter.equals("c") || letter.equals("C"))
    {
      School.runOption(player);
    }
    else if (letter.equals("d") || letter.equals("D"))
    {
      Extracurriculars.runOption(player);
    }
    // else if (letter.equals("e") || letter.equals("E"))

    // {
    // Finicials.runOption(player);
    // }
    // else if (letter.equals("f") || letter.equals("F"))
    // {
    // GameOverview.runOption(player);
    // }
    else if (letter.equals("g") || letter.equals("G"))
    {
      SummerJob.runOption(player);
    }

    else if (letter.equals("h") || letter.equals("H"))
    {
      if (finishYearCheck(player))
      {
        finishYear(player, scan);
      }
      else
      {
        Typer.print("Please complete all requirements before ending the year.");
        run(player);
      }
    }
    // else
    // {
    // Typer
    // .print("Some items have not been filled out. Please ensure you have
    // completed all requirements for the year.");
    // }
    // }
    else
    {
      Typer.print("I did not understand that command. Please try again:\n");
      run(player);
    }

  }

  public static boolean finishYearCheck(Player player)
  {
    // check they have at least one class
    if (player.getClassSchedule().getCurrentSchedule().isEmpty())
    {
      Typer.print("You have not selected any classes yet!");
      return false;
    }

    // check for required subjects
    boolean hasMath = false;
    boolean hasScience = false;
    boolean hasHistory = false;
    boolean hasEnglish = false;

    for (HighSchoolClass c : player.getClassSchedule().getCurrentSchedule())
    {
      if (c.getType().equals("math"))
        hasMath = true;
      if (c.getType().equals("science"))
        hasScience = true;
      if (c.getType().equals("history"))
        hasHistory = true;
      if (c.getType().equals("english"))
        hasEnglish = true;
    }

    // tell the player exactly what they are missing
    if (!hasMath)
    {
      Typer
        .print("You need at least one Math class before you can end the year!");
      return false;
    }
    if (!hasScience)
    {
      Typer
        .print("You need at least one Science class before you can end the year!");
      return false;
    }
    if (!hasHistory)
    {
      Typer
        .print("You need at least one History class before you can end the year!");
      return false;
    }
    if (!hasEnglish)
    {
      Typer
        .print("You need at least one English class before you can end the year!");
      return false;
    }

    // check homework hours are set for every class
    for (HighSchoolClass c : player.getClassSchedule().getCurrentSchedule())
    {
      if (c.getHomeworkWeeklyHours() == 0)
      {
        Typer.print("You have not set homework hours for " + c.getName()
          + " yet!");
        return false;
      }
    }

    return true;
  }

  public static void finishYear(Player player, Scanner scan)
  {
    Typer.print("\n=============================");
    Typer.print("       END OF YEAR RECAP");
    Typer.print("=============================\n");

    Typer.print("The year is over, " + player.getName() + ".");
    Typer.print("Let's see how everything played out...\n");
    scan.nextLine();

    // --- GRADES ---
    Typer.print("Calculating your grades...\n");
    player.getClassSchedule().calculateAllGrades();
    scan.nextLine();

    player.getClassSchedule().printGradeReport();
    scan.nextLine();

    // --- MOVE CLASSES TO TRANSCRIPT ---
    for (HighSchoolClass c : player.getClassSchedule().getCurrentSchedule())
    {
      player.addCompletedClass(c);
    }

    // --- CREDIT SUMMARY ---
    Typer.print("\n--- CREDITS EARNED THIS YEAR ---");
    player.getClassSchedule().printCreditSummary();
    scan.nextLine();

    // --- FINANCIAL SUMMARY ---
    Typer.print("\n--- FINANCIAL SUMMARY ---");
    Typer.print("Money saved this year:   $"
      + String.format("%.2f", player.getMoneySaved()));
    Typer.print("Weekly income:           $"
      + String.format("%.2f", player.getWeeklyIncome()));
    Typer.print("Weekly expenses:         $"
      + String.format("%.2f", player.getWeeklyExpenses()));
    scan.nextLine();

    // --- LIFESTYLE SUMMARY ---
    Typer.print("\n--- LIFESTYLE SUMMARY ---");
    Typer.print("Hours of sleep per night: " + player.getHoursOfSleep());
    Typer.print("Free time per week:       " + player.getFreeHours() + " hrs");
    scan.nextLine();

    // --- CLEAR SCHEDULE FOR NEXT YEAR ---
    player.getClassSchedule().getCurrentSchedule().clear();

    // Clear job
    for (Job j : player.getJobs())
    {
      player.setWeeklyIncome(player.getWeeklyIncome() - j.getWeeklyPay());
    }
    player.getJobs().clear();
    player.setJobHours(0);

    // Move sport info
    Sports.endOfYearSportUpdate(player);

    // clear summer
    SummerJob.endOfSummer(player);

    // --- AGE UP ---
    // you will need a setAge() or incrementAge() method in Player
    // player.incrementAge();

    Typer.print("\n=============================");
    Typer
      .print(player.getName() + " is now " + player.getAge() + " years old.");
    Typer.print("Press enter to continue to next year:");
    scan.nextLine();

    // move to next year
    Runner.yearInRunner++;
    // SecondYear.run(player); // uncomment when ready
  }

}
