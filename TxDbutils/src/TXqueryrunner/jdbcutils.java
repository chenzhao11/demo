package TXqueryrunner;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class jdbcutils {

	private static DataSource data=new ComboPooledDataSource();
	private static ThreadLocal<Connection> con=new ThreadLocal<Connection>();
	public DataSource getdatasource() {
		return data;

	}
	public static Connection returnconnection() {
	     Connection c=con.get();
		if(c==null) {
			try {
				return data.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
		}
	  return con.get();

	}
	public static void commit() throws SQLException {
		if (con.get()==null) {
			throw new RuntimeException("你还没有开启事务！！");
		}
		con.get().commit();
		con.get().close();
		con.remove();

	}
	public static void rollback() throws SQLException {
		if (con.get()==null) {
			throw new RuntimeException("你还没有开启事务！！");
		}
		con.get().rollback();
		con.get().close();
		con.remove();

	}
	public static void starttransaction() throws SQLException {
		if (con.get()!=null) {
			throw new RuntimeException("你已经开启事务！！");
		}
		Connection con1=(Connection) data.getConnection();
		con1.setAutoCommit(false);
		con.set(con1);

	}
	public static void release(Connection con2) throws SQLException {
		if (con2!=con.get()&&con2!=null) {
			con2.close();
			
		}
		

	}

}
