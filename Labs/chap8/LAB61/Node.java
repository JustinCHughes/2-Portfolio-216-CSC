package Labs.chap8.LAB61;

public class Node<T> {
  private Node<T> right;
  private Node<T> left;
  private Node<T> parent;
  private T data;
  
  public Node(T data)
  {
    this.data = data;
    this.right = null;
    this.left = null;
    this.parent = null;
  }
  
  public Node<T> getLeft()
  {
    return this.left;
  }

  public Node<T> getRight()
  {
    return this.right;
  }

  public Node<T> getParent()
  {
    return this.parent;
  }

  public T getElement()
  {
    return this.data;
  }

  public void setElement(T data)
  {
    this.data = data;
  }

  public void setLeft(Node<T> node)
  {
    this.left = node;
  }

  public void setRight(Node<T> node)
  {
    this.right = node;
  }

  public void setParent(Node<T> node)
  {
    this.parent = node;
  }

  public int numChildren()
  {
    int count = 0;
    if(this.left != null)
    {
      count++;
    }
    if(this.right != null)
    {
      count++;
    }
    return count;
  }
}
