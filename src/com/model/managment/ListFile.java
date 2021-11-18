package com.model.managment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class ListFile<Type> implements IntListFile {
	
	String path;
	Type obj;

	ListFile(String path){
		this.setPath(path);
	}


	public List<Type> openAndFitch() {
		List<Type> list = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(getPath());
			ObjectInputStream get = new ObjectInputStream(file);
			list = (List<Type>)get.readObject();

			file.close();
			get.close();
		} catch (FileNotFoundException e) {
			System.out.println("the path "+ path+ " not found ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Error initializing stream with path: "+path);
		}
		return list;
	}

	public boolean saveAndClose(List items){
		try{
			FileOutputStream file = new FileOutputStream(getPath());
			ObjectOutputStream to = new ObjectOutputStream(file);
			to.writeObject(items);
			to.close();
			file.close();
		} catch (FileNotFoundException e){
			System.out.println("the path "+ path+ " not found ");
			return false;
		} catch (IOException e){
			System.out.println("Error initializing stream with path: "+path);
			return false;
		}
		return true;
	}

		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = "E:/New2/book-Store-managment-by-java/src/com/files/"+path+".txt";
		}
		
		

}
