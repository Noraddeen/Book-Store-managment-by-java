package com.model.managment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.model.data.Book;
import com.model.data.Customer;
import com.model.data.Order;

public abstract class OrderList {
	
	List<Order> orders;
    ListFile file;

    OrderList(Customer customer, Book book){
        this.orders = new ArrayList<>();
      //  orders.add(new Order(customer, book, number));
    }
     
    OrderList() throws IOException{                // by default is getting listFile of Order
   	  file = new ListFile<Order>("Orders");
   	  orders = file.openAndFitch();
    }
    
    void add(Order Order) {
   	 orders.add(Order);
    }

    void fitchFromFile(){
        orders = file.openAndFitch();
    }

    void save() throws IOException {
        file.saveAndClose(orders);
    }
}
