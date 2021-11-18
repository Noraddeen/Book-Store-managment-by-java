package com.model.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;


public  abstract class IdModifier implements Serializable{
	
	long Id;
	static Random rand = new Random();

	public long getId() {
		return Id;
	}

	protected void setId() {
	    int range = 1000000;     //adding random between 0 to million to millisecon becouse of setuation assign to id in the same millisecond
		Id = new Date().getTime()+ rand.nextInt(range);
	}

}
