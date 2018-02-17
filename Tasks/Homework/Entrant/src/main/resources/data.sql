INSERT INTO users
(id, email, hash_password, state, role)
  SELECT
    1,
    'admin@admin.com',
    '$2a$08$4D5rbs8MnvsAMHyMR1wn1eAKQes1XYwewli.EV.MAtK7VrRsO7uz6',
    'CONFIRMED',
    'ADMIN'
  WHERE
    NOT EXISTS(
        SELECT id
        FROM users
        WHERE id = 1
    );

CREATE TABLE IF NOT EXISTS persistent_logins (
  username VARCHAR(64) NOT NULL,
  series VARCHAR(64) PRIMARY KEY NOT NULL,
  token VARCHAR(64) NOT NULL,
  last_used TIMESTAMP NOT NULL
)