/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg490os_project1;

import java.util.Calendar;

/**
 *
 * @author Joshua
 */
public class Rental {
    public enum RentalStatus{AVAILABLE, RENTED};
    
    private Calendar rentDate;
    private Calendar returnDate;
    private RentalStatus status;
}
    
