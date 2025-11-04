package app;

import java.util.Scanner;
import service.RoteadorService;
import model.Rota;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoteadorService service = new RoteadorService();

        System.out.println("Digite o IP de destino: ");
        String ip = sc.nextLine();

        Rota melhor = service.melhorRota(ip);

        if (melhor != null) {
            System.out.println("✅ Melhor rota encontrada:");
            System.out.println(melhor);
        } else {
            System.out.println("❌ Nenhuma rota encontrada para esse IP!");
        }

        sc.close();
    }
}
