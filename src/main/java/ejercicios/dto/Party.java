package ejercicios.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "parties")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_user_id")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "video_game_id")
    private Videogame videoGame;

    @Column(name = "party_name")
    private String partyName;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "party_participants",
            joinColumns = @JoinColumn(name = "party_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_user_id"))
    private List<User> participants;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "party", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

	public Party(Long id, User creator, Videogame videoGame, String partyName, List<User> participants,
			List<Message> messages) {
		super();
		this.id = id;
		this.creator = creator;
		this.videoGame = videoGame;
		this.partyName = partyName;
		this.participants = participants;
		this.messages = messages;
	}

	public Party() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Videogame getVideoGame() {
		return videoGame;
	}

	public void setVideoGame(Videogame videoGame) {
		this.videoGame = videoGame;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
