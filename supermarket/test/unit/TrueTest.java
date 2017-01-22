package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TrueTest {

	@Test
	public void Trivial() throws Exception {
		assertThat(true, is(equalTo(true)));
	}
}
