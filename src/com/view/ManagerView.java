package com.view;

import com.model.data.Manager;
import com.model.managment.ManagerList;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ManagerView {
    BookListView booksListView;
    CustomersListView customersListView;
    OrdersListView ordersListView ;
    public ManagerView(){
        booksListView = new BookListView();
        customersListView = new CustomersListView();
        ordersListView = new OrdersListView();
    }

    public void getManagerViews() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("\n portale to managing data windows. \n first login as data manager (admin)");
        boolean login= true;
        while(login){
            login = logIn();
        }
        System.out.println("\n  |  Manager Windows :");
        System.out.println("   |  1 : Books List managment window");
        System.out.println("   |  2 : Customers List managment window");
        System.out.println("   |  3 : Orders List managment window\n");
        System.out.print("   | input here window number : ");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice){
            case 1 :
                booksListView.showSteps();
                break;
            case 2 :
                customersListView.showSteps();
                break;
            case 3 :
                ordersListView.showSteps();
                break;
            default :
                System.out.println("no valid Chosen number :");
        }
    }

    private boolean logIn() throws IOException {
        AtomicBoolean authorise = new AtomicBoolean(false);
        ManagerList managers = new ManagerList();
        Scanner input = new Scanner(System.in);
        System.out.println("  |  --Log In-- ");

        System.out.print("  |  your Email :  ");
        String email = input.nextLine();

        System.out.print("  |  your Password :  ");
        String password = input.nextLine();

        Optional<Manager> manager = managers.getManagers()
                .stream()
                .filter((t)->t.getEmail().equals(email))
                .filter((t)->t.getPassWord().equals(password))
                .findFirst();
        if(manager.isPresent()){
            return false;
        }
        System.out.println("  |  not valid, be sure of email and password");
        return true;
    }

}
