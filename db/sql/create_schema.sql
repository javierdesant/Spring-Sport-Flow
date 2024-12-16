-- \c postgres;
-- drop DATABASE sportflow_db;

CREATE DATABASE sportflow_db;

\c sportflow_db;

CREATE TABLE users
(
    user_id  INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    email    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT chk_email_valid CHECK (
        email LIKE '%@upm.es' OR email LIKE '%@alumnos.upm.es'
        )
);

CREATE TABLE players
(
    player_id  INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id    INT          NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(150) NOT NULL,
    dni        VARCHAR(15)  NOT NULL UNIQUE,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

CREATE TABLE administrators
(
    admin_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id  INT NOT NULL UNIQUE,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

CREATE TABLE statistic_categories
(
    category_id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE player_statistics
(
    stat_id     INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    player_id   INT NOT NULL,
    category_id INT NOT NULL,
    value       DECIMAL(10, 2) DEFAULT 0.0,
    FOREIGN KEY (player_id) REFERENCES players (player_id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES statistic_categories (category_id) ON DELETE CASCADE,
    UNIQUE (player_id, category_id)
);

CREATE TABLE teams
(
    team_id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    team_name VARCHAR(150) NOT NULL UNIQUE,
    admin_id  INT,
    FOREIGN KEY (admin_id) REFERENCES administrators (admin_id) ON DELETE SET NULL
);

CREATE TABLE player_teams
(
    player_id INT NOT NULL,
    team_id   INT NOT NULL,
    PRIMARY KEY (player_id, team_id),
    FOREIGN KEY (player_id) REFERENCES players (player_id) ON DELETE CASCADE,
    FOREIGN KEY (team_id) REFERENCES teams (team_id) ON DELETE CASCADE
);

CREATE TABLE tournaments
(
    tournament_id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tournament_name VARCHAR(150) NOT NULL UNIQUE,
    start_date      DATE         NOT NULL,
    end_date        DATE         NOT NULL,
    league          VARCHAR(100) NOT NULL,
    sport           VARCHAR(100) NOT NULL,
    category_id     INT,
    FOREIGN KEY (category_id) REFERENCES statistic_categories (category_id) ON DELETE SET NULL
);

CREATE TABLE registrations
(
    registration_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tournament_id   INT NOT NULL,
    player_id       INT,
    team_id         INT,
    FOREIGN KEY (tournament_id) REFERENCES tournaments (tournament_id) ON DELETE CASCADE,
    FOREIGN KEY (player_id) REFERENCES players (player_id) ON DELETE SET NULL,
    FOREIGN KEY (team_id) REFERENCES teams (team_id) ON DELETE SET NULL,
    CONSTRAINT chk_registration CHECK (
        (player_id IS NOT NULL AND team_id IS NULL) OR
        (player_id IS NULL AND team_id IS NOT NULL)
        ),
    UNIQUE (tournament_id, player_id),
    UNIQUE (tournament_id, team_id)
);

CREATE TABLE matchups
(
    matchup_id    INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tournament_id INT         NOT NULL,
    matchup_type  VARCHAR(20) NOT NULL,
    FOREIGN KEY (tournament_id) REFERENCES tournaments (tournament_id) ON DELETE CASCADE,
    CONSTRAINT chk_matchup_type CHECK (matchup_type IN ('individual', 'team', 'free_for_all'))
);

CREATE TABLE matchup_participants
(
    matchup_id INT NOT NULL,
    player_id  INT,
    team_id    INT,
    FOREIGN KEY (matchup_id) REFERENCES matchups (matchup_id) ON DELETE CASCADE,
    FOREIGN KEY (player_id) REFERENCES players (player_id) ON DELETE CASCADE,
    FOREIGN KEY (team_id) REFERENCES teams (team_id) ON DELETE CASCADE,
    CONSTRAINT chk_valid_participant CHECK (
        (player_id IS NOT NULL AND team_id IS NULL) OR
        (player_id IS NULL AND team_id IS NOT NULL)
        ),
    CONSTRAINT unique_player_per_matchup UNIQUE (matchup_id, player_id),
    CONSTRAINT unique_team_per_matchup UNIQUE (matchup_id, team_id)
);

INSERT INTO statistic_categories (category_name)
VALUES ('Points scored'),
       ('Matches won'),
       ('Assists made'),
       ('Tournaments won'),
       ('Revenue generated');