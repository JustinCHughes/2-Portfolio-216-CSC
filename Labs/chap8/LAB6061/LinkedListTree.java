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

  public void addLeft(Node<T> position, T data)
  {
    if(position.getLeft() != null)
    {
      System.out.println("This node already has a left child!");
      return;
    }
    Node<T> newNode = new Node<>(data);
    position.setLeft(newNode);
  }

  public void addRight(Node<T> position, T data)
  {
    if(position.getRight() != null)
    {
      System.out.println("This node already has a left child!");
      return;
    }
    Node<T> newNode = new Node<>(data);
    position.setRight(newNode);
  }

  public void set(Node<T> position, T data)
  {
    position.setElement(data);
  }

  public T remove(Node<T> position)
  {
    Node<T> moveNode = null;
    int move = 0;
    T element = position.getElement();
    if(position.getLeft() != null && position.getRight() != null)
    {
      // Chooses the moveNode from the side that has a higher height
      if(position.getLeft().getHeight() > position.getRight().getHeight())
      {
        moveNode = position.getLeft();
        move = 1;
      }
      else
      {
        moveNode = position.getRight();
        move = 2;
      }
    }
    else if(position.getLeft() != null)
    {
      moveNode = position.getLeft();
      move = 1;
    }
    else if(position.getRight() != null)
    {
      moveNode = position.getRight();
      move = 2;
    }
    if(position.getParent() != null)
    {
      if(position.getParent().getLeft().equals(position))
      {
        position.getParent().setLeft(moveNode);
      }
      else
      {
        position.getParent().setRight(moveNode);
      }
    }
    if (moveNode != null)
    {
      moveNode.setParent(position.getParent());
    }
    if (moveNode != null
        && position.getLeft() != null
        && position.getRight() != null)
    {
      if (move == 1)
      {
        Node<T> rightChild = position.getRight();
        Node<T> rightMost = findRightMost(moveNode);
        rightMost.setRight(rightChild);
        rightChild.setParent(rightMost);
      } else if (move == 2)
      {
        Node<T> leftChild = position.getLeft();
        Node<T> leftMost = findLeftMost(moveNode);
        leftMost.setLeft(leftChild);
        leftChild.setParent(leftMost);
      }
    }

    position.setElement(null);
    position.setLeft(null);
    position.setRight(null);
    position.setParent(null);

    return element;
  }
}
