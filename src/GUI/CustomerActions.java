/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import pkg490os_project1.Container;
import pkg490os_project1.Controller;
import pkg490os_project1.Customer;
import pkg490os_project1.Rental;

/**
 *
 * @author Joshua
 */
public class CustomerActions extends javax.swing.JFrame {

    Class[] newCarsTypes = new Class[]{java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};
    String[] findCarsColumns = {"Select", "ID", "Make", "Model", "Year", "Size"};
    String[] rentedCarsColumns = {"Select", "ID", "Make", "Model", "Year", "Rented"};
    String[] returnedCarsColumns = {"ID", "Make", "Model", "Year", "Rented", "Returned"};
    String customerID;
    Controller controller;
    LinkedList<String> selectedRentals;
    LinkedList<String> selectedReturns;

    ;
    /**
     * Creates new form CustomerActions
     */
    public CustomerActions(Controller controller, String customerID) {
        selectedRentals = new LinkedList<String>();
        selectedReturns = new LinkedList<String>();
        EventHandler eh = new EventHandler();
        this.controller=controller;
        this.customerID=customerID;
        initComponents();
        updateFindTable();
        updateRentedTable();
        updateReturnedTable();
        frameLbl.setText(controller.getCustomerName(customerID) + "'s Account");
        searchBtn.addActionListener(eh);
        rentBtn.addActionListener(eh);
        returnBtn.addActionListener(eh);
        findCarsTbl.getSelectionModel().addListSelectionListener(eh);
        rentedCarsTbl.getSelectionModel().addListSelectionListener(eh);
    }

//    private String[][] getRentalsAsArray(Collection<Rental> rentals) {
//        String[][] result = new String[rentals.size()][6];
//        int i = 0;
//        for (Iterator iterator = rentals.iterator(); iterator.hasNext();) {
//            Rental rent = (Rental) iterator.next();
//            result[i] = rent.to_array();
//            System.out.print(result[i]);
//            i++;
//        }
//        return result;
//    }
    class EventHandler implements ActionListener, ListSelectionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == searchBtn) {
                updateFindTable();
            } else if (e.getSource() == rentBtn) {
                if (selectedRentals.size() > 0) {
                    for (String rental : selectedRentals) {
                        controller.rentCar(customerID, rental, Calendar.getInstance());
                    }
                }
                updateFindTable();
                updateRentedTable();
            } else if (e.getSource() == returnBtn) {
                if (selectedReturns.size() > 0) {
                    for (String rental : selectedReturns) {
                        controller.returnCar(rental, Calendar.getInstance());
                    }
                }
                updateReturnedTable();
                updateRentedTable();
                updateFindTable();
            }
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {

            int row = findCarsTbl.getSelectedRow();
            int col = findCarsTbl.getSelectedColumn();
            if (row >= 0 && col == 0) { //the user selected the checkbox (it is at column 0)
                boolean value = (boolean) findCarsTbl.getValueAt(row, 0);
                String product_ID = (String) findCarsTbl.getValueAt(row, 1); //we just need the product ID
                if (value) {
                    selectedRentals.add(product_ID);
                } else {
                    selectedRentals.remove(product_ID);
                }
            }
            int row1 = rentedCarsTbl.getSelectedRow();
            int col1 = rentedCarsTbl.getSelectedColumn();
            if (row1 >= 0 && col1 == 0) { //the user selected the checkbox (it is at column 0)
                boolean value = (boolean) rentedCarsTbl.getValueAt(row1, 0);
                String product_ID = (String) rentedCarsTbl.getValueAt(row1, 1); //we just need the product ID
                if (value) {
                    selectedReturns.add(product_ID);
                } else {
                    selectedReturns.remove(product_ID);
                }
            }
        }
    }    
    private void updateFindTable(){
        Object[][] rentals = controller.findRentals(search_field.getText());
        DefaultTableModel model = new DefaultTableModel(rentals, findCarsColumns){
            Class[] types = newCarsTypes;
            
            @Override
            public Class getColumnClass(int columnIndex){
                return types[columnIndex];
            }
        };
        findCarsTbl.setModel(model);
        selectedRentals=new LinkedList<String>();
    }
    private void updateRentedTable() {
        Object[][] rentals = controller.findRented(customerID);
        DefaultTableModel model = new DefaultTableModel(rentals, rentedCarsColumns) {
            Class[] types = newCarsTypes;

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        rentedCarsTbl.setModel(model);
        selectedRentals = new LinkedList<String>();
    }

    private void updateReturnedTable() {
        Object[][] rentals = controller.findReturned(customerID);
        this.returnedCarsTbl.setModel(new DefaultTableModel(rentals, returnedCarsColumns));
    }

//    private void updateTable() {
//        String[][] rowData = getRentalsAsArray(rentals.contains(search_field.getText().trim()));
//        String[] columns = {"Select", "ID", "Make", "Model", "Year", "Size"};
//        rentalsTbl.setModel(new javax.swing.table.DefaultTableModel(rowData, columns));
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        search_field = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        rentBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        findCarsTbl = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        returnBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        rentedCarsTbl = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        returnedCarsTbl = new javax.swing.JTable();
        frameLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        rentBtn.setText("Rent Selected");

        findCarsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Select", "ID", "Make", "Model", "Year", "Size"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(findCarsTbl);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBtn))
                            .addComponent(rentBtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addGap(18, 18, 18)
                .addComponent(rentBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Find Car", jPanel1);

        returnBtn.setText("Return Selected");

        rentedCarsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Select", "Make", "Model", "Year", "Rented"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(rentedCarsTbl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(returnBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Rented Cars", jPanel2);

        returnedCarsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Make", "Model", "Year", "Rented", "Returned"
            }
        ));
        jScrollPane3.setViewportView(returnedCarsTbl);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Returned Cars", jPanel3);

        frameLbl.setText("'s Account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(frameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(frameLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

    }//GEN-LAST:event_searchBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable findCarsTbl;
    private javax.swing.JLabel frameLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton rentBtn;
    private javax.swing.JTable rentedCarsTbl;
    private javax.swing.JButton returnBtn;
    private javax.swing.JTable returnedCarsTbl;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField search_field;
    // End of variables declaration//GEN-END:variables
}
