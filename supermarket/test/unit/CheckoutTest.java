package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import core.Checkout;
import core.PriceRules;

public class CheckoutTest {

	@Test
	public void baseCheckout() throws Exception {
		assertThat(new Checkout(new PriceRules()).Price("A"), is(equalTo(50)));
		assertThat(new Checkout(new PriceRules()).Price("B"), is(equalTo(30)));
		assertThat(new Checkout(new PriceRules()).Price("C"), is(equalTo(20)));
		assertThat(new Checkout(new PriceRules()).Price("D"), is(equalTo(15)));
	}
}
