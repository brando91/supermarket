package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import core.DiscountedProduct;

public class DiscountedProductTest {

	@Test
	public void unitPrice() throws Exception {
		DiscountedProduct product = new DiscountedProduct("A", 50, 3, 130);
		
		assertThat(product.totalPrice(1), is(equalTo(50)));
	}
	
	@Test
	public void discountedPrice() throws Exception {
		DiscountedProduct product = new DiscountedProduct("A", 50, 3, 130);
		
		assertThat(product.totalPrice(3), is(equalTo(130)));
	}
	
	@Test
	public void doubleDiscountPrice() throws Exception {
		DiscountedProduct product = new DiscountedProduct("A", 50, 3, 130);
		
		assertThat(product.totalPrice(6), is(equalTo(260)));
	}
	
	@Test
	public void mixedPrice() throws Exception {
		DiscountedProduct product = new DiscountedProduct("A", 50, 3, 130);
		
		assertThat(product.totalPrice(7), is(equalTo(310)));
	}
}
