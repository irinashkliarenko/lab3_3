package edu.iis.mto.time;

import static org.junit.Assert.*;

import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeUtils;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

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
		DateTimeUtils.setCurrentMillisOffset((Order.VALID_PERIOD_HOURS + 2) * DateTimeConstants.MILLIS_PER_HOUR);
		order.confirm();	
	}

}
