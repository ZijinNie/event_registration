package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity
public class RegistrationManager {

	private Set<Person> persons;

	@OneToMany(cascade = { CascadeType.ALL })
	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> personss) {
		this.persons = personss;
	}

	private Set<Registration> registrations;

	@OneToMany(cascade = { CascadeType.ALL })
	public Set<Registration> getRegistrations() {
		return this.registrations;
	}

	public void setRegistrations(Set<Registration> registrationss) {
		this.registrations = registrationss;
	}

	private Set<Event> events;

	@OneToMany(cascade = { CascadeType.ALL })
	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> eventss) {
		this.events = eventss;
	}

	private int id;

	public void setId(int value) {
		this.id = value;
	}

	@Id
	public int getId() {
		return this.id;
	}
	
	private Set<CarShow> carShows;
	
	private Set<CreditCard> creditCards;
	
	private Set<Promoter> promoters;

	@OneToMany(cascade = { CascadeType.ALL })
	public Set<CarShow> getCarShows() {
		return carShows;
	}

	public void setCarShows(Set<CarShow> carShows) {
		this.carShows = carShows;
	}

	@OneToMany(cascade = { CascadeType.ALL })
	public Set<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	@OneToMany(cascade = { CascadeType.ALL })
	public Set<Promoter> getPromoters() {
		return promoters;
	}

	public void setPromoters(Set<Promoter> promoters) {
		this.promoters = promoters;
	}
}
