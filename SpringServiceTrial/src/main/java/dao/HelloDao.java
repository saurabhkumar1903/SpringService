package dao;

import java.util.List;

import dto.User;

public interface HelloDao {
	
	public int insertinto(String userid,String password);
	public List<User> finduser(String userid,String password);

}
