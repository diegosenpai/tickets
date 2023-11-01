package ec.com.orion.learning.springboot.tickets.events;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProducRepository {

	private List<Product> products = List.of(
			new Product(901, 301, "Standar", "Standar Conference", BigDecimal.valueOf(33.33)),
			new Product(902, 301, "Premium", "Golden Ticket", BigDecimal.valueOf(3333)),
			new Product(903, 302, "Basic", "Standard Plan", BigDecimal.valueOf(3366)),
			new Product(904, 303, "Blue Label", "Premium Pass", BigDecimal.valueOf(0)));

	public List<Product> findByEventId(Integer eventId) {
		return products.stream().filter(p -> p.eventId().compareTo(eventId) == 0).toList();
	}

}
