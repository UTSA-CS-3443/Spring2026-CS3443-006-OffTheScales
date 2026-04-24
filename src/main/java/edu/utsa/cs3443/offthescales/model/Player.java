package edu.utsa.cs3443.offthescales.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Player {

    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleIntegerProperty score = new SimpleIntegerProperty();

    public Player(String name, int score) {
        this.name.set(name);
        this.score.set(score);
    }

    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public SimpleStringProperty nameProperty() { return name; }

    public int getScore() { return score.get(); }
    public void setScore(int score) { this.score.set(score); }
    public SimpleIntegerProperty scoreProperty() { return score; }

}
