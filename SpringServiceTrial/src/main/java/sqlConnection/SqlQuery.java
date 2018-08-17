package sqlConnection;

public class SqlQuery {
	public static String insertInto="insert into user(userid,password) values(?,?);";
	public static String getUser="select * from user where userid=? and password=?;";

}
