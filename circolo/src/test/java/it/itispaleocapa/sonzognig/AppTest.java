package it.itispaleocapa.sonzognig;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple App.
 */
class AppTest {
    
    Circolo circolo = new Circolo();
    
    @Test
    void socioTest() {
        Socio socio = new Socio("Giovanni", "Sonzogni", 18, "M");
        assertEquals("Giovanni", socio.getNome());
        assertEquals("Sonzogni", socio.getCognome());
        assertEquals(18, socio.getEta());
        assertEquals("M", socio.getSesso());
    }

    @Test
    void aggiungiSocioTest() {
        Socio socio = new Socio("Giovanni", "Sonzogni", 18, "M");
        circolo.aggiungiSocio(socio);
        assertEquals(1, circolo.soci.size());
    }

    @Test
    void eliminaSocioTest() {
        Socio socio = new Socio("Giovanni", "Sonzogni", 18, "M");
        circolo.aggiungiSocio(socio);
        circolo.eliminaSocio("Giovanni", "Sonzogni");
        assertEquals(0, circolo.soci.size());
    }

    @Test
    void modificaSocioTest() {
        Socio socio = new Socio("Giovanni", "Sonzogni", 18, "M");
        circolo.aggiungiSocio(socio);
        Socio socio2 = new Socio("Giovanni", "Sonzogni", 19, "M");
        circolo.modificaSocio("Giovanni", "Sonzogni", socio2);
        assertEquals(1, circolo.soci.size());
        assertEquals(19, circolo.soci.get("Giovanni").getEta());
    }

    @Test
    void incrementoEtaTest() {
        Socio socio = new Socio("Giovanni", "Sonzogni", 18, "M");
        Socio socio2 = new Socio("Giovanna", "Sonzogni", 20, "F");
        circolo.aggiungiSocio(socio);
        circolo.aggiungiSocio(socio2);
        circolo.incrementoEta();
        assertEquals(19, circolo.soci.get("Giovanni").getEta());
        assertEquals(21, circolo.soci.get("Giovanna").getEta());
    }

    @Test
    void etaMediaSociTest() {
        Socio socio = new Socio("Giovanni", "Sonzogni", 18, "M");
        Socio socio2 = new Socio("Giovanna", "Sonzogni", 20, "F");
        circolo.aggiungiSocio(socio);
        circolo.aggiungiSocio(socio2);
        assertEquals(19, circolo.etaMediaSoci());
    }

    @Test
    void etaMediaSessoTest() {
        Socio socio = new Socio("Giovanni", "Sonzogni", 18, "M");
        Socio socio2 = new Socio("Giovanna", "Sonzogni", 20, "F");
        circolo.aggiungiSocio(socio);
        circolo.aggiungiSocio(socio2);
        assertEquals(18, circolo.etaMediaSesso("M"));
        assertEquals(20, circolo.etaMediaSesso("F"));
    }

    @Test
    void distribuzionePercentualeSessoTest() {
        Socio socio = new Socio("Giovanni", "Sonzogni", 18, "M");
        Socio socio2 = new Socio("Giovanna", "Sonzogni", 20, "F");
        Socio socio3 = new Socio("Giovannina", "Sonzogni", 20, "F");
        Socio socio4 = new Socio("Giovannona", "Sonzogni", 20, "F");
        circolo.aggiungiSocio(socio);
        circolo.aggiungiSocio(socio2);
        circolo.aggiungiSocio(socio3);
        circolo.aggiungiSocio(socio4);
        assertEquals(25, circolo.distribuzionePercentualeSesso("M"));
        assertEquals(75, circolo.distribuzionePercentualeSesso("F"));
    }

    @Test
    void SocioNonEsistenteExceptionTest(){
        assertThrows(SocioNonEsistenteException.class, () -> circolo.eliminaSocio("Andrea", "Gritti"));
        assertThrows(SocioNonEsistenteException.class, () -> circolo.modificaSocio("Andrea", "Gritti", new Socio("Andrea", "Gritti", 18, "M")));
    }

    @Test
    void NessunSocioExceptionTest(){
        assertThrows(NessunSocioException.class, () -> circolo.incrementoEta());
        assertThrows(NessunSocioException.class, () -> circolo.etaMediaSoci());
        assertThrows(NessunSocioException.class, () -> circolo.etaMediaSesso("M"));
        assertThrows(NessunSocioException.class, () -> circolo.distribuzioneSesso("M"));
        assertThrows(NessunSocioException.class, () -> circolo.distribuzionePercentualeSesso("M"));
    }
}
