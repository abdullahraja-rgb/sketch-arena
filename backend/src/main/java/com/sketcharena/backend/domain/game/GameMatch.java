package com.sketcharena.backend.domain.game;

import java.time.Instant;
import java.util.Locale;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.sketcharena.backend.domain.organisation.Organisation;
import com.sketcharena.backend.domain.organisation.OrganisationMembership;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "game_match")
public class GameMatch {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "match_id", nullable = false, updatable = false)
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "organisation_id", nullable = false)
	private Organisation organisation;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "game_type_id", nullable = false)
	private GameType gameType;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "created_by_membership_id", nullable = false)
	private OrganisationMembership createdByMembership;

	@Column(name = "room_code", nullable = false, unique = true, length = 12)
	private String roomCode;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 32)
	private MatchStatus status = MatchStatus.LOBBY;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Instant createdAt;

	@Column(name = "started_at")
	private Instant startedAt;

	@Column(name = "ended_at")
	private Instant endedAt;

	protected GameMatch() {
	}

	public GameMatch(
			Organisation organisation,
			GameType gameType,
			OrganisationMembership createdByMembership,
			String roomCode) {
		this.organisation = organisation;
		this.gameType = gameType;
		this.createdByMembership = createdByMembership;
		this.roomCode = roomCode.toUpperCase(Locale.ROOT);
	}

	public UUID getId() {
		return id;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public GameType getGameType() {
		return gameType;
	}

	public OrganisationMembership getCreatedByMembership() {
		return createdByMembership;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public MatchStatus getStatus() {
		return status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getStartedAt() {
		return startedAt;
	}

	public Instant getEndedAt() {
		return endedAt;
	}
}
