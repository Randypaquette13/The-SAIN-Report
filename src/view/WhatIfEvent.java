package view;

import java.util.EventObject;

public class WhatIfEvent extends EventObject{

	String majorID;
	
	public WhatIfEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	public WhatIfEvent(Object source, String majorID) {
		super(source);
		this.majorID = majorID;
	}

	public String getMajorID() {
		return majorID;
	}
}
