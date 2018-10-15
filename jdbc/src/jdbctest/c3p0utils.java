package jdbctest;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0utils {
	private static ComboPooledDataSource ds=null;
	static {
		try {
		ds=new ComboPooledDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3308/test2");
		ds.setUser("root");
		ds.setPassword("zc19970919");
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setMaxPoolSize(50);
		  } 
		catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
	}
	
//要在其他的类里面直接通过类名.方法调用方法必须写成static的方法！！！
public static DataSource getdatasource() {
	return ds;
}
public static Connection getconnection() {

Connection connection=null;
try {
	connection = ds.getConnection();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return connection;

}
}
