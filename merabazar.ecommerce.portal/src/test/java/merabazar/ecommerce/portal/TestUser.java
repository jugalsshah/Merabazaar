package merabazar.ecommerce.portal;

import com.learnlogic.ecommerce.merabazar.database.daoImpl.UserDaoImpl;
import com.learnlogic.ecommerce.merabazar.model.Orders;
import com.learnlogic.ecommerce.merabazar.model.Users;

import junit.framework.TestCase;

public class TestUser extends TestCase {

	public void testCreateUser() {
	
			Users users = new Users();
			users.setOrders(new Orders());
			users.setUserAddress1("s");
			users.setUserAddress2("sss");
			users.setUserBillingaddress1("s");
			users.setUserBillingaddress2("sss");
			users.setUserCardType("mastercard");
			users.setUserCity("richardspon");
			users.setUserId(1L);
			users.setUserLname("shah");
			users.setUserFname("jugal");
			UserDaoImpl daoImpl= new UserDaoImpl();
			daoImpl.createUser(users);;
			
	}

	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	public void testRetriveAll() {
		fail("Not yet implemented");
	}

	public void testRetriveById() {
		fail("Not yet implemented");
	}

	public void testCheckDaoConfig() {
		fail("Not yet implemented");
	}

	public void testHibernateDaoSupport() {
		fail("Not yet implemented");
	}

	public void testSetSessionFactory() {
		fail("Not yet implemented");
	}

	public void testCreateHibernateTemplate() {
		fail("Not yet implemented");
	}

	public void testGetSessionFactory() {
		fail("Not yet implemented");
	}

	public void testSetHibernateTemplate() {
		fail("Not yet implemented");
	}

	public void testGetHibernateTemplate() {
		fail("Not yet implemented");
	}

	public void testCurrentSession() {
		fail("Not yet implemented");
	}

	public void testDaoSupport() {
		fail("Not yet implemented");
	}

	public void testAfterPropertiesSet() {
		fail("Not yet implemented");
	}

	public void testInitDao() {
		fail("Not yet implemented");
	}

	public void testObject() {
		fail("Not yet implemented");
	}

	public void testGetClass() {
		fail("Not yet implemented");
	}

	public void testHashCode() {
		fail("Not yet implemented");
	}

	public void testEquals() {
		fail("Not yet implemented");
	}

	public void testClone() {
		fail("Not yet implemented");
	}

	public void testToString() {
		fail("Not yet implemented");
	}

	public void testNotify() {
		fail("Not yet implemented");
	}

	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	public void testWaitLong() {
		fail("Not yet implemented");
	}

	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	public void testWait() {
		fail("Not yet implemented");
	}

	public void testFinalize() {
		fail("Not yet implemented");
	}

}
