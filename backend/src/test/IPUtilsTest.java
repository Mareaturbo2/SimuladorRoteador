package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import util.IPUtils;

public class IPUtilsTest {

    @Test
    void testEnderecoValido() {
        assertTrue(IPUtils.isValidIp("192.168.0.55"));
        assertTrue(IPUtils.isValidIp("10.0.0.1"));
    }

    @Test
    void testEnderecoInvalido() {
        assertFalse(IPUtils.isValidIp("300.168.0.1"));
        assertFalse(IPUtils.isValidIp("abc.def.ghi.jkl"));
    }

    @Test
    void testPertenceRede() {
        assertTrue(IPUtils.pertenceRede(
                "192.168.0.55", "192.168.0.0", "255.255.255.0"));
    }

    @Test
    void testPertenceRedeFalha() {
        assertFalse(IPUtils.pertenceRede(
                "172.16.0.1", "192.168.0.0", "255.255.255.0"));
    }
}
