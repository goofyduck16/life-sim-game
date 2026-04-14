
/**
 * Preference file version 110624
 * 
 * @author: Your First and Last name goes here!
 *          VHS Learning
 */
import java.util.*;

public class School
{
  static int year = Runner.yearInRunner;
  // --- MATHS ---
  static HighSchoolClass algebra2 =
    new HighSchoolClass("Algebra 2",
                        "Advanced algebra including functions, polynomials, and logarithms.",
                        "Mr. Garcia", "math", 5, year, 1, 16, "None", 5);
  static HighSchoolClass honorsAlgebra2 =
    new HighSchoolClass("Honors Algebra 2",
                        "Accelerated advanced algebra with college prep rigor.",
                        "Mr. Peterson", "math", 7, year, 1, 16, "None", 5);
  static HighSchoolClass geometry =
    new HighSchoolClass("Geometry",
                        "Study of shapes, angles, proofs, and spatial reasoning.",
                        "Ms. Huang", "math", 4, year, 1, 15, "None", 5);
  static HighSchoolClass honorsGeometry =
    new HighSchoolClass("Honors Geometry",
                        "Accelerated geometry with formal proofs and spatial reasoning.",
                        "Ms. Huang", "math", 6, year, 1, 15, "None", 5);
  static HighSchoolClass precalc =
    new HighSchoolClass("Pre-Calculus",
                        "Preparation for calculus including trigonometry and functions.",
                        "Mr. Garcia", "math", 6, year, 1, 17,
                        "Algebra 2 or Honors Algebra 2", 5);
  static HighSchoolClass honorsPrecalc =
    new HighSchoolClass("Honors Pre-Calculus",
                        "Accelerated preparation for calculus with advanced trigonometry.",
                        "Mr. Peterson", "math", 7, year, 1, 17,
                        "Algebra 2 or Honors Algebra 2", 5);
  static HighSchoolClass calcAB =
    new HighSchoolClass("AP Calculus AB",
                        "College level calculus covering limits, derivatives, and integrals.",
                        "Mr. Peterson", "math", 9, year, 1, 17,
                        "Pre-Calculus or Honors Pre-Calculus", 5);
  static HighSchoolClass calcBC =
    new HighSchoolClass("AP Calculus BC",
                        "Advanced college level calculus extending AB with series and more.",
                        "Ms. Huang", "math", 10, year, 1, 17, "AP Calculus AB",
                        5);
  static HighSchoolClass statistics =
    new HighSchoolClass("Statistics",
                        "Introduction to data analysis, probability, and statistical reasoning.",
                        "Mr. Garcia", "math", 4, year, 1, 16,
                        "Algebra 2 or Honors Algebra 2", 5);
  static HighSchoolClass apStatistics =
    new HighSchoolClass("AP Statistics",
                        "College level statistics with AP exam preparation.",
                        "Ms. Huang", "math", 7, year, 1, 17,
                        "Algebra 2 or Honors Algebra 2", 5);

  // --- ENGLISH ---

  static HighSchoolClass english1 =
    new HighSchoolClass("English 1",
                        "Introduction to literature, grammar, and essay writing.",
                        "Mrs. Thompson", "english", 3, year, 1, 14, "None", 5);
  static HighSchoolClass honorsEnglish1 =
    new HighSchoolClass("Honors English 1",
                        "Accelerated literature and writing with advanced texts.",
                        "Mr. Calloway", "english", 5, year, 1, 14, "None", 5);
  static HighSchoolClass english2 =
    new HighSchoolClass("English 2",
                        "Advanced literature analysis and persuasive writing.",
                        "Mrs. Thompson", "english", 4, year, 1, 15,
                        "English 1 or Honors English 1", 5);
  static HighSchoolClass honorsEnglish2 =
    new HighSchoolClass("Honors English 2",
                        "Accelerated literature analysis and advanced essay writing.",
                        "Mr. Calloway", "english", 6, year, 1, 15,
                        "English 1 or Honors English 1", 5);
  static HighSchoolClass english3 =
    new HighSchoolClass("English 3",
                        "American literature and advanced composition.",
                        "Ms. Okafor", "english", 4, year, 1, 16,
                        "English 2 or Honors English 2", 5);
  static HighSchoolClass honorsEnglish3 =
    new HighSchoolClass("Honors English 3",
                        "Accelerated American literature and research writing.",
                        "Mr. Calloway", "english", 6, year, 1, 16,
                        "English 2 or Honors English 2", 5);
  static HighSchoolClass english4 =
    new HighSchoolClass("English 4",
                        "British literature, senior research paper, and college prep writing.",
                        "Ms. Okafor", "english", 5, year, 1, 17,
                        "English 3 or Honors English 3", 5);
  static HighSchoolClass honorsEnglish4 =
    new HighSchoolClass("Honors English 4",
                        "Accelerated British literature and advanced college prep writing.",
                        "Mrs. Thompson", "english", 7, year, 1, 17,
                        "English 3 or Honors English 3", 5);
  static HighSchoolClass apLanguage =
    new HighSchoolClass("AP Language and Composition",
                        "College level rhetoric, argument, and non-fiction analysis.",
                        "Mr. Calloway", "english", 9, year, 1, 16,
                        "English 2 or Honors English 2", 5);
  static HighSchoolClass creativeWriting =
    new HighSchoolClass("Creative Writing",
                        "Fiction, poetry, and personal narrative writing workshop.",
                        "Mrs. Thompson", "english", 3, year, 1, 15,
                        "English 1 or Honors English 1", 3);
  static HighSchoolClass creativeWritingElective =
    new HighSchoolClass("Creative Writing",
                        "Fiction, poetry, and personal narrative writing workshop.",
                        "Mr. Calloway", "english", 3, year, 1, 14, "None", 3);

  // --- SCIENCES ---

  static HighSchoolClass honorsIntroPhysics =
    new HighSchoolClass("Honors Intro to Physics",
                        "Conceptual introduction to motion, energy, and forces. No calculus required.",
                        "Mr. Nakamura", "science", 3, year, 1, 14, "None", 5);
  static HighSchoolClass biology =
    new HighSchoolClass("Biology",
                        "Introduction to living organisms, cells, and ecosystems.",
                        "Ms. Patel", "science", 4, year, 1, 14, "None", 5);
  static HighSchoolClass honorsBiology =
    new HighSchoolClass("Honors Biology",
                        "Accelerated biology with lab emphasis and advanced concepts.",
                        "Ms. Patel", "science", 6, year, 1, 14, "None", 5);
  static HighSchoolClass chemistry =
    new HighSchoolClass("Chemistry",
                        "Introduction to atoms, molecules, reactions, and the periodic table.",
                        "Mr. Nakamura", "science", 5, year, 1, 15,
                        "Biology or Honors Biology", 5);
  static HighSchoolClass honorsChemistry =
    new HighSchoolClass("Honors Chemistry",
                        "Accelerated chemistry with advanced problem solving and lab work.",
                        "Ms. Reyes", "science", 7, year, 1, 15,
                        "Biology or Honors Biology", 5);
  static HighSchoolClass physics =
    new HighSchoolClass("Physics",
                        "Study of motion, energy, waves, and forces.",
                        "Mr. Nakamura", "science", 6, year, 1, 16,
                        "Algebra 2 or Honors Algebra 2", 5);
  static HighSchoolClass honorsPhysics =
    new HighSchoolClass("Honors Physics",
                        "Accelerated physics with calculus based problem solving.",
                        "Ms. Reyes", "science", 8, year, 1, 16,
                        "Algebra 2 or Honors Algebra 2", 5);
  static HighSchoolClass apBiology =
    new HighSchoolClass("AP Biology",
                        "College level biology with AP exam preparation.",
                        "Ms. Patel", "science", 9, year, 1, 17, "Biology", 5);
  static HighSchoolClass apChemistry =
    new HighSchoolClass("AP Chemistry",
                        "College level chemistry with AP exam preparation.",
                        "Ms. Reyes", "science", 9, year, 1, 16,
                        "Honors Chemistry", 5);
  static HighSchoolClass apPhysics =
    new HighSchoolClass("AP Physics",
                        "College level physics with AP exam preparation.",
                        "Mr. Nakamura", "science", 9, year, 1, 17,
                        "Honors Physics or Physics or Honors Intro to Physics",
                        5);
  static HighSchoolClass environmentalScience =
    new HighSchoolClass("Environmental Science",
                        "Study of ecosystems, climate, and human impact on the environment.",
                        "Ms. Patel", "science", 3, year, 1, 15,
                        "Biology or Honors Biology", 5);
  static HighSchoolClass psychology =
    new HighSchoolClass("Psychology",
                        "Introduction to human behavior, mental processes, and research methods.",
                        "Mrs. Davis", "other", 4, year, 1, 16, "None", 3);
  // --- HISTORY ---

  static HighSchoolClass worldHistory =
    new HighSchoolClass("World History",
                        "Survey of major world civilizations and historical events.",
                        "Mr. Johnson", "history", 3, year, 1, 14, "None", 5);
  static HighSchoolClass honorsWorldHistory =
    new HighSchoolClass("Honors World History",
                        "Accelerated survey of world civilizations with primary source analysis.",
                        "Ms. Abara", "history", 5, year, 1, 14, "None", 5);
  static HighSchoolClass earlyUsHistory =
    new HighSchoolClass("Early US History",
                        "Survey of American history from colonial times to World War One.",
                        "Mr. Johnson", "history", 3, year, 1, 15,
                        "World History or Honors World History", 5);
  static HighSchoolClass honorsEarlyUsHistory =
    new HighSchoolClass("Honors Early US History",
                        "Accelerated American history with document based analysis.",
                        "Ms. Abara", "history", 5, year, 1, 15,
                        "World History or Honors World History", 5);
  static HighSchoolClass modernUsHistory =
    new HighSchoolClass("Modern US History",
                        "Survey of American history from World War One to present day.",
                        "Mr. Deluca", "history", 3, year, 1, 16,
                        "Early US History or Honors Early US History", 5);
  static HighSchoolClass honorsModernUsHistory =
    new HighSchoolClass("Honors Modern US History",
                        "Accelerated American history from World War One to present day.",
                        "Mr. Deluca", "history", 5, year, 1, 16,
                        "Early US History or Honors Early US History", 5);
  static HighSchoolClass apHistory =
    new HighSchoolClass("AP US History",
                        "College level American history with AP exam preparation.",
                        "Ms. Abara", "history", 8, year, 1, 16,
                        "Early US History or Honors Early US History", 5);

  static HighSchoolClass economics =
    new HighSchoolClass("Economics",
                        "Introduction to micro and macroeconomics, supply and demand.",
                        "Mr. Deluca", "history", 4, year, 1, 16, "None", 5);
  static HighSchoolClass apEconomics =
    new HighSchoolClass("AP Economics",
                        "College level micro and macroeconomics with AP exam preparation.",
                        "Mr. Deluca", "history", 8, year, 1, 17, "None", 5);
  static HighSchoolClass government =
    new HighSchoolClass("Government",
                        "Study of the US government, constitution, and civic responsibility.",
                        "Mr. Johnson", "history", 4, year, 1, 17, "None", 5);
  static HighSchoolClass honorsGovernment =
    new HighSchoolClass("Honors Government",
                        "Accelerated study of the US government and political systems.",
                        "Ms. Abara", "history", 6, year, 1, 17, "None", 5);
  static HighSchoolClass apGovernment =
    new HighSchoolClass("AP Government",
                        "College level civics and political science with AP exam preparation.",
                        "Mr. Deluca", "history", 9, year, 1, 17, "None", 5);

  // --- GYM ---

  static HighSchoolClass pe1 =
    new HighSchoolClass("Physical Education 1",
                        "Basic fitness, team sports, and health education.",
                        "Coach Rivera", "gym", 2, year, 1, 14, "None", 3);

  static HighSchoolClass yoga =
    new HighSchoolClass("Yoga",
                        "Introduction to yoga, mindfulness, and stress management.",
                        "Ms. Santos", "gym", 1, year, 1, 14, "None", 2);
  static HighSchoolClass healthClass =
    new HighSchoolClass("Health",
                        "Study of physical and mental health, nutrition, and wellness.",
                        "Coach Rivera", "gym", 2, year, 1, 14, "None", 3);

  // --- ART ---

  static HighSchoolClass artBasics =
    new HighSchoolClass("Art Basics",
                        "Introduction to drawing, painting, and design principles.",
                        "Ms. Collins", "art", 2, year, 1, 14, "None", 3);
  static HighSchoolClass graphicDesign =
    new HighSchoolClass("Graphic Design",
                        "Introduction to digital design, typography, and visual communication.",
                        "Mr. Tran", "art", 3, year, 1, 15, "Art Basics", 3);
  static HighSchoolClass photography =
    new HighSchoolClass("Photography",
                        "Introduction to camera operation, composition, and photo editing.",
                        "Ms. Collins", "art", 2, year, 1, 14, "None", 2);
  static HighSchoolClass drama =
    new HighSchoolClass("Drama",
                        "Acting fundamentals, stagecraft, and performance techniques.",
                        "Mr. Tran", "art", 2, year, 1, 14, "None", 3);
  static HighSchoolClass bandBeginners =
    new HighSchoolClass("Band - Beginners",
                        "Introduction to reading music and playing a band instrument.",
                        "Mr. Williams", "art", 2, year, 1, 14, "None", 2);
  static HighSchoolClass bandAdvanced =
    new HighSchoolClass("Band - Advanced",
                        "Advanced ensemble performance and music theory.",
                        "Mr. Williams", "art", 4, year, 1, 15,
                        "Band - Beginners", 2);
  static HighSchoolClass choir =
    new HighSchoolClass("Choir",
                        "Vocal performance, music theory, and ensemble singing.",
                        "Ms. Diaz", "art", 2, year, 1, 14, "None", 2);

  // --- TECH ---

  static HighSchoolClass woodshop =
    new HighSchoolClass("Woodshop",
                        "Basic woodworking, tool safety, and hands-on building projects.",
                        "Mr. Burns", "tech", 3, year, 1, 15, "None", 3);
  static HighSchoolClass automotiveTech =
    new HighSchoolClass("Automotive Technology",
                        "Basic car maintenance, engine mechanics, and auto shop safety.",
                        "Mr. Burns", "tech", 3, year, 1, 15, "None", 3);
  static HighSchoolClass culinaryArts =
    new HighSchoolClass("Culinary Arts",
                        "Basic cooking techniques, kitchen safety, and nutrition.",
                        "Ms. Ferreira", "tech", 2, year, 1, 14, "None", 3);
  static HighSchoolClass computerScience =
    new HighSchoolClass("Computer Science 1",
                        "Introduction to programming logic, algorithms, and basic coding.",
                        "Ms. Lee", "tech", 5, year, 1, 16, "None", 3);
  static HighSchoolClass apComputerScience =
    new HighSchoolClass("AP Computer Science",
                        "College level programming in Java with AP exam preparation.",
                        "Mr. Osei", "tech", 9, year, 1, 17,
                        "Computer Science 1", 5);

  // --- LANGUAGE ---

  static HighSchoolClass spanishOne =
    new HighSchoolClass("Spanish 1",
                        "Introduction to Spanish language, vocabulary, and basic conversation.",
                        "Mrs. Morales", "lang", 3, year, 1, 14, "None", 3);
  static HighSchoolClass spanishTwo =
    new HighSchoolClass("Spanish 2",
                        "Intermediate Spanish grammar, reading, and conversation.",
                        "Mrs. Morales", "lang", 4, year, 1, 15, "Spanish 1", 3);
  static HighSchoolClass spanishThree =
    new HighSchoolClass("Spanish 3",
                        "Advanced Spanish composition and literature.",
                        "Mr. Vega", "lang", 6, year, 1, 16, "Spanish 2", 3);
  static HighSchoolClass apSpanish =
    new HighSchoolClass("AP Spanish",
                        "College level Spanish language and culture with AP exam preparation.",
                        "Mr. Vega", "lang", 9, year, 1, 17, "Spanish 3", 5);
  static HighSchoolClass frenchOne =
    new HighSchoolClass("French 1",
                        "Introduction to French language, vocabulary, and basic conversation.",
                        "Ms. Beaumont", "lang", 3, year, 1, 14, "None", 3);
  static HighSchoolClass frenchTwo =
    new HighSchoolClass("French 2",
                        "Intermediate French grammar, reading, and conversation.",
                        "Ms. Beaumont", "lang", 4, year, 1, 15, "French 1", 3);
  static HighSchoolClass frenchThree =
    new HighSchoolClass("French 3",
                        "Advanced French composition and literature.",
                        "Ms. Beaumont", "lang", 6, year, 1, 16, "French 2", 3);

  static HighSchoolClass apFrench =
    new HighSchoolClass("AP French",
                        "College level French language and culture with AP exam preparation.",
                        "Ms. Beaumont", "lang", 9, year, 1, 17, "French 3", 5);

  // --- STUDY HALL ---

  static HighSchoolClass studyHallA =
    new HighSchoolClass("Study Hall A",
                        "Supervised free period for homework, studying, or reading.",
                        "Various", "other", 0, year, 0, 14, "None", 3);

  static HighSchoolClass studyHallB =
    new HighSchoolClass("Study Hall B",
                        "Supervised free period for homework, studying, or reading.",
                        "Various", "other", 0, year, 0, 14, "None", 2);
  static HighSchoolClass studyHallC =
    new HighSchoolClass("Study Hall C",
                        "Supervised free period for homework, studying, or reading.",
                        "Various", "other", 0, year, 0, 14, "None", 1);

  static public ArrayList<HighSchoolClass> allClasses =
    new ArrayList<HighSchoolClass>(Arrays.asList(
                                                 // MATH
                                                 algebra2, honorsAlgebra2,
                                                 geometry, honorsGeometry,
                                                 precalc, honorsPrecalc, calcAB,
                                                 calcBC, statistics,
                                                 apStatistics,

                                                 // ENGLISH
                                                 english1, honorsEnglish1,
                                                 english2, honorsEnglish2,
                                                 english3, honorsEnglish3,
                                                 english4, honorsEnglish4,
                                                 apLanguage, creativeWriting,
                                                 creativeWritingElective,

                                                 // SCIENCE
                                                 honorsIntroPhysics, biology,
                                                 honorsBiology, chemistry,
                                                 honorsChemistry, physics,
                                                 honorsPhysics, apBiology,
                                                 apChemistry, apPhysics,
                                                 environmentalScience,
                                                 psychology,

                                                 // HISTORY
                                                 worldHistory,
                                                 honorsWorldHistory,
                                                 earlyUsHistory,
                                                 honorsEarlyUsHistory,
                                                 modernUsHistory,
                                                 honorsModernUsHistory,
                                                 apHistory, economics,
                                                 apEconomics, government,
                                                 honorsGovernment, apGovernment,

                                                 // GYM
                                                 pe1, yoga, healthClass,

                                                 // ART
                                                 artBasics, graphicDesign,
                                                 photography, drama,
                                                 bandBeginners, bandAdvanced,
                                                 choir,

                                                 // TECH
                                                 woodshop, automotiveTech,
                                                 culinaryArts, computerScience,
                                                 apComputerScience,

                                                 // LANGUAGE
                                                 spanishOne, spanishTwo,
                                                 spanishThree, apSpanish,
                                                 frenchOne, frenchTwo,
                                                 frenchThree, apFrench,

                                                 // STUDY HALL
                                                 studyHallA, studyHallB,
                                                 studyHallC));

  static public ArrayList<HighSchoolClass> getEligibleClasses(ArrayList<HighSchoolClass> completedClasses,
                                                              int age)
  {
    ArrayList<HighSchoolClass> eligible = new ArrayList<HighSchoolClass>();

    for (HighSchoolClass c : allClasses)
    {
      // check age and prerequisites
      if (age >= c.getPrerequisiteAge()
        && c.meetsPrerequisite(completedClasses))
      {
        // make sure they havent already taken it
        if (!completedClasses.contains(c))
          eligible.add(c);
      }
    }
    return eligible;
  }

  public static void runOption(Player player)
  {
    School school = new School();
    ArrayList<HighSchoolClass> classesAvail =
      school.getEligibleClasses(player.getCompletedClasses(), player.getAge());
    String name = player.getName();

    Scanner scan = new Scanner(System.in);
    Typer.print("\nWhat would you like to do in School?");
    Typer.print("View Overview - (a)");
    Typer.print("View Transcript - (b)");
    Typer.print("View Current Schedule - (c)");
    Typer.print("View Available Classes - (d)");
    Typer.print("Add Courses - (e)");
    Typer.print("Remove Courses - (f)");
    Typer.print("Set Homework Hours - (g)");
    Typer.print("Return to Actions - (h)");

    String letter = scan.next();
    scan.nextLine();

    // --- OVERVIEW ---
    if (letter.equals("a") || letter.equals("A"))
    {
      Typer.print("\n--- SCHOOL OVERVIEW ---");
      Typer.print("Name:           " + name);
      Typer.print("Age:            " + player.getAge());
      Typer.print("Year:           Year " + Runner.yearInRunner);
      // Typer.print("GPA: " + String.format("%.2f",
      // player.getGrades().getGPA()));
      Typer.print("Credits Earned: " + player.getCompletedClasses().size());
      Typer.print("Classes This Year: "
        + player.getClassSchedule().getCurrentSchedule().size());
      Typer.print("Hours/Week:     " + player.getClassSchedule().getTotalHours()
        + " hrs");
      player.getClassSchedule().printCreditSummary();
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- TRANSCRIPT ---
    else if (letter.equals("b") || letter.equals("B"))
    {
      if (player.getCompletedClasses().isEmpty())
      {
        Typer.print("\nYou have not completed any classes yet.");
      }
      else
      {
        Typer.print("\n--- TRANSCRIPT ---");
        Typer.print("Name: " + name);
        // Typer.print("GPA: " + String.format("%.2f",
        // player.getGrades().getGPA()) + "\n");
        for (HighSchoolClass c : player.getCompletedClasses())
        {
          Typer.print(c.getName() + " | " + c.getType().toUpperCase()
            + " | Grade: " + c.getLetterGrade() + " (" + c.getNumericalGrade()
            + ")" + " | Credits: " + c.getCredits() + " | Teacher: "
            + c.getTeacher());
        }
      }
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- CURRENT SCHEDULE ---
    else if (letter.equals("c") || letter.equals("C"))
    {
      player.getClassSchedule().printSchedule();
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- AVAILABLE CLASSES ---
    else if (letter.equals("d") || letter.equals("D"))
    {
      if (classesAvail.isEmpty())
      {
        Typer.print("\nThere are no classes available to you right now.");
      }
      else
      {
        Typer.print("\n--- AVAILABLE CLASSES ---");
        for (int i = 0; i < classesAvail.size(); i++)
        {
          HighSchoolClass c = classesAvail.get(i);
          Typer.print((i + 1) + ". " + c.getName() + " | "
            + c.getType().toUpperCase() + " | Difficulty: "
            + c.getDifficultyLevel() + "/10" + " | " + c.getClassTime()
            + " hrs/week" + " | Prereqs: " + c.getPrerequisitesClass()
            + " | Teacher: " + c.getTeacher());
          Typer.print("   " + c.getDescription() + "\n");
        }
      }
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- MAKE COURSE SELECTION ---
    else if (letter.equals("e") || letter.equals("E"))
    {
      if (classesAvail.isEmpty())
      {
        Typer.print("\nThere are no classes available to add.");
        scan.nextLine();
        runOption(player);
        return;
      }

      Typer.print("\n--- ADD CLASSES ---");
      Typer.print("Available classes:\n");
      for (int i = 0; i < classesAvail.size(); i++)
      {
        HighSchoolClass c = classesAvail.get(i);
        Typer.print((i + 1) + ". " + c.getName() + " | "
          + c.getType().toUpperCase() + " | Difficulty: "
          + c.getDifficultyLevel() + "/10" + " | " + c.getClassTime()
          + " hrs/week");
      }

      Typer
        .print("\nEnter the number of the class you want to add (or 0 to cancel):");
      int choice = scan.nextInt();
      scan.nextLine();

      if (choice == 0)
      {
        runOption(player);
        return;
      }

      if (choice < 1 || choice > classesAvail.size())
      {
        Typer.print("Invalid choice.");
      }
      else
      {
        HighSchoolClass chosen = classesAvail.get(choice - 1);
        player.getClassSchedule().addClass(chosen);
      }

      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- EDIT COURSE SELECTION ---
    else if (letter.equals("f") || letter.equals("F"))
    {
      ArrayList<HighSchoolClass> current =
        player.getClassSchedule().getCurrentSchedule();

      if (current.isEmpty())
      {
        Typer.print("\nYour schedule is empty, there is nothing to edit.");
        scan.nextLine();
        runOption(player);
        return;
      }

      Typer.print("\n--- REMOVE COURSES ---");
      Typer.print("Current schedule:\n");
      for (int i = 0; i < current.size(); i++)
      {
        HighSchoolClass c = current.get(i);
        Typer.print((i + 1) + ". " + c.getName() + " | "
          + c.getType().toUpperCase() + " | " + c.getClassTime() + " hrs/week");
      }

      Typer
        .print("\nEnter the number of the class you want to remove (or 0 to cancel):");
      int choice = scan.nextInt();
      scan.nextLine();

      if (choice == 0)
      {
        runOption(player);
        return;
      }

      if (choice < 1 || choice > current.size())
      {
        Typer.print("Invalid choice.");
      }
      else
      {
        HighSchoolClass chosen = current.get(choice - 1);
        player.getClassSchedule().removeClass(chosen);
      }

      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    else if (letter.equals("g") || letter.equals("G"))
    {
      player.getClassSchedule().setHomeworkHours(scan);
      Typer.print("\nPress enter to continue:");
      scan.nextLine();
      runOption(player);
    }

    // --- RETURN TO ACTIONS ---
    else if (letter.equals("h") || letter.equals("H"))
    {
      FirstYear.run(player);
    }

    // --- INVALID INPUT ---
    else
    {
      Typer.print("Invalid option, please try again.");
      runOption(player);
    }

  }
}
