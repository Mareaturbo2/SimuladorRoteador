package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import service.RoteadorService;
import model.Rota;

public class RoteadorServiceTest {

    @Test
    void testMelhorRota() {
        RoteadorService service = new RoteadorService();

        Rota rota = service.melhorRota("192.168.0.55");

        assertNotNull(rota);
        assertEquals("192.168.0.0", rota.getRede());
        assertEquals("255.255.255.0", rota.getMascara());
    }

    @Test
    void testSemRota() {
    RoteadorService service = new RoteadorService();

    Rota rota = service.melhorRota("200.200.200.200");

    assertNull(rota);
}
}
