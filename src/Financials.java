import java.util.*;
import java.util.InputMismatchException;

public class Financials
{
  // constants
  public static final int SCHOOL_WEEKS = 40;
  public static final int SUMMER_WEEKS = 9;
  public static final double MAX_LOAN = 4000.00;

  public static int getValidInt(Scanner scan, String prompt, int max)
  {
    int input = -1;
    while (input < 0 || input > max)
    {
      Typer.print(prompt);
      try
      {
        input = scan.nextInt();
        scan.nextLine();
        if (input < 0 || input > max)
          Typer.print("Please enter a number between 0 and " + max + ":");
      }
      catch (InputMismatchException e)
      {
        scan.nextLine();
        Typer.print("Invalid input, please enter a number:");
      }
    }
    return input;
  }

  // --- PROJECTED SCHOOL YEAR EARNINGS ---
  public static double getProjectedSchoolIncome(Player player)
  {
    return player.getWeeklyIncome() * SCHOOL_WEEKS;
  }

  // --- PROJECTED SCHOOL YEAR EXPENSES ---
  public static double getProjectedSchoolExpenses(Player player)
  {
    double expenses = player.getWeeklyExpenses() * SCHOOL_WEEKS;

    // add sport fee if they are in a sport
    if (player.getCurrentSport() != null)
      expenses += 50.00;

    return expenses;
  }

  // --- PROJECTED SUMMER EARNINGS ---
  public static double getProjectedSummerIncome(Player player)
  {
    double total = 0;
    for (SummerJob j : player.getSummerJobs())
      total += j.getTotalSummerPay();
    return total;
  }

  // --- PROJECTED SUMMER EXPENSES ---
  public static double getProjectedSummerExpenses(Player player)
  {
    double expenses = 0;

    // camp fee if signed up
    for (SummerJob j : player.getSummerJobs())
    {
      if (j == SummerJob.summerCamp)
        expenses += SummerJob.CAMP_COST;
    }

    return expenses;
  }

  // --- FULL FINANCIAL BREAKDOWN ---
  public static void printFullBreakdown(Player player)
  {
    Typer.print("\n=============================");
    Typer.print("     FINANCIAL OVERVIEW");
    Typer.print("=============================\n");

    // --- CURRENT STATUS ---
    Typer.print("--- CURRENT STATUS ---");
    Typer.print("Money Saved:           $"
      + String.format("%.2f", player.getMoneySaved()));
    Typer.print("Outstanding Loans:     $"
      + String.format("%.2f", player.getLoanBalance()));
    Typer.print("Net Worth:             $" + String
      .format("%.2f", player.getMoneySaved() - player.getLoanBalance()));

    // --- SCHOOL YEAR ---
    Typer.print("\n--- SCHOOL YEAR (" + SCHOOL_WEEKS + " weeks) ---");

    // income sources
    Typer.print("\nINCOME:");
    if (player.getJobs().isEmpty())
    {
      Typer.print("  No jobs during school year.");
    }
    else
    {
      for (Job j : player.getJobs())
      {
        Typer.print("  " + j.getName() + " ($"
          + String.format("%.2f", j.getWeeklyPay()) + "/week x " + SCHOOL_WEEKS
          + " weeks): $"
          + String.format("%.2f", j.getWeeklyPay() * SCHOOL_WEEKS));
      }
    }
    Typer.print("  Allowance ($300 annual):              $300.00");
    Typer.print("  ----------------------------------------");
    Typer.print("  Projected School Income:              $"
      + String.format("%.2f", getProjectedSchoolIncome(player) + 300.00));

    // expenses
    Typer.print("\nEXPENSES:");
    Typer.print("  Weekly expenses ($"
      + String.format("%.2f", player.getWeeklyExpenses()) + "/week x "
      + SCHOOL_WEEKS + " weeks): $"
      + String.format("%.2f", player.getWeeklyExpenses() * SCHOOL_WEEKS));
    if (player.getCurrentSport() != null)
    {
      Typer.print("  Sport sign up fee (" + player.getCurrentSport().getName()
        + "):   $50.00");
    }
    Typer.print("  ----------------------------------------");
    Typer.print("  Projected School Expenses:            $"
      + String.format("%.2f", getProjectedSchoolExpenses(player)));

    // school net
    double schoolNet =
      (getProjectedSchoolIncome(player) + 300.00)
        - getProjectedSchoolExpenses(player);
    Typer.print("\n  Projected School Net Gain:            $"
      + String.format("%.2f", schoolNet));

    // --- SUMMER ---
    Typer.print("\n--- SUMMER (" + SUMMER_WEEKS + " weeks) ---");

    // summer income
    Typer.print("\nINCOME:");
    if (player.getSummerJobs().isEmpty())
    {
      Typer.print("  No summer activities planned yet.");
    }
    else
    {
      for (SummerJob j : player.getSummerJobs())
      {
        if (j.getWeeklyPay() > 0)
        {
          Typer.print("  " + j.getName() + " ($"
            + String.format("%.2f", j.getWeeklyPay()) + "/week x "
            + SUMMER_WEEKS + " weeks): $"
            + String.format("%.2f", j.getTotalSummerPay()));
        }
      }
    }
    Typer.print("  ----------------------------------------");
    Typer.print("  Projected Summer Income:              $"
      + String.format("%.2f", getProjectedSummerIncome(player)));

    // summer expenses
    Typer.print("\nEXPENSES:");
    boolean hasSummerExpenses = false;
    for (SummerJob j : player.getSummerJobs())
    {
      if (j == SummerJob.summerCamp)
      {
        Typer.print("  Prestigious Summer Camp fee:          -$"
          + String.format("%.2f", SummerJob.CAMP_COST));
        hasSummerExpenses = true;
      }
    }
    if (!hasSummerExpenses)
      Typer.print("  No summer expenses.");

    Typer.print("  ----------------------------------------");
    Typer.print("  Projected Summer Expenses:            $"
      + String.format("%.2f", getProjectedSummerExpenses(player)));

    // summer net
    double summerNet =
      getProjectedSummerIncome(player) - getProjectedSummerExpenses(player);
    Typer.print("\n  Projected Summer Net Gain:            $"
      + String.format("%.2f", summerNet));

    // --- LOANS ---
    if (player.getLoanBalance() > 0)
    {
      Typer.print("\n--- LOANS ---");
      Typer.print("  Outstanding loan balance: $"
        + String.format("%.2f", player.getLoanBalance()));
      Typer.print("  This will be automatically deducted at end of summer.");
      double afterLoan = summerNet - player.getLoanBalance();
      Typer.print("  Summer net after loan repayment: $"
        + String.format("%.2f", afterLoan));
    }

    // --- FULL YEAR TOTAL ---
    Typer.print("\n=============================");
    Typer.print("--- FULL YEAR PROJECTION ---");
    double fullYearNet = schoolNet + summerNet - player.getLoanBalance();
    Typer.print("School net:            $" + String.format("%.2f", schoolNet));
    Typer.print("Summer net:            $" + String.format("%.2f", summerNet));
    if (player.getLoanBalance() > 0)
      Typer.print("Loan repayment:       -$"
        + String.format("%.2f", player.getLoanBalance()));
    Typer.print("----------------------------");
    Typer
      .print("Projected Year Net:    $" + String.format("%.2f", fullYearNet));
    Typer.print("Current savings:       $"
      + String.format("%.2f", player.getMoneySaved()));
    Typer.print("Projected end savings: $"
      + String.format("%.2f", player.getMoneySaved() + fullYearNet));
    Typer.print("=============================");
  }

  // --- LOAN SYSTEM ---
  public static void takeLoan(Player player, Scanner scan)
  {
    double remainingLoanCapacity = MAX_LOAN - player.getLoanBalance();

    if (remainingLoanCapacity <= 0)
    {
      Typer.print("\nYou have reached the maximum loan amount of $"
        + String.format("%.2f", MAX_LOAN) + ".");
      Typer.print("You must repay your current loans before borrowing more.");
      return;
    }

    Typer.print("\n--- PARENT LOAN ---");
    Typer.print("Your parents are willing to lend you money in an emergency.");
    Typer
      .print("Maximum loan amount:      $" + String.format("%.2f", MAX_LOAN));
    Typer.print("Current loan balance:     $"
      + String.format("%.2f", player.getLoanBalance()));
    Typer.print("Available to borrow:      $"
      + String.format("%.2f", remainingLoanCapacity));
    Typer
      .print("Repayment:                Automatically deducted at end of summer.");
    Typer.print("Interest:                 None\n");

    Typer.print("How much would you like to borrow? (0 to cancel):");

    double amount = -1;
    while (amount < 0 || amount > remainingLoanCapacity)
    {
      try
      {
        amount = scan.nextDouble();
        scan.nextLine();
        if (amount == 0)
          return;
        if (amount < 0 || amount > remainingLoanCapacity)
          Typer.print("Please enter an amount between $0 and $"
            + String.format("%.2f", remainingLoanCapacity) + ":");
      }
      catch (InputMismatchException e)
      {
        scan.nextLine();
        Typer.print("Invalid input, please enter a number:");
      }
    }

    player.setLoanBalance(player.getLoanBalance() + amount);
    player.setMoneySaved(player.getMoneySaved() + amount);

    Typer.print("\nLoan approved!");
    Typer.print("Amount borrowed:      $" + String.format("%.2f", amount));
    Typer.print("Total loan balance:   $"
      + String.format("%.2f", player.getLoanBalance()));
    Typer.print("Money saved:          $"
      + String.format("%.2f", player.getMoneySaved()));
    Typer.print("This will be repaid automatically at the end of summer.");
  }

  // --- REPAY LOAN AT END OF SUMMER ---
  // called in FirstYear.finishYear after endOfSummer
  public static boolean repayLoan(Player player, Scanner scan)
  {
    if (player.getLoanBalance() <= 0)
      return true;

    Typer.print("\n--- LOAN REPAYMENT ---");
    Typer.print("Outstanding loan:  $"
      + String.format("%.2f", player.getLoanBalance()));
    Typer.print("Money saved:       $"
      + String.format("%.2f", player.getMoneySaved()));

    // check if they can afford it
    if (player.getMoneySaved() >= player.getLoanBalance())
    {
      player.setMoneySaved(player.getMoneySaved() - player.getLoanBalance());
      Typer.print("Loan repaid successfully!");
      Typer.print("Amount repaid:     $"
        + String.format("%.2f", player.getLoanBalance()));
      player.setLoanBalance(0);
      Typer.print("Money remaining:   $"
        + String.format("%.2f", player.getMoneySaved()));
      return true;
    }
    else
    {
      // cant afford it - force them to reorganize
      Typer.print("\nYou cannot afford to repay your loan!");
      Typer.print("You need $" + String.format("%.2f", player.getLoanBalance())
        + " but only have $" + String.format("%.2f", player.getMoneySaved())
        + ".");
      Typer.print("You must reorganize your schedule before the year can end.");
      Typer.print("Returning to actions...");
      scan.nextLine();
      return false;
    }
  }

  // --- RUN OPTION ---
  public static void runOption(Player player)
  {
    Scanner scan = new Scanner(System.in);

    Typer.print("\n--- FINANCIALS ---");
    Typer.print("What would you like to do?");
    Typer.print("View Full Financial Breakdown - (a)");
    Typer.print("Take Parent Loan - (b)");
    Typer.print("View Loan Status - (c)");
    Typer.print("Return to Actions - (d)");

    String letter = scan.next();
    scan.nextLine();

    // --- FULL BREAKDOWN ---
    if (letter.equals("a") || letter.equals("A"))
    {
      printFullBreakdown(player);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- TAKE LOAN ---
    else if (letter.equals("b") || letter.equals("B"))
    {
      takeLoan(player, scan);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- VIEW LOAN STATUS ---
    else if (letter.equals("c") || letter.equals("C"))
    {
      Typer.print("\n--- LOAN STATUS ---");
      if (player.getLoanBalance() <= 0)
      {
        Typer.print("You have no outstanding loans.");
      }
      else
      {
        Typer.print("Outstanding loan balance: $"
          + String.format("%.2f", player.getLoanBalance()));
        Typer.print("Maximum loan allowed:     $"
          + String.format("%.2f", MAX_LOAN));
        Typer.print("Remaining borrowing capacity: $"
          + String.format("%.2f", MAX_LOAN - player.getLoanBalance()));
        Typer.print("Repayment due:            End of summer");
      }
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- RETURN ---
    else if (letter.equals("d") || letter.equals("D"))
    {
      FirstYear.run(player);
    }

    // --- INVALID ---
    else
    {
      Typer.print("I did not understand that. Please try again.");
      runOption(player);
    }
  }
}
