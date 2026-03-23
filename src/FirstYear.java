
/**
 * Preference file version 110624
 * 
 * @author: Your First and Last name goes here!
 *          VHS Learning
 */
import java.util.Scanner;

public class FirstYear
{
  public static void run(Player p)
  {
    Scanner scan = new Scanner(System.in);

    Typer.print("Year one has now begun...");
    actionPrompt();
    String choice = scan.next();
    moveToCorrectClass(choice);

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

  }

  public static void moveToCorrectClass(String letter)
  {
    if (letter.equals("a") || letter.equals("A"))
    {
      FamilyInfo.runOption();
    }
    else if (letter.equals("b") || letter.equals("B"))
    {
      Player.runOption();
    }
    else if (letter.equals("c") || letter.equals("C"))
    {
      School.runOption();
    }
    else if (letter.equals("d") || letter.equals("D"))
    {
      Extracurriculars.runOption();
    }
    else if (letter.equals("e") || letter.equals("E"))
    {
      Finicials.runOption();
    }
    else if (letter.equals("f") || letter.equals("F"))
    {
      GameOverview.runOption();
    }
    else
    {
      Typer.print("I did not understand that command. Please try again:\n");
      actionPrompt();
    }

  }
}
