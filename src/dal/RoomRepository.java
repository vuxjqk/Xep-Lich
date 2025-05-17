/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dto.Room;
import java.util.List;

/**
 *
 * @author PC
 */
public class RoomRepository {

    public static List<Room> loadRooms() {
        return CsvHelper.readCsv("data/rooms.csv", values -> new Room(
                Integer.parseInt(values[0]),
                values[1]
        ));
    }

    public static void saveRooms(List<Room> rooms) {
        CsvHelper.writeCsv(
                "data/rooms.csv",
                new String[]{"RoomId", "RoomName"},
                rooms,
                room -> new String[]{
                    String.valueOf(room.id()),
                    room.name()
                }
        );
    }
}
