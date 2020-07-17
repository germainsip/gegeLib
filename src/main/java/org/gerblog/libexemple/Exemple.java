package org.gerblog.libexemple;

import java.util.HashMap;
import java.util.Map;

public class Exemple {
    private int id;
    private String name;
    private String comment;

    public Exemple(int id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Map<String, String> elmts = new HashMap<>();

    public Exemple() {
        this.elmts.put(
                "Les boutons",
                "Exemple de code sur les boutons JavaFX"
        );
        this.elmts.put(
                "Les champs texte",
                "Les textField et la vérification de ceux ci"
        );this.elmts.put(
                "Les Sliders",
                "Les Slider et quelques exemples d'application"
        );
    }
}
