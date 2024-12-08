package Labs.chap8.LAB60;

import java.util.Scanner;

public class LAB60 {
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter the root element for the tree: ");
    String root = in.nextLine();
    ArrayListTree<String> tree = new ArrayListTree<>(root);

    boolean exit = false;

    while (!exit)
    {
      System.out.println("\n--- Binary Tree Operations ---");
      System.out.println("1. Add a left child");
      System.out.println("2. Add a right child");
      System.out.println("3. Check for a left child at a position");
      System.out.println("4. Check for a right child at a position");
      System.out.println("5. Check for a parent at a position");
      System.out.println("6. Check number of children at a position");
      System.out.println("7. Check if a position is internal");
      System.out.println("8. Check tree size");
      System.out.println("9. Print the tree");
      System.out.println("10. Exit");
      System.out.print("Choose an option: ");

      int choice = in.nextInt();

      switch (choice)
      {
        case 1:
          // Add Left Child
          System.out.print("Enter the parent position to add a left child: ");
          int addLeftParent = in.nextInt();
          System.out.print("Enter the value for the left child: ");
          in.nextLine();
          String leftValue = in.nextLine();
          tree.addLeft(addLeftParent, leftValue);
          break;

        case 2:
          // Add Right Child
          System.out.print("Enter the parent position to add a right child: ");
          int addRightParent = in.nextInt();
          System.out.print("Enter the value for the right child: ");
          in.nextLine();
          String rightValue = in.nextLine();
          tree.addRight(addRightParent, rightValue);
          break;

        case 3:
          // Check for Left Child
          System.out.print("Enter the position to check for a left child: ");
          int positionLC = in.nextInt();
          if(tree.checkPosition(positionLC) == true)
          {
            break;
          }
          else if(tree.leftChild(positionLC) == null)
          {
            System.out.println("There is no left child at this position");
            break;
          }
          System.out.println("Left child: " + tree.leftChild(positionLC));
          break;

        case 4:
          // Check for Right Child
          System.out.print("Enter the position to check for a right child: ");
          int positionRC = in.nextInt();
          if(tree.checkPosition(positionRC) == true)
          {
            break;
          }
          else if(tree.rightChild(positionRC) == null)
          {
            System.out.println("There is no right child at this position");
            break;
          }
          System.out.println("Right child: "+tree.rightChild(positionRC));
          break;

        case 5:
          // Check for Parent
          System.out.print("Enter the position to check for a parent: ");
          int positionPC = in.nextInt();
          if(tree.parent(positionPC) != null)
          {
            System.out.println("Parent: " + tree.parent(positionPC));
          }
          break;

        case 6:
          // Check Number of Children
          System.out.print("Enter the position to check number of children:");
          int positionNC = in.nextInt();
          if(tree.numChildren(positionNC) != null)
          {
            System.out.println("Number of children: "
             + tree.numChildren(positionNC));
          }
          break;

        case 7:
          // Check if Position is Internal
          System.out.print("Enter the position to check if internal: ");
          int positionIC = in.nextInt();
          if(tree.isInternal(positionIC) != null)
          {
            System.out.println("Is internal: " + tree.isInternal(positionIC));
          }
          break;

        case 8:
          // Check Tree Size
          System.out.println("Tree size: " + tree.size());
          break;

        case 9:
          // Print the Tree
          System.out.println("Tree elements: ");
          tree.print();
          break;

        case 10:
          // Exit
          System.out.println("Exiting the program. Goodbye!");
          exit = true;
          break;

        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }
    }

    in.close();
  }
}
