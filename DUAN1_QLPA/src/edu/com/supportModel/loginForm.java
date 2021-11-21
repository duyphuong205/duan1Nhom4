package edu.com.supportModel;

public class loginForm {
  String id;
  String password;
  boolean remember;
  public loginForm() {

}
public loginForm(String id, String password, boolean remember) {
	super();
	this.id = id;
	this.password = password;
	this.remember = remember;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isRemember() {
	return remember;
}
public void setRemember(boolean remember) {
	this.remember = remember;
}

  
}
