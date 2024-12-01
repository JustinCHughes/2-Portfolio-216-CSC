package Labs.chap8.LAB6061;

public class LinkedListTree<T> {
  private Node<T> root;
  private int size;

  public LinkedListTree ()
  {
    this.root = null;
    this.size = 0;
  }

  public void addRoot(Node<T> root)
  {
    this.root = root;
    this.size++;
  }

  public Node<T> getRoot()
  {
    return this.root;
  }

  public void addLeft(Node<T> position, Node<T> newNode)
  {
    if(position.getLeft() != null)
    {
      System.out.println("This node already has a left child!");
      return;
    }
    position.setLeft(newNode);
    newNode.setParent(position);
    this.size++;
  }

  public void addRight(Node<T> position, Node<T> newNode)
  {
    if(position.getRight() != null)
    {
      System.out.println("This node already has a right child!");
      return;
    }
    position.setRight(newNode);
    newNode.setParent(position);
    this.size++;
  }

  public void set(Node<T> position, T data)
  {
    position.setElement(data);
  }

  public T remove(Node<T> node)
  {
    Node<T> moveNode;
    // As per the code in 8.3.1, we do not remove nodes with 2 children
    if(node.getLeft() != null && node.getRight() != null)
    {
      System.out.println("Node has two children! Do not remove");
      return null;
    }
    moveNode = (node.getLeft() != null ? node.getLeft() : node.getRight());
    if(node.getParent() != null)
    {
      if(node.getParent().getLeft().equals(node))
      {
        node.getParent().setLeft(moveNode);
      }
      else
      {
        node.getParent().setRight(moveNode);
      }
    }
    if (moveNode != null)
    {
      moveNode.setParent(node.getParent());
    }
    this.size--;
    T element = node.getElement();

    node.setElement(null);
    node.setLeft(null);
    node.setRight(null);
    node.setParent(node);

    return element;
  }

  public int size()
  {
    return this.size;
  }
}
