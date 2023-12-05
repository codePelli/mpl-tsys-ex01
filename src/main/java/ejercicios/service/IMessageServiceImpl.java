package ejercicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejercicios.dao.MessageDAO;
import ejercicios.dao.PartyDAO;
import ejercicios.dao.UserDAO;
import ejercicios.dto.Message;
import ejercicios.dto.Party;
import ejercicios.dto.User;


@Service
public class IMessageServiceImpl implements IMessageService {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	PartyDAO partyDAO;
	
    @Autowired
    MessageDAO messageDAO;


	@Override
	public Message sendMessage(Long userId, Long partyId, String message) {
		// TODO Auto-generated method stub
		User user = userDAO.findById(userId).orElse(null);
		Party party = partyDAO.findById(partyId).orElse(null);
		
		Message msg = new Message();
		
		msg.setSender(user);
		msg.setParty(party);
		msg.setContent(message);
		
		return messageDAO.save(msg);
	}

	@Override
	public void editMessage(Long userId, Long messageId, String newMessage) {
		// TODO Auto-generated method stub
        Message msg = messageDAO.findById(messageId).orElse(null);
        
        if (msg != null && msg.getSender().getId().equals(userId)) {
        	
            msg.setContent(newMessage);
            messageDAO.save(msg);
        }

	}

	@Override
	public void deleteMessage(Long userId, Long messageId) {
		// TODO Auto-generated method stub
        Message msg = messageDAO.findById(messageId).orElse(null);

        if (msg != null && msg.getSender().getId().equals(userId)) {
        	
            messageDAO.delete(msg);
        }
	}

	@Override
	public List<Message> getPartyChat(Long partyId) {
		// TODO Auto-generated method stub

	    Party party = partyDAO.findById(partyId).orElse(null);
	    
		return messageDAO.findAll();
	}

}
