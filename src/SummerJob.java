import java.util.*;
import java.util.InputMismatchException;

public class SummerJob
{
  // --- INSTANCE VARIABLES ---
  private String name;
  private String description;
  private int timeWeekly;
  private double weeklyPay;
  private String resumeStrength;
  private String type;

  // --- CONSTANTS ---
  public static final int SUMMER_WEEKS = 12;
  public static final int SUMMER_TOTAL_HOURS = 168;
  public static final int SUMMER_SLEEP_HOURS = 56;
  public static final int SUMMER_AMENITY_HOURS = 21;
  public static final int SUMMER_BASE_FREE_HOURS = 91; // 168 - 56 - 21
  public static final double CAMP_COST = 250.00;

  // --- CONSTRUCTOR ---
  public SummerJob(String name, String description, int timeWeekly,
    double weeklyPay, String resumeStrength, String type)
  {
    this.name = name;
    this.description = description;
    this.timeWeekly = timeWeekly;
    this.weeklyPay = weeklyPay;
    this.resumeStrength = resumeStrength;
    this.type = type;
  }

  // --- GETTERS ---
  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public int getTimeWeekly()
  {
    return timeWeekly;
  }

  public double getWeeklyPay()
  {
    return weeklyPay;
  }

  public String getResumeStrength()
  {
    return resumeStrength;
  }

  public String getType()
  {
    return type;
  }

  // total pay over the whole summer
  public double getTotalSummerPay()
  {
    return weeklyPay * SUMMER_WEEKS;
  }

  // --- SUMMER JOB INSTANCES ---

  public static SummerJob lifeguard =
    new SummerJob("Lifeguard",
                  "Guard swimmers at the Red Grove community pool. "
                    + "Requires focus and responsibility. CPR certification provided.",
                  20, 150.00, "medium", "service");
  // 20 hrs/week, $150/week = $1350 total

  public static SummerJob summerCamp =
    new SummerJob("Prestigious Summer Camp",
                  "Attend an elite summer leadership and academic camp. "
                    + "Highly competitive and impressive on college applications. "
                    + "Costs $250 to attend but opens doors for the future.",
                  60, 0.00, "very strong", "academic");
  // 60 hrs/week, costs $250, no pay

  public static SummerJob summerInternship =
    new SummerJob("Summer Internship",
                  "Intern at a local business over the summer. Low pay but "
                    + "great professional experience and networking opportunities.",
                  25, 80.00, "strong", "professional");
  // 25 hrs/week, $80/week = $720 total

  public static SummerJob iceCreamScooper =
    new SummerJob("Ice Cream Scooper",
                  "Scoop ice cream at a local parlor in Red Grove. "
                    + "Easy going summer job with decent pay and flexible hours.",
                  15, 100.00, "weak", "service");
  // 15 hrs/week, $100/week = $900 total

  public static SummerJob restaurantWaiter =
    new SummerJob("Restaurant Waiter",
                  "Wait tables full time over the summer at a local restaurant. "
                    + "High time commitment but the best paying summer option with tips.",
                  35, 250.00, "weak", "service");
  // 35 hrs/week, $250/week = $2250 total

  public static SummerJob sportsTraining =
    new SummerJob("General Sports Training",
                  "Train intensively in your current sport over the summer. "
                    + "Adds +4 mastery to your sport. Requires 40 hours a week.",
                  40, 0.00, "medium", "athletics");
  // 40 hrs/week, no pay, +4 mastery

  // --- ALL SUMMER JOBS LIST ---
  public static ArrayList<SummerJob> allSummerJobs =
    new ArrayList<SummerJob>(Arrays.asList(lifeguard, summerCamp,
                                           summerInternship, iceCreamScooper,
                                           restaurantWaiter, sportsTraining));

  // --- METHODS ---

  public static void printSummerJobList(ArrayList<SummerJob> jobs)
  {
    for (int i = 0; i < jobs.size(); i++)
    {
      SummerJob j = jobs.get(i);
      Typer.print((i + 1) + ". " + j.getName() + " | "
        + j.getType().toUpperCase() + " | " + j.getTimeWeekly() + " hrs/week"
        + " | Pay: $" + String.format("%.2f", j.getWeeklyPay()) + "/week ($"
        + String.format("%.2f", j.getTotalSummerPay()) + " total)"
        + " | Resume: " + j.getResumeStrength());
      Typer.print("   " + j.getDescription() + "\n");
    }
  }

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

  // returns jobs the player hasnt already signed up for
  public static ArrayList<SummerJob> getEligibleSummerJobs(ArrayList<SummerJob> currentJobs,
                                                           Player player)
  {
    ArrayList<SummerJob> eligible = new ArrayList<SummerJob>();
    for (SummerJob j : allSummerJobs)
    {
      // skip if already signed up
      if (currentJobs.contains(j))
        continue;

      // skip sports training if player has no current sport
      if (j.getType().equals("athletics") && player.getCurrentSport() == null)
        continue;

      eligible.add(j);
    }
    return eligible;
  }

  // --- ADD SUMMER JOB ---
  public static void addSummerJob(Player player, Scanner scan)
  {
    ArrayList<SummerJob> eligible =
      getEligibleSummerJobs(player.getSummerJobs(), player);

    if (eligible.isEmpty())
    {
      Typer.print("\nThere are no summer jobs available to you right now.");
      return;
    }

    Typer.print("\n--- AVAILABLE SUMMER JOBS ---");
    Typer.print("Free summer hours available: " + player.getSummerFreeHours()
      + " hrs/week\n");
    printSummerJobList(eligible);

    int choice =
      getValidInt(scan,
                  "\nEnter the number of the job you want to take (or 0 to cancel):",
                  eligible.size());

    if (choice == 0)
      return;

    SummerJob chosen = eligible.get(choice - 1);

    // check free time
    if (chosen.getTimeWeekly() > player.getSummerFreeHours())
    {
      Typer.print("You don't have enough free time for " + chosen.getName()
        + ". It requires " + chosen.getTimeWeekly()
        + " hrs/week but you only have " + player.getSummerFreeHours()
        + " hrs free.");
      return;
    }

    // handle summer camp cost
    if (chosen == summerCamp)
    {
      if (player.getMoneySaved() < CAMP_COST)
      {
        Typer.print("You cannot afford the $" + String.format("%.2f", CAMP_COST)
          + " camp fee.");
        Typer.print("You currently have $"
          + String.format("%.2f", player.getMoneySaved()));
        return;
      }
      player.setMoneySaved(player.getMoneySaved() - CAMP_COST);
      Typer.print("Camp fee paid: -$" + String.format("%.2f", CAMP_COST));
    }

    // handle sports training mastery boost
    if (chosen == sportsTraining)
    {
      player.getCurrentSport().increaseMastery();
      player.getCurrentSport().increaseMastery();
      player.getCurrentSport().increaseMastery();
      player.getCurrentSport().increaseMastery();
      Typer.print("Sports training complete!");
      Typer.print("Your mastery in " + player.getCurrentSport().getName()
        + " increased by 4!");
      Typer
        .print("New mastery: " + player.getCurrentSport().getMastery() + "/10");
    }

    // add job and update summer hours
    player.getSummerJobs().add(chosen);
    player
      .setSummerJobHours(player.getSummerJobHours() + chosen.getTimeWeekly());

    Typer.print("\n" + chosen.getName() + " added to your summer!");
    Typer.print("Hours committed:          " + chosen.getTimeWeekly()
      + " hrs/week");
    if (chosen.getWeeklyPay() > 0)
    {
      Typer.print("Weekly pay:               $"
        + String.format("%.2f", chosen.getWeeklyPay()));
      Typer.print("Total summer earnings:    $"
        + String.format("%.2f", chosen.getTotalSummerPay()));
    }
    Typer.print("Free hours remaining:     " + player.getSummerFreeHours()
      + " hrs/week");
  }

  // --- REMOVE SUMMER JOB ---
  public static void removeSummerJob(Player player, Scanner scan)
  {
    if (player.getSummerJobs().isEmpty())
    {
      Typer.print("\nYou have not signed up for any summer activities yet.");
      return;
    }

    Typer.print("\n--- YOUR SUMMER ACTIVITIES ---");
    printSummerJobList(player.getSummerJobs());

    int choice =
      getValidInt(scan,
                  "\nEnter the number of the activity you want to remove (or 0 to cancel):",
                  player.getSummerJobs().size());

    if (choice == 0)
      return;

    SummerJob chosen = player.getSummerJobs().get(choice - 1);

    Typer.print("\nAre you sure you want to remove " + chosen.getName()
      + "? (yes/no):");
    String confirm = scan.next();
    scan.nextLine();

    if (confirm.equalsIgnoreCase("yes"))
    {
      player.getSummerJobs().remove(chosen);
      player
        .setSummerJobHours(player.getSummerJobHours() - chosen.getTimeWeekly());

      // remove mastery if they drop sports training
      if (chosen == sportsTraining)
      {
        // subtract 4 mastery but dont let it go below 0
        Sports currentSport = player.getCurrentSport();
        if (currentSport != null)
        {
          int newMastery = currentSport.getMastery() - 4;
          if (newMastery < 0)
            newMastery = 0;
          currentSport.setMastery(newMastery);
          Typer
            .print("Mastery in " + currentSport.getName() + " reduced by 4.");
          Typer.print("New mastery: " + currentSport.getMastery() + "/10");
        }
      }

      if (chosen == summerCamp)
        Typer.print("Note: The $" + String.format("%.2f", SummerJob.CAMP_COST)
          + " camp fee is non-refundable.");

      Typer
        .print("Free hours returned: " + chosen.getTimeWeekly() + " hrs/week");
      Typer.print("Free hours now:      " + player.getSummerFreeHours()
        + " hrs/week");
    }
  }

  // --- VIEW SUMMER PLAN ---
  public static void viewSummerPlan(Player player)
  {
    Typer.print("\n--- SUMMER PLAN ---");
    Typer.print("Summer length:       " + SUMMER_WEEKS + " weeks");
    Typer.print("Free hrs/week:       " + SUMMER_BASE_FREE_HOURS + " hrs");
    Typer.print("Hours committed:     " + player.getSummerJobHours()
      + " hrs/week");
    Typer.print("Hours remaining:     " + player.getSummerFreeHours()
      + " hrs/week\n");

    if (player.getSummerJobs().isEmpty())
    {
      Typer.print("No summer activities planned yet.");
      return;
    }

    double totalEarnings = 0;
    Typer.print("Activities:");
    for (SummerJob j : player.getSummerJobs())
    {
      Typer.print("- " + j.getName() + " | " + j.getTimeWeekly() + " hrs/week"
        + " | $" + String.format("%.2f", j.getTotalSummerPay()) + " total");
      totalEarnings += j.getTotalSummerPay();
    }

    Typer.print("\nTotal summer earnings: $"
      + String.format("%.2f", totalEarnings));
  }

  // --- END OF SUMMER - adds earnings to player and resets ---
  public static void endOfSummer(Player player)
  {
    double totalEarnings = 0;
    for (SummerJob j : player.getSummerJobs())
      totalEarnings += j.getTotalSummerPay();

    player.setMoneySaved(player.getMoneySaved() + totalEarnings);

    Typer.print("\n--- END OF SUMMER ---");
    Typer.print("Total earned this summer: $"
      + String.format("%.2f", totalEarnings));
    Typer.print("Money saved:              $"
      + String.format("%.2f", player.getMoneySaved()));

    // reset summer fields
    player.getSummerJobs().clear();
    player.setSummerJobHours(0);
  }

  public static void runOption(Player player)
  {
    Scanner scan = new Scanner(System.in);

    Typer.print("\n--- SUMMER ---");
    Typer.print("What would you like to do this summer?");
    Typer.print("View Summer Plan - (a)");
    Typer.print("Add Summer Activity - (b)");
    Typer.print("Remove Summer Activity - (c)");
    Typer.print("View Time Budget - (d)");
    Typer.print("Return to Actions - (e)");

    String letter = scan.next();
    scan.nextLine();

    // --- VIEW SUMMER PLAN ---
    if (letter.equals("a") || letter.equals("A"))
    {
      viewSummerPlan(player);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- ADD SUMMER ACTIVITY ---
    else if (letter.equals("b") || letter.equals("B"))
    {
      addSummerJob(player, scan);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- REMOVE SUMMER ACTIVITY ---
    else if (letter.equals("c") || letter.equals("C"))
    {
      removeSummerJob(player, scan);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- VIEW TIME BUDGET ---
    else if (letter.equals("d") || letter.equals("D"))
    {
      Typer.print("\n--- SUMMER TIME BUDGET ---");
      Typer.print("Total hours in a week:     168 hrs");
      Typer.print("Sleep (8 hrs/night):       -56 hrs");
      Typer.print("Eating/hygiene/amenities:  -21 hrs");
      Typer.print("---------------------------");
      Typer.print("Base free hours:            91 hrs");
      Typer.print("");
      Typer.print("Activities committed:      -" + player.getSummerJobHours()
        + " hrs");
      Typer.print("---------------------------");
      Typer.print("Free hours remaining:       " + player.getSummerFreeHours()
        + " hrs/week");
      Typer.print("");

      // show breakdown per activity
      if (!player.getSummerJobs().isEmpty())
      {
        Typer.print("Breakdown:");
        for (SummerJob j : player.getSummerJobs())
        {
          Typer.print("  - " + j.getName() + ": " + j.getTimeWeekly()
            + " hrs/week");
        }
      }

      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- RETURN TO ACTIONS ---
    else if (letter.equals("e") || letter.equals("E"))
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