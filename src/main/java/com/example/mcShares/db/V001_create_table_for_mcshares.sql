--Create table t_customer_type
CREATE TABLE t_customer_type
(
    id_customer_type  UUID        NOT NULL,
    cod_customer_type VARCHAR(50) NOT NULL,
    lib_customer_type VARCHAR(50) NOT NULL,
    dat_update        TIMESTAMP WITHOUT TIME ZONE,
    dat_create        TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_t_customer_type PRIMARY KEY (id_customer_type)

);

COMMENT
ON TABLE t_customer_type IS 'Table that holds type of customers';
COMMENT
ON COLUMN t_customer_type.cod_customer_type IS 'Code customer type';
COMMENT
ON COLUMN t_customer_type.lib_customer_type IS 'Description customer type';

--Create table t_customer_contact_details
CREATE TABLE t_customer_contact_details
(
    id_contact_details UUID         NOT NULL,
    contact_name       VARCHAR(255) NOT NULL,
    contact_number     VARCHAR(255),
    dat_update         TIMESTAMP WITHOUT TIME ZONE,
    dat_create         TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_t_customer_contact_details PRIMARY KEY (id_contact_details)
);

COMMENT
ON TABLE t_customer_contact_details IS 'Table that holds type of customer contact details';
COMMENT
ON COLUMN t_customer_contact_details.contact_name IS 'Customer name';
COMMENT
ON COLUMN t_customer_contact_details.contact_number IS 'Customer contact number';

--Create table t_customer_mailing_address
CREATE TABLE t_customer_mailing_address
(
    id_mailing_address UUID         NOT NULL,
    address_line_1     VARCHAR(255) NOT NULL,
    address_line_2     VARCHAR(255) NOT NULL,
    town_city          VARCHAR(255) NOT NULL,
    country            VARCHAR(255) NOT NULL,
    dat_update         TIMESTAMP WITHOUT TIME ZONE,
    dat_create         TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_t_customer_mailing_address PRIMARY KEY (id_mailing_address)
);

COMMENT
ON TABLE t_customer_mailing_address IS 'Table that holds type of customer mailing details';
COMMENT
ON COLUMN t_customer_mailing_address.address_line_1 IS 'Customer address_line_1';
COMMENT
ON COLUMN t_customer_mailing_address.address_line_2 IS 'Customer address_line_2';
COMMENT
ON COLUMN t_customer_mailing_address.town_city IS 'Customer town or city';
COMMENT
ON COLUMN t_customer_mailing_address.country IS 'Customer country';

--Create table t_customer_shares_details
CREATE TABLE t_customer_shares_details
(
    id_share_details UUID    NOT NULL,
    num_shares       INTEGER NOT NULL,
    share_price      DOUBLE PRECISION,
    balance          DOUBLE PRECISION,
    dat_update       TIMESTAMP WITHOUT TIME ZONE,
    dat_create       TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_t_customer_shares_details PRIMARY KEY (id_share_details)
);

COMMENT
ON TABLE t_customer_shares_details IS 'Table that holds type of customer shares details';
COMMENT
ON COLUMN t_customer_shares_details.num_shares IS 'Customer number of shares';
COMMENT
ON COLUMN t_customer_shares_details.share_price IS 'Customer share price of shares';
COMMENT
ON COLUMN t_customer_shares_details.balance IS 'Customer share price * number of shares';

--Create table t_customer
CREATE TABLE t_customer
(
    id_customer        UUID NOT NULL,
    ref_customer       VARCHAR(255),
    id_customer_type   UUID NOT NULL,
    date_of_birth      TIMESTAMP WITHOUT TIME ZONE,
    date_incorp        TIMESTAMP WITHOUT TIME ZONE,
    registration_no    VARCHAR(255),
    id_mailing_address UUID,
    id_contact_details UUID,
    id_share_details   UUID,
    dat_update         TIMESTAMP WITHOUT TIME ZONE,
    dat_create         TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_t_customer PRIMARY KEY (id_customer)
);

COMMENT
ON TABLE t_customer IS 'Table that holds type of customer details';
COMMENT
ON COLUMN t_customer.ref_customer IS 'Customer id reference';
COMMENT
ON COLUMN t_customer.id_customer_type IS 'Customer type';
COMMENT
ON COLUMN t_customer.date_of_birth IS 'Customer date of birth';
COMMENT
ON COLUMN t_customer.date_incorp IS 'Customer dat incorp';
COMMENT
ON COLUMN t_customer.registration_no IS 'Customer registration_no';
COMMENT
ON COLUMN t_customer.id_mailing_address IS 'Customer mailing address';
COMMENT
ON COLUMN t_customer.id_contact_details IS 'Customer contact details';
COMMENT
ON COLUMN t_customer.id_share_details IS 'Customer share details';

ALTER TABLE t_customer
    ADD CONSTRAINT FK_T_CUSTOMER_ON_ID_CONTACT_DETAILS FOREIGN KEY (id_contact_details) REFERENCES t_customer_contact_details (id_contact_details);

ALTER TABLE t_customer
    ADD CONSTRAINT FK_T_CUSTOMER_ON_ID_CUSTOMER_TYPE FOREIGN KEY (id_customer_type) REFERENCES t_customer_type (id_customer_type);

ALTER TABLE t_customer
    ADD CONSTRAINT FK_T_CUSTOMER_ON_ID_MAILING_ADDRESS FOREIGN KEY (id_mailing_address) REFERENCES t_customer_mailing_address (id_mailing_address);

ALTER TABLE t_customer
    ADD CONSTRAINT FK_T_CUSTOMER_ON_ID_SHARE_DETAILS FOREIGN KEY (id_share_details) REFERENCES t_customer_shares_details (id_share_details);

--Create table t_shares_file_upload
CREATE TABLE t_shares_file_upload
(
    id_shares_file_upload UUID         NOT NULL,
    file_name             VARCHAR(255) NOT NULL,
    doc_ref               VARCHAR(255) NOT NULL,
    doc_date              TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    status                VARCHAR(255),
    dat_update            TIMESTAMP WITHOUT TIME ZONE,
    dat_create            TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_t_shares_file_upload PRIMARY KEY (id_shares_file_upload)
);

--Insert values in t_customer_type
INSERT INTO public.t_customer_type(id_customer_type, cod_customer_type, lib_customer_type, dat_create)
VALUES (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), 'INDIVIDUAL', 'Individual', now());

INSERT INTO public.t_customer_type(id_customer_type, cod_customer_type, lib_customer_type, dat_create)
VALUES (uuid_in(md5(random()::text || clock_timestamp()::text)::cstring), 'CORPORATE', 'Corporate', now());

--Create table t_user
CREATE TABLE t_user
(
    id_user    UUID         NOT NULL,
    username   VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    dat_update TIMESTAMP WITHOUT TIME ZONE,
    dat_create TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_t_user PRIMARY KEY (id_user)
);

--Create index for ref_customer
CREATE INDEX t_customer_ref_customer ON t_customer (ref_customer);