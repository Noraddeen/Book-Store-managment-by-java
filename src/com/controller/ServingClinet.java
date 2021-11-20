package com.controller;

import com.model.data.Book;
import com.model.data.Customer;
import com.model.data.Order;
import com.model.managment.BookList;
import com.model.managment.CustomerList;
import com.model.managment.OrderList;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class ServingClinet extends Thread{

            static OrderList orders ;
            static BookList books;
            static CustomerList customers;
            Customer remoteCustomer = null;

            Socket clientSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;

             ServingClinet(Socket clientSocket, PrintWriter out, BufferedReader in){
                 this.out = out;
                 this.in = in;
                 this.clientSocket = clientSocket;
                 orders = new OrderList();
                 customers = new CustomerList();
                 books = new BookList();
             }
             public void run(){

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

    private void choices() {
        out.println("services you choose : \n  |  0 to display book ");
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
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = sdformat.format(date);

        orders.getOrders().stream()
                .filter((order)->sdformat.format(order.getOrderDate()).equals(today))
                .filter((order)->Long.parseLong(order.getCustomer()) == remoteCustomer.getId())
                .forEach((order)->sendOrdersInfo(order));// foreach
    } // fun
            
    private void getClientOrderInLastSession() {
        orders.getOrders().stream()
                .filter((order)->order.getSession() == clientSocket.getPort())
                .filter((order)->Long.parseLong(order.getCustomer()) == remoteCustomer.getId())
                .forEach((order)->sendOrdersInfo(order));
    }

    private void sendOrdersInfo(Order order){
        Book book = books.getById(Long.parseLong(order.getBook()));
        out.println(" | title: "+ book.getTitle() + " | author: " + book.getAuther() + " | number: " + order.getNumber() + " |  session: " + order.getSession() + " | date: " + order.getOrderDate());
    }

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
            boolean haveEnoughBooks = updateBookNumber(bookId, bookNumber);
            if(!haveEnoughBooks){return;}
            int session = clientSocket.getPort();
            System.out.println(bookNumber);
            orders.add(new Order(""+remoteCustomer.getId(), bookId, bookNumber, session));
        } catch (Exception e) {
            System.out.println(e.getMessage() + " error while Ordering in setOrder function");
        }
    }

    private boolean updateBookNumber(String id, String number){
        boolean haveEnoughAmountOfBook = true;
        Book book =  books.getById(Long.parseLong(id));
        synchronized(this){
            int numOfBookLeft = book.getnumber() - Integer.parseInt(number);
            if (numOfBookLeft < 0) {
                out.println("  we don't have this amount of books of " + book.getTitle() + " we have : " + book.getnumber());
                numOfBookLeft = book.getnumber();
                haveEnoughAmountOfBook = false;
            }
            String num = "" + numOfBookLeft;
            book.setnumber(num);
        } // synchronized
        books.saveUpdate();
        return haveEnoughAmountOfBook;
    } // fun

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
