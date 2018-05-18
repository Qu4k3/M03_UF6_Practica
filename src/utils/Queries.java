package utils;

public class Queries {

    public static String queryTracks = "SELECT id_track, name, abrv FROM track";
    
    public static String queryPlayers = "SELECT p.id_player, p.id_clan, c.acronym, p.name FROM player p, clan c WHERE p.id_clan = c.id_clan";

    public static String queryInsertRun = "INSERT INTO `run` (`id_player`, `id_track`, `time`) VALUES (?, ?, ?);";
    /* id_player, id_track, time(mil) */

    public static String queryNewClan = "INSERT INTO `clan` (`name`, `acronym`, `division`, `status`) VALUES (?, ?, ?, ?);";
    /* name, acronym, division, status */

    public static String queryDropClan = "DELETE FROM `clan` WHERE `clan`.`acronym` = ?";
    /* acronym */

    public static String queryUpdatePlayerClan = "UPDATE `player` SET `id_clan` = ? WHERE `player`.`id_player` = ?";
    /* id_clan, id_player */

    public static String queryTotalTime = "SELECT p.name AS player_name, p.nationality, c.logo, SUM(r.time) AS tiempo_total FROM player p, run r, clan c WHERE p.id_player = r.id_player AND p.id_clan = c.id_clan AND (SELECT COUNT(*) FROM run r2 WHERE r2.id_player = p.id_player) = 48 GROUP BY p.id_player ORDER BY tiempo_total ASC LIMIT 25";

    public static String queryWorldRecord = "SELECT wr.name, wr.flag, wr.time FROM wr WHERE wr.game_mode = '150cc' AND wr.id_track = ?";

    public static String queryTopPlayersList = "SELECT p.name AS player_name, p.nationality, r.time, c.logo FROM player p, run r, clan c WHERE r.game_name = 'MK8DX' AND r.game_mode = '150cc' AND r.id_track = ? AND p.id_player = r.id_player AND p.id_clan = c.id_clan ORDER BY r.time ASC LIMIT 10";

    public static String queryTopPlayersListByClan = "SELECT p.name AS player_name, p.nationality, r.time, c.logo FROM player p, run r, clan c WHERE r.game_name = 'MK8DX' AND r.game_mode = '150cc' AND r.id_track = ? AND p.id_player = r.id_player AND p.id_clan = c.id_clan AND c.acronym = ? ORDER BY r.time ASC LIMIT 10";

    public static String queryListClans = "SELECT c.acronym, c.logo, c.name FROM clan c ORDER BY c.acronym";
}
