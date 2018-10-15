package jdbctest;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

public class Dbutilstest {
@Test
	public void query() throws SQLException {
//	通过获取connection
//	QueryRunner qr=new QueryRunner();
//	String sql="select * from stu where id=?";
//	BeanHandler bean=new BeanHandler(User.class);
//	User user=qr.query(c3p0utils.getconnection(),sql,bean,1);
//	System.out.println(user);
//通过获取DataSource
	QueryRunner qr=new QueryRunner(c3p0utils.getdatasource());
	String sql="select * from stu where id=?";
	BeanHandler bean= new BeanHandler(User.class);
	User user =qr.query(sql, bean,1);
	System.out.println(user);
	}
}
