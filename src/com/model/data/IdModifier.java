package com.model.data;

public  abstract class IdModifier implements  Serializable{
	
	int Id;

	protected int getId() {
		return Id;
	}

	protected void setId(int id) {
		Id = id;
	}

}