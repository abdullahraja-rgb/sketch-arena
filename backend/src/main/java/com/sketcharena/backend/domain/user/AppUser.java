package com.sketcharena.backend.domain.user;

// timestamp generation
import java.time.Instant;
// converting emails to lowercase
import java.util.Locale;
// generate uid
import java.util.UUID;

// imported from hibernate (jpa in springboot)
// creates timestamps 
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

// jpa imports
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// adding above a class tells that this class maps to a db table
@Entity
// specifies the table 
@Table(name = "app_user")
public class AppUser {

    // pk
	@Id
    // uses hibernate to create an id 
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "user_id", nullable = false, updatable = false)
	private UUID id;

	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;

	@Column(nullable = false, unique = true, length = 50)
	private String username;

	@Column(nullable = false, unique = true, length = 320)
	private String email;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

    // takes value from a defined enum
	@Enumerated(EnumType.STRING)
    // nullable = true is default
	@Column(name = "platform_role", length = 32)
	private PlatformRole platformRole;

	@Enumerated(EnumType.STRING)
	@Column(name = "account_status", nullable = false, length = 32)
	private AccountStatus accountStatus = AccountStatus.ACTIVE;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Instant createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

    // class constructor - protected cant be called from classes in other packages
	protected AppUser() {
	}


    // constructor used by the application code to create an entry
	public AppUser(String firstName, String lastName, String username, String email, String passwordHash) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email.toLowerCase(Locale.ROOT);
		this.passwordHash = passwordHash;
	}

    // getter methods for the columns 
	public UUID getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public PlatformRole getPlatformRole() {
		return platformRole;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}
}
