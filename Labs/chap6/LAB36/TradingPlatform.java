package Labs.chap6.LAB36;

public class TradingPlatform {
  private Node head;
  private Node tail;
  private int size;
  private int profit;
  private int totalShares;

  // Intialized with two sentinel nodes on either side of deque
  public TradingPlatform()
  {
    Node sentryHead = new Node(0,0);
    Node sentryTail = new Node(0,0);

    this.head = sentryHead;
    this.tail = sentryTail;
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.size = 0;
    this.profit = 0;
  }

  // Buying shares is our form of enqueueing
  public void buy(int shares, int price)
  {
    Node newNode = new Node(shares, price);
    if(this.head.next == this.tail)
    {
      this.head.next = newNode;
      this.tail.prev = newNode;
      newNode.next = this.tail;
      newNode.prev = this.head;
      this.size++;
      this.totalShares = this.totalShares + shares;
    }
    else
    {
      newNode.next = this.head.next;
      newNode.prev = this.head;
      newNode.next.prev = newNode;
      this.head.next = newNode;
      this.size++;
      this.totalShares = this.totalShares + shares;
    }
  }

  // Selling shares
  public void sell(int shares, int price)
  {
    // If size is 0, returns and tells user no shares to sell
    if(this.size == 0)
    {
      System.out.println("You have no shares to sell");
      return;
    }
    // Returns and tells user can't sell negative shares
    if(shares < 0)
    {
      System.out.println("You cannot sell negative shares");
      return;
    }
    // User does not have enough shares to sell
    if(this.totalShares < shares)
    {
      System.out.println("You do not have that many shares to sell");
      return;
    }
    // Runs until loop breaks out
    while(true)
    {
      // There are more shares in the current node than we are trying to sell
      // Subtract amount we are trying to sell, change pnl then break out
      if(this.tail.prev.getShares() > shares)
      {
        this.profit = this.profit + this.tail.prev.subtractShares(shares,price);
        this.totalShares = this.totalShares - shares;
        break;
      }
      else
      {
        int sale = this.tail.prev.getShares();
        this.profit = this.profit + this.tail.prev.subtractShares(sale, price);
        this.totalShares = this.totalShares - sale;
        shares = shares - sale;
        dequeue();
        if(shares == 0)
        {
          break;
        }
      }
    }
  }

  // Dequeue is private because this should not be called outside of the
  // function. Only sell calls the dequeue
  private void dequeue()
  {
    if(this.size == 0)
    {
      return;
    }
    Node tempNode = this.tail.prev;
    tempNode.prev.next = this.tail;
    this.tail.prev = tempNode.prev;
    tempNode.next = null;
    tempNode.prev = null;
    this.size--;
  }

  // Checks if deque is empty
  public boolean isEmpty()
  {
    return this.size == 0;
  }

  // Returns current size of deque
  public int size()
  {
    return this.size;
  }

  // Returns current shares owned
  public int sharesOwned()
  {
    return this.totalShares;
  }

  // Returns current pnl of trader
  public int pnl()
  {
    return this.profit;
  }

  // Prints the deque from start to end
  public void print()
  {
    Node current = this.tail.prev;
    for(int i = 0; i < this.size; i++)
    {
      System.out.println("Bought " + current.getShares() + " at $" + current.price);
      current = current.prev;
    }
  }
}
