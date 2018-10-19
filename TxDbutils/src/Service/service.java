package Service;

import java.sql.SQLException;

import org.junit.Test;

import Dao.Studao;
import Domain.Stu;

public class service {
	@Test
	public void test() throws SQLException {
		Stu st=Studao.query("hh");
		System.out.println(st);
		Studao.add(100,"hh","disan" );
	}

}
