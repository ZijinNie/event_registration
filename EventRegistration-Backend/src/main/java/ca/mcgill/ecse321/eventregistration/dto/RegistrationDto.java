package ca.mcgill.ecse321.eventregistration.dto;

public class RegistrationDto {

	private PersonDto person;
	private EventDto event;
	private CreditCardDto creditCard;
	
	public CreditCardDto getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardDto creditCard) {
		this.creditCard = creditCard;
	}

	public RegistrationDto() {
	}

	public RegistrationDto(PersonDto person, EventDto event) {
		this.person = person;
		this.event = event;
		
	}

	public RegistrationDto(PersonDto person, EventDto event, CreditCardDto creditCard) {
		this(person,event);
		this.creditCard=creditCard;
		
	}
	public EventDto getEvent() {
		return event;
	}

	public void setEvent(EventDto event) {
		this.event = event;
	}

	public PersonDto getPerson() {
		return person;
	}

	public void setPerson(PersonDto person) {
		this.person = person;
	}
	
	

}
