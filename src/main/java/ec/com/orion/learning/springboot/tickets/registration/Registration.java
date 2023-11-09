/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package ec.com.orion.learning.springboot.tickets.registration;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author dmac240713
 */
@Document("registrations")
public record Registration(
		@Id
		String id, Integer productId, String ticketCode,
		@NotBlank(message = "Attendee Name is required") String attendeeName) {

}
