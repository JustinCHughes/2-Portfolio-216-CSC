package Labs.chap8.LAB61;

import java.util.HashMap;
import java.util.Scanner;

public class LAB61 {
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    // Initialize the tree with a root node
    System.out.print("Enter the root data to initialize the tree: ");
    String rootData = in.nextLine();
    LinkedListTree<String> tree = new LinkedListTree<>();
    Node<String> rootNode = new Node<>(rootData);
    tree.addRoot(rootNode);

    // HashMap to track nodes for easy reference
    // Because of nature of HashMaps, all values must be unique
    // when we are using this UI. I thought this would be fine since
    // it is not in relation to the core functionality of the lab
    // in regards to creating the linkedlisttree and is rather in
    // regards to creating a functioning UI
    HashMap<String, Node<String>> nodeRegistry = new HashMap<>();
    nodeRegistry.put(rootData, rootNode);

    boolean exit = false;

    while (!exit)
    {
      System.out.println("\n--- Tree Operations ---");
      System.out.println("1. Add Left Child");
      System.out.println("2. Add Right Child");
      System.out.println("3. Remove Node");
      System.out.println("4. Current Tree Attributes");
      System.out.println("5. Check Left Child");
      System.out.println("6. Check Right Child");
      System.out.println("7. Check Parent");
      System.out.println("8. Exit");
      System.out.print("Choose an option: ");

      int choice = in.nextInt();
      in.nextLine();

      switch (choice)
      {
        case 1:
          // Add Left Child
          System.out.print("Enter the parent node data: ");
          String leftParentData = in.nextLine();
          Node<String> leftParent = nodeRegistry.get(leftParentData);

          if (leftParent == null)
          {
            System.out.println("Parent node not found!");
            break;
          }

          System.out.print("Enter the left child data: ");
          String leftChildData = in.nextLine();

          if (nodeRegistry.containsKey(leftChildData))
          {
            System.out.println("A node with this data already exists!");
            break;
          }

          Node<String> leftChild = new Node<>(leftChildData);
          tree.addLeft(leftParent, leftChild);
          nodeRegistry.put(leftChildData, leftChild);
          System.out.println("Left child added to "
           + leftParentData + ": " + leftChildData);
          break;

        case 2:
          // Add Right Child
          System.out.print("Enter the parent node data: ");
          String rightParentData = in.nextLine();
          Node<String> rightParent = nodeRegistry.get(rightParentData);

          if (rightParent == null)
          {
            System.out.println("Parent node not found!");
            break;
          }

          System.out.print("Enter the right child data: ");
          String rightChildData = in.nextLine();

          if (nodeRegistry.containsKey(rightChildData))
          {
            System.out.println("A node with this data already exists!");
            break;
          }

          Node<String> rightChild = new Node<>(rightChildData);
          tree.addRight(rightParent, rightChild);
          nodeRegistry.put(rightChildData, rightChild);
          System.out.println("Right child added to "
           + rightParentData + ": " + rightChildData);
          break;

        case 3:
          // Remove Node
          System.out.print("Enter the node data to remove: ");
          String removeData = in.nextLine();
          Node<String> removeNode = nodeRegistry.get(removeData);

          if (removeNode == null)
          {
            System.out.println("Node not found!");
            break;
          }

          if (removeNode.numChildren() > 1)
          {
            System.out.println("Node has two children! Cannot remove.");
            break;
          }

          String removedElement = tree.remove(removeNode);
          nodeRegistry.remove(removeData);
          System.out.println("Node removed: " + removedElement);
          break;

        case 4:
          // View Tree
          System.out.println("Tree size: " + tree.size());
          System.out.println("Nodes in the tree: " + nodeRegistry.keySet());
          break;

        case 5:
          // Check Left Child
          System.out.print("Enter the node data to check its left child: ");
          String leftCheckData = in.nextLine();
          Node<String> leftCheckNode = nodeRegistry.get(leftCheckData);

          if (leftCheckNode == null)
          {
            System.out.println("Node not found!");
            break;
          }

          Node<String> leftChildNode = leftCheckNode.getLeft();
          System.out.println("Left child: "
           + (leftChildNode != null ? leftChildNode.getElement() : "None"));
          break;

        case 6:
          // Check Right Child
          System.out.print("Enter the node data to check its right child: ");
          String rightCheckData = in.nextLine();
          Node<String> rightCheckNode = nodeRegistry.get(rightCheckData);

          if (rightCheckNode == null)
          {
            System.out.println("Node not found!");
            break;
          }

          Node<String> rightChildNode = rightCheckNode.getRight();
          System.out.println("Right child: "
           + (rightChildNode != null ? rightChildNode.getElement() : "None"));
          break;

        case 7:
          // Check Parent
          System.out.print("Enter the node data to check its parent: ");
          String parentCheckData = in.nextLine();
          Node<String> parentCheckNode = nodeRegistry.get(parentCheckData);

          if (parentCheckNode == null)
          {
            System.out.println("Node not found!");
            break;
          }

          Node<String> parentNode = parentCheckNode.getParent();
          System.out.println("Parent: "
           + (parentNode != null ? parentNode.getElement() : "None"));
          break;

        case 8:
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
