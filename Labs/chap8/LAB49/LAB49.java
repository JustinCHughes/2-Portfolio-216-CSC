// Algorithm preorderDraw draws a binary tree T by assigning x- and
// y-coordinates to each position p such that x(p) is the number of nodes
// preceding p in the preorder traversal of T and y(p) is the depth of in T.
// (a) Show that the drawing of T produced by preorderDraw has no
// pairs of crossing edges.
// (b) Redraw the binary tree of Figure 8.6.3 using preorderDraw.

// Used my ArrayListTree from Lab 60
// Question part a)
// The x coordinate increments as we find nodes in the tree
// The y coordinate always moves downward and to a larger x coordinate
// No two nodes share the same x coordinate and edges only connect
// going from parent to child, there's no way for edges to overlap or cross
// Thus, we can say that the drawing of tree T produced by preorderDraw
// has no pairs of crossing edges

package Labs.chap8.LAB49;

import java.util.ArrayList;

public class LAB49 {
  private static ArrayList<String[]> coordinates;
  private static int x;

  public static void main(String[] args)
  {
    // Creating tree that was referenced in the problem
    // Reference tree is Figure 8.6.3
    // Conventional drawing of tree for comparison
    //              A
    //         /         \
    //        B              C
    //    /       \         / \
    //   D         E       J   K
    //  / \               / \
    // F   G             L   M
    //    / \
    //   H   I
    ArrayListTree<String> tree = new ArrayListTree<>("A"); // Root
    tree.addLeft(0, "B"); // Left
    tree.addRight(0, "C"); // Right
    tree.addLeft(1, "D"); // Left Left
    tree.addRight(1, "E"); // Left Right
    tree.addLeft(3, "F"); // Left Left Left
    tree.addRight(3, "G"); // Left Left Right
    tree.addLeft(8, "H"); // Left Left Right Left
    tree.addRight(8, "I"); // Left Left Right Right
    tree.addLeft(2, "J"); // Right Left
    tree.addRight(2, "K"); // Right Right
    tree.addLeft(5, "L"); // Right Left Left
    tree.addRight(5, "M"); // Right Left Right

    coordinates = new ArrayList<>();
    x = 0;
    preorder(tree, 0, 0);

    System.out.println("Preorder draw of tree from 8.6.3");
    // Draw the tree
    drawTree();
  }

  // Recursive call to get the coordinates
  public static void preorder(ArrayListTree<String> tree,int position,int depth)
  {
    if (tree.checkPositionQuiet(position))
    {
      return;
    }

    // Assign coordinates for the current node
    coordinates.add(new String[] { tree.getElement(position)
          ,String.valueOf(x++)
          ,String.valueOf(depth) });

    // Visit left and right children recursively
    // Left
    preorder(tree, position * 2 + 1, depth + 1);
    // Right
    preorder(tree, position * 2 + 2, depth + 1);
  }

  // Was originally used so that I can QA the outputs
  // Leaving this in just in case I need to check on stuff later
  public static void printCoordinates()
  {
    System.out.println("Node coordinates (position, x, y):");
    for (String[] coord : coordinates)
    {
      System.out.println("Position " + coord[0] + ": ("
        + coord[1] + ", " + coord[2] + ")");
    }
  }

  public static void drawTree()
  {
    // Determine the X and Y of the grid
    int maxX = 0;
    int maxY = 0;
    for (String[] coord : coordinates)
    {
      maxX = Math.max(maxX, Integer.parseInt(coord[1]));
      maxY = Math.max(maxY, Integer.parseInt(coord[2]));
    }

    // Creating the grid that we're going to be using.
    String[][] grid = new String[maxY + 1][maxX + 1];
    for (int i = 0; i <= maxY; i++)
    {
      for (int j = 0; j <= maxX; j++)
      {
        // Start the grid with all spaces
        grid[i][j] = " ";
      }
    }

    // Replace the spaces in the graph with the node values where needed
    for (String[] coord : coordinates)
    {
      int x = Integer.parseInt(coord[1]);
      int y = Integer.parseInt(coord[2]);
      grid[y][x] = coord[0];
    }

    // Print the grid row by row
    for (int i = 0; i <= maxY; i++)
    {
      for (int j = 0; j <= maxX; j++)
      {
        System.out.print(grid[i][j]);
      }
      System.out.println();
    }
  }
}
