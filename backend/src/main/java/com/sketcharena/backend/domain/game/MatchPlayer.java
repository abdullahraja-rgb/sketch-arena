package com.sketcharena.backend.domain.game;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.sketcharena.backend.domain.organisation.Organisation;
import com.sketcharena.backend.domain.organisation.OrganisationMembership;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "match_player")
public class MatchPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "match_player_id", nullable = false, updatable = false)
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "organisation_id", nullable = false)
	private Organisation organisation;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "match_id", nullable = false)
	private GameMatch match;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "membership_id", nullable = false)
	private OrganisationMembership membership;

	@CreationTimestamp
	@Column(name = "joined_at", nullable = false, updatable = false)
	private Instant joinedAt;

	@Column(name = "left_at")
	private Instant leftAt;

	protected MatchPlayer() {
	}

	public MatchPlayer(
			Organisation organisation,
			GameMatch match,
			OrganisationMembership membership) {
		this.organisation = organisation;
		this.match = match;
		this.membership = membership;
	}

	public UUID getId() {
		return id;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public GameMatch getMatch() {
		return match;
	}

	public OrganisationMembership getMembership() {
		return membership;
	}

	public Instant getJoinedAt() {
		return joinedAt;
	}

	public Instant getLeftAt() {
		return leftAt;
	}
}
