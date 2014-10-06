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
    
    private String ID;
    private Calendar rentDate;
    private Calendar returnDate;
    private RentalStatus status;    
    private Car rentalCar;
    private boolean selected;
    
    public Rental(String id,Car rentalCar){
        
        this.ID = id;
        this.rentalCar = rentalCar;
        this.status=RentalStatus.AVAILABLE;
        this.selected=false;
        this.rentDate = null;
        this.returnDate = null;
    }
    public String getID(){
        return ID;
    }
   public void setID(String id){
       this.ID = id;
   }
   public RentalStatus getStatus(){
       return status;
   }
    public void rentCar(Calendar rentDate, Calendar dueDate){
        status=status.RENTED;
        this.rentDate=rentDate;
        this.returnDate=dueDate;

    }
    public void returnCar(Calendar returnDate){
        status=status.AVAILABLE;
        this.returnDate=returnDate;
    }
//    @Override
//    public boolean startsWith(String key) {
//    //    return rentalCar.contains(key);
//        return true;
//    }
    public String getMake(){
        return rentalCar.getSpecs().getMake();
    }
    public String getModel(){
        return rentalCar.getSpecs().getModel();
    }
    public String getYear(){
        return rentalCar.getSpecs().getYear();
    }
    public String getSize(){
        return rentalCar.getSpecs().getSize();
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
    
