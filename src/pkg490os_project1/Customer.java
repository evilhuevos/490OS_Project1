/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg490os_project1;

/**
 *
 * @author Joshua
 */
public class Customer {
    private String name;
    private String phone;
    private String address;
    
    Customer(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public String[] to_array(){
                String[] array={name,phone,address};
        return array;
    }
}
