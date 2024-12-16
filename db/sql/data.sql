\c sportflow_db;

INSERT INTO users (email, password)
VALUES ('admin1@upm.es', 'securepass1'),
       ('admin2@upm.es', 'securepass2'),
       ('player1@alumnos.upm.es', 'securepass3'),
       ('player2@alumnos.upm.es', 'securepass4'),
       ('player3@alumnos.upm.es', 'securepass5'),
       ('player4@alumnos.upm.es', 'securepass6'),
       ('player5@alumnos.upm.es', 'securepass7'),
       ('player6@alumnos.upm.es', 'securepass8');

INSERT INTO players (user_id, first_name, last_name, dni)
VALUES (3, 'John', 'Doe', '123456789A'),
       (4, 'Jane', 'Smith', '987654321B'),
       (5, 'Alice', 'Johnson', '876543210C'),
       (6, 'Bob', 'Williams', '456789123D'),
       (7, 'Charlie', 'Brown', '789123456E'),
       (8, 'Emma', 'Davis', '321098765F');

INSERT INTO administrators (user_id)
VALUES (1),
       (2);

INSERT INTO statistic_categories (category_name)
VALUES ('Goles marcados'),
       ('Partidos ganados'),
       ('Tiros realizados'),
       ('Faltas cometidas'),
       ('Asistencias realizadas');

INSERT INTO teams (team_name, admin_id)
VALUES ('Red Wolves', 1),
       ('Blue Tigers', 2),
       ('Green Falcons', 1);

INSERT INTO player_teams (player_id, team_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 2),
       (5, 3),
       (6, 3);

INSERT INTO tournaments (tournament_name, start_date, end_date, league, sport, category_id)
VALUES ('Fútbol UPM 2024', '2024-03-01', '2024-03-20', 'Liga Universitaria', 'Fútbol', 1),
       ('Baloncesto de Primavera', '2024-05-15', '2024-06-10', 'Liga Escolar', 'Baloncesto', 2),
       ('Voleibol de Invierno', '2024-11-01', '2024-11-30', 'Liga General', 'Voleibol', 3);

INSERT INTO registrations (tournament_id, player_id, team_id)
VALUES (1, 1, NULL),
       (1, 2, NULL),
       (2, NULL, 1),
       (3, NULL, 2),
       (3, NULL, 3);

INSERT INTO matchups (tournament_id, matchup_type)
VALUES (1, 'individual'),
       (2, 'team'),
       (3, 'team');

INSERT INTO matchup_participants (matchup_id, player_id, team_id)
VALUES (1, 3, NULL),
       (1, 4, NULL),
       (2, NULL, 1),
       (3, NULL, 2),
       (3, NULL, 3);

INSERT INTO player_statistics (player_id, category_id, value)
VALUES (1, 1, 15.0),
       (2, 1, 8.0),
       (3, 2, 10.0),
       (4, 2, 12.0),
       (5, 4, 5.0),
       (6, 3, 30.0);