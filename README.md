# Back to the supermarket

This week, we’ll implement the code for a checkout system that handles pricing schemes such as “apples cost 50 cents, three apples cost $1.30.”

This week, let’s implement the code for a supermarket checkout that calculates the total price of a number of items.  In a normal supermarket, things are identified using Stock Keeping Units, or SKUs.  In our store, we’ll use individual letters of the alphabet (A, B, C, and so on).  Our goods are priced individually. In addition, some items are multipriced: buy n of them, and 
they’ll cost you x cents.  For example, item ‘A’ might cost 50 cents individually, but this week we have a special offer: buy three ‘A’s and they’ll cost you $1.30. 

In fact this week’s prices are:

      Item   Unit      Special
             Price     Price
      --------------------------
        A     50       3 for 130
        B     30       2 for 45
        C     20
        D     15

Our checkout accepts items in any order, so that if we scan a B, an A, and another B, we’ll recognize the two B’s and price them at 45 (for a total price so far of 95). 
Because the pricing changes frequently, we need to be able to pass in a set of pricing rules each time we start handling a checkout transaction.

The interface to the checkout should look like:

       var checkOut = new CheckOut(pricingRules);
       checkOut.Scan(item);
       checkOut.Scan(item);
       ...
       var price = checkOut.Total;

Here’s a set of unit tests for a Java implementation.
The helper method price lets you specify a sequence of items using a string, calling the checkout’s scan method on each item in turn before finally returning the total price.

# Tests

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTotals() {
		assertEquals(0, Price(""));
		assertEquals(50, Price("A"));
		assertEquals(80, Price("AB"));
		assertEquals(115, Price("CDBA"));
		
		assertEquals(100, Price("AA"));
		assertEquals(130, Price("AAA"));
		assertEquals(180, Price("AAAA"));
		assertEquals(230, Price("AAAAA"));
		assertEquals(260, Price("AAAAAA"));
		
		assertEquals(160, Price("AAAB"));
		assertEquals(175, Price("AAABB"));
		assertEquals(190, Price("AAABBD"));
		assertEquals(190, Price("DABABA"));
	}
	
	@Test
	public void incrementalTest(){
		Checkout co = new Checkout(new PriceRules());
		assertEquals(0,co.totals());
                co.scan('A');
                assertEquals(50, co.totals());
                co.scan('B');
                assertEquals(80, co.totals());
                co.scan('A');
                assertEquals(130, co.totals());
                co.scan('A');
                assertEquals(160, co.totals());
                co.scan('B');
                assertEquals(175, co.totals());
	}

	private int Price(String items) {
		Checkout co = new Checkout(new PriceRules());
		for(char c : items.toCharArray())
			co.scan(c);
		return co.totals();
	}
}
