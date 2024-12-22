\c sportflow_db;

-- TODO!: update with encoded passwords

INSERT INTO users (email, password)
VALUES ('admin1@upm.es', 'securepass1'),
       ('admin2@upm.es', 'securepass2'),
       ('player1@alumnos.upm.es', 'securepass3'),
       ('player2@alumnos.upm.es', 'securepass4'),
       ('player3@alumnos.upm.es', 'securepass5'),
       ('player4@alumnos.upm.es', 'securepass6'),
       ('player5@alumnos.upm.es', 'securepass7'),
       ('player6@alumnos.upm.es', 'securepass8');

INSERT INTO administrators (user_id)
VALUES (1),
       (2);

INSERT INTO players (user_id, first_name, last_name, dni, admin_id)
VALUES (3, 'John', 'Doe', '123456789A', 1),
       (4, 'Jane', 'Smith', '987654321B', 2),
       (5, 'Alice', 'Johnson', '876543210C', 1),
       (6, 'Bob', 'Williams', '456789123D', 2),
       (7, 'Charlie', 'Brown', '789123456E', 1),
       (8, 'Emma', 'Davis', '321098765F', 1);

INSERT INTO categories (category_code, category_name)
VALUES ('POINTS', 'Puntos marcados'),
       ('MATCHES', 'Partidos ganados'),
       ('ASSISTS', 'Asistencias'),
       ('TOURNAMENTS', 'Torneos ganados'),
       ('MONEY', 'Dinero generado en el torneo');

INSERT INTO leagues (league_code, league_name)
VALUES ('U10', 'Liga Sub-10'),
       ('U12', 'Liga Sub-12'),
       ('U14', 'Liga Sub-14'),
       ('U16', 'Liga Sub-16'),
       ('U18', 'Liga Sub-18'),
       ('U20', 'Liga Sub-20'),
       ('U23', 'Liga Sub-23'),
       ('ADULT', 'Liga de Adultos'),
       ('MASTER', 'Liga de Veteranos'),
       ('SENIOR', 'Liga Senior'),
       ('40PLUS', 'Liga para Mayores de 40'),
       ('50PLUS', 'Liga para Mayores de 50'),
       ('60PLUS', 'Liga para Mayores de 60');

INSERT INTO sports (sport_code, sport_name)
VALUES ('FBL', 'Fútbol'),
       ('BSK', 'Baloncesto'),
       ('TEN', 'Tenis'),
       ('SWM', 'Natación'),
       ('BOX', 'Boxeo'),
       ('ATH', 'Atletismo'),
       ('GLF', 'Golf'),
       ('CKT', 'Críquet'),
       ('BSB', 'Béisbol'),
       ('RUG', 'Rugby'),
       ('VOL', 'Voleibol'),
       ('HBL', 'Balonmano'),
       ('CYC', 'Ciclismo'),
       ('HOC', 'Hockey'),
       ('SKI', 'Esquí'),
       ('SBD', 'Snowboard'),
       ('IHO', 'Hockey sobre hielo'),
       ('SRF', 'Surf'),
       ('BDM', 'Bádminton'),
       ('TTE', 'Tenis de mesa'),
       ('WRS', 'Lucha'),
       ('JUD', 'Judo'),
       ('KTE', 'Karate'),
       ('TKW', 'Taekwondo'),
       ('FEN', 'Esgrima'),
       ('ARC', 'Tiro con arco'),
       ('SHO', 'Tiro'),
       ('EQU', 'Equitación'),
       ('TRI', 'Triatlón'),
       ('WLF', 'Halterofilia'),
       ('SAL', 'Vela'),
       ('ROW', 'Remo'),
       ('CAS', 'Piragüismo'),
       ('SKS', 'Monopatín'),
       ('CLB', 'Escalada'),
       ('GYM', 'Gimnasia'),
       ('MAR', 'Artes marciales'),
       ('POL', 'Polo'),
       ('MCS', 'Deportes de motor'),
       ('ESP', 'Esports');

INSERT INTO teams (team_name, admin_id)
VALUES ('Red Wolves', 1),
       ('Blue Tigers', 2),
       ('Green Falcons', 1);

INSERT INTO player_teams (player_id, team_id)
VALUES (8, 1),
       (7, 1),
       (3, 2),
       (4, 2),
       (5, 3),
       (6, 3);

INSERT INTO tournaments (tournament_name, start_date, end_date, league_code, sport_code, category_code)
VALUES ('Fútbol UPM 2024', '2024-03-01', '2024-03-20', 'U18', 'FBL', 'POINTS'),
       ('Baloncesto de Primavera', '2024-05-15', '2024-06-10', 'U16', 'BSK', 'MATCHES'),
       ('Voleibol de Invierno', '2024-11-01', '2024-11-30', 'U14', 'VOL', 'ASSISTS');

INSERT INTO registrations (tournament_id, player_id, team_id)
VALUES (1, 3, NULL),
       (1, 4, NULL),
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

INSERT INTO statistics (player_id, category_code, value)
VALUES (8, 'POINTS', 15.0),
       (7, 'POINTS', 8.0),
       (7, 'MATCHES', 10.0),
       (4, 'MATCHES', 12.0),
       (5, 'TOURNAMENTS', 5.0),
       (6, 'ASSISTS', 30.0),
       (3, 'MATCHES', 10.0),
       (3, 'TOURNAMENTS', 1.0),
       (3, 'ASSISTS', 15.0);



INSERT INTO tournaments (tournament_name, start_date, end_date, league_code, sport_code, category_code)
VALUES ('Tenis Universitario 2025', '2025-04-10', '2025-05-01', 'U20', 'TEN', 'MATCHES'),
       ('Atletismo Regional', '2024-09-15', '2024-09-30', 'U16', 'ATH', 'POINTS'),
       ('Rugby Escolar', '2024-10-05', '2024-10-20', 'U12', 'RUG', 'TOURNAMENTS'),
       ('Golf de Verano', '2025-06-01', '2025-06-15', 'ADULT', 'GLF', 'MONEY'),
       ('Natación Nacional', '2024-07-01', '2024-07-20', 'U18', 'SWM', 'ASSISTS');

INSERT INTO users (email, password)
VALUES ('player7@alumnos.upm.es', 'securepass9'),
       ('player8@alumnos.upm.es', 'securepass10'),
       ('player9@alumnos.upm.es', 'securepass11'),
       ('player10@alumnos.upm.es', 'securepass12'),
       ('player11@alumnos.upm.es', 'securepass13'),
       ('player12@alumnos.upm.es', 'securepass14'),
       ('player13@alumnos.upm.es', 'securepass15');

INSERT INTO players (user_id, first_name, last_name, dni)
VALUES (9, 'Lucas', 'Martínez', '112233445X'),
       (10, 'Sofía', 'González', '223344556Z'),
       (11, 'David', 'López', '334455667Y'),
       (12, 'María', 'Hernández', '445566778Z'),
       (13, 'Carlos', 'García', '556677889X'),
       (14, 'Julieta', 'Ramos', '778899001X'),
       (15, 'Sofía', 'Torres', '112233445B');

INSERT INTO player_teams (player_id, team_id)
VALUES (15, 1),
       (14, 1),
       (9, 3),
       (10, 3),
       (11, 2),
       (12, 2),
       (13, 1);

INSERT INTO statistics (player_id, category_code, value)
VALUES (15, 'POINTS', 20.0),
       (14, 'MATCHES', 5.0),
       (9, 'ASSISTS', 12.0),
       (10, 'TOURNAMENTS', 3.0),
       (11, 'MONEY', 1500.0),
       (12, 'POINTS', 8.0),
       (13, 'MATCHES', 6.0);

INSERT INTO registrations (tournament_id, player_id, team_id)
VALUES (4, 9, NULL),
       (4, 10, NULL),
       (5, NULL, 3),
       (5, NULL, 2),
       (3, NULL, 1);

INSERT INTO matchups (tournament_id, matchup_type)
VALUES (4, 'team'),
       (5, 'individual');

INSERT INTO matchup_participants (matchup_id, player_id, team_id)
VALUES (4, NULL, 3),
       (4, NULL, 1),
       (5, 15, NULL),
       (5, 13, NULL);

INSERT INTO teams (team_name, admin_id)
VALUES ('Yellow Foxes', 2),
       ('Black Panthers', 1);

INSERT INTO player_teams (player_id, team_id)
VALUES (15, 4),
       (14, 4),
       (13, 5);

INSERT INTO statistics (player_id, category_code, value)
VALUES (14, 'ASSISTS', 18.0),
       (15, 'TOURNAMENTS', 7.0),
       (13, 'MONEY', 2000.0);