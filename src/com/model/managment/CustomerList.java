package com.model.managment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import com.model.data.Customer;

public class CustomerList {
	
	private List<Customer> customers;
    IntListFile file;
    public CustomerList(String str) throws Exception {
        customers = new ArrayList<Customer>();
        customers.add(new Customer("Ahmed","Hawler shikhla C111","0750 2368 829","ahmedSakvan22@gmail.com","qwert12345"));
        customers.add(new Customer("Joan","Hawler shikhla C112","0751 3623 829","JoanAziz11@gmail.com","qwert12345"));
        customers.add(new Customer("Aras","Hawler bakhtiari B001","0750 1268 829","ArasFroad12@gmail.com","qwert12345"));
        customers.add(new Customer("Bhram","Hawler kasnazan A023","0750 2368 829","JihanNawroz98@gmail.com","asdfg12345"));
        customers.add(new Customer("Shram","Sulimania Halabja F091","0751 2368 829","ShramJalal12@gmail.com","asdfg12345"));
        customers.add(new Customer("Afrin","Dhuk Gondi D093","0771 2368 999","AfrinGoan123@gmail.com","asdfg12345"));
        customers.add(new Customer("sara","Dhuk Masakn Dorai","0782 2368 666","SaraSakvan09@gmail.com","asdfg12345"));
    }

   public CustomerList() throws IOException{                // by default is getting listFile of Customer
      file = new ListFile<Customer>("Customers");
      customers = file.openAndFitch();
    }
        
    void add(Customer Customer) {
        customers.add(Customer);
    }

    void fitchFromFile(){
        customers = file.openAndFitch();
    }
    void save() throws IOException {
        file.saveAndClose(customers);
    }
    public List<Customer> getAllCustomers(){
        return customers;
    }

    public void removeById(int Id){



    }

}

