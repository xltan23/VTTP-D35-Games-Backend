package sg.edu.nus.iss.server.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Game {
    
    // Defining members
    private int gameId;
    private String name;
    private int year;
    private int ranking;
    private int usersRated;
    private String url;
    private String image;

    // Generate Getter and Setters
    public int getGameId() {
        return gameId;
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    public int getUsersRated() {
        return usersRated;
    }
    public void setUsersRated(int usersRated) {
        this.usersRated = usersRated;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Game [gameId=" + gameId + ", name=" + name + ", year=" + year + ", ranking=" + ranking + ", usersRated="
                + usersRated + ", url=" + url + ", image=" + image + "]";
    }

    // Convert Game Object to JsonObject
    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                    .add("gameId", gameId)
                    .add("name", name)
                    .add("year", year)
                    .add("ranking", ranking)
                    .add("usersRated", usersRated)
                    .add("url", url)
                    .add("image", image)
                    .build();
    }

    // Convert SqlRowSet to Game Object
    public static Game create(SqlRowSet srs) {
        Game game = new Game();
        game.setGameId(srs.getInt("gid"));
        game.setName(srs.getString("name"));
        game.setYear(srs.getInt("year"));
        game.setRanking(srs.getInt("ranking"));
        game.setUsersRated(srs.getInt("users_rated"));
        game.setUrl(srs.getString("url"));
        game.setImage(srs.getString("image"));
        return game;
    }
}
