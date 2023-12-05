package ejercicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejercicios.dao.VideogameDAO;
import ejercicios.dto.Videogame;

@Service
public class IVideogameServiceImpl implements IVideogameService{

    @Autowired
    VideogameDAO videogameDAO;
    
	@Override
	public Videogame getVideoGameById(Long id) {
		// TODO Auto-generated method stub
        return videogameDAO.findById(id).orElse(null);
	}

}
