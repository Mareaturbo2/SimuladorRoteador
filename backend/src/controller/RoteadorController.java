package controller;

import static spark.Spark.*;

import com.google.gson.Gson;
import model.Rota;
import service.RoteadorService;

public class RoteadorController {

    private static final Gson gson = new Gson();

    public static void configurarRotas(RoteadorService service) {

        // CORS para permitir o frontend
        options("/*", (req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Methods", "GET,POST,DELETE,OPTIONS");
            res.header("Access-Control-Allow-Headers", "Content-Type");
            return "OK";
        });
        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

        get("/api/rotas", (req, res) -> {
            res.type("application/json");
            return gson.toJson(service.listarRotas());
        });

        get("/api/melhor-rota", (req, res) -> {
            res.type("application/json");
            String ip = req.queryParams("ip");
            Rota rota = service.melhorRota(ip);
            if (rota == null) {
                res.status(404);
                return "{\"erro\":\"Nenhuma rota encontrada para o IP informado\"}";
            }
            return gson.toJson(rota);
        });

        post("/api/rotas", (req, res) -> {
            res.type("application/json");
            Rota nova = gson.fromJson(req.body(), Rota.class);
            service.adicionarRota(nova);
            return "{\"mensagem\":\"Rota adicionada\"}";
        });

        
    }
}
