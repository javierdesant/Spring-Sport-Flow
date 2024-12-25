# Resumen de Endpoints RESTful

## Público

| Método | Endpoint           | Descripción                               |
|--------|--------------------|-------------------------------------------|
| `GET`  | `/api/tournaments` | Lista torneos (participantes aleatorios). |

## Jugador

| Método   | Endpoint                                | Descripción                                     |
|----------|-----------------------------------------|-------------------------------------------------|
| `POST`   | `/api/auth/login`                       | Inicia sesión.                                  |
| `POST`   | `/api/auth/logout`                      | Cierra sesión.                                  |
| `POST`   | `/api/tournaments/{tournamentId}/join`  | Inscribe al jugador o a su equipo en un torneo. |
| `DELETE` | `/api/tournaments/{tournamentId}/leave` | Retira al jugador o a su equipo de un torneo.   |
| `GET`    | `/api/players/me/statistics`            | Consulta estadísticas del jugador autenticado.  |

## Administrador

| Método   | Endpoint                                       | Descripción                                          |
|----------|------------------------------------------------|------------------------------------------------------|
| `POST`   | `/api/auth/login`                              | Inicia sesión.                                       |
| `POST`   | `/api/auth/logout`                             | Cierra sesión.                                       |
| `POST`   | `/api/players`                                 | Crea un jugador.                                     |
| `DELETE` | `/api/players/{playerId}`                      | Elimina un jugador.                                  |
| `POST`   | `/api/teams`                                   | Crea un equipo.                                      |
| `DELETE` | `/api/teams/{teamId}`                          | Elimina un equipo.                                   |
| `PUT`    | `/api/teams/{teamId}/add-player/{playerId}`    | Añade un jugador a un equipo.                        |
| `PUT`    | `/api/teams/{teamId}/remove-player/{playerId}` | Retira un jugador de un equipo.                      |
| `POST`   | `/api/tournaments`                             | Crea un torneo.                                      |
| `DELETE` | `/api/tournaments/{tournamentId}`              | Elimina un torneo.                                   |
| `POST`   | `/api/tournaments/{tournamentId}/matchmaking`  | Realiza el emparejamiento en un torneo.              |
| `GET`    | `/api/tournaments`                             | Lista torneos con ranking y elimina los finalizados. |
