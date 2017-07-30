CREATE TABLE currencies (
  code    VARCHAR(3) PRIMARY KEY NOT NULL,
  country TEXT                   NOT NULL,
  name    TEXT                   NOT NULL
);

CREATE TABLE exchange (
  from_curr  VARCHAR(3) NOT NULL REFERENCES currencies (code),
  to_curr    VARCHAR(3) NOT NULL REFERENCES currencies (code),
  rate       NUMERIC    NOT NULL,
  date       DATE       NOT NULL,
  created_at TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
);

