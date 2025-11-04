package util;

public class IPUtils {

    public static boolean isValidIp(String ip) {
        if (ip == null) return false;
        String[] parts = ip.trim().split("\\.");
        if (parts.length != 4) return false;
        try {
            for (String p : parts) {
                if (p.isEmpty()) return false;
                int v = Integer.parseInt(p);
                if (v < 0 || v > 255) return false;
                // Evita zeros à esquerda
                if (!String.valueOf(v).equals(p)) {
                    if (!(v == 0 && p.equals("0"))) return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int ipToInt(String ip) {
        String[] parts = ip.split("\\.");
        int result = 0;
        for (String p : parts) {
            result = (result << 8) | Integer.parseInt(p);
        }
        return result;
    }

    public static int calcularPrefixo(String mask) {
        int maskInt = ipToInt(mask);
        return Integer.bitCount(maskInt);
    }

    public static boolean pertenceRede(String ip, String rede, String mascara) {
        int ipInt   = ipToInt(ip);
        int redeInt = ipToInt(rede);
        int maskInt = ipToInt(mascara);
        return (ipInt & maskInt) == (redeInt & maskInt);
    }

    public static boolean isDefaultMask(String mascara) {
        return "0.0.0.0".equals(mascara);
    }
}
