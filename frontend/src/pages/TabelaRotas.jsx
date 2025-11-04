import { useEffect, useState } from "react";

const API_URL = "http://localhost:4567/api/rotas";

export default function TabelaRotas() {
  const [rotas, setRotas] = useState([]);

  const listar = async () => {
    try {
      const res = await fetch(API_URL);
      const data = await res.json();
      setRotas(data);
    } catch (error) {
      console.error("Erro ao consultar rotas:", error);
    }
  };

  

  useEffect(() => {
    listar();
  }, []);

  return (
    <div>
      <h2>Tabela de Rotas</h2>

      <table style={{ width: "100%", marginTop: "20px", color: "white" }}>
        <thead>
          <tr>
            <th>Rede</th>
            <th>Máscara</th>
            <th>Gateway</th>
            
          </tr>
        </thead>
        <tbody>
          {rotas.map((r, i) => (
            <tr key={i}>
              <td>{r.rede}</td>
              <td>{r.mascara}</td>
              <td>{r.gateway}</td>
              
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
