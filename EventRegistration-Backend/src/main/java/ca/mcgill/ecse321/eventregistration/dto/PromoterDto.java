package ca.mcgill.ecse321.eventregistration.dto;

import java.util.Collections;
import java.util.List;

public class PromoterDto extends PersonDto{
	
	private List<EventDto> promotes;
	
	public List<EventDto> getPromotes() {
		return promotes;
	}


	public void setPromotes(List<EventDto> promotes) {
		this.promotes = promotes;
	}


	public PromoterDto () {
		super();
	}
	

	@SuppressWarnings("unchecked")
	public PromoterDto(String name) {
		super(name, Collections.EMPTY_LIST);
		this.promotes=Collections.EMPTY_LIST;
	}

	public PromoterDto(String name, List<EventDto> events, List<EventDto> promotes) {
		super(name,events);
		this.promotes = promotes;
	}
}
