package ec.com.orion.learning.springboot.tickets.events;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class EventRepository {

	private List<Event> events = List.of(
			new Event(301, "Object Oriented Patterns", new Organizer(101, "Orion Technologies", "Orion LLC"),
					new Venue(201, "Orion Tower", "Ibarra", "Ecuador"), LocalDate.now(), LocalDate.now().plusDays(3)),
			new Event(302, "SpringBoot Fundamentals", new Organizer(102, "Liverpool Inc", "Liverpool LLC"),
					new Venue(202, "Liverpool convention Center", "Liverpool", "United Kingdom"), LocalDate.now(),
					LocalDate.now().plusDays(3)),
			new Event(303, "JPA Fundamentals", new Organizer(103, "ACME INC", "ACME Laboratories"),
					new Venue(203, "Ontario Tower", "Ontario", "Canada"), LocalDate.now(),
					LocalDate.now().plusDays(7)));

	public List<Event> findByOrganizerId(Integer organizerId) {
		return events.stream().filter(e -> e.organizer().id() == organizerId).toList();
	}

	public Optional<Event> findById(Integer eventId) {
		System.out.println("Empieza la diversion: " + eventId);
		for (Event event : events) {
			System.out.println(String.format("compare %b", event.id() == eventId));
		}
		return events.stream().filter(e -> e.id().compareTo(eventId)==0).findAny();
	}

}
