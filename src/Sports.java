import java.util.*;
import java.util.InputMismatchException;

public class Sports
{
  // --- INSTANCE VARIABLES ---
  private String name;
  private String description;
  private int timeWeekly;
  private String season;
  private int extraTraining;
  private int mastery; // 0-10, builds over multiple years

  // --- CONSTRUCTOR ---
  public Sports(String name, String description, int timeWeekly)
  {
    this.name = name;
    this.description = description;
    this.timeWeekly = timeWeekly;
    this.extraTraining = 0;
    this.mastery = 0;
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

  public String getSeason()
  {
    return season;
  }

  public int getExtraTraining()
  {
    return extraTraining;
  }

  public int getMastery()
  {
    return mastery;
  }

  // total hours including extra training
  public int getTotalWeeklyHours()
  {
    return timeWeekly + extraTraining;
  }

  // --- SETTERS ---
  public void setExtraTraining(int hours)
  {
    extraTraining = hours;
  }

  // mastery increases by 1 each year they play, capped at 10
  public void increaseMastery()
  {
    if (mastery < 10)
      mastery++;
  }

  public void setMastery(int mastery)
  {
    if (mastery < 0)
      mastery = 0;
    if (mastery > 10)
      mastery = 10;
    this.mastery = mastery;
  }
  // --- SPORT INSTANCES ---

  public static Sports football =
    new Sports("Football",
               "Play on the school football team. High intensity, full contact sport "
                 + "with games on Friday nights.",
               15);

  public static Sports basketball =
    new Sports("Basketball",
               "Play on the school basketball team. Fast paced sport with games "
                 + "throughout the winter season.",
               15);

  public static Sports baseball =
    new Sports("Baseball",
               "Play on the school baseball team. America's pastime with a long "
                 + "spring season and frequent games.",
               15);

  public static Sports soccer =
    new Sports("Soccer",
               "Play on the school soccer team. High endurance sport with games "
                 + "throughout the fall season.",
               15);

  public static Sports swimming =
    new Sports("Swimming",
               "Compete on the school swim team. Individual and relay events "
                 + "with meets throughout the winter.",
               15);

  public static Sports trackAndField =
    new Sports("Track and Field",
               "Compete in running, jumping, or throwing events. Individual "
                 + "focused with spring meets.",
               10);

  public static Sports tennis =
    new Sports("Tennis",
               "Play on the school tennis team. Individual and doubles matches "
                 + "throughout the spring season.",
               10);

  public static Sports volleyball =
    new Sports("Volleyball",
               "Play on the school volleyball team. Team sport with matches "
                 + "throughout the fall season.",
               10);

  public static Sports wrestling =
    new Sports("Wrestling",
               "Compete on the school wrestling team. Physically demanding "
                 + "individual sport in the winter season.",
               10);

  public static Sports crossCountry =
    new Sports("Cross Country",
               "Run competitively as part of the school cross country team. "
                 + "Long distance running with fall meets.",
               10);

  // --- ALL SPORTS LIST ---
  public static ArrayList<Sports> allSports =
    new ArrayList<Sports>(Arrays.asList(football, basketball, baseball, soccer,
                                        swimming, trackAndField, tennis,
                                        volleyball, wrestling, crossCountry));

  // --- METHODS ---

  public static void printSportsList(ArrayList<Sports> sports)
  {
    if (sports != null)
    {
      for (int i = 0; i < sports.size(); i++)
      {
        Sports s = sports.get(i);
        Typer.print((i + 1) + ". " + s.getName() + " | Base hours: "
          + s.getTimeWeekly() + " hrs/week" + " | Mastery: " + s.getMastery()
          + "/10");
        Typer.print("   " + s.getDescription() + "\n");
      }
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

  // --- JOIN SPORT ---
  public static void joinSport(Player player, Scanner scan)
  {
    // check if already in a sport this year
    if (player.getCurrentSport() != null)
    {
      Typer
        .print("\nYou are already playing " + player.getCurrentSport().getName()
          + " this year. You can only play one sport per year.");
      return;
    }

    // check if they can afford the fee
    if (player.getMoneySaved() < 50.00)
    {
      Typer.print("\nYou cannot afford the $50.00 sign up fee for sports.");
      Typer.print("You currently have $"
        + String.format("%.2f", player.getMoneySaved()));
      return;
    }

    Typer.print("\n--- AVAILABLE SPORTS ---");
    Typer.print("Note: There is a $50.00 sign up fee for all sports.");
    Typer
      .print("Free hours available: " + player.getFreeHours() + " hrs/week\n");
    printSportsList(allSports);

    int choice =
      getValidInt(scan,
                  "\nEnter the number of the sport you want to join (or 0 to cancel):",
                  allSports.size());

    if (choice == 0)
      return;

    Sports chosen = allSports.get(choice - 1);

    // check free time for base hours
    if (chosen.getTimeWeekly() > player.getFreeHours())
    {
      Typer.print("You don't have enough free time for " + chosen.getName()
        + ". It requires " + chosen.getTimeWeekly()
        + " hrs/week but you only have " + player.getFreeHours()
        + " hrs free.");
      return;
    }

    // ask about extra training hours
    int freeAfterBase = player.getFreeHours() - chosen.getTimeWeekly();
    Typer.print("\n" + chosen.getName() + " requires " + chosen.getTimeWeekly()
      + " base hrs/week.");
    Typer.print("You have " + freeAfterBase
      + " hrs/week left after base practice.");
    Typer.print("Extra training increases your mastery level each year.");

    int extraHours = -1;
    if (freeAfterBase > 0)
    {
      Typer
        .print("How many extra training hours per week would you like to add? (0-"
          + freeAfterBase + "):");
      extraHours = getValidInt(scan, "", freeAfterBase);
    }
    else
    {
      Typer.print("You have no free hours left for extra training.");
      extraHours = 0;
    }

    chosen.setExtraTraining(extraHours);

    // charge the fee
    player.setMoneySaved(player.getMoneySaved() - 50.00);

    // set sport and update hours
    player.setCurrentSport(chosen);
    player.setExtracurricularHours(player.getExtracurricularHours()
      + chosen.getTotalWeeklyHours());

    Typer.print("\nYou have joined " + chosen.getName() + "!");
    Typer.print("Sign up fee paid:     -$50.00");
    Typer.print("Money remaining:      $"
      + String.format("%.2f", player.getMoneySaved()));
    Typer
      .print("Base hours:           " + chosen.getTimeWeekly() + " hrs/week");
    Typer.print("Extra training:       " + extraHours + " hrs/week");
    Typer.print("Total hours:          " + chosen.getTotalWeeklyHours()
      + " hrs/week");
    Typer.print("Current mastery:      " + chosen.getMastery() + "/10");
    Typer.print("Free hours remaining: " + player.getFreeHours() + " hrs/week");
  }

  // --- QUIT SPORT ---
  public static void quitSport(Player player, Scanner scan)
  {
    if (player.getCurrentSport() == null)
    {
      Typer.print("\nYou are not currently playing any sport.");
      return;
    }

    Sports current = player.getCurrentSport();

    Typer.print("\nCurrent sport: " + current.getName());
    Typer.print("Hours/week:    " + current.getTotalWeeklyHours() + " hrs");
    Typer.print("Mastery:       " + current.getMastery() + "/10");
    Typer.print("\nNote: Quitting will not refund the $50.00 sign up fee.");
    Typer.print("Are you sure you want to quit? (yes/no):");

    String confirm = scan.next();
    scan.nextLine();

    if (confirm.equalsIgnoreCase("yes"))
    {
      player.setExtracurricularHours(player.getExtracurricularHours()
        - current.getTotalWeeklyHours());
      player.setCurrentSport(null);
      Typer.print("You have quit " + current.getName() + ".");
      Typer.print("Hours returned:  " + current.getTotalWeeklyHours()
        + " hrs/week");
      Typer.print("Free hours now:  " + player.getFreeHours() + " hrs/week");
      Typer.print("Note: Your mastery progress has been lost.");
    }
    else
    {
      Typer.print("You decided to stay on the team.");
    }
  }

  // called at end of year to increase mastery if they stuck with the sport
  public static void endOfYearSportUpdate(Player player)
  {
    if (player.getCurrentSport() != null)
    {
      Sports s = player.getCurrentSport();
      s.increaseMastery();
      Typer.print("\n--- SPORT UPDATE ---");
      Typer.print("Sport:   " + s.getName());
      Typer.print("Mastery: " + s.getMastery() + "/10"
        + (s.getMastery() == 10 ? " (MAX!)" : " (+" + 1 + ")"));
    }
  }
}