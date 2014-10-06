/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg490os_project1;

import java.util.LinkedList;

/**
 *
 * @author Joshua
 */
public class Customer implements Searchable<String>{
    
    private String id;
    private String name;
    private String phone;
    private String address;
    private LinkedList<String> rentals;
    
    public Customer(String id,String name, String address, String phone){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        rentals= new LinkedList<String>();// keep a list of rented items.
    }
   
    public void setName(String name){
       this.name = name;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }
    public String getId(){
        return id;
    }
//    @Override
//    public boolean startsWith(String key) {
//        return name.contains(key);
//    }

    @Override
    public boolean contains(String key) {
        return name.toLowerCase().contains(key.toLowerCase()) || id.toLowerCase().contains(key.toLowerCase()) 
                || address.toLowerCase().contains(key.toLowerCase()) || phone.toLowerCase().contains(key.toLowerCase());
       //return name.startsWith(key);
    }
    public void rentCar(String ID){
        if(!rentals.contains(ID))
            rentals.add(ID);
    }
    public LinkedList<String> getRental(){
        return rentals;
    }

    @Override
    public String[] to_array() {
        String[] array={name,phone,address};
        return array;
    }
}
