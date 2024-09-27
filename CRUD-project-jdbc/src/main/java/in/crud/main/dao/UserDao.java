package in.crud.main.dao;

import java.io.ObjectInputFilter.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.crud.main.models.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
//	--------------DATA INSERTION-----------------------------------
	public Boolean insertUser(User user) {
		Boolean status = false;
		try {
			String INSERT_SQL = "INSERT INTO users(name, userId, password, email) VALUES(?,?,?,?)";
			int count = jdbcTemplate.update(INSERT_SQL, user.getName(), user.getUserId(), user.getPassword(), user.getEmail());
		if(count > 0) {
			status = true;
		}else {
			status = false;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

}
