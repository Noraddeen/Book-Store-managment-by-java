package com.model.data.managment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.model.data.Book;

public class ListFile<Type> {
	
	String path ;
	Type obj ;
	
	FileOutputStream outputStream;
	ObjectOutputStream put ;
	
	List<Type> previousList;
       
	ListFile(String path){
		
	    	setPath(path);	
	}    
	
	
		List<Type> open() throws IOException{
			
			List<Type> list =new ArrayList<Type>();
			
		try {
			FileInputStream file = new FileInputStream(new File(getPath()));
			ObjectInputStream get = new ObjectInputStream(file);
			obj = (Type)get.readObject();
			
			while(obj != null) {
				list.add(obj);
				obj = (Type)get.readObject();
			}
			
			get.close();
			file.close();
            
			//open and be ready for output
			outputStream = new FileOutputStream(new File(getPath()));
			put = new ObjectOutputStream(outputStream);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		addPreviousList(list);
		return list;
		    
	}
		
		void add(Type obj){		
		try {
			
			put.writeObject(obj);
			
			}catch (IOException e) {
				System.out.println("Error initializing stream");
			}
	    }


		private void addPreviousList(List<Type> list) throws IOException {
			
			ListIterator iterator = list.listIterator();
			while(iterator.hasNext()) {
				put.writeObject(iterator.next());
			}	
		}
		void close(){
			
		    try {
				
				 outputStream.close();
				 put.close() ;
				 
			}catch (IOException e) {
				System.out.println("Error initializing stream");
			}
			
		}


		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		
		

}
