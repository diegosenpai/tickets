/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package ec.com.orion.learning.springboot.tickets.registration;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author dmac240713
 */
public record Registration(Integer id, Integer productId, String ticketCode,
		@NotBlank(message = "Attendee Name is required") String attendeeName) {

}
