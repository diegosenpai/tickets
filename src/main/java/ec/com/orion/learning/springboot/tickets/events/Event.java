/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package ec.com.orion.learning.springboot.tickets.events;

import java.time.LocalDate;

/**
 *
 * @author dmac240713
 */
public record Event(Integer id, String name, Organizer organizer, Venue venue, LocalDate startDate, LocalDate endDate) {

}
