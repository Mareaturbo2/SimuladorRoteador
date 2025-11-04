package model;

public class Rota {
    private String rede;
    private String mascara;
    private String gateway;

    public String getRede() {
        return rede;
    }

    public String getMascara() {
        return mascara;
    }

    public String getGateway() {
        return gateway;
    }

    @Override
    public String toString() {
        return rede + " / " + mascara + " → Gateway: " + gateway;
    }
}
