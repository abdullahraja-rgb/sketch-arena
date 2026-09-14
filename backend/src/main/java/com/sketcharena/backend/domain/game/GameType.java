package com.sketcharena.backend.domain.game;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game_type")
public class GameType {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "game_type_id", nullable = false, updatable = false)
	private UUID id;

	@Column(nullable = false, unique = true, length = 50)
	private String code;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(columnDefinition = "text")
	private String description;

	@Column(name = "min_players", nullable = false)
	private int minPlayers;

	@Column(name = "max_players", nullable = false)
	private int maxPlayers;

	@Column(nullable = false)
	private boolean active = true;

	protected GameType() {
	}

	public GameType(String code, String name, String description, int minPlayers, int maxPlayers) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
	}

	public UUID getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public boolean isActive() {
		return active;
	}
}
