package ec.com.orion.learning.springboot.tickets.events;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class OrganizerRepository {

	private List<Organizer> content = List.of(new Organizer(3, "Orion Technologies", "Orion Techonologies"),
			new Organizer(33, "Globomantics", "Globomantics Technology"),
			new Organizer(333, "Phoenix", "Phoenix Green LLC"));

	public List<Organizer> findAll() {
		return content;
	}

}
