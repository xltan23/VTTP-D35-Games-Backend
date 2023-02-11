package sg.edu.nus.iss.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.server.models.Game;
import sg.edu.nus.iss.server.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepo;

    // Format name to %name% for MySQL query
    public List<Game> findGameByName(String name) {
        return gameRepo.findGamesByName("%%%s%%".formatted(name));
    }
}
