package sqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	private String driverName;
	private String url;;
	private String user;
	private String password;
	private Connection conn;
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public DataBaseConnection(String driverName, String url, String user, String password) throws ClassNotFoundException, SQLException {
		super();
		this.driverName = driverName;
		this.url = url;
		this.user = user;
		this.password = password;
		
		Class.forName(driverName);
		this.conn=DriverManager.getConnection(url, user, password);
	}
	
	public DataBaseConnection() {
		super();
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
