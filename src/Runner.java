
/**
 * Preference file version 110624
 * 
 * @author: JaneElliot and joc
 * 
 */
import java.util.Scanner;

public class Runner
{

  public static void main(String[] args)
  {
    intro();

  }

  public static void intro()
  {
    // scanner class stuff
    Scanner scan = new Scanner(System.in);
    // TODO Auto-generated method stub

    // Get's users name
    Typer.print("Please enter your first name:");
    String userName = scan.next();
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);

    // Intro
    Typer.print("Hello " + userName + "! Welcome to Divitiae...\n\n");
    Typer.print("You are going to be given full power to determine the "
      + "outcome of your character's life." + " Your character is a"
      + " 14 year old white male born in Red Grove, Arizona."
      + " Please give your character a name now:");
    // get Character name
    String characterName = scan.next();
    characterName =
      characterName.substring(0, 1).toUpperCase() + characterName.substring(1);
    // model their city after phoenix
    Typer.print("Thank you! " + characterName
      + " has a younger brother and a sister, aged 4 and 6. " + characterName
      + " lives in a five bedroom rented house with his siblings, parents, and grandmother."
      + " His mom is a cashier at a Fry's Marketplace, earning $35,000 annually. "
      + "His father works as a dishwasher at local resturants and earns $30,000 "
      + "annually. Each year their family spends $62880 on nessecary expenses. You"
      + " will be able to inspect costs closer later on. " + characterName
      + " is provided $300 dollars annually by his parents to spend on academics, "
      + "athletic fees, and any other extracurrcular expenses.\n");
    Typer.print("You will organize " + characterName
      + "'s life from age 14 to 30. The objective of the game is to get "
      + characterName
      + " to be earning $90,000 dollars annually by age thirty. Good luck! Press enter to continue:");

    scan.close();
  }

}
