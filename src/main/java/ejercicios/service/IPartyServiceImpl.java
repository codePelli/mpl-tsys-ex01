package ejercicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejercicios.dao.PartyDAO;
import ejercicios.dao.UserDAO;
import ejercicios.dao.VideogameDAO;
import ejercicios.dto.*;

@Service
public class IPartyServiceImpl implements IPartyService{
	
    @Autowired
    private PartyDAO partyDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private VideogameDAO videogameDAO;

	@Override
	public Party createParty(Long userId, Long videogameId, String partyName) {
		// TODO Auto-generated method stub
		
		Optional<User> user = userDAO.findById(userId);
		Optional<Videogame> videogame = videogameDAO.findById(videogameId);
		
		Party party = new Party();
		//party.setCreator(userId);
		//party.setVideoGame(videogame);
		party.setPartyName(partyName);
		
		return partyDAO.save(party);
	}

	@Override
	public List<Party> searchParties(Long videogameId) {
		// TODO Auto-generated method stub
		return partyDAO.findAll();
	}

	@Override
	public void joinParty(Long userId, Long partyId) {
		// TODO Auto-generated method stub
        Optional<User> userOptional = userDAO.findById(userId);
        Optional<Party> partyOptional = partyDAO.findById(partyId);

    }

	@Override
	public void leaveParty(Long userId, Long partyId) {
		// TODO Auto-generated method stub
		
	}

}
