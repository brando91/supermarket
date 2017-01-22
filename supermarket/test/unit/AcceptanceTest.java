package unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.Checkout;
import core.PriceRules;

public class AcceptanceTest {

	@Test
	public void testTotals() {
	    assertEquals(0, priceFor(""));
	    assertEquals(50, priceFor("A"));
	    assertEquals(80, priceFor("AB"));
	    assertEquals(115, priceFor("CDBA"));

	    assertEquals(100, priceFor("AA"));
	    assertEquals(130, priceFor("AAA"));
	    assertEquals(180, priceFor("AAAA"));
	    assertEquals(230, priceFor("AAAAA"));
	    assertEquals(260, priceFor("AAAAAA"));

	    assertEquals(160, priceFor("AAAB"));
	    assertEquals(175, priceFor("AAABB"));
	    assertEquals(190, priceFor("AAABBD"));
	    assertEquals(190, priceFor("DABABA"));
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
	
	private int priceFor(String items) {
		return new Checkout(new PriceRules()).Price(items);
	}
}
