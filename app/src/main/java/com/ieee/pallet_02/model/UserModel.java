package com.ieee.pallet_02.model;

public class UserModel{

	private String password;

	private int money;

	private String nickname;

	private String emailID;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setMoney(int money){
		this.money = money;
	}

	public int getMoney(){
		return money;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public String getNickname(){
		return nickname;
	}

	public void setEmailID(String emailID){
		this.emailID = emailID;
	}

	public String getEmailID(){
		return emailID;
	}

	@Override
 	public String toString(){
		return 
			"UserModel{" + 
			"password = '" + password + '\'' + 
			",money = '" + money + '\'' + 
			",nickname = '" + nickname + '\'' + 
			",emailID = '" + emailID + '\'' + 
			"}";
		}
}