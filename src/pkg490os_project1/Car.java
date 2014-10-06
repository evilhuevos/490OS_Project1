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
public class Car  implements Searchable<String>{
    private String id;
    private CarSpec carSpecs;
    
    
    
    public Car(String id, CarSpec carSpecs){
        this.id=id;
        this.carSpecs=carSpecs;
       
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setSpecs(CarSpec specs){
        this.carSpecs = specs;
    }
    public CarSpec getSpecs() {
        return carSpecs;
    }
    public String[] to_array() {
        String[] array = {id,carSpecs.getMake(),carSpecs.getModel(),carSpecs.getYear(),carSpecs.getSize()};
        return array;
    }

//    @Override
//    public boolean startsWith(String key) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public boolean contains(String key) {
       return id.toLowerCase().contains(key.toLowerCase()) ;
    }

}
