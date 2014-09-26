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
public class Rental implements Searchable<String>{




    public enum RentalStatus{AVAILABLE, RENTED};
    
    private Calendar rentDate;
    private Calendar returnDate;
    private RentalStatus status;    
    private Car rentalCar;
    private boolean selected;
    
    public Rental(Car rentalCar){
        this.rentalCar = rentalCar;
        status=RentalStatus.AVAILABLE;
        selected=false;
    }
    
    public void rentCar(Calendar rentDate, Calendar returnDate){
        status=status.RENTED;
        this.rentDate=rentDate;
        this.returnDate=returnDate;

    }
    public void returnCar(Calendar returnDate){
        status=status.AVAILABLE;
        this.returnDate=returnDate;
    }
    @Override
    public boolean startsWith(String key) {
    //    return rentalCar.contains(key);
        return true;
    }

    @Override
    public boolean contains(String key) {
    //    return rentalCar.contains(key);
        return true;
    }  
    
    @Override
    public String[] to_array() {
        return this.rentalCar.to_array();
    }
}
    
