package ec.com.orion.learning.springboot.tickets.events;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class EventController {

	private EventRepository eventRepo;
	private ProducRepository productRepo;
	private OrganizerRepository organizerRepo;

	public EventController(EventRepository eventRepo, ProducRepository productRepo, OrganizerRepository organizerRepo) {
		super();
		this.eventRepo = eventRepo;
		this.productRepo = productRepo;
		this.organizerRepo = organizerRepo;
	}

	@GetMapping(path = "/organizers")
	public List<Organizer> getAllOrganizers() {
		return organizerRepo.findAll();
	}

	@GetMapping(path = "/events")
	public List<Event> getEventsByOrganizerId(@RequestParam("organizerId") Integer organizerId) {
		return eventRepo.findByOrganizerId(organizerId);
	}

	@GetMapping(path = "/events/{id}")
	public Event getEventById(@PathVariable("id") Integer id) {
		return eventRepo.findById(id)
				.orElseThrow(() -> new NoSuchElementException(String.format("Event with id:%d not found", id)));
	}

	@GetMapping(path = "/products")
	public List<Product> getProductsByEventId(@RequestParam("eventId") Integer eventId) {
		return productRepo.findByEventId(eventId);
	}
}
