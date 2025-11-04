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

    public Rota melhorRota(String ip) {
        List<Rota> rotas = tabela.getRotas();
        Rota melhor = null;
        int melhorPrefixo = -1;

        for (Rota r : rotas) {
            if (IPUtils.pertenceRede(ip, r.getRede(), r.getMascara())) {
                int p = IPUtils.calcularPrefixo(r.getMascara());
                if (p > melhorPrefixo) {
                    melhorPrefixo = p;
                    melhor = r;
                }
            }
        }

        return melhor;
    }
}
