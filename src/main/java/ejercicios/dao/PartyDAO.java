package ejercicios.dao;
import ejercicios.dto.Party;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyDAO extends JpaRepository<Party, Long> {
}