package ejercicios.service;

import java.util.List;

import ejercicios.dto.Message;

public interface IMessageService {

    Message sendMessage(Long userId, Long partyId, String message);

    void editMessage(Long userId, Long messageId, String newMessage);

    void deleteMessage(Long userId, Long messageId);

    List<Message> getPartyChat(Long partyId);
}