/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */
 package com.example.player.controller;

 import org.springframework.web.bind.annotation.RestController;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.PutMapping;
 import org.springframework.web.bind.annotation.DeleteMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestBody;
 import com.example.player.model.Player;
 import com.example.player.service.PlayerH2Service;
 import org.springframework.beans.factory.annotation.Autowired;
 import java.util.*;

 @RestController 
 public class PlayerController {

    @Autowired 
    PlayerH2Service playerH2Service;

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return playerH2Service.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId) {
        return playerH2Service.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerH2Service.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@RequestBody Player player, @PathVariable("playerId") int playerId){
        return playerH2Service.updatePlayer(player, playerId);
    }

    @DeleteMapping("players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
        playerH2Service.deletePlayer(playerId);
    }
    
 }
