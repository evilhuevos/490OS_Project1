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
public class Customer implements Searchable<String>{
    private String id;
    private String name;
    private String phone;
    private String address;
    
    Customer(String id,String name, String address, String phone){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean startsWith(String key) {
        return name.contains(key);
    }

    @Override
    public boolean contains(String key) {
       return name.startsWith(key);
    }

    @Override
    public String[] to_array() {
        String[] array={name,phone,address};
        return array;
    }
}
