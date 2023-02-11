package sg.edu.nus.iss.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import sg.edu.nus.iss.server.models.Game;
import sg.edu.nus.iss.server.services.GameService;

@Controller
@RequestMapping(path = "/api")
public class GameController {
    
    @Autowired
    private GameService gameSvc;

    // localhost:8080/api/games?name={name}
    @GetMapping(value = "/games", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getGames(@RequestParam String name) {
        System.out.printf(">>> Query String: name=%s\n", name);
        List<Game> gameList = gameSvc.findGameByName(name);
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Game game:gameList) {
            jab.add(game.toJSON());
        }
        return ResponseEntity.ok(jab.build().toString());
    }
}
