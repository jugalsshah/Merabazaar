package com.learnlogic.ecommerce.merabazar.database.dao;

import java.util.List;

import com.learnlogic.ecommerce.merabazar.model.Users;

public interface UserDao {
	
	public void createUser(Users users);
	public void updateUser(Users users);
	public List<Users> retriveAll();
	public List<Users> retriveById(Users user);
	

}
