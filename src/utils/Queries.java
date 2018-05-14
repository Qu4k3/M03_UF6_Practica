package utils;

public class Queries {

    String queryTotalTime = "SELECT p.name AS player_name, p.nationality, c.logo, SUM(r.time) AS tiempo_total"
        + "FROM player p, run r, clan c"
        + "WHERE p.id_player = r.id_player AND p.id_clan = c.id_clan AND (SELECT COUNT(*) FROM run r2 WHERE r2.id_player = p.id_player) = 48 GROUP BY p.id_player ORDER BY tiempo_total ASC LIMIT 25";

}
