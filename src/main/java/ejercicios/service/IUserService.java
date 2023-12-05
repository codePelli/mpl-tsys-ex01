package ejercicios.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import ejercicios.dto.Message;
import ejercicios.dto.Party;
import ejercicios.dto.User;

public interface IUserService {
	
    List<User> getUsers();

    User registerUser(User user);

    User updateUser(User user);

    User userPerId(Long id);

}
