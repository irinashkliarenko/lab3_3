package edu.iis.mto.time;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private Order order;
	
	@Before
	public void setUp() throws Exception {
		order = new Order();
	}

	@Test(expected = OrderExpiredException.class)
	public void testOrderExpired() {
		order.submit();
		order.confirm();
	}

}
