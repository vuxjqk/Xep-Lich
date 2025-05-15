/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import dal.RoomRepository;
import dto.Room;
import java.util.List;

/**
 *
 * @author PC
 */
public class RoomManager {

    private static List<Room> rooms;

    public static List<Room> getRooms() {
        if (rooms == null) {
            rooms = RoomRepository.loadRooms();
        }
        return rooms;
    }
}
