/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg490os_project1;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Joshua
 */
public class Car {
    private String id;
    private CarSpec carSpecs;
    
    public Car(String id, CarSpec carSpecs){
        this.id=id;
        this.carSpecs=carSpecs;
    }
    public String[] to_array() {
        String[] array = {id,carSpecs.getMake(),carSpecs.getModel(),Integer.toString(carSpecs.getYear()),carSpecs.getSize()};
        return array;
    }

}
