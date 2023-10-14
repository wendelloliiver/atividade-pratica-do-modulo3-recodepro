package model;

public class Destino {
    private int id;
    private String pais;
    private String cidade;
    private String clima;

    public Destino(int id, String pais, String cidade, String clima) {
        this.id = id;
        this.pais = pais;
        this.cidade = cidade;
        this.clima = clima;
    }

    public int getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public String getCidade() {
        return cidade;
    }

    public String getClima() {
        return clima;
    }
}
