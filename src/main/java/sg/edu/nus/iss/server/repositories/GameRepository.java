package sg.edu.nus.iss.server.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.server.models.Game;

import static sg.edu.nus.iss.server.repositories.Queries.*;

@Repository
public class GameRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Search game table in Bgg database to retrieve list of games with name in it
    public List<Game> findGamesByName(String name) {
        List<Game> gameList = new LinkedList<>();
        // Query MySQL for Boardgame names that possess name
        SqlRowSet srs = jdbcTemplate.queryForRowSet(SQL_SELECT_GAME_BY_NAME, name);
        while(srs.next()) {
            gameList.add(Game.create(srs));
        }
        return gameList;
    }
}
