package com.learnlogic.ecommerce.merabazar.database.daoImpl;

import java.util.List;


import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;






import com.learnlogic.ecommerce.merabazar.database.dao.UserDao;
import com.learnlogic.ecommerce.merabazar.model.Users;


@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

//	sssss
	public void createUser(Users users) {
		// TODO Auto-generated method stub
	  getHibernateTemplate().save(users);;
	}

	public void updateUser(Users users) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(users);;
	}

	public List<Users> retriveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Users> retriveById(Users user) {
		// TODO Auto-generated method stub
	 List<Users> list = (List<Users>) getHibernateTemplate().find(
                "from Users where userId=?",user
          );
	return (List<Users>)list.get(0);
	}

}
