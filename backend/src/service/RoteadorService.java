package service;

import java.util.List;
import model.Rota;
import model.TabelaRotas;
import util.IPUtils;

public class RoteadorService {

    private TabelaRotas tabela;

    public RoteadorService() {
        tabela = new TabelaRotas();
    }

    public List<Rota> listarRotas() {
        return tabela.getRotas();
    }

    public void adicionarRota(Rota rota) {
        tabela.getRotas().add(rota);
    }

    

    public Rota melhorRota(String ip) {
        if (!IPUtils.isValidIp(ip)) {
            System.out.println("IP inválido: " + ip);
            return null;
        }

        List<Rota> rotas = tabela.getRotas();
        if (rotas == null || rotas.isEmpty()) {
            System.out.println("Tabela de rotas vazia.");
            return null;
        }

        Rota melhor = null;
        int melhorPrefixo = -1;

        for (Rota r : rotas) {
            if (r == null || r.getRede() == null || r.getMascara() == null) continue;

            if (IPUtils.pertenceRede(ip, r.getRede(), r.getMascara())) {
                int p = IPUtils.calcularPrefixo(r.getMascara());
                if (p > melhorPrefixo) {
                    melhorPrefixo = p;
                    melhor = r;
                }
            }
        }

        // Se nenhuma rota específica casar, procurar rota default 0.0.0.0/0
        if (melhor == null) {
            for (Rota r : rotas) {
                if ("0.0.0.0".equals(r.getRede()) && "0.0.0.0".equals(r.getMascara())) {
                    melhor = r;
                    break;
                }
            }
        }

        return melhor;
    }
}
