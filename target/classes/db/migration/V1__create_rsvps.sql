CREATE TABLE rsvps (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR NOT NULL,
  last_name VARCHAR NOT NULL,
  email VARCHAR NOT NULL,
  phone_number VARCHAR NOT NULL,
  contact_style VARCHAR NOT NULL
);