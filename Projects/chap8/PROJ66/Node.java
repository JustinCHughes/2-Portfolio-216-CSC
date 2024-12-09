package Projects.chap8.PROJ66;

import java.util.ArrayList;

public class Node {
  private Board state; // Current board state
  private ArrayList<Node> children; // Possible future states
  private int score;
  private int selectedCell;

  // Constructor
  public Node(Board state)
  {
    this.state = new Board(state); // Copy the current board state
    this.children = new ArrayList<>();
    this.score = 0; // Default score
    this.selectedCell = -1; // Default for root
  }

  // Constructor for child nodes
  public Node(Board state, int selectedCell)
  {
    this.state = new Board(state); // Copy the current board state
    this.children = new ArrayList<>();
    this.score = 0; // Default score
    this.selectedCell = selectedCell; // Store the selected cell
  }

  public void generateTree(int currentPlayer)
  {
    // Stop recursion when the game is over
    String gameState = state.gameState();
    if (gameState.equals("Victory"))
    {
      // Assign score based on winner
      this.score = (currentPlayer == 1) ? -1 : 1; // Opponent has won
      return;
    }
    else if (gameState.equals("Draw"))
    {
      this.score = 0; // Assign score for a draw
      return;
    }

    // RGenerate child nodes for all possible moves
    ArrayList<Integer> availableMoves = state.available(); // Get available
    for (int move : availableMoves)
    {
      // Create a copy of the current board
      Board newState = new Board(state);

      // Apply the move for the current player
      newState.playerSelect(move, currentPlayer);

      // Create a new child node with the updated state
      Node child = new Node(newState, move);

      // Recurse down the tree for the next player's turn
      child.generateTree(3 - currentPlayer); // Alternate players

      // Add the child to this node
      this.addChild(child);
    }

    // Calculate the score for the current node by summing child scores
    this.score = this.children.stream()
      .mapToInt(Node::getScore) // Get the score of each child
      .sum();
  }

  public void printScore(int currentPlayer)
  {
    if(currentPlayer == 1)
    {
      // Bubble sort the children by score in descending order
      for (int i = 0; i < children.size() - 1; i++)
      {
        for (int j = 0; j < children.size() - 1 - i; j++)
        {
          if (children.get(j).getScore() < children.get(j + 1).getScore())
          {
            // Swap the two nodes
            Node temp = children.get(j);
            children.set(j, children.get(j + 1));
            children.set(j + 1, temp);
          }
        }
      }
    }
    else
    {
      // Bubble sort the children by score in ascending order
      for (int i = 0; i < children.size() - 1; i++)
      {
        for (int j = 0; j < children.size() - 1 - i; j++)
        {
          if (children.get(j).getScore() > children.get(j + 1).getScore())
          {
            // Swap the two nodes
            Node temp = children.get(j);
            children.set(j, children.get(j + 1));
            children.set(j + 1, temp);
          }
        }
      }
    }
  
    // Print the sorted scores
    System.out.println("Best Cell Selections First:");
    for (Node child : children)
    {
      System.out.println("Cell " + child.choice() + ": " + child.getScore());
    }
  }

  public Node traverse(int move)
  {
    for (Node child : children)
    {
      if (child.choice() == move)
      {
        return child; // Return the child node with the matching move
      }
    }
    return null; // This shouldn't be possible
  }

  // Getters and Setters
  public Board getState()
  {
    return state;
  }

  public ArrayList<Node> getChildren()
  {
    return children;
  }

  public void addChild(Node child)
  {
    children.add(child);
  }

  public int getScore()
  {
    return score;
  }

  public void setScore(int score)
  {
    this.score = score;
  }

  public int choice()
  {
    return selectedCell;
  }
}
