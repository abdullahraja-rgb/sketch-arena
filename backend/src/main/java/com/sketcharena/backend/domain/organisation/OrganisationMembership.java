package com.sketcharena.backend.domain.organisation;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "organisation_membership")
public class OrganisationMembership {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "membership_id", nullable = false, updatable = false)
	private UUID id;

    /* defines a many-to-one relationship from our curr class to the imported class (membership to organisation). we specify in this method to load the organisation class not immediately via
    .LAZY if we used alternatively .EAGER that would load immediately. optional = false is the equivalent
    of defining a not null relationship meaning org_id is needed.  */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    // speciifies the table name where the fk comes from and null=false means fk cant be null
	@JoinColumn(name = "organisation_id", nullable = false)
	private Organisation organisation;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private AppUser user;

	@Enumerated(EnumType.STRING)
	@Column(name = "organisation_role", nullable = false, length = 32)
	private OrganisationRole role;

	@CreationTimestamp
	@Column(name = "joined_at", nullable = false, updatable = false)
	private Instant joinedAt;

	@Column(name = "left_at")
	private Instant leftAt;

	protected OrganisationMembership() {
	}

	public OrganisationMembership(Organisation organisation, AppUser user, OrganisationRole role) {
		this.organisation = organisation;
		this.user = user;
		this.role = role;
	}

	public UUID getId() {
		return id;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public AppUser getUser() {
		return user;
	}

	public OrganisationRole getRole() {
		return role;
	}

	public Instant getJoinedAt() {
		return joinedAt;
	}

	public Instant getLeftAt() {
		return leftAt;
	}
}
