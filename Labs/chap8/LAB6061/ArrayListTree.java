package Labs.chap8.LAB6061;

import java.util.ArrayList;

public class ArrayListTree<T> {
  private ArrayList<T> data;
  private int size;
  
  // Initializes ArrayTreeList and adds the root node
  public ArrayListTree(T root)
  {
    this.data = new ArrayList<>();
    this.data.add(root);
    this.size = 1;
  }
  
  // Gets the element at the position index given
  public T getElement(int position)
  {
    if (checkPosition(position))
    {
      return null;
    }
    return data.get(position);
  }

  // Returns current size of the tree
  public int size()
  {
    return this.size;
  }

  // Returns true or false if the tree is empty
  public boolean isEmpty()
  {
    return this.size == 0;
  }

  // Returns the element in the root
  public T root()
  {
    return this.getElement(0);
  }

  // Returns null if the position isn't a valid position
  // Adds to count when left and child exist and then returns count
  public Integer numChildren(int position)
  {
    if(checkPosition(position))
    {
      return null;
    }
    increaseCapacity(position * 2 + 2);
    Integer count = 0;
    if(leftChild(position) != null)
    {
      count++;
    }
    if(rightChild(position) != null)
    {
      count++;
    }
    return count;
  }

  // Checks is position is internal
  public Boolean isInternal(int position)
  {
    if(checkPosition(position))
    {
      return null;
    }
    return numChildren(position) != 0;
  }

  // Checks if position is external
  public Boolean isExternal(int position)
  {
    if(checkPosition(position))
    {
      return null;
    }
    return numChildren(position) == 0;
  }

  // Returns value of left child
  public T leftChild(int position)
  {
    int left = position * 2 + 1;
    if(checkPosition(position))
    {
      return null;
    }
    increaseCapacity(left);
    return data.get(left);
  }

  // Returns value of right child
  public T rightChild(int position)
  {
    int right = position * 2 + 2;
    if(checkPosition(position))
    {
      return null;
    }
    increaseCapacity(right);
    return data.get(right);
  }

  // Gets element house in the data of position - 1 / 2 which should be
  // the parent node of the child. Returns null i
  public T parent(int position)
  {
    if(position == 0)
    {
      System.out.println("This is position 0. Root nood has no parent");
      return null;
    }
    else if(checkPosition(position))
    {
      return null;
    }
    else
    {
      return this.getElement((position - 1) / 2);
    }
  }
  
  // Adds a left node
  public void addLeft(int parent, T input)
  {
    if(checkPosition(parent))
    {
      return;
    }
    increaseCapacity(parent * 2 + 1);
    if(this.data.get(parent * 2 + 1) != null)
    {
      System.out.println("This position already has a value");
      return;
    }
    this.data.set(parent * 2 + 1, input);
    this.size = this.size + 1;
  }

  // Adds a right node
  public void addRight(int parent, T input)
  {
    if(checkPosition(parent))
    {
      return;
    }
    increaseCapacity(parent * 2 + 2);
    if(this.data.get(parent * 2 + 2) != null)
    {
      System.out.println("This position already has a value");
      return;
    }
    this.data.set(parent * 2 + 2, input);
    this.size = this.size + 1;
  }

  // Checks if the current position is real or not. Informs user that position
  // was invalid and returns true. Returns false if position is valid
  public boolean checkPosition(int position)
  {
    if(position >= data.size() || data.get(position) == null)
    {
      System.out.println("The position input was invalid");
      return true;
    }
    return false;
  }

  // Whenever we call for a position, we first ensure that the size of
  // the Arraylist is big enough to intake a parameter of this position
  // size. If it is not big enough, we add null to the index positions
  // until we reach the required size
  public void increaseCapacity(int position)
  {
    while(data.size() <= position)
    {
      data.add(null);
    }
  }
}
