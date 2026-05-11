import java.util.Scanner;

public class FourthYear
{
  public static void run(Player player)
  {
    Scanner scan = new Scanner(System.in);

    Typer.print("\n--- YEAR FOUR - SENIOR YEAR ---");
    Typer
      .print(player.getName() + " is now " + player.getAge() + " years old.\n");
    Typer.print("This is your final year of high school. Make it count!\n");
    actionPrompt();
    String choice = scan.next();
    scan.nextLine();
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
    Typer.print("Access Financials-(e)");
    Typer.print("Access Game Information-(f)");
    Typer.print("Access Summer Jobs-(g)");
    Typer.print("End year-(h)");
  }

  public static void moveToCorrectClass(String letter, Player player,
                                        Scanner scan)
  {
    if (letter.equals("a") || letter.equals("A"))
      FamilyInfo.runOption(player);
    else if (letter.equals("b") || letter.equals("B"))
      Player.runOption(player);
    else if (letter.equals("c") || letter.equals("C"))
      School.runOption(player);
    else if (letter.equals("d") || letter.equals("D"))
      Extracurriculars.runOption(player);
    else if (letter.equals("e") || letter.equals("E"))
      Financials.runOption(player);
    else if (letter.equals("f") || letter.equals("F"))
      GameInstructions.runOption(player);
    else if (letter.equals("g") || letter.equals("G"))
      SummerJob.runOption(player);
    else if (letter.equals("h") || letter.equals("H"))
    {
      if (finishYearCheck(player))
        finishYear(player, scan);
      else
      {
        Typer.print("Please complete all requirements before ending the year.");
        run(player);
      }
    }
    else
    {
      Typer.print("I did not understand that command. Please try again:\n");
      run(player);
    }
  }

  public static boolean finishYearCheck(Player player)
  {
    if (player.getClassSchedule().getCurrentSchedule().isEmpty())
    {
      Typer.print("You have not selected any classes yet!");
      return false;
    }

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
    Typer.print("    END OF SENIOR YEAR RECAP");
    Typer.print("=============================\n");
    Typer.print("High school is over, " + player.getName() + "!");
    Typer.print("Let's see how everything played out...");
    Typer.print("Press enter to continue:");
    scan.nextLine();

    // --- GRADES ---
    Typer.print("\n--- CALCULATING GRADES ---");
    player.getClassSchedule().calculateAllGrades();
    player.getClassSchedule().printGradeReport();
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    for (HighSchoolClass c : player.getClassSchedule().getCurrentSchedule())
      player.addCompletedClass(c);

    Typer.print("\n--- CREDITS EARNED THIS YEAR ---");
    player.getClassSchedule().printCreditSummary();
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    // --- FULL HIGH SCHOOL TRANSCRIPT ---
    Typer.print("\n--- FULL HIGH SCHOOL TRANSCRIPT ---");
    player.printCompletedClasses();
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    Typer.print("\n--- SCHOOL YEAR FINANCIAL SUMMARY ---");
    double schoolIncome = Financials.getProjectedSchoolIncome(player) + 300.00;
    double schoolExpenses = Financials.getProjectedSchoolExpenses(player);
    double schoolNet = schoolIncome - schoolExpenses;
    Typer.print("Income this year:        $"
      + String.format("%.2f", schoolIncome));
    Typer.print("Expenses this year:      $"
      + String.format("%.2f", schoolExpenses));
    Typer
      .print("Net gain:                $" + String.format("%.2f", schoolNet));
    player.setMoneySaved(player.getMoneySaved() + schoolNet);
    Typer.print("Money saved:             $"
      + String.format("%.2f", player.getMoneySaved()));
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    Typer.print("\n--- EXTRACURRICULARS SUMMARY ---");
    if (player.getJoinedClubs().isEmpty())
      Typer.print("You were not in any clubs this year.");
    else
    {
      Typer.print("Clubs you participated in:");
      for (Clubs c : player.getJoinedClubs())
        Typer.print("  - " + c.getName() + " | " + c.getTimeWeekly()
          + " hrs/week");
    }

    if (player.getCurrentSport() != null)
    {
      Typer.print("\nSport: " + player.getCurrentSport().getName());
      Typer.print("Final mastery: " + player.getCurrentSport().getMastery()
        + "/10");
      Sports.endOfYearSportUpdate(player);
      Typer.print("Mastery after update:  "
        + player.getCurrentSport().getMastery() + "/10");
    }
    else
      Typer.print("\nYou did not play a sport this year.");
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    Typer.print("\n--- LIFESTYLE SUMMARY ---");
    Typer
      .print("Hours of sleep per night:  " + player.getHoursOfSleep() + " hrs");
    Typer.print("School hours per week:     30 hrs");
    Typer.print("Homework hours per week:   " + player.getHomeworkHours()
      + " hrs");
    Typer.print("Extracurricular hrs/week:  " + player.getExtracurricularHours()
      + " hrs");
    Typer.print("Job hours per week:        " + player.getJobHours() + " hrs");
    Typer.print("Free time per week:        " + player.getFreeHours() + " hrs");
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    Typer.print("\n--- SUMMER ---");
    if (player.getSummerJobs().isEmpty())
      Typer.print("You did not have any summer activities planned.");
    else
    {
      Typer.print("Summer activities:");
      for (SummerJob j : player.getSummerJobs())
        Typer.print("  - " + j.getName() + " | $"
          + String.format("%.2f", j.getTotalSummerPay()) + " total");
    }
    SummerJob.endOfSummer(player);
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    if (player.getLoanBalance() > 0)
    {
      Typer.print("\n--- LOAN REPAYMENT ---");
      boolean loanRepaid = Financials.repayLoan(player, scan);
      if (!loanRepaid)
      {
        Typer
          .print("Please reorganize your finances and try to end the year again.");
        Typer.print("Press enter to return to actions:");
        scan.nextLine();
        FourthYear.run(player);
        return;
      }
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
    }

    Typer.print("\n--- EMPLOYMENT SUMMARY ---");
    if (player.getJobs().isEmpty())
      Typer.print("You were not employed during the school year.");
    else
    {
      Typer.print("Jobs held this year:");
      for (Job j : player.getJobs())
        Typer.print("  - " + j.getName() + " | $"
          + String.format("%.2f", j.getWeeklyPay()) + "/week | "
          + j.getTimeWeekly() + " hrs/week");
    }
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    Typer.print("\n--- FULL YEAR WRAP UP ---");
    Typer.print("Final money saved:         $"
      + String.format("%.2f", player.getMoneySaved()));
    Typer.print("Outstanding loans:         $"
      + String.format("%.2f", player.getLoanBalance()));
    Typer.print("Net worth:                 $" + String
      .format("%.2f", player.getMoneySaved() - player.getLoanBalance()));
    Typer.print("\nPress enter to continue:");
    scan.nextLine();

    // --- HIGH SCHOOL COMPLETE MESSAGE ---
    Typer.print("\n=============================");
    Typer.print("   HIGH SCHOOL COMPLETE!");
    Typer.print("=============================");
    Typer.print(player.getName() + " has graduated from high school!");
    Typer.print("Money saved:     $"
      + String.format("%.2f", player.getMoneySaved()));
    Typer.print("Age:             " + player.getAge());
    if (player.getCurrentSport() != null)
      Typer.print("Sport mastery:   " + player.getCurrentSport().getName() + " "
        + player.getCurrentSport().getMastery() + "/10");
    Typer.print("\nThe next chapter begins...");
    Typer.print("Press enter to continue:");
    scan.nextLine();

    // --- CLEAR EVERYTHING ---
    player.getClassSchedule().getCurrentSchedule().clear();
    for (Job j : player.getJobs())
      player.setWeeklyIncome(player.getWeeklyIncome() - j.getWeeklyPay());
    player.getJobs().clear();
    player.getJoinedClubs().clear();
    player.getSummerJobs().clear();
    player.setSummerJobHours(0);
    player.resetTimeAllocation();
    player.incrementAge();
    Runner.yearInRunner++;

    // CollegeYear1.run(player); // uncomment when ready
  }
}
