package ca.mcgill.ecse321.eventregistration.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person{
private String name;

    public void setName(String value) {
        this.name = value;
    }
    @Id
    public String getName() {
        return this.name;
    }
    
    private Set<Registration> registrations;

    @OneToMany(cascade = { CascadeType.ALL })
	public Set<Registration> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(Set<Registration> registration) {
		this.registrations = registration;
	}
    
    
}
