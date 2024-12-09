package Projects.chap8.PROJ66;

public class Menu
{
  // Prompts user for cell selection
	public static int playerSelectMenu(Board game, Node root, int currPlayer)
	{
    int selection;
		// Runs once and continues as long as valid is still false
		do
		{
      char charPlay = (currPlayer == 1) ? 'A' : 'B';
      root.printScore(currPlayer);
      game.printBoard();
			// Initial prompt for user input and checks user input for int
			String input = "Player " + charPlay
         + " - please select an empty square from 1-9";
      selection = Validation.integerCheck(input);

      // Determines if selection is in bounds of board
      if(selection < 1 || selection > 9)
      {
        System.out.println("That is not a valid cell."
          + "Please select an unclaimed square from 1-9\n");
        // Checks if user selected an empty cell
      }
      else if(!game.cellEmpty(selection))
      {
        System.out.println("That cell is taken."
          + "Please select a different cell\n");
      }
      else
      {
        // Updates board according to player selection
        // Updates valid to true to escape while loop
        game.playerSelect(selection, currPlayer);
        break;
      }
		} while(true);

    return selection;
	}
}