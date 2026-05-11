
/**
 * Preference file version 110624
 * 
 * @author: Your First and Last name goes here!
 *          VHS Learning
 */
import java.util.*;

public class Clubs
{
  // --- INSTANCE VARIABLES ---
  private String name;
  private String description;
  private int difficultyLevel;
  private int year;
  private int prerequisiteAge;
  private int timeWeekly;
  private String type;

  // --- CONSTRUCTOR ---
  public Clubs(String name, String description, int difficultyLevel, int year,
    int prerequisiteAge, int timeWeekly, String type)
  {
    this.name = name;
    this.description = description;
    this.difficultyLevel = difficultyLevel;
    this.year = year;
    this.prerequisiteAge = prerequisiteAge;
    this.timeWeekly = timeWeekly;
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

  public int getDifficultyLevel()
  {
    return difficultyLevel;
  }

  public int getYear()
  {
    return year;
  }

  public int getPrerequisiteAge()
  {
    return prerequisiteAge;
  }

  public int getTimeWeekly()
  {
    return timeWeekly;
  }

  public String getType()
  {
    return type;
  }

  // --- ALL CLUB INSTANCES ---

  // --- ART & PERFORMANCE ---
  public static Clubs artClub =
    new Clubs("Art Club",
              "Create paintings, drawings, and mixed media projects. Showcase work at the end of year art show.",
              2, Runner.yearInRunner, 14, 2, "art");

  public static Clubs dramaClub =
    new Clubs("Drama Club",
              "Rehearse and perform in school plays and musicals. Open to all experience levels.",
              3, Runner.yearInRunner, 14, 4, "art");

  // --- ACADEMIC ---
  public static Clubs modelUN =
    new Clubs("Model UN",
              "Simulate United Nations debates. Research global issues and represent assigned countries.",
              5, Runner.yearInRunner, 14, 3, "academic");

  public static Clubs debateClub =
    new Clubs("Debate Club",
              "Compete in regional debate tournaments. Develops public speaking and critical thinking.",
              5, Runner.yearInRunner, 14, 3, "academic");

  public static Clubs roboticsClub =
    new Clubs("Robotics Club",
              "Design and build robots to compete in regional competitions. No experience required.",
              5, Runner.yearInRunner, 14, 5, "tech");

  public static Clubs foreignLanguageClub =
    new Clubs("Foreign Language Club",
              "Explore world cultures through food, film, and conversation in a foreign language.",
              2, Runner.yearInRunner, 14, 2, "academic");

  // --- CIVIC & LEADERSHIP ---
  public static Clubs studentCouncil =
    new Clubs("Student Council",
              "Represent your class in school government. Organize events and advocate for students.",
              4, Runner.yearInRunner, 14, 3, "leadership");

  public static Clubs environmentalClub =
    new Clubs("Environmental Club",
              "Organize recycling drives, clean ups, and awareness campaigns for local environmental issues.",
              2, Runner.yearInRunner, 14, 2, "civic");

  public static Clubs yearbook =
    new Clubs("Yearbook Club",
              "Design and produce the school yearbook. Involves photography, writing, and layout.",
              3, Runner.yearInRunner, 14, 3, "art");

  // --- ALL CLUBS LIST ---
  public static ArrayList<Clubs> allClubs =
    new ArrayList<Clubs>(Arrays.asList(
                                       // ART & PERFORMANCE
                                       artClub, dramaClub,

                                       // ACADEMIC
                                       modelUN, debateClub, foreignLanguageClub,

                                       // TECH
                                       roboticsClub,
                                       // CIVIC & LEADERSHIP
                                       studentCouncil, environmentalClub,
                                       yearbook

    ));

  // --- METHODS ---

  // returns clubs the player is old enough to join and hasnt joined yet
  public static ArrayList<Clubs> getEligibleClubs(ArrayList<Clubs> joinedClubs,
                                                  int age)
  {
    ArrayList<Clubs> eligible = new ArrayList<Clubs>();
    for (Clubs c : allClubs)
    {
      if (age >= c.getPrerequisiteAge() && !joinedClubs.contains(c))
        eligible.add(c);
    }
    return eligible;
  }

  // safe int input helper
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

  // displays list of clubs
  public static void printClubList(ArrayList<Clubs> clubs)
  {
    for (int i = 0; i < clubs.size(); i++)
    {
      Clubs c = clubs.get(i);
      Typer.print((i + 1) + ". " + c.getName() + " | "
        + c.getType().toUpperCase() + " | " + c.getTimeWeekly() + " hrs/week"
        + " | Difficulty: " + c.getDifficultyLevel() + "/10");
      Typer.print("   " + c.getDescription() + "\n");
    }
  }

  // --- JOIN CLUBS ---
  public static void joinClubs(Player player, Scanner scan)
  {
    ArrayList<Clubs> eligible =
      getEligibleClubs(player.getJoinedClubs(), player.getAge());

    if (eligible.isEmpty())
    {
      Typer.print("\nThere are no clubs available to join.");
      return;
    }

    Typer.print("\n--- AVAILABLE CLUBS ---");
    Typer
      .print("Free hours available: " + player.getFreeHours() + " hrs/week\n");
    printClubList(eligible);

    int choice =
      getValidInt(scan,
                  "\nEnter the number of the club you want to join (or 0 to cancel):",
                  eligible.size());

    if (choice == 0)
      return;

    Clubs chosen = eligible.get(choice - 1);

    if (chosen.getTimeWeekly() > player.getFreeHours())
    {
      Typer.print("You don't have enough free time for " + chosen.getName()
        + ". It requires " + chosen.getTimeWeekly()
        + " hrs/week but you only have " + player.getFreeHours()
        + " hrs free.");
      return;
    }

    player.getJoinedClubs().add(chosen);
    player.setExtracurricularHours(player.getExtracurricularHours()
      + chosen.getTimeWeekly());

    Typer.print(chosen.getName() + " joined!");
    Typer.print("Hours committed: " + chosen.getTimeWeekly() + " hrs/week");
    Typer.print("Free hours remaining: " + player.getFreeHours() + " hrs/week");
  }

  // --- EDIT CLUBS ---
  public static void editClubs(Player player, Scanner scan)
  {
    ArrayList<Clubs> joined = player.getJoinedClubs();

    if (joined.isEmpty())
    {
      Typer.print("\nYou have not joined any clubs yet.");
      return;
    }

    Typer.print("\n--- YOUR CLUBS ---");
    printClubList(joined);

    int choice =
      getValidInt(scan,
                  "\nEnter the number of the club you want to leave (or 0 to cancel):",
                  joined.size());

    if (choice == 0)
      return;

    Clubs chosen = joined.get(choice - 1);
    joined.remove(chosen);
    player.setExtracurricularHours(player.getExtracurricularHours()
      - chosen.getTimeWeekly());

    Typer.print("You have left " + chosen.getName() + ".");
    Typer.print("Hours returned: " + chosen.getTimeWeekly() + " hrs/week");
    Typer.print("Free hours now: " + player.getFreeHours() + " hrs/week");
  }
}