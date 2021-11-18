package com.controller;

import com.model.data.Book;
import com.model.data.Customer;
import com.model.data.Order;
import com.model.managment.BookList;
import com.model.managment.CustomerList;
import com.model.managment.OrderList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class ServerSideSocket {

    Socket clientSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;

    OrderList orders ;
    BookList books;
    CustomerList customers;
    Customer remoteCustomer = null;

    public ServerSideSocket(){
        orders = new OrderList();
        customers = new CustomerList();
        books = new BookList();
    }

    public void connection() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        Socket clientSocket = null;
        while(true) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                System.out.println("stream not build ");
            }

            out.println("Welcome to Book Store ");
            sentAllBook();
            String inputLine = "";
            choices();
            try {
                while ((inputLine = in.readLine()) != null) {

                    switch (inputLine.substring(0, 1)) {
                        case "0":
                            sentAllBook();
                            break;
                        case "1":
                            setOrder();
                            break;
                        case "2":
                            getClientOrderInLastSession();
                            break;
                        case "3":
                            getClientOrdersInToday();
                            break;
                        case "4":
                            loginClient();
                            break;
                        case "5":
                            out.close();
                            in.close();
                            clientSocket.close();
                    }
                    choices();
                }
            } catch (Exception e) {
            }
        }
    } // fun

    private void choices() {
        out.println("type : \n  |  0 to display book ");
        out.println("  |  1 to buy book");
        out.println("  |  2 to get what you buy in this session");
        out.println("  |  3 to get what you buy in this day");
        out.println("  |  4 to login");
        out.println("1");
    }

    public void loginClient(){
        boolean ValidlogIn = false;
        while (!ValidlogIn) {           // loop tell get valid email
            out.println("Start Login : ");
            out.println("Email :");
            out.println("1");    // sent 1 as port for prompt client to input
            String customerEmail = "";
            String customerPassword = "";
            try {
                customerEmail = in.readLine();
                out.println("password :");
                out.println("1");
                customerPassword = in.readLine();
            } catch (Exception e) {
                System.out.println("not able to fetch custoner athorize");
            }
            Customer client = customers.getByEmailAndPassword(customerEmail, customerPassword);
            if (client == null) {
                out.println("Invalid Login");
            } else {
                out.println("Valid Login");
                remoteCustomer = client;
                ValidlogIn = true;
            } // if else
        } // while
    } // fun

    private void getClientOrdersInToday() {
        Date today = new Date();
        for(Order order : orders.getOrders()){
            if(order.getOrderDate().equals(today) && Long.parseLong(order.getCustomer()) == remoteCustomer.getId()){
                Book book = books.getById(Integer.parseInt(order.getBook()));
                out.println(book.getId() + " " + book.getTitle() + " " + book.getAuther() + " " + order.getNumber() + " session: " + order.getSession() + " date: " + order.getOrderDate());
            } // if
        } // foreach
    } // fun
    private void getClientOrderInLastSession() {
        for(Order order : orders.getOrders()){
            if(order.getSession() == clientSocket.getPort()){
                Book book = books.getById(Integer.parseInt(order.getBook()));
                out.println(book.getId() + " " + book.getTitle() + " " + book.getAuther() + " " + order.getNumber() + " session: " + order.getSession() + " date: " + order.getOrderDate());
            } // if
        } // foreach
    } // fun

    private void setOrder() {
        String bookId = "";
        String bookNumber = "";
        if(remoteCustomer == null){
            out.println("login first for continue perchuseing: ");
            loginClient();
        }
        try {
            out.println("  |  book Id: ");
            out.println("1");                     // sent 1 as port for prompt client to input
            bookId = in.readLine();
            out.println("  |  book number: ");
            out.println("1");
            bookNumber = in.readLine();
            int session = clientSocket.getPort();
            System.out.println(bookNumber);
            orders.add(new Order(""+remoteCustomer.getId(), bookId, bookNumber, session));
        } catch (Exception e) {
            System.out.println(e.getMessage() + " error while Ordering in setOrder function");
        }
        updateBookNumber(bookId, bookNumber);

    }

    private void updateBookNumber(String id, String number){
        Book book =  books.getById(Long.parseLong(id));
        int numOfBookLeft = book.getnumber() - Integer.parseInt(number);
        if(numOfBookLeft < 0){
            out.println("  we don't have this amount of books of "+ book.getTitle()+" we have : "+book.getnumber());
            numOfBookLeft = book.getnumber();
        }
        String num = ""+numOfBookLeft;
        book.setnumber(num);
    }

    public void sentAllBook(){
        List<Book> bookList = books.getBooks();
        String bookInfo;
        for(Book t : bookList) {
            bookInfo = String.format("|id: %-20d|title: %-30s |author: %-25s |number: %-10s |type: %-25s |price: %-20s \n",
                    t.getId(),
                    t.getTitle(),
                    t.getAuther(),
                    t.getnumber(),
                    t.getBooktype(),
                    t.getprice());
            out.print(bookInfo);
        }
    }


}







