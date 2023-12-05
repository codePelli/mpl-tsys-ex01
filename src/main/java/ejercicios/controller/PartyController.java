package ejercicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ejercicios.dto.Party;
import ejercicios.service.IPartyService;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private IPartyService partyService;

    @PostMapping("/create")
    public Party createParty(@RequestParam Long userId,@RequestParam Long videoGameId,@RequestParam String partyName) {
        return partyService.createParty(userId, videoGameId, partyName);
    }

    @GetMapping("/search")
    public List<Party> searchParties(@RequestParam Long videoGameId) {
        return partyService.searchParties(videoGameId);
    }

    @PostMapping("/join")
    public void joinParty(@RequestParam Long userId,@RequestParam Long partyId) {
        partyService.joinParty(userId, partyId);
    }

    @PostMapping("/leave")
    public void leaveParty(@RequestParam Long userId,@RequestParam Long partyId) {
        partyService.leaveParty(userId, partyId);
    }
}
