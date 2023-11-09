package ec.com.orion.learning.springboot.tickets.registration;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "registration")
public class RegistrationController {

	private RegistrationRepository registrationRepo;

	public RegistrationController(RegistrationRepository registrationRepo) {
		super();
		this.registrationRepo = registrationRepo;
	}

	@PostMapping
	public Registration register(@RequestBody @Valid Registration registration) {
		return registrationRepo.save(registration);
	}

	@PutMapping
	public Registration update(@RequestBody Registration registration) {
		return registrationRepo.update(registration);
	}

	@DeleteMapping(path = "/{ticketCode}")
	public void delete(@PathVariable("ticketCode") String ticketCode) {
		registrationRepo.deleteByTicketCode(ticketCode);
	}

	@GetMapping(path = "/{ticketCode}")
	public Registration findByTicketCode(@PathVariable String ticketCode) {
		return registrationRepo.findRegistrationByTicketCode(ticketCode).orElseThrow(() -> new NoSuchElementException(
				String.format("Registration with ticket code %s not foud", ticketCode)));
	}

}
