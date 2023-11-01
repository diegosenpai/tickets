package ec.com.orion.learning.springboot.tickets.registration;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepository {

	private Map<String, Registration> storage = new ConcurrentHashMap<>();

	private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

	public Registration create(Registration someRegistration) {
		String ticketCode = UUID.randomUUID().toString();
		int registrationId = ID_GENERATOR.getAndIncrement();
		Registration registration = new Registration(registrationId, someRegistration.productId(), ticketCode,
				someRegistration.attendeeName());
		storage.put(ticketCode, registration);
		return registration;
	}

	public Optional<Registration> findRegistrationByTicketCode(String ticketCode) {
		return Optional.ofNullable(storage.get(ticketCode));
	}

	public Registration update(Registration updatedRegistration) {
		String ticketCode = updatedRegistration.ticketCode();
		Optional<Registration> result = findRegistrationByTicketCode(ticketCode);
		if (result.isPresent()) {
			Registration registration = storage.get(ticketCode);
			Registration updated = new Registration(registration.id(), registration.productId(),
					registration.ticketCode(), updatedRegistration.attendeeName());
			storage.put(ticketCode, updated);
			return updated;
		} else {
			throw new NoSuchElementException(String.format("Registration with ticket code %s not found", ticketCode));
		}
	}

	public void deleteByTicketCode(String ticketCode) {
		storage.remove(ticketCode);
	}

}
