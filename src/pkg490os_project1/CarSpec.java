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
public class CarSpec implements Searchable<String> {

    
    public enum CarSize{COMPACT,MIDSIZE,FULLSIZE};
    private String make;
    private String model;
    private int year;
    private CarSize size;
    private String ID;
    
    public CarSpec(String id,String make, String model, int year, CarSize size ){
        this.make = make;
        this.model = model;
        this.year = year;
        this.size = size;
        this.ID = id;
    }
    public void setId(String id){
        this.ID = id;
    }
    public String getId(){
        return ID;
    }
    public void setMake(String make){
        this.make = make;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setSize(CarSize size){
        this.size = size;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public String getYear(){
        return Integer.toString(year);
    }
    public String getSize(){
        return size.toString();
    }
//    @Override
//    public boolean startsWith(String key) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public boolean contains(String key) {
       return make.toLowerCase().contains(key.toLowerCase()) || model.toLowerCase().contains(key.toLowerCase());// need to check the other elements
    }

    @Override
    public String[] to_array() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
