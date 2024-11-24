package Labs.chap6.LAB36;

public class Node {
  // Set shares to private. Don't want to accidentally change
  // Price set to final since can't change price you bought it at
  private int shares;
  public final int price;
  public Node next;
  public Node prev;

  // Intialize Node
  public Node(int shares, int price)
  {
    if(shares != -1)
    {
      System.out.printf("Buy %d share(s) at $%d each\n", shares, price);
    }
    this.shares = shares;
    this.price = price;
    this.next = null;
    this.prev = null;
  }
  
  // Method to subtract shares if only a partial of the whole is sold
  public int subtractShares(int sold, int sellPrice)
  {
    System.out.printf("Sell %d share(s) at $%d each\n", sold, sellPrice);
    this.shares = this.shares - sold;
    return sold * (sellPrice - this.price);
  }

  // Returns amount of shares in this node
  public int getShares()
  {
    return this.shares;
  }
}
