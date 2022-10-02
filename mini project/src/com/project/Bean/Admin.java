package com.project.Bean;

public class Admin {

	private int aid;
	private String aname;
	private String admemail;
	private String admpassword;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int aid, String aname, String admemail, String admpassword) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.admemail = admemail;
		this.admpassword = admpassword;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAdmemail() {
		return admemail;
	}
	public void setAdmemail(String admemail) {
		this.admemail = admemail;
	}
	public String getAdmpassword() {
		return admpassword;
	}
	public void setAdmpassword(String admpassword) {
		this.admpassword = admpassword;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", admemail=" + admemail + ", admpassword=" + admpassword
				+ "]";
	}
	

}
