package com.project.Bean;

public class Tender {

	private int tid;
	private String tname;
	private String type;
	private int price;
	private String deadline;
	private String location;
	public Tender() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tender(int tid, String tname, String type, int price, String deadline, String location) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.type = type;
		this.price = price;
		this.deadline = deadline;
		this.location = location;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Tender [tid=" + tid + ", tname=" + tname + ", type=" + type + ", price=" + price + ", deadline="
				+ deadline + ", location=" + location + "]";
	}
	
	
}
