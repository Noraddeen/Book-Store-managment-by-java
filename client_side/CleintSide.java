package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CleintSide {
    public static void main(String [] args) throws IOException {

          Socket echoSocket = null;
          PrintWriter out = null;
          BufferedReader in = null;
          try {

              echoSocket = new Socket("127.0.0.1", 4444);
              out = new PrintWriter(echoSocket.getOutputStream(), true);
              in=new BufferedReader(new InputStreamReader(echoSocket. getInputStream()));
          } catch (UnknownHostException e) {
              System.err.println("Don't know host: .");
              System.exit(1);
          } catch (IOException e) {
              System.err.println("Couldn't get I/O for ");
              System.exit(1);
          }
          Scanner inputFromKeyport = new Scanner(System.in);
          String userInput;


          try {
              while ((userInput = in.readLine()) != null) {
                  boolean isServerAskForInput = userInput.equals("1");
                  if (isServerAskForInput) {    // 1 if send then is ask for input from client
                      System.out.print("input here: ");
                      out.println(inputFromKeyport.nextLine());
                  }
                  System.out.println("echo: " + (isServerAskForInput ? "input done" : userInput));
              }
          }catch (StringIndexOutOfBoundsException e){
              System.out.println("size of string from server is 0, "+ e.getMessage());
          }

          try {
              out.close();
              in.close();
              //stdIn.close();
              echoSocket.close();
          }catch (Exception e){
              System.out.println(e.getMessage());
          }
    }
}

//      System.out.println("echo: " + ((userInput.substring(0,1).equals("1"))?"input :":userInput));
