/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg490os_project1;

import java.util.Calendar;
import java.util.Collection;
import pkg490os_project1.CarSpec.CarSize;
import pkg490os_project1.Rental.RentalStatus;

/**
 *
 * @author Jose
 */
public class Controller {
    
    public enum Add{
        SUCCESS, EXIST, FAILED
    }
    
    private Container<String, Customer> customer;
    private Container<String, Car> car;
    private Container<String, CarSpec> carSpec;
    private Container<String, Rental> rental;
    private int availableRentals = 0;
    protected String uniqueID = "R1"; 
    
    public Controller(){
        
        customer = new Container<String, Customer>();
        car = new Container<String, Car>();
        carSpec = new Container<String, CarSpec>();
        rental = new Container<String, Rental>();
        }
    public Add addCustomer(String id, String name, String address, String phone){
        if (customer.exists(id)){
            return Add.EXIST;
        }else {
            customer.addElement(id, new Customer(id,name, address, phone));
        }
        return Add.SUCCESS;
    }
    public Add addCarSpecs(String id,String make, String model, int year, CarSize size ){
        if(carSpec.exists(id)){
            return Add.EXIST;
        }else{
           carSpec.addElement(id, new CarSpec(id,make, model, year, size));
        }
        return Add.SUCCESS;
    }
    public Add addCar(String id, String spec_id){
        try{
            if(car.exists(id))
                return Add.EXIST;
            
            CarSpec specs = carSpec.find(spec_id);
            car.addElement(id, new Car(id,specs));
            
        }
        catch(Exception e){
            return Add.FAILED;
        }
        return Add.FAILED;
    }
    public Add addRental(String car_id){
        try{
            if(rental.exists(uniqueID)){
                int i = Integer.parseInt(uniqueID.substring(1));
                i++;
                uniqueID="R"+i;
            }                
            Car rental_car = car.find(car_id);
            System.out.println(uniqueID);
            rental.addElement(uniqueID,new Rental(uniqueID, rental_car));
            availableRentals++;                        
        }catch(Exception ex){
            return Add.FAILED;
        }
        return Add.FAILED;        
    }
    public String getCustomerName(String id){
        try{
            return customer.find(id).getName();
        }
        catch(Exception ex){
            return "1";
        }
    }
    public Object[][] findRentals(String data){
        Collection<Rental> rentals = this.rental.contains(data);
        Object[][] result = new Object[rentals.size()][6];
        int count = 0;
        for (Rental rental : rentals){
            if(rental.getStatus()==RentalStatus.AVAILABLE){
                Object[] rentArray={false,rental.getID(),rental.getMake(),rental.getModel(), rental.getYear(),rental.getSize()};
                result[count++] = rentArray;
            }
        }
        return result;
    }
    public Object[][] findRented(String data){
        Collection<Rental> rented = this.rental.contains(data);
        Object[][] result = new Object[rented.size()][6];
        int count = 0;
        for (Rental rental : rented){
            if(rental.getStatus()==RentalStatus.RENTED){
                Object[] rentArray={false,rental.getID(),rental.getMake(),rental.getModel(), rental.getYear(),rental.getRentDate()};
                result[count++] = rentArray;
            }
        }
        return result;
    }
    public Object[][] findReturned(String data){
        Collection<Rental> returned = this.rental.contains(data);
        Object[][] result = new Object[returned.size()][5];
        int count = 0;
        for (Rental rental : returned){
            if(rental.getStatus()==RentalStatus.RETURNED){
                Object[] rentArray={rental.getID(),rental.getMake(),rental.getModel(), rental.getYear(),rental.getRentDate(),rental.getReturnDate()};
                result[count++] = rentArray;
            }
        }
        return result;
    }
    public void rentCar(String customerId, String rentalId, Calendar date) {
        try {
            Rental selectedCar = rental.find(rentalId);
            System.out.println(selectedCar.getStatus());
            if (selectedCar.getStatus() == RentalStatus.AVAILABLE) { // only rent if available
                selectedCar.rentCar(customerId, date);
            }
        } catch (Exception ex) {
            System.out.println("car not available, oops");
        }
    }
    public void returnCar(String rentalId, Calendar date){
                try {
            Rental selectedCar = rental.find(rentalId);
            System.out.println(selectedCar.getStatus());
            if (selectedCar.getStatus() == RentalStatus.RENTED) { // only return if rented
                selectedCar.returnCar(date);
                addRental(selectedCar.getCarID());
            }
        } catch (Exception ex) {
            System.out.println("car not rented, oops");
        }
    }
    public Object[][] findCustomer(String data){
        Collection<Customer> customers = this.customer.contains(data);
        Object[][] result = new Object [customers.size()][3];
        int count = 0;
        for (Customer customer : customers){
            Object[] c_array = { customer.getId(),customer.getName(), customer.getPhone(), customer.getAddress()};
            result[count++] = c_array;
        }
        return result;
    }
}
