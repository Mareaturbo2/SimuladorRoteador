import { useState } from "react";
import "../App.css";

const API_URL = "http://localhost:4567/api";

export default function Roteamento() {
  const [ip, setIp] = useState("");
  const [rota, setRota] = useState(null);
  const [erro, setErro] = useState("");

  const consultarRota = async () => {
    setErro("");
    setRota(null);

    if (!ip.trim()) {
      setErro("Informe um endereço IP.");
      return;
    }

    try {
      const res = await fetch(`${API_URL}/melhor-rota?ip=${ip}`);
      const data = await res.json();
      if (!res.ok) {
        setErro(data.erro);
        return;
      }
      setRota(data);

    } catch {
      setErro("Falha de comunicação com o roteador.");
    }
  };

  return (
    <>
      <h2>Simulador de Roteamento Cisco</h2>
      <div className="card">
        <label>IP de Destino</label>
        <input
          placeholder="Ex: 192.168.0.10"
          value={ip}
          onChange={e => setIp(e.target.value)}
        />
        <button onClick={consultarRota}>Consultar Melhor Rota</button>

        {erro && <p className="erro">{erro}</p>}

        {rota && (
          <div className="resultado">
            <p><strong>Rede:</strong> {rota.rede}</p>
            <p><strong>Máscara:</strong> {rota.mascara}</p>
            <p><strong>Gateway:</strong> {rota.gateway}</p>
          </div>
        )}
      </div>
    </>
  );
}
