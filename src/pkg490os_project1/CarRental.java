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
public class CarRental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LinkedList<Customer> customers = new LinkedList<>();
        customers.add(new Customer("Samir James","6102 NE Antioch RD","816-878-1111"));
        customers.add(new Customer("Kim Sam","7123 Main Street","816-847-8888"));
        customers.add(new Customer("Mehmet Scholl","12 Rockhill Rd","816-444-2378"));
        CustomerList mainForm = new CustomerList(customers);
        mainForm.setVisible(true);
    }
    
}
