package it.itispaleocapa.sonzognig;

public class Socio {
    String nome;
    String cognome;
    int eta;
    String sesso;

    public Socio(String nome, String cognome, int eta, String sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.sesso = sesso;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getSesso() {
        return sesso;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}