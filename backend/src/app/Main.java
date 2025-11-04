package app;

import controller.RoteadorController;
import service.RoteadorService;

public class Main {
    public static void main(String[] args) {
        RoteadorService service = new RoteadorService();
        RoteadorController.configurarRotas(service);
        System.out.println("✅ Servidor rodando em http://localhost:4567/");
    }
}
