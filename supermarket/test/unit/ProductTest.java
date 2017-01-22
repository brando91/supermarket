package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import core.SimpleProduct;

public class ProductTest {

	@Test
	public void matches() throws Exception {
		
		SimpleProduct product = new SimpleProduct("A", 2);
		
		assertThat(product.matches('a'), is(equalTo(true)));
		assertThat(product.matches('A'), is(equalTo(true)));
		assertThat(product.matches('B'), is(equalTo(false)));
	}
}
