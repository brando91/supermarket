package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
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
	
	@Test
	public void differentItemsCheckout() throws Exception {
		Checkout checkout = new Checkout(new PriceRules());
		
		assertThat(checkout.Price("ABCD"), is(equalTo(115)));
	}
	
	@Test
	public void multipleItemsCheckout() throws Exception {
		Checkout checkout = new Checkout(new PriceRules());
		
		assertThat(checkout.Price("DDD"), is(equalTo(45)));
	}
	
	@Ignore
	public void applyASpecialPrice() throws Exception {
		Checkout checkout = new Checkout(new PriceRules());
		
		assertThat(checkout.Price("AAA"), is(equalTo(130)));
	}
}
