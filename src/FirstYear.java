
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
    moveToCorrectClass(choice, player);

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

  public static void moveToCorrectClass(String letter, Player player)
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
    // else if (letter.equals("d") || letter.equals("D"))
    // {
    // Extracurriculars.runOption(player);
    // }
    // else if (letter.equals("e") || letter.equals("E"))
    // {
    // Finicials.runOption(player);
    // }
    // else if (letter.equals("f") || letter.equals("F"))
    // {
    // GameOverview.runOption(player);
    // }
    // else if (letter.equals("g") || letter.equals("G"))
    // {
    // SummerJob.runOption(player);
    // }
    // else if (letter.equals("g") || letter.equals("G"))
    // {
    // if (finishYearCheck())
    // {
    // finishYear();
    // }
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

  public static boolean finishYearCheck()
  {
    return false;
  }

  public static void finishYear(Player player)
  {
    // calculate grades based on homework hours set during the year
    player.getClassSchedule().calculateAllGrades();
    player.getClassSchedule().printGradeReport();

    // move completed classes to player transcript
    for (HighSchoolClass c : player.getClassSchedule().getCurrentSchedule())
    {
      player.addCompletedClass(c);
    }

    // clear schedule for next year
    player.getClassSchedule().getCurrentSchedule().clear();
  }

}
