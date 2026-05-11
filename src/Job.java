import java.util.*;
import java.util.InputMismatchException;

public class Job
{
  // --- INSTANCE VARIABLES ---
  private String name;
  private String description;
  private int prerequisiteAge;
  private int timeWeekly;
  private String resumeStrength;
  private String type;
  private double weeklyPay;

  // --- CONSTRUCTOR ---
  public Job(String name, String description, int prerequisiteAge,
    int timeWeekly, String resumeStrength, String type, double weeklyPay)
  {
    this.name = name;
    this.description = description;
    this.resumeStrength = resumeStrength;
    this.prerequisiteAge = prerequisiteAge;
    this.timeWeekly = timeWeekly;
    this.type = type;
    this.weeklyPay = weeklyPay;
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

  public String getResumeStrength()
  {
    return resumeStrength;
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

  public double getWeeklyPay()
  {
    return weeklyPay;
  }

  // --- JOB INSTANCES ---

  public static Job restaurantWaiter =
    new Job("Restaurant Waiter",
            "Wait tables at a local diner on weekends. Good pay with tips but "
              + "physically demanding and requires a friendly attitude.",
            14, 12, "low", "service", 180.00);
  // 12 hrs/week, ~$15/hr

  public static Job tutor =
    new Job("Peer Tutor",
            "Tutor younger or struggling students in subjects you excel at. "
              + "Flexible hours and looks great on college applications.",
            14, 6, "high", "academic", 90.00);
  // 6 hrs/week, ~$15/hr

  public static Job dogShelterVolunteer =
    new Job("Dog Shelter Volunteer",
            "Volunteer at the Red Grove Animal Shelter. Walk dogs, clean kennels, "
              + "and help with adoption events. No pay but builds character and community ties.",
            14, 5, "medium", "volunteer", 0.00);
  // 5 hrs/week, no pay but good resume

  public static Job businessIntern =
    new Job("Local Business Internship",
            "Intern at a local business in Red Grove. Shadow professionals, "
              + "assist with projects, and build real world skills. "
              + "Heavy time commitment but the strongest resume builder available.",
            15, 20, "very high", "professional", 60.00);
  // 15 hrs/week, small stipend

  // --- ALL JOBS LIST ---
  public static ArrayList<Job> allJobs =
    new ArrayList<Job>(Arrays.asList(restaurantWaiter, tutor,
                                     dogShelterVolunteer, businessIntern));

  // --- METHODS ---

  public static ArrayList<Job> getEligibleJobs(ArrayList<Job> currentJobs,
                                               int age)
  {
    ArrayList<Job> eligible = new ArrayList<Job>();
    for (Job j : allJobs)
    {
      if (age >= j.getPrerequisiteAge() && !currentJobs.contains(j))
        eligible.add(j);
    }
    return eligible;
  }

  public static void printJobList(ArrayList<Job> jobs)
  {
    for (int i = 0; i < jobs.size(); i++)
    {
      Job j = jobs.get(i);
      Typer.print((i + 1) + ". " + j.getName() + " | "
        + j.getType().toUpperCase() + " | " + j.getTimeWeekly() + " hrs/week"
        + " | Pay: $" + String.format("%.2f", j.getWeeklyPay()) + "/week"
        + " | Resume Strength: " + j.getResumeStrength());
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

  // --- GET JOB ---
  public static void getJob(Player player, Scanner scan)
  {
    ArrayList<Job> eligible =
      getEligibleJobs(player.getJobs(), player.getAge());

    if (eligible.isEmpty())
    {
      Typer.print("\nThere are no jobs available to you right now.");
      return;
    }

    Typer.print("\n--- AVAILABLE JOBS ---");
    Typer
      .print("Free hours available: " + player.getFreeHours() + " hrs/week\n");
    printJobList(eligible);

    int choice =
      getValidInt(scan,
                  "\nEnter the number of the job you want to apply for (or 0 to cancel):",
                  eligible.size());

    if (choice == 0)
      return;

    Job chosen = eligible.get(choice - 1);

    if (chosen.getTimeWeekly() > player.getFreeHours())
    {
      Typer.print("You don't have enough free time for " + chosen.getName()
        + ". It requires " + chosen.getTimeWeekly()
        + " hrs/week but you only have " + player.getFreeHours()
        + " hrs free.");
      return;
    }

    player.addJob(chosen);

    Typer.print("\nCongratulations! You got the job as a " + chosen.getName()
      + "!");
    Typer
      .print("Hours committed:      " + chosen.getTimeWeekly() + " hrs/week");
    Typer.print("Weekly pay:           $"
      + String.format("%.2f", chosen.getWeeklyPay()));
    Typer.print("Free hours remaining: " + player.getFreeHours() + " hrs/week");
  }

  // --- QUIT JOB ---
  public static void quitJob(Player player, Scanner scan)
  {
    if (player.getJobs().isEmpty())
    {
      Typer.print("\nYou don't currently have any jobs.");
      return;
    }

    Typer.print("\n--- YOUR JOBS ---");
    printJobList(player.getJobs());

    int choice =
      getValidInt(scan,
                  "\nEnter the number of the job you want to quit (or 0 to cancel):",
                  player.getJobs().size());

    if (choice == 0)
      return;

    Job chosen = player.getJobs().get(choice - 1);

    Typer.print("\nAre you sure you want to quit " + chosen.getName()
      + "? (yes/no):");
    String confirm = scan.next();
    scan.nextLine();

    if (confirm.equalsIgnoreCase("yes"))
    {
      player.removeJob(chosen);
      Typer.print("You have quit your job as a " + chosen.getName() + ".");
      Typer.print("Hours returned:  " + chosen.getTimeWeekly() + " hrs/week");
      Typer.print("Free hours now:  " + player.getFreeHours() + " hrs/week");
    }
    else
    {
      Typer.print("You decided to keep your job.");
    }
  }
}