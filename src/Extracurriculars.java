import java.util.Scanner;

/**
 * Preference file version 110624
 * 
 * @author: Your First and Last name goes here!
 *          VHS Learning
 */

public class Extracurriculars
{
  public static void runOption(Player player)
  {
    String name = player.getName();

    Scanner scan = new Scanner(System.in);
    Typer.print("What would you like to do in Extracurriculars?");
    Typer.print("Join clubs - (a)");
    Typer.print("Edit clubs - (b)");
    Typer.print("Join sports - (c)");
    Typer.print("Edit sports - (d)");
    Typer.print("Get Job - (e)");
    Typer.print("Edit Jobs - (f)");
    Typer.print("Return to Actions - (g)");

    String letter = scan.next();
    scan.nextLine();
    if (letter.equals("a") || letter.equals("A"))
    {
      Clubs.joinClubs(player, scan);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }
    else if (letter.equals("b") || letter.equals("B"))
    {
      Clubs.editClubs(player, scan);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }
    else if (letter.equals("c") || letter.equals("C"))
    {
      Sports.joinSport(player, scan);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }
    else if (letter.equals("d") || letter.equals("D"))
    {
      Sports.quitSport(player, scan);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }
    else if (letter.equals("e") || letter.equals("E"))
    {
      Job.getJob(player, scan);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }
    else if (letter.equals("f") || letter.equals("F"))
    {
      Job.quitJob(player, scan);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }
    else if (letter.equals("g") || letter.equals("G"))
    {
      FirstYear.run(player);
    }
    else
    {
      Typer.print("Invalid option, please try again.");
      runOption(player);
    }

    scan.close();
  }

}
