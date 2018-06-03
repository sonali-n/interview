package com.ubs.opsit.interviews;

public class BerlinClock implements TimeConverter {

	@Override
	public String convertTime(String time) {
		if (time == null) {
			throw new IllegalArgumentException(Constants.NULL_TIME);
		}
		String[] timeStamp = time.split(":", 3);
		int hours = 0, minutes = 0, seconds = 0;
		String secondString, hourString, minString, clock;
		try {
			hours   = Integer.parseInt(timeStamp[0]);
			minutes = Integer.parseInt(timeStamp[1]);
			seconds = Integer.parseInt(timeStamp[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Constants.INVALID_TIME);
		}

		validateTime(hours, minutes, seconds);

		secondString = TimeCalculations.processSeconds(seconds);
		hourString = TimeCalculations.processHours(hours);
		minString = TimeCalculations.processMinutes(minutes);
		clock = secondString + hourString + minString;
		return clock;

	}

	private void validateTime(int hours, int minutes, int seconds) {
		if (hours < 0 || hours > 24) {
			throw new IllegalArgumentException(Constants.HOUR_ERR);
		}
		if (minutes < 0 || minutes > 59) {
			throw new IllegalArgumentException(Constants.MIN_ERR);
		}
		if (seconds < 0 || seconds > 59) {
			throw new IllegalArgumentException(Constants.SEC_ERR);
		}
	}

}
