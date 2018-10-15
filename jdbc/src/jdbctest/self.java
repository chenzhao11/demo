package jdbctest;

import org.junit.Test;

import com.mysql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.lang.*;
import java.sql.*;

public class self {
	private static String  url ="jdbc:mysql://localhost:3308/test2";

	private static String  classname ="com.mysql.jdbc.Driver";
	private  static String  user ="root";

	private  static String  password ="zc19970919";//static块里面的必须是static
	static java.sql.Connection connection=null;
	static {
		try {
			Class.forName(classname);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		      connection=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
    	
	}

	@Test
    public void query () throws SQLException {
		String sql="select * from stu";
    	//sql.jdbc的preparedstatement    qiubie??
    	PreparedStatement prepared= (PreparedStatement) connection.prepareStatement(sql);
    	ResultSet set=prepared.executeQuery();
    	while(set.next()) {
    	String id=set.getString(1);
    	String name=set.getString(2);
    	String gender=set.getString(3);
    	
    	System.out.println(id+"   " +name+"   "+ gender+"   ");
    
    	}
    	System.out.println("==================================");
    }
	@Test
     public void insert() {
	
	    java.sql.PreparedStatement prepared;
    	 String sql="insert into stu values(?,?,?)";
    	 try {
    		 prepared=connection.prepareStatement(sql);
    		 prepared.setInt(1, 3);
    		 prepared.setString(2, "disan");
    		 prepared.setString(3, "l");
    		 prepared.executeUpdate();
    		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println("==============插入成功");
    	try {
			query();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
     }
	@Test
	public void delete() throws SQLException {
		String sql ="delete from stu where id=?";
		PreparedStatement pred=(PreparedStatement) connection.prepareStatement(sql);
		pred.setInt(1, 3);
		pred.execute();
		System.out.println("=================");
		query();
	}
	@Test
	public void change() throws SQLException {
		String sql="update stu set sname=? where id=?";
		PreparedStatement pred=(PreparedStatement) connection.prepareStatement(sql);
		pred.setString(1, "xiugaiguohou");
		pred.setInt(2, 1);
		pred.executeUpdate();
				
	}
}

