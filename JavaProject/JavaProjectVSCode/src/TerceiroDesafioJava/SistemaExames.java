package TerceiroDesafioJava;

import java.util.*;

public class SistemaExames {
    static List<Usuario> usuarios = new ArrayList<>();
    static List<Requisicao> requisicoes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarUsuarios();
        while (true) {
            Usuario usuarioLogado = autenticarUsuario(scanner);

            if (usuarioLogado != null) {
                mostrarMenu(scanner, usuarioLogado);
            } else {
                System.out.println("Autenticação falhou!");
            }
        }
    }

    private static void inicializarUsuarios() {
        Admin admin = new Admin(1, "admin", "admin");
        usuarios.add(admin);
    }

    private static Usuario autenticarUsuario(Scanner scanner) {
        System.out.print("Nome de usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome) && usuario.autenticar(senha)) {
                return usuario;
            }
        }

        return null;
    }

    private static void mostrarMenu(Scanner scanner, Usuario usuario) {
        int opcao;
        do {
            System.out.println("1. Criar requisição");
            System.out.println("2. Registrar coleta");
            System.out.println("3. Registrar diagnóstico");
            System.out.println("4. Consultar exames");
            System.out.println("5. Relatórios");
            if (usuario.hasRole("ADMIN")) {
                System.out.println("6. Criar usuário");
                System.out.println("7. Definir papel de usuário");
                System.out.println("9. Mostrar todos os usuários");
            }
            System.out.println("8. Trocar de usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    if (usuario.hasRole("FUNCIONARIO") || usuario.hasRole("ADMIN")) {
                        criarRequisicao(scanner);
                    } else {
                        System.out.println("Permissão negada.");
                    }
                    break;
                case 2:
                    if (usuario.hasRole("FUNCIONARIO") || usuario.hasRole("ADMIN")) {
                        registrarColeta(scanner);
                    } else {
                        System.out.println("Permissão negada.");
                    }
                    break;
                case 3:
                    if (usuario.hasRole("FUNCIONARIO") || usuario.hasRole("ADMIN")) {
                        registrarDiagnostico(scanner);
                    } else {
                        System.out.println("Permissão negada.");
                    }
                    break;
                case 4:
                    if (usuario.hasRole("PACIENTE") || usuario.hasRole("ADMIN")) {
                        consultarExames(scanner, usuario);
                    } else {
                        System.out.println("Permissão negada.");
                    }
                    break;
                case 5:
                    if (usuario.hasRole("ADMIN")) {
                        gerarRelatorios(scanner);
                    } else {
                        System.out.println("Permissão negada.");
                    }
                    break;
                case 6:
                    if (usuario.hasRole("ADMIN")) {
                        criarUsuario(scanner);
                    } else {
                        System.out.println("Permissão negada.");
                    }
                    break;
                case 7:
                    if (usuario.hasRole("ADMIN")) {
                        definirPapelDeUsuario(scanner);
                    } else {
                        System.out.println("Permissão negada.");
                    }
                    break;
                case 8:
                    System.out.println("Deslogando...");
                    return; // Retorna ao loop de autenticação para trocar de usuário
                case 9:
                    if (usuario.hasRole("ADMIN")) {
                        mostrarTodosUsuarios();
                    } else {
                        System.out.println("Permissão negada.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void criarRequisicao(Scanner scanner) {
        mostrarTodosPacientes();
        System.out.print("ID do paciente: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Paciente paciente = (Paciente) buscarUsuarioPorId(idPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        List<Exame> exames = new ArrayList<>();

        System.out.print("Quantos exames? ");
        int numExames = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numExames; i++) {
            System.out.print("Tipo do exame: ");
            String tipo = scanner.nextLine();
            System.out.print("Descrição do exame: ");
            String descricao = scanner.nextLine();

            Exame exame = new Exame(i, tipo, descricao, new Date());
            exames.add(exame);
        }

        mostrarTodosMedicos();
        System.out.print("ID do médico: ");
        int idMedico = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Medico medico = (Medico) buscarUsuarioPorId(idMedico);
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        medico.criarRequisicao(paciente, exames);

        System.out.println("Requisição criada com sucesso.");
    }

    private static void registrarColeta(Scanner scanner) {
        System.out.print("ID do exame: ");
        int idExame = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Exame exame = buscarExamePorId(idExame);
        if (exame != null) {
            System.out.print("Quantidade (ml): ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.print("Hora da coleta (HH:mm): ");
            String horaColeta = scanner.nextLine();
            // Simulação da hora como data atual para simplicidade
            Coleta coleta = new Coleta(quantidade, new Date());
            exame.registrarColeta(coleta);

            System.out.println("Coleta registrada com sucesso.");
        } else {
            System.out.println("Exame não encontrado.");
        }
    }

    private static void registrarDiagnostico(Scanner scanner) {
        System.out.print("ID do exame: ");
        int idExame = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Exame exame = buscarExamePorId(idExame);
        if (exame != null) {
            System.out.print("Resultado: ");
            String resultado = scanner.nextLine();
            System.out.print("Parecer: ");
            String parecer = scanner.nextLine();

            Diagnostico diagnostico = new Diagnostico(resultado, parecer);
            exame.registrarDiagnostico(diagnostico);

            System.out.println("Diagnóstico registrado com sucesso.");
        } else {
            System.out.println("Exame não encontrado.");
        }
    }

    private static Exame buscarExamePorId(int idExame) {
        for (Requisicao requisicao : requisicoes) {
            for (Exame exame : requisicao.getExames()) {
                if (exame.getId() == idExame) {
                    return exame;
                }
            }
        }
        return null;
    }

    private static void consultarExames(Scanner scanner, Usuario usuario) {
        if (usuario.hasRole("PACIENTE")) {
            Paciente paciente = (Paciente) usuario;
            paciente.consultarExames();
        } else {
            System.out.println("Permissão negada.");
        }
    }

    private static void gerarRelatorios(Scanner scanner) {
        System.out.println("Relatório de todos os exames realizados:");
        for (Requisicao requisicao : requisicoes) {
            System.out.println("Requisição do paciente: " + requisicao.getPaciente().getNome());
            for (Exame exame : requisicao.getExames()) {
                System.out.println(exame);
            }
        }
    }

    private static void definirPapelDeUsuario(Scanner scanner) {
        System.out.print("ID do usuário: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario != null) {
            System.out.print("Novo papel: ");
            String papel = scanner.nextLine();
            if (usuario instanceof Admin) {
                ((Admin) usuario).definirPapel(usuario, papel);
            } else {
                usuario.setPapel(papel);
                System.out.println("Papel do usuário " + usuario.getNome() + " foi alterado para " + papel);
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private static Usuario buscarUsuarioPorId(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    private static void criarUsuario(Scanner scanner) {
        System.out.print("ID do novo usuário: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Nome do novo usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Senha do novo usuário: ");
        String senha = scanner.nextLine();
        System.out.print("Papel do novo usuário: ");
        String papel = scanner.nextLine();

        Usuario novoUsuario;
        switch (papel.toUpperCase()) {
            case "PACIENTE":
                novoUsuario = new Paciente(idUsuario, nome, senha);
                break;
            case "MEDICO":
                novoUsuario = new Medico(idUsuario, nome, senha);
                break;
            case "FUNCIONARIO":
                novoUsuario = new Funcionario(idUsuario, nome, senha, papel.toUpperCase());
                break;
            default:
                System.out.println("Papel inválido. Usuário não criado.");
                return;
        }

        usuarios.add(novoUsuario);
        System.out.println("Usuário criado com sucesso.");
    }

    private static void mostrarTodosUsuarios() {
        System.out.println("Lista de todos os usuários:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", Papel: " + usuario.getPapel());
        }
    }

    private static void mostrarTodosPacientes() {
        System.out.println("Lista de todos os pacientes:");
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Paciente) {
                System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome());
            }
        }
    }

    private static void mostrarTodosMedicos() {
        System.out.println("Lista de todos os médicos:");
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Medico) {
                System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome());
            }
        }
    }
}
