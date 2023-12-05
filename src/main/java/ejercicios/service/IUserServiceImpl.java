package ejercicios.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ejercicios.dao.UserDAO;
import ejercicios.dto.User;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    UserDAO userDAO;

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	@Override
	public User userPerId(Long id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id).get();
	}
}
