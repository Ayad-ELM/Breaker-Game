package com.ump.ensao;

public class Break {

	private boolean active;
	private int xcor,ycour;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getXcor() {
		return xcor;
	}
	public void setXcor(int xcor) {
		this.xcor = xcor;
	}
	public int getYcour() {
		return ycour;
	}
	public void setYcour(int ycour) {
		this.ycour = ycour;
	}
	public Break(boolean active, int xcor, int ycour) {
		this.active = active;
		this.xcor = xcor;
		this.ycour = ycour;
	}
	
}
