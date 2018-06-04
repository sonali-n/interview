package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class BerlinClockTest {
	
	BerlinClock clock = new BerlinClock();
	
	@Test
	public void testfirst(){
		String time  = "00:00:00";
		String berlinClock = clock.convertTime(time);
		String expectedOutput = "Y" + "\r\n"+
				"OOOO" + "\r\n"+
				"OOOO" + "\r\n"+
				"OOOOOOOOOOO" + "\r\n"+
				"OOOO";
		assertEquals(berlinClock, expectedOutput);
	}
	
	@Test
	public void testrandom(){
		String time  = "13:17:01";
		String berlinClock = clock.convertTime(time);
		String expectedOutput = 
				"O"+ "\r\n"+
				"RROO"+ "\r\n"+
				"RRRO"+ "\r\n"+
				"YYROOOOOOOO"+ "\r\n"+
				"YYOO";
		assertEquals(berlinClock, expectedOutput);
	}
	
	@Test
	public void testmidnight(){
		String time  = "23:59:59";
		String berlinClock = clock.convertTime(time);
		String expectedOutput = "O"+ "\r\n"+
				"RRRR"+ "\r\n"+
				"RRRO"+ "\r\n"+
				"YYRYYRYYRYY"+ "\r\n"+
				"YYYY";
		assertEquals(berlinClock, expectedOutput);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testmidnightwithException(){
		String time  = "24:59:59";
		String berlinClock = clock.convertTime(time);
		throw new IllegalArgumentException(Constants.HOUR_ERR);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testMinuteswithException(){
		String time  = "23:60:59";
		String berlinClock = clock.convertTime(time);
		throw new IllegalArgumentException(Constants.MIN_ERR);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSecondswithException(){
		String time  = "23:59:60";
		String berlinClock = clock.convertTime(time);
		throw new IllegalArgumentException(Constants.MIN_ERR);
	}

}
