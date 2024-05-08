package br.com.clothingstore.model;

public class Clothing{


    private String id;
    private String name;


    public Clothing(String name) {
        this.name = name;
    }

    public Clothing(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }

public String getName() {
    return name;
}
    public void setName(String name) {
        this.name = name;
    }



}