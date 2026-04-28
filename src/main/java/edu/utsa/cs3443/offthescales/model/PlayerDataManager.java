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

                name = data[0].trim();
                score = Integer.parseInt(data[1].trim());

                playerList.add(new Player(name, score));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: "+filePath);
            e.printStackTrace();
        }

        return playerList;
    }

}
