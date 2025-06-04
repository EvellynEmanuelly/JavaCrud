import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Gerenciamento de Alunos ---");
            System.out.println("1. Inserir aluno");
            System.out.println("2. Listar todos os alunos");
            System.out.println("3. Buscar aluno por ID");
            System.out.println("4. Atualizar aluno");
            System.out.println("5. Deletar aluno");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    inserirAluno(alunoDAO, scanner);
                    break;
                case 2:
                    listarAlunos(alunoDAO);
                    break;
                case 3:
                    buscarAlunoPorId(alunoDAO, scanner);
                    break;
                case 4:
                    atualizarAluno(alunoDAO, scanner);
                    break;
                case 5:
                    deletarAluno(alunoDAO, scanner);
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        alunoDAO.fecharConexao();
        scanner.close();
    }

    private static void inserirAluno(AlunoDAO alunoDAO, Scanner scanner) {
        System.out.println("\n--- Inserir Novo Aluno ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        Aluno aluno = new Aluno(nome, idade, curso);
        alunoDAO.inserir(aluno);
    }

    private static void listarAlunos(AlunoDAO alunoDAO) {
        System.out.println("\n--- Lista de Alunos ---");
        List<Aluno> alunos = alunoDAO.listarTodos();

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    private static void buscarAlunoPorId(AlunoDAO alunoDAO, Scanner scanner) {
        System.out.println("\n--- Buscar Aluno por ID ---");
        System.out.print("Digite o ID do aluno: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = alunoDAO.buscarPorId(id);

        if (aluno != null) {
            System.out.println("\nAluno encontrado:");
            System.out.println(aluno);
        } else {
            System.out.println("Aluno não encontrado com o ID " + id);
        }
    }

    private static void atualizarAluno(AlunoDAO alunoDAO, Scanner scanner) {
        System.out.println("\n--- Atualizar Aluno ---");
        System.out.print("Digite o ID do aluno a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = alunoDAO.buscarPorId(id);

        if (aluno != null) {
            System.out.println("\nDados atuais do aluno:");
            System.out.println(aluno);

            System.out.print("Novo nome (deixe em branco para manter): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) {
                aluno.setNome(nome);
            }

            System.out.print("Nova idade (digite 0 para manter): ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            if (idade != 0) {
                aluno.setIdade(idade);
            }

            System.out.print("Novo curso (deixe em branco para manter): ");
            String curso = scanner.nextLine();
            if (!curso.isEmpty()) {
                aluno.setCurso(curso);
            }

            alunoDAO.atualizar(aluno);
        } else {
            System.out.println("Aluno não encontrado com o ID " + id);
        }
    }

    private static void deletarAluno(AlunoDAO alunoDAO, Scanner scanner) {
        System.out.println("\n--- Deletar Aluno ---");
        System.out.print("Digite o ID do aluno a ser deletado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = alunoDAO.buscarPorId(id);

        if (aluno != null) {
            System.out.println("\nDados do aluno a ser deletado:");
            System.out.println(aluno);

            System.out.print("Tem certeza que deseja deletar este aluno? (S/N): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                alunoDAO.deletar(id);
            } else {
                System.out.println("Operação cancelada.");
            }
        } else {
            System.out.println("Aluno não encontrado com o ID " + id);
        }
    }
}