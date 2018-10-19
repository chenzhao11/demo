package TXqueryrunner;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;


public class TXqueryrunner extends QueryRunner {

	public TXqueryrunner() {
		// TODO Auto-generated constructor stub
	}

	public TXqueryrunner(boolean pmdKnownBroken) {
		super(pmdKnownBroken);
		// TODO Auto-generated constructor stub
	}

	public TXqueryrunner(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	public TXqueryrunner(DataSource ds, boolean pmdKnownBroken) {
		super(ds, pmdKnownBroken);
		// TODO Auto-generated constructor stub
	}



	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		java.sql.Connection co= jdbcutils.returnconnection();
		T t= super.query(co,sql,rsh ,param);
		jdbcutils.release((Connection) co);
		return t;
	}

	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		Connection co=(Connection) jdbcutils.returnconnection();
		T t= super.query(co,sql,rsh, params);
		jdbcutils.release(co);
		return t;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection co=(Connection) jdbcutils.returnconnection();
		T t= super.query(co,sql, rsh, params);
		jdbcutils.release(co);
		return t;

	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection co=(Connection) jdbcutils.returnconnection();
		T t= super.query(co,sql, rsh);
		jdbcutils.release(co);
		return t;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection co=(Connection) jdbcutils.returnconnection();
	    int i= super.update(sql);
		jdbcutils.release(co);
		return i;
		
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection co=(Connection) jdbcutils.returnconnection();
	    int i=super.update(co,sql, param);
		jdbcutils.release(co);
		return i;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection co=(Connection) jdbcutils.returnconnection();
		int i=super.update(co,sql, params);
		jdbcutils.release(co);
		return i;
		
		
	}
	

}
