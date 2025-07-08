# Sistema Universitário

Este projeto é um sistema universitário acadêmico em Java, desenvolvido como parte de um trabalho do 3º semestre. Ele segue uma estrutura modular inspirada no padrão Maven, organizando o código em camadas como `model`, `dao`, `service`, `ui` e `utils`, mesmo sem o uso direto do Maven como gerenciador de dependências.

## 📁 Estrutura do Projeto.

```bash
SistemaUniversitario/
└── APS3Semestre/
    ├── .idea/                      # Configurações do IntelliJ
    ├── out/                        # Diretório de saída de compilação
    ├── src/
    │   └── main.java.br.edu.amazonia/
    │       ├── dao/
    │       │   ├── factory/
    │       │   │   └── EntidadeFactory.java
    │       │   ├── impl/
    │       │   │   ├── AbstractRepositorioCSV.java
    │       │   │   ├── RepositorioAlunoCSV.java
    │       │   │   ├── RepositorioAvaliacaoCSV.java
    │       │   │   ├── RepositorioCursoCSV.java
    │       │   │   ├── RepositorioDisciplinaCSV.java
    │       │   │   └── RepositorioProfessorCSV.java
    │       │   ├── Repositorio.java
    │       │   ├── RepositorioAluno.java
    │       │   ├── RepositorioAvaliacao.java
    │       │   ├── RepositorioCurso.java
    │       │   ├── RepositorioDisciplina.java
    │       │   └── RepositorioProfessor.java
    │       ├── exception/
    │       │   ├── ArquivoNaoEncontradoException.java
    │       │   ├── DadosCorruptosException.java
    │       │   ├── DadosInvalidosException.java
    │       │   ├── EntidadeNaoEncontradaException.java
    │       │   ├── NegocioException.java
    │       │   ├── PersistenciaException.java
    │       │   └── UniversidadeException.java
    │       ├── model/
    │       │   ├── Aluno.java
    │       │   ├── Avaliacao.java
    │       │   ├── Curso.java
    │       │   ├── Disciplina.java
    │       │   └── Professor.java
    │       ├── service/
    │       │   ├── impl/
    │       │   │   ├── AlunoServiceImpl.java
    │       │   │   ├── AvaliacaoServiceImpl.java
    │       │   │   ├── CursoServiceImpl.java
    │       │   │   ├── DisciplinaServiceImpl.java
    │       │   │   ├── ProfessorServiceImpl.java
    │       │   │   └── RelatorioServiceImpl.java
    │       │   ├── AlunoService.java
    │       │   ├── AvaliacaoService.java
    │       │   ├── CursoService.java
    │       │   ├── DisciplinaService.java
    │       │   ├── ProfessorService.java
    │       │   └── RelatorioService.java
    │       ├── ui/
    │       │   ├── handler/
    │       │   │   ├── AlunoUIHandler.java
    │       │   │   ├── AvaliacaoUIHandler.java
    │       │   │   ├── CursoUIHandler.java
    │       │   │   ├── DisciplinaUIHandler.java
    │       │   │   ├── ProfessorUIHandler.java
    │       │   │   └── RelatorioUIHandler.java
    │       │   ├── util/
    │       │   │   └── ConsoleUtils.java
    │       │   └── MainMenuUI.java
    │       ├── utils/
    │       │   ├── csv/
    │       │   │   └── CsvUtils.java
    │       │   ├── format/
    │       │   │   └── FormatadorUtils.java
    │       │   └── validation/
    │       │       └── ValidadorUtils.java
    │       └── App.java             # Classe principal
    ├── .gitignore
    ├── alunos.csv
    ├── avaliacao.csv
    ├── cursos.csv
    ├── disciplina.csv
    └── professores.csv
```

## 🧠 Funcionalidades.

- Cadastro, edição e listagem de:
  - Alunos
  - Professores
  - Disciplinas
  - Cursos
  - Avaliações
- Geração de relatórios
- Persistência dos dados em arquivos CSV
- Validações e tratamento de exceções customizadas
- Interface de usuário baseada em console

## 🚀 Como Executar.

### Pré-requisitos:
- Java JDK 17 ou superior
- IDE recomendada: IntelliJ IDEA

### Clonar o projeto:
```bash
git clone https://github.com/seu-usuario/sistema-universitario.git
```

### Executar:
Abrir o projeto na IDE.
Rodar a classe App.java (br.edu.amazonia.App) como aplicação Java.

## 📦 Tecnologias Utilizadas.
- Java 17
- Arquivos CSV para persistência de dados
- Estrutura de pacotes inspirada no Maven
- Programação orientada a objetos

## ⚠️ Observações.
O projeto não utiliza Maven diretamente, mas adota uma estrutura similar, facilitando futuras migrações para Maven/Gradle se necessário.
Os dados de exemplo estão disponíveis nos arquivos .csv incluídos no repositório.

👨‍💻 Autores.
[Ludmyla Coimbra Muniz Cordeiro]
