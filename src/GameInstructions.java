
/**
 * Preference file version 110624
 * 
 * @author: Your First and Last name goes here!
 *          VHS Learning
 */
import java.util.Scanner;

public class GameInstructions
{
  public static void runOption(Player player)
  {
    Scanner scan = new Scanner(System.in);

    Typer.print("\n=============================");
    Typer.print("       GAME INSTRUCTIONS");
    Typer.print("=============================\n");

    Typer.print("Welcome to Divitiae!");
    Typer.print("You are organizing the life of " + player.getName()
      + " from age 14 to 30.");
    Typer.print("The goal is to have " + player.getName()
      + " earning $90,000 annually by age 30.\n");
    Typer.print("Press enter to continue:");
    scan.nextLine();

    // --- THE BASICS ---
    Typer.print("\n--- THE BASICS ---");
    Typer.print("Each year you will manage " + player.getName() + "'s life");
    Typer.print("by making decisions across several categories:");
    Typer.print("");
    Typer.print("  SCHOOL       - Choose classes and set study time.");
    Typer.print("  EXTRACURRICULARS - Join clubs, sports, and get jobs.");
    Typer.print("  SUMMER       - Plan summer activities and jobs.");
    Typer.print("  FINANCIALS   - Track earnings, expenses, and loans.");
    Typer.print("  FAMILY INFO  - View your character's background.");
    Typer.print("  PLAYER STATS - View your character's current status.");
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    // --- TIME ---
    Typer.print("\n--- TIME ---");
    Typer.print("Every week has 168 hours. They are spent as follows:\n");
    Typer.print("  Sleep (8 hrs/night):          56 hrs");
    Typer.print("  Eating/hygiene/amenities:     21 hrs");
    Typer.print("  School (6 hrs/day, 5 days):   30 hrs");
    Typer.print("  -----------------------------------");
    Typer.print("  Free hours to use:             61 hrs\n");
    Typer.print("You decide how to split your 61 free hours between:");
    Typer.print("  - Homework (affects your grades)");
    Typer.print("  - Clubs and sports");
    Typer.print("  - Jobs");
    Typer.print("  - Whatever is left is true free time\n");
    Typer.print("In the summer there is no school, so you have 91 free hours.");
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    // --- SCHOOL ---
    Typer.print("\n--- SCHOOL ---");
    Typer.print("Each year you must enroll in at least one class in each");
    Typer.print("of the four core subjects:\n");
    Typer.print("  - Math");
    Typer.print("  - Science");
    Typer.print("  - History");
    Typer.print("  - English\n");
    Typer.print("Some classes have prerequisites — you must have completed");
    Typer.print("certain classes before you can enroll.\n");
    Typer.print("After enrolling, you set how many hours per week you");
    Typer.print("will study for each class.");

    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    // --- GRADES ---
    Typer.print("\n--- GRADES ---");
    Typer.print("Grades are calculated at the END of each year based on:");
    Typer.print("  - How many hours you studied");
    Typer.print("  - The difficulty of the class");
    Typer.print("  - A small random factor\n");
    Typer.print("Grades range from D- to A+.");
    Typer.print("Higher grades open up better opportunities later in life.");
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    // --- EXTRACURRICULARS ---
    Typer.print("\n--- EXTRACURRICULARS ---");
    Typer
      .print("Outside of school you can do clubs, sports, and/or have a job:");
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    // --- SUMMER ---
    Typer.print("\n--- SUMMER ---");
    Typer.print("Summer lasts 9 weeks. You have 91 free hours per week.");
    Typer.print("You can take on multiple summer activities as long as");
    Typer.print("you have enough free hours.\n");
    Typer
      .print("\nSummer earnings are paid as a lump sum at the end of summer.");
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    // --- FINANCES ---
    Typer.print("\n--- FINANCES ---");
    Typer
      .print(player.getName() + " starts with $300 from his parents annually.");
    Typer.print("You must manage his money carefully.\n");
    Typer.print("You can borrow up to $4,000 from your parents at any time.");
    Typer.print("There is no interest, but the loan MUST be repaid");
    Typer.print("automatically at the end of summer.");
    Typer.print("If you cannot repay it, you must reorganize your");
    Typer.print("schedule until you can.\n");
    Typer.print("Keep an eye on your projected earnings and expenses");
    Typer.print("in the Financials section throughout the year.");
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    FirstYear.run(player);
  }
}
