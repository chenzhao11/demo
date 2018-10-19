package Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import Domain.Stu;
import TXqueryrunner.TXqueryrunner;
import TXqueryrunner.jdbcutils;

public class Studao {
	
 public static  Stu query(String name) throws SQLException {
	 Stu st=null;
	 String sql ="select * from stu where sname=?";
	 TXqueryrunner tx=new TXqueryrunner();
	 st=tx.query(sql, name, new BeanHandler<Stu>(Stu.class));
	return st;
	 	

}
 public static  void add (int big,String name1,String name2) throws SQLException {
	jdbcutils.starttransaction();
	String sql ="update stu set id=id+? where sname=?";
	String sql2 ="update stu set id=id-? where sname=?";
	new TXqueryrunner().update(sql, big,name1);
	new TXqueryrunner().update(sql2, big,name2);
	jdbcutils.commit();
	 	

}

}
