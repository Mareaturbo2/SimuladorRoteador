
# 🧭 Simulador de Roteador com Interface Web Estilo Cisco 🚀

> Projeto acadêmico — Redes de Computadores  
> Interface inspirada em equipamentos Cisco

---

## 📘 Descrição Geral do Projeto

O **Simulador de Roteador** é um sistema completo composto por:

✅ **Backend Java com Spark** que simula o processo de roteamento  
✅ **Algoritmo de Longest Prefix Match** para determinar o melhor caminho  
✅ **Frontend React + Vite** com interface estilo **Cisco WebUI**  
✅ Visualização da tabela de rotas estáticas  
✅ Comunicação via API REST

📌 Objetivo: Demonstrar de forma didática o funcionamento de roteadores reais.

---

## 🧠 Funcionalidades do Sistema

| Funcionalidade | Status |
|---|:---:|
| Consulta de melhor rota | ✅ |
| Visualização da tabela de rotas | ✅ |
| Interface Cisco-like | ✅ |
| Tratamento de erros e validações | ✅ |

---

## 🔌 Arquitetura do Sistema

```mermaid
flowchart LR
A[Frontend React + Vite] -- HTTP / JSON --> B[API Spark Java - Backend]
B --> C[Arquivo rotas.json]
```

---

## 📂 Estrutura do Projeto

```
SimuladorRoteador/
│
├── backend/
│   ├── src/
│   │   ├── app/Main.java
│   │   ├── controller/RoteadorController.java
│   │   ├── model/(Rota.java, TabelaRotas.java)
│   │   ├── service/RoteadorService.java
│   │   └── util/IPUtils.java
│   └── rotas.json
│
└── frontend/
    ├── src/
    │   ├── App.jsx
    │   ├── App.css
    │   └── pages/(Roteamento.jsx, TabelaRotas.jsx, Sobre.jsx)
    └── package.json
```

---

## 📡 API REST – Endpoints

| Método | Rota | Função |
|---|---|---|
| GET | `/api/rotas` | Lista todas as rotas |
| GET | `/api/melhor-rota?ip=x.x.x.x` | Retorna a melhor rota |

Exemplo de resposta:

```json
{
  "rede": "192.168.0.0",
  "mascara": "255.255.255.0",
  "gateway": "192.168.0.1"
}
```

---

## ⚙️ Como Executar

🔹 **Backend**

```bash
cd backend
javac -cp "lib/*;src" src/**/*.java
java -cp "lib/*;src" app.Main
```

Servidor disponível em:

👉 http://localhost:4567/

---

🔹 **Frontend**

```bash
cd frontend
npm install
npm run dev
```

Acesso no navegador:

👉 http://localhost:5173/

---

## 🧪 Testes sugeridos

| Entrada | Resultado Esperado |
|---|---|
| `192.168.0.55` | Rota da rede `192.168.0.0/24` |
| `10.1.2.3` | Rota `10.0.0.0/8` |
| IP inválido | Mensagem de erro |

---

## 🎯 Longest Prefix Match (Resumo)

O roteador compara o IP de destino com todas as redes conhecidas e escolhe a rota com **maior número de bits idênticos** após aplicar a máscara.

✔ Garante que o pacote siga pela rota mais específica.

---

## 🖥️ Interface do Sistema

> (Inserir prints após exportação)

- Tela de Consulta de Rotas  
- Tela de Tabela de Rotas  
- Tela Sobre

---

## 👨‍💻 Créditos da Equipe

| Integrante | Função |
|---|---|
| **Bruno** | Estrutura do JSON e início do projeto |
| **Robson** | Leitura da tabela de rotas |
| **Luiz** | Algoritmo LPM |
| **Matheus K.** | Testes iniciais |
| **Paulo** | Integração geral, Backend REST e Interface Web |
| **Matheus Luna** | Interação com o usuário |

---

## ✅ Status Final do Projeto

| Marco | Resultado |
|---|:---:|
| Planejamento e Configuração | ✅ |
| Funcionalidade básica | ✅ |
| Interface e recursos extras | ✅ |
| Documentação e preparação da apresentação | ✅ |

---

## 🚀 Possíveis Melhorias Futuras

- Inclusão de rotas dinâmicas (RIP/OSPF)
- Testes automatizados das requisições
- Interface com mais recursos visuais

---

# ✅ Conclusão

✔ Projeto **100% funcional**, documentado e pronto para apresentação ✅  
📡 Demonstra prática de conceitos essenciais de **roteamento em redes**

---
