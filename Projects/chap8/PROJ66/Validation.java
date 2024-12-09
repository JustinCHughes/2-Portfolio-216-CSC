package Projects.chap8.PROJ66;

import java.util.Scanner;

public class Validation
{
  // Validates that user input an integer before any further checks on input
  public static int integerCheck(String prompt)
  {
    Scanner in = new Scanner(System.in);
    int userInput = -1;

    while(true)
    {
      System.out.println(prompt);
      if(in.hasNextInt())
      {
        userInput = in.nextInt();
        break;
      }
      System.out.println("That is not an integer. Please input an integer");
      in.nextLine();
    }
    return userInput;
  }
}
