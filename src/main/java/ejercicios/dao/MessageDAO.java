package ejercicios.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ejercicios.dto.Message;

public interface MessageDAO extends JpaRepository<Message, Long> {
}
