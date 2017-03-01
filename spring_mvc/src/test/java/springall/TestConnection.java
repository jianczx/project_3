package springall;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Person;
import com.yc.dao.BaseDao;

import junit.framework.TestCase;

public class TestConnection extends TestCase {
	@Test
	public void testDataSourse() throws SQLException{
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		assertNotNull(ac.getBean("dataSource"));
		DataSource ds=(DataSource) ac.getBean("dataSource");
		
		Connection con=ds.getConnection();
		System.out.println( con );
	}
	
	@Test
	public void testsqlSessionFactory() throws SQLException{
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		assertNotNull(ac.getBean("sqlSessionFactory"));
		SqlSessionFactory ds=(SqlSessionFactory) ac.getBean("sqlSessionFactory");
	
		System.out.println( ds );
	}
	
	@Test
	public void testPersonDaoMybatisImpl() throws SQLException{
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		assertNotNull(ac.getBean("personDaoMyBatisImpl"));
		System.out.println( ac.getBean("personDaoMyBatisImpl"));
		
		BaseDao<Person> pd=(BaseDao<Person>)ac.getBean("personDaoMyBatisImpl");
		List<Person> list=pd.findAll(new Person(), "findAll");
		for(Person p:list){
			System.out.println(  p );
		}
	}
	
	@Test
	public void testPage() throws SQLException{
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		assertNotNull(ac.getBean("personDaoMyBatisImpl"));
		System.out.println( ac.getBean("personDaoMyBatisImpl"));
		
		BaseDao<Person> pd=(BaseDao<Person>)ac.getBean("personDaoMyBatisImpl");
		
		Person p=new Person();
		Map<String,Integer> map=new HashMap<String,Integer> ();
		map.put("start", 0);
		map.put("start", 5);
		
		List<Person> list=pd.findAll(p,map, "findbypage");
		for(Person p1:list){
			System.out.println(  p1 );
		}
	}
	
}
