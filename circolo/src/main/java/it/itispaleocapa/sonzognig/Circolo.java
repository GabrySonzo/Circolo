package it.itispaleocapa.sonzognig;

import java.util.HashMap;

public class Circolo {
    HashMap<String, Socio> soci;
    
    public Circolo() {
        soci = new HashMap<String, Socio>();
    }

    public void aggiungiSocio(Socio socio) {
        soci.put(socio.getNome(), socio);
    }

    public void eliminaSocio(String nome, String cognome) {
        if(!soci.containsKey(nome)) {
            throw new SocioNonEsistenteException();
        }
        soci.values().removeIf(socio -> socio.getNome().equals(nome) && socio.getCognome().equals(cognome));
    }

    public void modificaSocio(String nome, String cognome, Socio socio) {
        eliminaSocio(nome, cognome);
        aggiungiSocio(socio);
    }

    public void incrementoEta() {
        if(soci.isEmpty()) {
            throw new NessunSocioException();
        }
        soci.values().forEach(socio -> socio.setEta(socio.getEta() + 1));
    }

    public double etaMediaSoci() {
        if(soci.isEmpty()) {
            throw new NessunSocioException();
        }
        return soci.values().stream().mapToInt(Socio::getEta).average().getAsDouble();
    }

    public double etaMediaSesso(String sesso) {
        if(soci.values().stream().filter(socio -> socio.getSesso().equals(sesso)).count() == 0) {
            throw new NessunSocioException();
        }
        return soci.values().stream().filter(socio -> socio.getSesso().equals(sesso)).mapToInt(Socio::getEta).average().getAsDouble();
    }

    public double distribuzioneSesso(String sesso) {
        if(soci.values().stream().filter(socio -> socio.getSesso().equals(sesso)).count() == 0) {
            throw new NessunSocioException();
        }
        return soci.values().stream().filter(socio -> socio.getSesso().equals(sesso)).count();
    }

    public double distribuzionePercentualeSesso(String sesso){
        return distribuzioneSesso(sesso) / soci.size() * 100;
    }

    
}