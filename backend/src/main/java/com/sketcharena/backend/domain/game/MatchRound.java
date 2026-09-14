package com.sketcharena.backend.domain.game;

import java.time.Instant;
import java.util.UUID;

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
@Table(name = "match_round")
public class MatchRound {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "round_id", nullable = false, updatable = false)
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "match_id", nullable = false)
	private GameMatch match;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "drawer_match_player_id", nullable = false)
	private MatchPlayer drawer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "guesser_match_player_id", nullable = false)
	private MatchPlayer guesser;

	@Column(name = "round_number", nullable = false)
	private int roundNumber;

	@Column(name = "secret_word", nullable = false, length = 100)
	private String secretWord;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 32)
	private RoundStatus status = RoundStatus.PENDING;

	@Enumerated(EnumType.STRING)
	@Column(length = 32)
	private RoundOutcome outcome;

	@Column(name = "points_awarded", nullable = false)
	private int pointsAwarded;

	@Column(name = "started_at")
	private Instant startedAt;

	@Column(name = "deadline_at")
	private Instant deadlineAt;

	@Column(name = "ended_at")
	private Instant endedAt;

	@Column(name = "guessed_at")
	private Instant guessedAt;

	protected MatchRound() {
	}

	public MatchRound(
			GameMatch match,
			MatchPlayer drawer,
			MatchPlayer guesser,
			int roundNumber,
			String secretWord) {
		this.match = match;
		this.drawer = drawer;
		this.guesser = guesser;
		this.roundNumber = roundNumber;
		this.secretWord = secretWord;
	}

	public UUID getId() {
		return id;
	}

	public GameMatch getMatch() {
		return match;
	}

	public MatchPlayer getDrawer() {
		return drawer;
	}

	public MatchPlayer getGuesser() {
		return guesser;
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public String getSecretWord() {
		return secretWord;
	}

	public RoundStatus getStatus() {
		return status;
	}

	public RoundOutcome getOutcome() {
		return outcome;
	}

	public int getPointsAwarded() {
		return pointsAwarded;
	}

	public Instant getStartedAt() {
		return startedAt;
	}

	public Instant getDeadlineAt() {
		return deadlineAt;
	}

	public Instant getEndedAt() {
		return endedAt;
	}

	public Instant getGuessedAt() {
		return guessedAt;
	}
}
