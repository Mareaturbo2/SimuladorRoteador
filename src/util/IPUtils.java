package util;

public class IPUtils {

    public static int ipToInt(String ip) {
        String[] parts = ip.split("\\.");
        int result = 0;

        for (String p : parts) {
            result = result << 8;
            result |= Integer.parseInt(p);
        }

        return result;
    }

    public static int calcularPrefixo(String mask) {
        int maskInt = ipToInt(mask);
        return Integer.bitCount(maskInt);
    }

    public static boolean pertenceRede(String ip, String rede, String mascara) {
        int ipInt = ipToInt(ip);
        int redeInt = ipToInt(rede);
        int maskInt = ipToInt(mascara);

        return (ipInt & maskInt) == (redeInt & maskInt);
    }
}
