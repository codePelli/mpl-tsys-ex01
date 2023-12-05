package ejercicios.service;

import java.util.List;

import ejercicios.dto.Party;

public interface IPartyService {
	
    Party createParty(Long userId, Long videoGameId, String partyName);

    List<Party> searchParties(Long videoGameId);

    void joinParty(Long userId, Long partyId);

    void leaveParty(Long userId, Long partyId);
}
