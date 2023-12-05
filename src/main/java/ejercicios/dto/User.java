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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String pass;

    @Column(name = "email")
    private String email;

    @Column(name = "steam_username")
    private String steamUsername;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Party> createdParties;

    @JsonIgnore
    @ManyToMany(mappedBy = "participants")
    private List<Party> joinedParties;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;
    
	public User() {
		super();
	}

	public User(Long id, String username, String pass, String email, String steamUsername, List<Party> createdParties,
			List<Party> joinedParties, List<Message> messages) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.steamUsername = steamUsername;
		this.createdParties = createdParties;
		this.joinedParties = joinedParties;
		this.messages = messages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSteamUsername() {
		return steamUsername;
	}

	public void setSteamUsername(String steamUsername) {
		this.steamUsername = steamUsername;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
    
    
}
