// When a share of common stock of some company is sold, the capital gain
// (or, sometimes, loss) is the difference between the share's selling price
// and the price originally paid to buy it. This rule is easy to understand
// for a single share, but if we sell multiple shares of stock bought over
// a long period of time, then we must identify the shares actually being
// sold. A standard accounting principle for identifying which shares of a
// stock were sold in such a case is to use a FIFO protocol—the shares sold
// are the ones that have been held the longest (indeed, this is the default
// method built into several personal finance software packages).
// For example, suppose we:
// buy 100 shares at $20 each on day 1,
// 20 shares at $24 on day 2,
// 200 shares at $36 on day 3,
// and then sell 150 shares on day 4 at $30 each.
// Then applying the FIFO protocol means that of the 150 shares sold, 100
// were bought on day 1, 20 were bought on day 2, and 30 were bought on day
// 3. The capital gain in this case would therefore be
// 100 * 10 + 20 * 6 + 30 *(-6), or $940. Write a program that takes as
// input a sequence of transactions of the form buy x share(s) at $y each
// or sell x share(s) at $y each, assuming that the transactions occur on
// consecutive days and the values and are integers. Given this input sequence,
// the output should be the total capital gain (or loss) for the entire
// sequence, using the FIFO protocol to identify shares.

package Labs.chap6.LAB36;

import java.util.Scanner;

public class LAB36 {
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    TradingPlatform platform = new TradingPlatform();
    boolean exit = false;

    while (!exit)
    {
      System.out.println("\n--- Stock Trading Platform ---");
      System.out.println("1. Buy Shares");
      System.out.println("2. Sell Shares");
      System.out.println("3. View Current Stock Owned");
      System.out.println("4. View Current PNL");
      System.out.println("5. Exit");
      System.out.print("Choose an option: ");

      int choice = in.nextInt();
      int buyShares, buyPrice, sellShares, sellPrice;

      switch (choice)
      {
        case 1:
          // Buy Shares
          do {
            System.out.print("Enter the number of shares to buy: ");
            buyShares = in.nextInt();
            if(buyShares <= 0)
            {
              System.out.println("You can't buy <= 0 shares");
            }
            else
            {
              break;
            }
          } while(true);
          do {
            System.out.print("Enter the price per share: ");
            buyPrice = in.nextInt();
            if(buyPrice <= 0)
            {
              System.out.println("You can't buy shares at price <= 0");
            }
            else
            {
              break;
            }
          } while(true);
          platform.buy(buyShares, buyPrice);
          break;

        case 2:
          // Sell Shares
          do { 
            System.out.print("Enter the number of shares to sell: ");
            sellShares = in.nextInt();
            if(sellShares <= 0)
            {
              System.out.println("You can't sell <= 0 shares");
            }
            else
            {
              break;
            }
          } while (true);

          do { 
            System.out.print("Enter the selling price per share: ");
            sellPrice = in.nextInt();
            if(sellPrice <= 0)
            {
              System.out.println("You can't sell shares at price <= 0");
            }
            else
            {
              break;
            }
          } while (true);

          platform.sell(sellShares, sellPrice);
          break;

        case 3:
          // View Current Stock Owned
          platform.print();
          System.out.println("\nTotal shares owned: " + platform.sharesOwned());
          break;

        case 4:
          // View Current PNL
          System.out.println("\nCurrent PNL: $" + platform.pnl());
          break;

        case 5:
          // Exit
          System.out.println("Exiting the platform. Goodbye!");
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