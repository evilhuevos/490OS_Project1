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
public class CarSpec {
    public enum CarSize{COMPACT,MIDSIZE,FULLSIZE};
    
    private String make;
    private String model;
    private int year;
    private CarSize size;
    
    CarSpec(String make, String model, int year,CarSize size ){
        this.make = make;
        this.model = model;
        this.year = year;
        this.size = size;
    }
}
