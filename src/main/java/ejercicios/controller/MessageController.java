package ejercicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ejercicios.dto.Message;
import ejercicios.service.IMessageService;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @PostMapping("/send")
    public Message sendMessage(@RequestParam Long userId,@RequestParam Long partyId,@RequestParam String content) {
        return messageService.sendMessage(userId, partyId, content);
    }

    @PutMapping("/edit/{messageId}")
    public void editMessage(@RequestParam Long userId,@PathVariable Long messageId,@RequestParam String newMessage) {
        messageService.editMessage(userId, messageId, newMessage);
    }

    @DeleteMapping("/delete/{messageId}")
    public void deleteMessage(@RequestParam Long userId, @PathVariable Long messageId) {
        messageService.deleteMessage(userId, messageId);
    }

    @GetMapping("/chat/{partyId}")
    public List<Message> getPartyChat(@PathVariable Long partyId) {
        return messageService.getPartyChat(partyId);
    }
}
