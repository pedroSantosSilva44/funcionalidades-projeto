package br.com.clothingstore.model;

public class Roupa {


    private String id;
    private String name;

    public Roupa(String name) {
        this.name = name;
    }

    public Roupa(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }

}
