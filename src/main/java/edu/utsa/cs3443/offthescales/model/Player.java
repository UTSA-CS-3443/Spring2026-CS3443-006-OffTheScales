package edu.utsa.cs3443.offthescales.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Player {

    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleIntegerProperty score = new SimpleIntegerProperty();
    private final SimpleStringProperty songPlayed = new SimpleStringProperty();

    public Player(String name, int score, String songPlayed) {
        this.name.set(name);
        this.score.set(score);
        this.songPlayed.set(songPlayed);
    }

    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public SimpleStringProperty nameProperty() { return name; }

    public int getScore() { return score.get(); }
    public void setScore(int score) { this.score.set(score); }
    public SimpleIntegerProperty scoreProperty() { return score; }

    public String getSongPlayed() { return songPlayed.get(); }
    public void setSongPlayed(String songPlayed) { this.songPlayed.set(songPlayed); }
    public SimpleStringProperty songPlayedProperty() { return songPlayed; }

}
