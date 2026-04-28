package edu.utsa.cs3443.offthescales.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDataManager {

    public List<Player> loadPlayersFromFile(String filePath) {
        List<Player> playerList = new ArrayList<Player>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name;
                int score;
                String songPlayed;

                name = data[0].trim();
                score = Integer.parseInt(data[1].trim());
                songPlayed = data[2].trim();

                playerList.add(new Player(name, score, songPlayed));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: "+filePath);
            e.printStackTrace();
        }

        return playerList;
    }

    public List<Player> getListFromSong(String songPlayed) {
        List<Player> playerList = loadPlayersFromFile("data/players.csv");
        List<Player> songPlayerList = new ArrayList<>();

        for (Player player : playerList) {
            if (player.getSongPlayed().equals(songPlayed)) {
                songPlayerList.add(player);
            }
        }

        return songPlayerList;
    }

}
