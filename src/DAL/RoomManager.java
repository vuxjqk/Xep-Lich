/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Room;
import java.util.List;

/**
 *
 * @author PC
 */
public class RoomManager {

    private static List<Room> rooms;

    public static List<Room> getRooms() {
        if (rooms == null) {
            rooms = CsvHelper.readFromCsv("rooms.csv", record -> new Room(
                    Integer.parseInt(record[0]), record[1]));
        }
        return rooms;
    }
}
