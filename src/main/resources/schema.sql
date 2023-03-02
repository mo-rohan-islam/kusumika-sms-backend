DROP SCHEMA kusumika IF EXISTS;

CREATE SCHEMA kusumika AUTHORIZATION sa;

------------------------------

--CREATE OR REPLACE FUNCTION kusumika.update_creation_ts()
-- RETURNS trigger
-- LANGUAGE plpgsql
--AS $function$
--	BEGIN
--		new.creation_ts = now();
--		return new;	
--	END;
--$function$
--;
--
------------------------------
--
--CREATE OR REPLACE FUNCTION kusumika.update_last_updated_ts()
-- RETURNS trigger
-- LANGUAGE plpgsql
--AS $function$
--	BEGIN
--		new.last_updated_ts = now();
--		return new;
--	END;
--$function$
--;


----------------------------------

-- kusumika.village definition

-- Drop table

DROP TABLE kusumika.village IF EXISTS;

CREATE TABLE kusumika.village (
	village_name varchar(20) NOT NULL,
	post_office varchar(20) NULL,
	police_station varchar(20) NULL,
	pin_code varchar(6) NULL,
	district varchar(15) NULL,
	creation_ts timestamp NULL,
	last_updated_ts timestamp NULL,
	CONSTRAINT village_pkey PRIMARY KEY (village_name)
);

-- Table Triggers

--create trigger update_creation_ts before
--insert
--    on
--    kusumika.village for each row execute function kusumika.update_creation_ts();
--create trigger update_last_updated_ts before
--update
--    on
--    kusumika.village for each row execute function kusumika.update_last_updated_ts();
--    
---------------------------------------
   
-- kusumika.household definition

-- Drop table

DROP TABLE kusumika.household IF EXISTS;

CREATE TABLE kusumika.household (
	household_id serial NOT NULL,
	father_first_name varchar(30) NULL,
	father_middle_name varchar(30) NULL,
	father_last_name varchar(30) NULL,
	village_name varchar(20) NOT NULL,
	mother_first_name varchar(30) NULL,
	mother_middle_name varchar(30) NULL,
	mother_last_name varchar(30) NULL,
	phone_number_1 varchar(10) NULL,
	phone_number_2 varchar(10) NULL,
	creation_ts timestamp NULL,
	last_updated_ts timestamp NULL,
	CONSTRAINT household_pkey PRIMARY KEY (household_id),
	CONSTRAINT household_village_fkey FOREIGN KEY (village_name) REFERENCES kusumika.village(village_name)
);

-- Table Triggers

--create trigger update_creation_ts before
--insert
--    on
--    kusumika.household for each row execute function kusumika.update_creation_ts();
--create trigger update_last_updated_ts before
--update
--    on
--    kusumika.household for each row execute function kusumika.update_last_updated_ts();
--    
-----------------------------------------------
   
-- kusumika.bank definition

-- Drop table

DROP TABLE kusumika.bank IF EXISTS;

CREATE TABLE kusumika.bank (
	bank_ifsc varchar(11) NOT NULL,
	bank_name varchar(25) NULL,
	bank_branch varchar(15) NULL,
	city varchar(15) NULL,
	state varchar(20) NULL,
	creation_ts timestamp NULL,
	last_updated_ts timestamp NULL,
	CONSTRAINT bank_pkey PRIMARY KEY (bank_ifsc)
);

-- Table Triggers

--create trigger update_creation_ts before
--insert
--    on
--    kusumika.bank for each row execute function kusumika.update_creation_ts();
--create trigger update_last_updated_ts before
--update
--    on
--    kusumika.bank for each row execute function kusumika.update_last_updated_ts();
--    
-------------------------------------------------
   
-- kusumika.student definition

-- Drop table

DROP TABLE kusumika.student IF EXISTS;

CREATE TABLE kusumika.student (
	student_id serial NOT NULL,
	first_name varchar(30) NOT NULL,
	middle_name varchar(30) NULL,
	last_name varchar(30) NULL,
	standard varchar(3) NOT NULL,
	class_roll int2 NOT NULL,
	date_of_birth date NULL,
	aadhar varchar(12) NULL,
	bank_ifsc varchar(11) NULL,
	bank_account_number varchar(20) NULL,
	bank_account_holder varchar(1) NULL,
	household_id int4 NOT NULL,
	creation_ts timestamp NULL,
	last_updated_ts timestamp NULL,
	CONSTRAINT student_pkey PRIMARY KEY (student_id),
	CONSTRAINT student_bank_ifsc_fkey FOREIGN KEY (bank_ifsc) REFERENCES kusumika.bank(bank_ifsc),
	CONSTRAINT student_household_id_fkey FOREIGN KEY (household_id) REFERENCES kusumika.household(household_id)
);

-- Table Triggers

--create trigger update_creation_ts before
--insert
--    on
--    kusumika.student for each row execute function kusumika.update_creation_ts();
--create trigger update_last_updated_ts before
--update
--    on
--    kusumika.student for each row execute function kusumika.update_last_updated_ts();
--    
-------------------------------------
   
-- kusumika.fees definition

-- Drop table

DROP TABLE kusumika.fees IF EXISTS;

CREATE TABLE kusumika.fees (
	standard varchar(3) NOT NULL,
	admission_fees int4 NOT NULL,
	monthly_fees int2 NOT NULL,
	creation_ts timestamp NULL,
	last_updated_ts timestamp NULL,
	CONSTRAINT fees_pkey PRIMARY KEY (standard)
);

-- Table Triggers

--create trigger update_creation_ts before
--insert
--    on
--    kusumika.fees for each row execute function kusumika.update_creation_ts();
--create trigger update_last_updated_ts before
--update
--    on
--    kusumika.fees for each row execute function kusumika.update_last_updated_ts();
--    
----------------------------------------
   
-- kusumika.fees_collection definition

-- Drop table

DROP TABLE kusumika.fees_collection IF EXISTS;

CREATE TABLE kusumika.fees_collection (
	fees_collection_id serial NOT NULL,
	household_id int4 NOT NULL,
	payment_json json NOT NULL,
	previous_due int2 NULL,
	advance_payment int2 NULL,
	concession int2 NULL,
	creation_ts timestamp NULL,
	last_updated_ts timestamp NULL,
	CONSTRAINT fees_collection_pkey PRIMARY KEY (fees_collection_id)
);

-- Table Triggers

--create trigger update_creation_ts before
--insert
--    on
--    kusumika.fees_collection for each row execute function kusumika.update_creation_ts();
--create trigger update_last_updated_ts before
--update
--    on
--    kusumika.fees_collection for each row execute function kusumika.update_last_updated_ts();


