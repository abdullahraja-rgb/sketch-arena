CREATE TABLE app_user (
    userd_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(320) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    platform_role VARCHAR(32),
    account_status VARCHAR(32) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uk_app_user_username UNIQUE (username),
    CONSTRAINT uk_app_user_email UNIQUE (email),
    CONSTRAINT ck_app_user_email_lowercase CHECK (email = LOWER(email)),
    CONSTRAINT ck_app_user_platform_role
        CHECK (platform_role IS NULL OR platform_role IN ('PLATFORM_ADMIN')),
    CONSTRAINT ck_app_user_account_status
        CHECK (account_status IN ('ACTIVE', 'SUSPENDED', 'DISABLED'))
);

CREATE TABLE organisation (
    organisation_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(150) NOT NULL,
    description TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE organisation_membership (
    membership_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    -- fk
    organisation_id UUID NOT NULL,
    user_id UUID NOT NULL,
    organisation_role VARCHAR(32) NOT NULL,
    joined_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    left_at TIMESTAMPTZ,

    -- fk constraint
    CONSTRAINT fk_membership_organisation
        FOREIGN KEY (organisation_id) REFERENCES organisation (organisation_id),
    CONSTRAINT fk_membership_user
        FOREIGN KEY (user_id) REFERENCES app_user (user_id),
    CONSTRAINT uk_membership_organisation_identity
        UNIQUE (organisation_id, membership_id),
    CONSTRAINT ck_membership_role
        CHECK (organisation_role IN ('ORGANISATION_ADMIN', 'PLAYER')),
    CONSTRAINT ck_membership_dates
        CHECK (left_at IS NULL OR left_at >= joined_at)
);