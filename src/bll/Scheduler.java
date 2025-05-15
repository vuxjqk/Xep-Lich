/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import java.util.Random;

/**
 *
 * @author PC
 */
public class Scheduler {
    
    private GeneticAlgorithm ga;
    
    public Scheduler() {
        ga = new GeneticAlgorithm(DoctorManager.getDoctors(), RoomManager.getRooms(), DayManager.getDays(),
                200, 2000, 3, 0.8, 0.2, new Random());
    }
    
    public void runGeneticAlgorithm() {
        ScheduleManager.setSchedules(ga.run());
    }
}
