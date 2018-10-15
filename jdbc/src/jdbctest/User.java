package jdbctest;

public class User {
	//BeanHandler  列的名字必须与属性名字相同
	private String sname;
	private int id;
	private String gender;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [sname=" + sname + ", id=" + id + ", gender=" + gender + "]";
	}
	
}
