DROP TABLE IF EXISTS banks CASCADE;
DROP TABLE IF EXISTS currencies CASCADE;
DROP TABLE IF EXISTS deposits CASCADE;
DROP TABLE IF EXISTS credits CASCADE;

CREATE TABLE banks (
	bic             BIGINT          NOT NULL,
	name            VARCHAR(100)    NOT NULL,
	legal_entity    VARCHAR(100)    NOT NULL,
	description     TEXT            NOT NULL,
	logo            VARCHAR(250)    NOT NULL,
	url             VARCHAR(250)    NOT NULL,

	CONSTRAINT pk_banks PRIMARY KEY (bic),
	CONSTRAINT uq_banks__name UNIQUE (name),
	CONSTRAINT uq_banks__legal_entity UNIQUE (legal_entity)
);

CREATE TABLE currencies (
	num         BIGINT          NOT NULL,
	code        VARCHAR(3)      NOT NULL,
	currency    VARCHAR(30)     NOT NULL,

	CONSTRAINT pk_currencies PRIMARY KEY (num),
	CONSTRAINT uq_currencies__code UNIQUE (code),
	CONSTRAINT uq_currencies__currency UNIQUE (currency)
);

CREATE TABLE deposits (
	id                  BIGINT          GENERATED BY DEFAULT AS IDENTITY,
	bank_bic            BIGINT          NOT NULL,
	name                VARCHAR(100)    NOT NULL,
	product_url         VARCHAR(250)    NOT NULL,
	is_active           BOOLEAN         NOT NULL,
	currency_num        BIGINT          NOT NULL,
	amount_min          INTEGER         NOT NULL,
	amount_max          INTEGER         NOT NULL,
	term                INTEGER         NOT NULL,
	rate                DECIMAL(4,2)    NOT NULL,
	capitalization      BOOLEAN         NOT NULL,
	replenishment       BOOLEAN         NOT NULL,
	partial_withdrawal  BOOLEAN         NOT NULL,

	CONSTRAINT pk_deposits PRIMARY KEY (id),
	CONSTRAINT fk_deposits__banks FOREIGN KEY (bank_bic) REFERENCES banks(bic) ON DELETE CASCADE,
	CONSTRAINT fk_deposits__currencies FOREIGN KEY (currency_num) REFERENCES currencies(num) ON DELETE CASCADE
);

CREATE TABLE credits (
	id                  BIGINT          GENERATED BY DEFAULT AS IDENTITY,
	bank_bic            BIGINT          NOT NULL,
	name                VARCHAR(100)    NOT NULL,
	product_url         VARCHAR(250)    NOT NULL,
	is_active           BOOLEAN         NOT NULL,
	currency_num        BIGINT          NOT NULL,
	amount_min          INTEGER         NOT NULL,
    amount_max          INTEGER         NOT NULL,
    term                INTEGER         NOT NULL,
    rate                DECIMAL(4,2)    NOT NULL,
    payment_type        VARCHAR(20)     NOT NULL,

	CONSTRAINT pk_credits PRIMARY KEY (id),
	CONSTRAINT fk_credits__banks FOREIGN KEY (bank_bic) REFERENCES banks(bic) ON DELETE CASCADE,
	CONSTRAINT fk_credits__currencies FOREIGN KEY (currency_num) REFERENCES currencies(num) ON DELETE CASCADE
);
