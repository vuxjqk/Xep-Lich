/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package dto;

import java.util.List;

/**
 *
 * @author PC
 */
public record Doctor(int id, String name, List<Room> roomsAllowed, List<Day> daysOff) {

}
