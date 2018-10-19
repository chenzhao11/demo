package Domain;

public class Stu {
  private String sname=null;
  private String gender=null;
  int id=0;
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "Stu [sname=" + sname + ", gender=" + gender + ", id=" + id + "]";
}
  
}
