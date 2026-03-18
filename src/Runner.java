
/**
 * Preference file version 110624
 * 
 * @author: JaneElliot
 *          VHS Learning
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
    System.out.println("Please enter your name:");
    String userName = scan.next();

    // Intro
    System.out.print("Hello " + userName + "!");
    System.out.println(" Welcome to Divitiae...\n\n");
    System.out
      .println("You are going to be given full power to determine the \noutcome of your character's life."
        + " Your character is a\n14 year old white male born in Red Grove, Arizona.\nPlease give your character a name now:");
    // get Character name
    String characterName = scan.next();
    // model their city after phoenix
    System.out.println("Thank you! " + characterName
      + " has two younger brothers and a sister, aged 1, 4, and 6. "
      + characterName
      + " lives in a small apartment flat with his siblings, parents, and grandmother."
      + " His mom is a part time teacher, earning $40,000 annually. ");

    scan.close();
  }

}
