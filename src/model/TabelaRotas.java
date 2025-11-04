package model;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class TabelaRotas {

    private List<Rota> rotas;

    public TabelaRotas() {
        carregarRotas();
    }

    private void carregarRotas() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("rotas.json");
            Rota[] array = gson.fromJson(reader, Rota[].class);
            rotas = Arrays.asList(array);
        } catch (Exception e) {
            System.out.println("Erro ao carregar rotas: " + e.getMessage());
        }
    }

    public List<Rota> getRotas() {
        return rotas;
    }
}
