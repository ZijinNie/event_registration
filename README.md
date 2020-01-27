#Event Registration System

The repository stores the source code for a event registration system. 

Technology used: 
Backend: Java, Spring Boot
Frontend: JavaScript, Vue.js
Build: Gradle
Deployment: Heroku

Feature: 

- User could create a event by giving name, date time.
- User could create a person by giving name
- User can register for an event
- The system shall support managing promoters. Each promoter can promote events. All
promoters count as persons, that is, they can still be registered to events.
- In addition to generic events, specific events can be registered as carshow. Each carshow has
one make attribute.
- Users of the system shall be able to register payments for existing registrations. Participants of
an event pay for a registration via CreditCard. A payment shall record the device ID in the
format DDDD-DDDD (where D denotes a digit) and the payment amount in CAD
