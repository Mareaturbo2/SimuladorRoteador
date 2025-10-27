# 🧭 Simulador de Roteador com Tabela de Rotas Estáticas (Java)

## 📘 Descrição do Projeto
Este projeto é um **simulador de roteador** desenvolvido em **Java**, que lê uma tabela de rotas estáticas a partir de um arquivo JSON e determina a **melhor rota** para um IP de destino informado pelo usuário, utilizando o critério de **Longest Prefix Match**.

---

## 🎯 Objetivo
Simular o processo de decisão de roteamento de um roteador real, de forma didática e modular, aplicando conceitos de redes e programação orientada a objetos.

---

## ⚙️ Funcionalidades
- Leitura da tabela de rotas a partir de `rotas.json`;
- Conversão e comparação de endereços IP e máscaras de rede;
- Determinação da melhor rota para um IP de destino;
- Exibição do resultado no console;
- Testes automáticos de rotas conhecidas.

---

## 🧩 Estrutura de Pastas

```
/SimuladorRoteador
│
├── src/
│   ├── app/
│   │   └── Main.java              # Interação com o usuário
│   ├── model/
│   │   ├── Rota.java              # Estrutura de dados da rota
│   │   └── TabelaRotas.java       # Leitura e armazenamento das rotas
│   ├── service/
│   │   └── RoteadorService.java   # Lógica de decisão da melhor rota
│   ├── util/
│   │   └── IPUtils.java           # Utilitários para manipulação de IP
│   └── test/
│       └── RoteadorTest.java      # Casos de teste
│
└── rotas.json                     # Arquivo com rotas estáticas
```

---

## 🧠 Tecnologias Utilizadas
- **Java 17+**
- **Gson (Google)** — para leitura de arquivos JSON
- **VS Code / IntelliJ IDEA / Eclipse** — ambiente de desenvolvimento
- **GitHub** — versionamento do projeto

---

## 🧰 Como Executar o Projeto

1. **Instale o JDK 17 ou superior**  
2. **Clone ou extraia este projeto** em sua máquina  
3. **Adicione a biblioteca Gson**  
   - Via Maven (`pom.xml`):
     ```xml
     <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.10.1</version>
     </dependency>
     ```
   - Ou manualmente, adicionando o arquivo `.jar` ao classpath.  
4. Compile e execute a classe principal:
   ```bash
   javac app/Main.java
   java app.Main
   ```
5. Insira um IP de destino para testar.

---

## 📄 Exemplo de `rotas.json`

```json
[
  {"rede": "192.168.0.0", "mascara": "255.255.255.0", "gateway": "192.168.0.1"},
  {"rede": "10.0.0.0", "mascara": "255.0.0.0", "gateway": "10.0.0.1"},
  {"rede": "172.16.0.0", "mascara": "255.240.0.0", "gateway": "172.16.0.1"}
]
```

---

## 👨‍💻 Divisão de Tarefas

| Aluno | Função | Descrição |
|--------|--------|-----------|
| **Bruno** | 🧩 Estrutura e Definição do JSON | Criação do arquivo `rotas.json` e estrutura inicial do projeto. |
| **Robson** | 📄 Leitura do Arquivo | Implementação da classe `TabelaRotas` com leitura via Gson. |
| **Luiz** | 🔍 Cálculo da Melhor Rota | Lógica de decisão (Longest Prefix Match) em `RoteadorService`. |
| **Matheus K.** | 🧪 Testes | Casos de teste e validação da saída do sistema. |
| **Paulo** | ⚙️ Integração Final | Integração geral e revisão do projeto. |
| **Matheus Luna** | 💬 Interface com o Usuário | Interação via console e exibição dos resultados. |

---

## 📅 Marco 1 – Planejamento e Configuração
✅ Documento de planejamento entregue  
✅ Ambiente Java configurado  
✅ Biblioteca Gson adicionada  
✅ Código inicial (esqueleto) pronto e funcional  

---
