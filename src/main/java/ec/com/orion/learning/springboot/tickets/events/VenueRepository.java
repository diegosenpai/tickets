package ec.com.orion.learning.springboot.tickets.events;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class VenueRepository {

	private List<Venue> venues = List.of(new Venue(101, "Orion Tower", "Ibarra", "Ecuador"),
			new Venue(102, "Liverpool Headquarters", "Liverpool", "United Kingdom"));

	public Optional<Venue> findById(Integer id) {
		return venues.stream().filter(v -> v.id() == id).findAny();
	}

	
	
}
