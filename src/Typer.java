/**
 * Preference file version 110624
 * 
 * @author: Your First and Last name goes here!
 *          VHS Learning
 */

public class Typer
{

  public static void print(String text)
  {
    // Split into words and track line length
    String[] words = text.split(" ");
    int lineLength = 0;
    int maxLineLength = 60;

    for (String word : words)
    {
      // Add enter if line would get too long
      if (lineLength + word.length() > maxLineLength)
      {
        System.out.println();
        lineLength = 0;
      }

      // Type out each character slowly
      for (char c : word.toCharArray())
      {
        System.out.print(c);
        try
        {
          Thread.sleep(35); // milliseconds per character
        }
        catch (InterruptedException e)
        {
          Thread.currentThread().interrupt();
        }
      }

      // Print space after word
      System.out.print(" ");
      lineLength += word.length() + 1;
    }
    System.out.println(); // final enter at end
  }
}
