/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.CustomerList;
import java.util.Collection;
import pkg490os_project1.Car;
import pkg490os_project1.CarSpec;
import pkg490os_project1.Container;
import pkg490os_project1.Customer;
import pkg490os_project1.Rental;
import pkg490os_project1.Controller;

/**
 *
 * @author Joshua
 */
public class CarRental {
 static int id = 100;
 public static Container<String, Customer> customers = new Container<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Controller controller = new Controller();
        controller.addCustomer(Integer.toString(id++),"Samir James","6102 NE Antioch RD","816-878-1111");
        controller.addCustomer(Integer.toString(id++),"Kim Sam","7123 Main Street","816-847-8888");
        controller.addCustomer(Integer.toString(id++),"Mehmet Scholl","12 Rockhill Rd","816-444-2378");
        controller.addCustomer(Integer.toString(id++),"Mehmet Scholl","12 Rockhill Rd","816-444-2378");
        controller.addCarSpecs("000001", "Honda", "Civic", 2014, CarSpec.CarSize.COMPACT);
        controller.addCarSpecs("000002", "Toyota", "Corolla",2014, CarSpec.CarSize.MIDSIZE);
        controller.addCarSpecs("000003", "Honda", "Accord", 2014, CarSpec.CarSize.MIDSIZE);
        controller.addCar("0001", "000001");
        controller.addCar("0002", "000001");
        controller.addCar("0003", "000002");
        controller.addCar("0004", "000002");
        controller.addCar("0005", "000003");
        controller.addRental("0001");
        controller.addRental("0003");
        controller.addRental("0002");
        controller.addRental("0004");
        controller.addRental("0005");
                
//          Container<String, String, Rental> rentals = new Container<String,String,Rental>();
//       // customers.addElement("123", new Customer("123","Samir James","6102 NE Antioch RD","816-878-1111"));
//        //customers.addElement("124",new Customer("124","Kim Sam","7123 Main Street","816-847-8888"));
//        //customers.addElement("125",new Customer("125","Mehmet Scholl","12 Rockhill Rd","816-444-2378"));
//        
//        rentals.addElement("1", new Rental(new Car("5321",new CarSpec("Nissan","Altima",2012,CarSpec.CarSize.COMPACT))));
//        rentals.addElement("2", new Rental(new Car("4874",new CarSpec("Nissan","Altima",2012,CarSpec.CarSize.MIDSIZE))));
//        rentals.addElement("3", new Rental(new Car("1234",new CarSpec("Volks Wagen","Passat",2002,CarSpec.CarSize.FULLSIZE))));
//        rentals.addElement("4", new Rental(new Car("2222",new CarSpec("Hundai","Tiburon",2011,CarSpec.CarSize.MIDSIZE))));
//        
       
        CustomerList customer = new CustomerList(controller);
        customer. setVisible(true);
       
        
//        java.awt.EventQueue.invokeLater(new Runnable(){
//            public void run(){
//                CustomerList mainForm = new CustomerList(customers,rentals);
//                mainForm.setVisible(true);
//            }
//        });
//    }
//    public static void addCustomer(String name, String phone, String address){
//        
//        id++;
//        customers.addElement(Integer.toString(id), new Customer(Integer.toString(id), name, phone, address));
//           
//       }
    
    }}
