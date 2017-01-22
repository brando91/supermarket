package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import core.SimpleProduct;

public class SimpleProductTest {

	@Test
	public void multipleSimpleProducts() throws Exception {
		SimpleProduct product = new SimpleProduct("A", 10);
		
		assertThat(product.priceFor(5), is(equalTo(50)));
	}
}
