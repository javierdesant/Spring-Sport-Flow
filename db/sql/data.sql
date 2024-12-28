\c sportflow_db;

-- String password = nombre + "123";
INSERT INTO users (email, password)
VALUES ('james.kirk@upm.es', '$2a$10$qmEcW3S/SWFqlWF7Ss1ZkOdGl96Dt8bOiAP5Da/aUMwsH9Kap2PUa'),
       ('agent.smith@upm.es', '$2a$10$9LfCQonwlohiFX7QL9nvKOsNXX1s1rhgDNtFAKCq8hq7VbgZelRBC'),
       ('tyler.durden@alumnos.upm.es', '$2a$10$GGfioRX1G7Omq4FFrCW22OJdixlQnB32bd/6Re.vE//hClJaToznm'),
       ('leia.organa@alumnos.upm.es', '$2a$10$uFKH4u1EsslRC8pgiQRtPOwMrmF5Izlmqo1J5LO.KuiafZVedmA9y'),
       ('ellen.ripley@alumnos.upm.es', '$2a$10$yn50jHAL2KR3cODFm1Ua9.I32gcbn5TWdFyeAV1DgDJh5jdPwId3K'),
       ('marty.mcfly@alumnos.upm.es', '$2a$10$coXR4DMqv/8bFq.XVUaLM..a9BOWjhV2kt8HmOmFS1vf7wEOxIB8S'),
       ('forrest.gump@alumnos.upm.es', '$2a$10$4/BMdoUUpL9P.Cx1QCdhZ.kBppahnNrNxlJNdzyDOpfz95cpRpNTW'),
       ('nathan.algren@alumnos.upm.es', '$2a$10$OAsu1gNPk8CxVrJXSQOY...PuXxSlChXWjKYimQdeKG5DRFtQPcB6'),
       ('frodo.baggins@alumnos.upm.es', '$2a$10$76uXwdVb2WiXhZftxf5uIu4ta.F6XEg/TkZNqqFKotDmGBffsKnLu'),
       ('aragorn.elessar@alumnos.upm.es', '$2a$10$GKeNSuu2eP9XD52HHnWTGeTEbaTUCF9uhw8ykmdEAOhGWpVARQcjO'),
       ('tony.stark@alumnos.upm.es', '$2a$10$AGsV.LegtNgI1nhYt13OPOuPMGUY6Jxg9KWTfRjhbnEjbW6rlbKKu'),
       ('jack.sparrow@alumnos.upm.es', '$2a$10$PJRF.ru/cm2pmRbTkfvIDO8oTAnWSOlN0usXCiCJGNhbCh/txrrQy'),
       ('bruce.wayne@alumnos.upm.es', '$2a$10$2n77tqnuCyckIegi6W6xOeOhheVDTDBla1XuWzIKzN5t6gxnVRDsa'),
       ('severus.snape@alumnos.upm.es', '$2a$10$tTRzQBoS7VrAv/mlwMo3keZj1RasALslHZa7D09Mj1Wpfrhy0p7SG'),
       ('natasha.romanoff@alumnos.upm.es', '$2a$10$8KRz2CFmxKCtqTLv0yIJ2OjjYwqOR/BE/H1rs1l4mDZInyD4fooWW');

INSERT INTO administrators (user_id)
VALUES (1),
       (2);

INSERT INTO players (user_id, first_name, last_name, dni, admin_id)
VALUES (3, 'Tyler', 'Durden', '123456789A', 1),
       (4, 'Leia', 'Organa', '987654321B', 2),
       (5, 'Ellen', 'Ripley', '876543210C', 1),
       (6, 'Marty', 'McFly', '456789123D', 2),
       (7, 'Forrest', 'Gump', '789123456E', 1),
       (8, 'Nathan', 'Algren', '321098765F', 1),
       (9, 'Frodo', 'Baggins', '112233445X', 1),
       (10, 'Aragorn', 'Elessar', '223344556Z', NULL),
       (11, 'Tony', 'Stark', '334455667Y', 1),
       (12, 'Jack', 'Sparrow', '445566778Z', NULL),
       (13, 'Bruce', 'Wayne', '556677889X', 1),
       (14, 'Severus', 'Snape', '778899001X', 2),
       (15, 'Natasha', 'Romanoff', '112233445B', 1);

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
       ('Green Falcons', 1),
       ('Yellow Foxes', 2),
       ('Black Panthers', 1);

INSERT INTO player_teams (player_id, team_id)
VALUES (8, 1),
       (7, 1),
       (3, 2),
       (4, 2),
       (5, 3),
       (6, 3),
       (9, 3),
       (10, 3),
       (11, 2),
       (12, 2),
       (13, 1),
       (13, 5),
       (15, 4),
       (14, 4),
       (15, 1),
       (14, 1);

INSERT INTO tournaments (tournament_name, start_date, end_date, league_code, sport_code, category_code)
VALUES ('Fútbol UPM 2024', '2024-03-01', '2024-03-20', 'U18', 'FBL', 'POINTS'),
       ('Baloncesto de Primavera', '2024-05-15', '2024-06-10', 'U16', 'BSK', 'MATCHES'),
       ('Voleibol de Invierno', '2024-11-01', '2024-11-30', 'U14', 'VOL', 'ASSISTS'),
       ('Tenis Universitario 2025', '2025-04-10', '2025-05-01', 'U20', 'TEN', 'MATCHES'),
       ('Atletismo Regional', '2024-09-15', '2024-09-30', 'U16', 'ATH', 'POINTS'),
       ('Rugby Escolar', '2024-10-05', '2024-10-20', 'U12', 'RUG', 'TOURNAMENTS'),
       ('Golf de Verano', '2025-06-01', '2025-06-15', 'ADULT', 'GLF', 'MONEY'),
       ('Natación Nacional', '2024-07-01', '2024-07-20', 'U18', 'SWM', 'ASSISTS');

INSERT INTO registrations (tournament_id, player_id, team_id)
VALUES (1, 3, NULL),
       (1, 4, NULL),
       (2, NULL, 1),
       (3, NULL, 2),
       (3, NULL, 3),
       (4, 9, NULL),
       (4, 10, NULL),
       (5, NULL, 3),
       (5, NULL, 2),
       (3, NULL, 1);

INSERT INTO matchups (tournament_id, matchup_type)
VALUES (1, 'individual'),
       (2, 'team'),
       (3, 'team'),
       (4, 'team'),
       (5, 'individual');

INSERT INTO matchup_participants (matchup_id, player_id, team_id)
VALUES (1, 3, NULL),
       (1, 4, NULL),
       (2, NULL, 1),
       (3, NULL, 2),
       (3, NULL, 3),
       (4, NULL, 3),
       (4, NULL, 1),
       (5, 15, NULL),
       (5, 13, NULL);

INSERT INTO statistics (player_id, category_code, value)
VALUES (3, 'MATCHES', 10.0),
       (3, 'TOURNAMENTS', 1.0),
       (3, 'ASSISTS', 15.0),
       (4, 'MATCHES', 12.0),
       (5, 'TOURNAMENTS', 5.0),
       (6, 'ASSISTS', 30.0),
       (7, 'POINTS', 8.0),
       (7, 'MATCHES', 10.0),
       (8, 'POINTS', 15.0),
       (9, 'ASSISTS', 12.0),
       (10, 'TOURNAMENTS', 3.0),
       (11, 'MONEY', 1500.0),
       (12, 'POINTS', 8.0),
       (13, 'MATCHES', 6.0),
       (13, 'MONEY', 2000.0),
       (14, 'ASSISTS', 18.0),
       (14, 'MATCHES', 5.0),
       (15, 'POINTS', 20.0),
       (15, 'TOURNAMENTS', 7.0);
