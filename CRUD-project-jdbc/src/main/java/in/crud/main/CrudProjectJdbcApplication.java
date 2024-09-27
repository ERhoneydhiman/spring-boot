package in.crud.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.crud.main.dao.UserDao;
import in.crud.main.models.User;

@SpringBootApplication
public class CrudProjectJdbcApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudProjectJdbcApplication.class, args);
		System.out.println("started...");
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User("honey", "hd101", "123", "hd@mail.com");
		Boolean status =  userDao.insertUser(user1);
		if(status) {
			System.out.println("done...");
		}else {
			System.out.println("not done...");
		}
		
	}

}
