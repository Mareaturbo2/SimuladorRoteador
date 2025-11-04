package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import service.RoteadorService;
import model.Rota;

public class RoteadorTest {

    @Test
    void testeRotaLocal() {
        RoteadorService service = new RoteadorService();
        Rota rota = service.melhorRota("192.168.0.25");

        assertNotNull(rota, "Nenhuma rota encontrada!");
        assertEquals("192.168.0.1", rota.getGateway(), "Gateway incorreto para a rota!");
        System.out.println("✅ Teste rota local OK → " + rota);
    }
}