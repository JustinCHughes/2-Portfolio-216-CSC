package Labs.chap8.LAB6061;

public class Main {
  public static void main(String[] args)
  {
    ArrayListTree<String> tree = new ArrayListTree<>("Root");
    tree.addLeft(0, "Left");
    tree.addRight(0, "Right");

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
    System.out.println("Size: " + tree.size() + "\n");
  }
}
