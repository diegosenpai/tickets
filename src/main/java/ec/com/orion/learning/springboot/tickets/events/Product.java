/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package ec.com.orion.learning.springboot.tickets.events;

import java.math.BigDecimal;

/**
 *
 * @author dmac240713
 */
public record Product(Integer id, Integer eventId, String name, String description, BigDecimal price) {

}
