package Labs.chap8.LAB6061;

public class Main {
  public static void main(String[] args)
  {
    ArrayListTree<String> tree = new ArrayListTree<>("Root");
    tree.addLeft(0, "Left");
    tree.addRight(0, "Right");
    tree.addRight(2, "RightRight");
    tree.addRight(6,"RightRightRight");

    System.out.println("Tests For ArrayList Tree: ");
    System.out.println("Root: " + tree.root());
    System.out.println("Left Child of Root: " + tree.leftChild(0));
    System.out.println("Right Child of Root: " + tree.rightChild(0));
    System.out.println("Root # of Children: " + tree.numChildren(0));
    System.out.println("Root Internal? " + tree.isInternal(0));
    System.out.println("Left Child External? " + tree.isExternal(1));
    System.out.println("Parent of Left Child: " + tree.parent(1));
    System.out.println("Parent of Right Child: " + tree.parent(2));
    // Should print invalid position then return and print null
    System.out.println("Element 5 (Does Not Exist): " + tree.getElement(5));
    System.out.println("Size: " + tree.size());
    System.out.println("Print ArrayList Tree:");
    tree.print();
    System.out.println();

    LinkedListTree<String> tree2 = new LinkedListTree<>();
    Node<String> rootNode = new Node<>("Root");
    Node<String> lNode = new Node<>("Left");
    Node<String> rNode = new Node<>("Right");
    Node<String> lLNode = new Node<>("LeftLeft");
    Node<String> rRNode = new Node<>("rightRight");
    
    tree2.addRoot(rootNode);
    tree2.addLeft(rootNode, lNode);
    tree2.addRight(rootNode, rNode);
    tree2.addLeft(lNode, lLNode);
    tree2.addRight(rNode, rRNode);

    System.out.println("Tests For Linked List Tree: ");

    String value = tree2.getRoot().getElement();
    System.out.println("Root: " + value);

    value = rootNode.getLeft().getElement();
    System.out.println("Left Child of Root: " + value);

    value = rootNode.getRight().getElement();
    System.out.println("Right Child of Root: " + value);
    System.out.println("Root # of Children: " + rootNode.numChildren());

    value = lNode.getParent().getElement();
    System.out.println("Parent of Left Child: " + value);

    value = rNode.getParent().getElement();
    System.out.println("Parent of Right Child: " + value);

    value = rNode.getRight().getElement();
    System.out.println("Right Child of Right Node: " + value);
    System.out.println("Size: " + tree2.size());

    value = tree2.remove(rNode);
    System.out.println("Removed Right Node: " + value);
    System.out.println("Right Num Children: " + rNode.numChildren());

    value = rootNode.getRight().getElement();
    System.out.println("Updated Right Child of Root: " + value);

    value = rRNode.getParent().getElement();
    System.out.println("Updated RightRight Node Parent: " + value);

    value = rNode.getParent().getElement();
    System.out.println("Updated Right Node Parent: " + value);
    System.out.println("Updated Size: " + tree2.size());
    System.out.println();

  }
}
