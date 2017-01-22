package unit;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;

import core.Checkout;
import core.PriceRules;

public class AcceptanceTest {

	@Ignore
	public void testTotals() {
	    Checkout checkout = new Checkout(new PriceRules());
	    
		assertEquals(0, checkout.Price(""));
	    assertEquals(50, checkout.Price("A"));
	    assertEquals(80, checkout.Price("AB"));
	    assertEquals(115, checkout.Price("CDBA"));

	    assertEquals(100, checkout.Price("AA"));
	    assertEquals(130, checkout.Price("AAA"));
	    assertEquals(180, checkout.Price("AAAA"));
	    assertEquals(230, checkout.Price("AAAAA"));
	    assertEquals(260, checkout.Price("AAAAAA"));

	    assertEquals(160, checkout.Price("AAAB"));
	    assertEquals(175, checkout.Price("AAABB"));
	    assertEquals(190, checkout.Price("AAABBD"));
	    assertEquals(190, checkout.Price("DABABA"));
	}

	@Ignore
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
}
