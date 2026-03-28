
/**
 * Preference file version 110624
 * 
 * @author: JaneElliot and Joc
 *          VHS Learning
 */
import java.util.Scanner;

public class FamilyInfo
{

  public static void runOption(Player player)
  {
    String name = player.getName();

    Scanner scan = new Scanner(System.in);
    Typer.print("What would you like to see in Family Information?");
    Typer.print("Family History - (a)");
    Typer.print("Parent Income and Expenses - (b)");
    Typer.print("Return to Actions - (c)");

    String letter = scan.next();
    scan.nextLine();
    if (letter.equals("a") || letter.equals("A"))
    {
      Typer.print("\n--- PLAYER HISTORY ---\n");

      Typer.print(name
        + " grew up in Red Grove, Arizona, a small working-class "
        + "suburb outside of Phoenix. The neighborhood is tight-knit but struggling, "
        + "with many families living paycheck to paycheck.\n");

      Typer.print(name
        + "'s mother, Hanna, immigrated from Hungary, or Magyarország, at age 19 "
        + "and has worked at Fry's Marketplace for the past eleven years. She is hardworking "
        + "and determined, but exhausted from long shifts and raising three kids. "
        + "She earns $35,000 a year.\n");

      Typer.print(name + "'s father, David, grew up in Red Grove himself. He "
        + "dropped out of high school at 16 and has bounced between restaurant jobs ever since. "
        + "He earns $30,000 a year washing dishes at local diners. He wants better for "
        + name + " but doesn't always know how to show it.\n");

      Typer
        .print("The family of six, including grandmother Zoé, shares a five bedroom "
          + "rented house. Zoé watches the younger kids while the parents work. She speaks "
          + "little English but is the heart of the household.\n");

      Typer.print(name
        + "'s younger siblings are Marcell, age 4, and Emma, age 6. "
        + "They look up to " + name
        + " more than anyone else in the family.\n");
      Typer.print("Please enter to return to Family Information Sections");
      scan.nextLine();
      runOption(player);

    }
    else if (letter.equals("b") || letter.equals("B"))
    {
      Typer.print("\n--- FAMILY INCOME & EXPENSES ---\n");

      Typer.print("ANNUAL INCOME:\n");
      Typer.print("  Hanna (Fry's Marketplace cashier):       $35,000\n");
      Typer.print("  David (Restaurant dishwasher):           $30,000\n");
      Typer.print("  ----------------------------------------\n");
      Typer.print("  Total Household Income:                  $65,000\n");

      Typer.print("\nANNUAL EXPENSES:\n");
      Typer.print("  Food (family of six, ~$270/week):        $14,000\n");
      Typer.print("  Housing (five bedroom rental, $2k/mo):   $24,000\n");
      Typer.print("  Car (5 years old):                        $5,000\n");
      Typer.print("  Taxes:                                   $11,000\n");
      Typer.print("  Utilities (gas, water, electric, $400/mo): $4,800\n");
      Typer.print("  School Supplies:                            $500\n");
      Typer.print("  Life Insurance ($40/mo):                    $480\n");
      Typer.print("  Phone Bills (four phones, $150/mo):       $1,800\n");
      Typer.print("  Clothing:                                 $1,000\n");
      Typer.print("  " + name + "'s Annual Allowance:   $300\n");
      Typer.print("  ----------------------------------------\n");
      Typer.print("  Total Expenses:                          $62,880\n");

      Typer.print("\n  NOTE: This family has NO health insurance.\n");

      Typer.print("\nMONEY LEFT OVER:                           $2,120\n");
      Typer.print("  This is the family's entire safety net. One emergency\n");
      Typer.print("  could wipe it out completely.\n");
      Typer.print("Please enter to return to Family Information Sections");
      scan.nextLine();
      runOption(player);
    }
    else if (letter.equals("c") || letter.equals("C"))
    {
      FirstYear.run(player);
    }
    else
    {
      Typer.print("I am sorry I did not understand that. Please try again.");
      runOption(player);
    }

    scan.close();
  }

}
