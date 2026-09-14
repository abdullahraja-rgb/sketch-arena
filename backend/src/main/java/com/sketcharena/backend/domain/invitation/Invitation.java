package com.sketcharena.backend.domain.invitation;

import java.time.Instant;
import java.util.Locale;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.sketcharena.backend.domain.organisation.Organisation;
import com.sketcharena.backend.domain.organisation.OrganisationRole;
import com.sketcharena.backend.domain.user.AppUser;

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
@Table(name = "invitation")
public class Invitation {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "invitation_id", nullable = false, updatable = false)
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "organisation_id", nullable = false)
	private Organisation organisation;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "invited_by_user_id", nullable = false)
	private AppUser invitedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accepted_by_user_id")
	private AppUser acceptedBy;

	@Column(name = "invited_email", nullable = false, length = 320)
	private String invitedEmail;

	@Enumerated(EnumType.STRING)
	@Column(name = "offered_role", nullable = false, length = 32)
	private OrganisationRole offeredRole;

	@Column(name = "token_hash", nullable = false, unique = true)
	private String tokenHash;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 32)
	private InvitationStatus status = InvitationStatus.PENDING;

	@CreationTimestamp
	@Column(name = "invited_at", nullable = false, updatable = false)
	private Instant invitedAt;

	@Column(name = "expires_at", nullable = false)
	private Instant expiresAt;

	@Column(name = "accepted_at")
	private Instant acceptedAt;

	protected Invitation() {
	}

	public Invitation(
			Organisation organisation,
			AppUser invitedBy,
			String invitedEmail,
			OrganisationRole offeredRole,
			String tokenHash,
			Instant expiresAt) {
		this.organisation = organisation;
		this.invitedBy = invitedBy;
		this.invitedEmail = invitedEmail.toLowerCase(Locale.ROOT);
		this.offeredRole = offeredRole;
		this.tokenHash = tokenHash;
		this.expiresAt = expiresAt;
	}

	public UUID getId() {
		return id;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public AppUser getInvitedBy() {
		return invitedBy;
	}

	public AppUser getAcceptedBy() {
		return acceptedBy;
	}

	public String getInvitedEmail() {
		return invitedEmail;
	}

	public OrganisationRole getOfferedRole() {
		return offeredRole;
	}

	public String getTokenHash() {
		return tokenHash;
	}

	public InvitationStatus getStatus() {
		return status;
	}

	public Instant getInvitedAt() {
		return invitedAt;
	}

	public Instant getExpiresAt() {
		return expiresAt;
	}

	public Instant getAcceptedAt() {
		return acceptedAt;
	}
}
