/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg490os_project1;

import java.util.Collection;

/**
 *
 * @author Joshua
 */
public class CarRental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Container<String, String, Customer> customers = new Container<>();
        Container<String, String, Rental> rentals = new Container<String,String,Rental>();
        customers.addElement("123", new Customer("123","Samir James","6102 NE Antioch RD","816-878-1111"));
        customers.addElement("124",new Customer("124","Kim Sam","7123 Main Street","816-847-8888"));
        customers.addElement("125",new Customer("125","Mehmet Scholl","12 Rockhill Rd","816-444-2378"));
        
        rentals.addElement("1", new Rental(new Car("5321",new CarSpec("Nissan","Altima",2012,CarSpec.CarSize.COMPACT))));
        rentals.addElement("2", new Rental(new Car("4874",new CarSpec("Nissan","Altima",2012,CarSpec.CarSize.MIDSIZE))));
        rentals.addElement("3", new Rental(new Car("1234",new CarSpec("Volks Wagen","Passat",2002,CarSpec.CarSize.FULLSIZE))));
        rentals.addElement("4", new Rental(new Car("2222",new CarSpec("Hundai","Tiburon",2011,CarSpec.CarSize.MIDSIZE))));
        
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                CustomerList mainForm = new CustomerList(customers,rentals);
                mainForm.setVisible(true);
            }
        });
    }
    
}
