import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import "./App.css";

import Roteamento from "./pages/Roteamento";
import TabelaRotas from "./pages/TabelaRotas";
import Sobre from "./pages/Sobre";

function App() {
  return (
    <BrowserRouter>
      <div className="layout">
        <aside className="sidebar">
          <h3>CISCO SIM</h3>
          <nav>
            <Link to="/">Roteamento</Link>
            <Link to="/rotas">Tabela de Rotas</Link>
            <Link to="/sobre">Sobre</Link>
          </nav>
        </aside>

        <main className="content">
          <Routes>
            <Route path="/" element={<Roteamento />} />
            <Route path="/rotas" element={<TabelaRotas />} />
            <Route path="/sobre" element={<Sobre />} />
          </Routes>

          <footer>
            🟢 Status: Conectado ao roteador
          </footer>
        </main>
      </div>
    </BrowserRouter>
  );
}

export default App;
