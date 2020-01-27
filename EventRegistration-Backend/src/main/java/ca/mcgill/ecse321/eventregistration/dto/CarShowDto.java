package ca.mcgill.ecse321.eventregistration.dto;

import java.sql.Date;
import java.sql.Time;

public class CarShowDto extends EventDto{
	private String make;
	
	public CarShowDto () {
		
	}
	
	public CarShowDto(String name) {
		super(name, Date.valueOf("1971-01-01"), Time.valueOf("00:00:00"), Time.valueOf("23:59:59"));
	}

	public CarShowDto(String name, Date date, Time startTime, Time endTime, String make) {
		super(name, date, startTime, endTime);
		this.make = make;
	}

	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getMake() {
		return this.make;
	}
	
}
