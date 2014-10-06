/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg490os_project1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Joshua
 */
public class Rental implements Searchable<String>{




    public enum RentalStatus{AVAILABLE, RENTED, RETURNED};
    
    private String ID;
    private Calendar rentDate;
    private Calendar returnDate;
    private RentalStatus status;    
    private Car rentalCar;
    private boolean selected;
    private String custID;
    
    public Rental(String id,Car rentalCar){
        
        this.ID = id;
        this.rentalCar = rentalCar;
        this.status=RentalStatus.AVAILABLE;
        this.selected=false;
        this.rentDate = null;
        this.returnDate = null;
        this.custID = "";
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
    public void rentCar(String custID, Calendar rentDate){
        status=status.RENTED;
        this.custID=custID;
        this.rentDate=rentDate;
        System.out.println(custID+" rented car "+rentalCar.getId());

    }
    public void returnCar(Calendar returnDate){
        this.returnDate=returnDate;
        this.status=status.RETURNED;
    }
 
    public String getMake() {
        return rentalCar.getSpecs().getMake();
    }

    public String getModel() {
        return rentalCar.getSpecs().getModel();
    }

    public String getYear() {

       return rentalCar.getSpecs().getYear();
    }

    public String getSize() {
        return rentalCar.getSpecs().getSize();
    }

    public String getRentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        if (rentDate != null) {
            return sdf.format(rentDate.getTime());
        }
        return "";
    }

    public String getReturnDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        if (returnDate != null) {
            return sdf.format(returnDate.getTime());
        }
        return "";
    }

    public String getCustomerID() {
        return custID;
    }

    public String getCarID() {
        return rentalCar.getId();
    }
    @Override
    public boolean contains(String key) {
        return rentalCar.getSpecs().getId().toLowerCase().contains(key.toLowerCase())
                || rentalCar.getSpecs().getMake().toLowerCase().contains(key.toLowerCase())
                || rentalCar.getSpecs().getModel().toLowerCase().contains(key.toLowerCase())
                || rentalCar.getSpecs().getYear().toLowerCase().contains(key.toLowerCase())
                || rentalCar.getSpecs().getSize().toLowerCase().contains(key.toLowerCase())
                || getCustomerID().toLowerCase().contains(key.toLowerCase());
    }
    
    @Override
    public String[] to_array() {
        return this.rentalCar.to_array();
    }
}