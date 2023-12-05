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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "videogames")
public class Videogame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gamename")
    private String gamename;

    @Column(name = "platform")
    private String platform;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "videoGame", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Party> parties;

	public Videogame(Long id, String gamename, String platform, List<Party> parties) {
		super();
		this.id = id;
		this.gamename = gamename;
		this.platform = platform;
		this.parties = parties;
	}

	public Videogame() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGamename() {
		return gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

}