package com.model.managment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.model.data.Book;
import com.model.data.Customer;
import com.model.data.Order;

public class OrderList {
	
	static volatile List<Order> orders;
        ListFile file;

//    public OrderList(String str){
//        this.orders = new ArrayList<>();
//        orders.add(new Order("1636358981111","1636358989057", "2", 5555));
//        orders.add(new Order("1636358982222","1636358989057", "1", 5555));
//        file = new ListFile("Orders");
//        file.saveAndClose(orders);
//    }
     
    public OrderList() {
      try {                                            // by default is getting listFile of Order
          file = new ListFile<Order>("Orders");
          orders = file.openAndFitch();
      } catch(Exception I){
          System.out.println(I.getMessage());
      }
    }
    
    public void add(Order Order) {
   	 orders.add(Order);
        save();
    }
    public List<Order> getOrders(){
        return orders;
    }

    void fitchFromFile(){
        orders = file.openAndFitch();
    }

    void save() {
        file.saveAndClose(orders);
    }
}
