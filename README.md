# Projeto de Gerenciamento de Alunos em Java

Este projeto foi desenvolvido com o objetivo de aplicar conceitos de Programação Orientada a Objetos (POO) em Java, utilizando um banco de dados SQLite para persistência dos dados. A aplicação permite o gerenciamento básico de informações de alunos.

## 🧠 Funcionalidades

- Cadastro de alunos
- Listagem de alunos
- Armazenamento persistente com SQLite
- Arquitetura orientada a objetos
- DAO (Data Access Object) para separação da lógica de acesso a dados

## 📁 Estrutura do Projeto

```
ProjetoEvellyn-java/
├── src/
│   ├── Aluno.java          # Classe modelo representando um aluno
│   ├── AlunoDAO.java       # Classe responsável pelas operações com o banco de dados
│   └── Main.java           # Classe principal para execução do programa
├── alunos.db               # Banco de dados SQLite com os dados dos alunos
├── .gitignore              # Arquivos e pastas ignorados pelo Git
└── ProjetoEvellyn-java.iml # Arquivo de configuração do IntelliJ IDEA
```

## 🛠️ Tecnologias Utilizadas

- Java
- SQLite
- IntelliJ IDEA (opcional, mas recomendado)
- Git

## ▶️ Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/ProjetoEvellyn-java.git
   cd ProjetoEvellyn-java
   ```

2. Abra o projeto em sua IDE Java preferida (como IntelliJ ou Eclipse).

3. Certifique-se de que o banco de dados `alunos.db` esteja na raiz do projeto.

4. Execute a classe `Main.java`.

## 📌 Requisitos

- JDK 11 ou superior
- SQLite JDBC Driver (pode ser adicionado via IDE ou manualmente)

## ✍️ Autoria

Desenvolvido por **Evellyn Emanuelly da Silva Queiroz**  
Curso: Ciências da Computação - UniFavip Wyden  
Período: 5º (2025.1)

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
