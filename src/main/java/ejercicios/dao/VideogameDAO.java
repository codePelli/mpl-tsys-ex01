package ejercicios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejercicios.dto.Videogame;

@Repository
public interface VideogameDAO extends JpaRepository<Videogame, Long> {
    Videogame findByGamename(String gamename);
}
