package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Repository;

import dto.*;
import sqlConnection.SqlQuery;
import sqlConnection.DataBaseConnection;

@Repository
public class HelloDaoImpl implements HelloDao {

	@Autowired
	private DataBaseConnection dataBaseConnection;

	private JdbcTemplate jdbcTemplate;

	public DataBaseConnection getBaseConnection() {
		return dataBaseConnection;
	}

	public void setBaseConnection(DataBaseConnection baseConnection) {
		this.dataBaseConnection = baseConnection;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public HelloDaoImpl(DataBaseConnection dataBaseConnection) {
		this.dataBaseConnection = dataBaseConnection;
		jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(this.dataBaseConnection.getConn(), false));
	}

	public HelloDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int insertinto(String userid, String password) {

		return jdbcTemplate.update(SqlQuery.insertInto, new Object[] { userid, password });
	}

	public List<User> finduser(String userid, String password) {
		// TODO Auto-generated method stub
		//return jdbcTemplate.query(SqlQuery.getUser, new BeanPropertyRowMapper<User>(User.class));
		return jdbcTemplate.query(SqlQuery.getUser,new Object[] { userid, password }, new RowMapper<User>() {

			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				String userid=arg0.getString("userid");
				String password=arg0.getString("password");
				return new User(userid, password);
			}
		});
	
	}

}