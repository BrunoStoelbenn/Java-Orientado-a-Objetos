import java.util.*;

// Enum para os cargos dos funcionários
enum Cargo {
    GERENTE, ANALISTA, ASSISTENTE, ESTAGIARIO
}

// Classe Funcionário
class Funcionario {
    private String nome;
    private Cargo cargo;
    private double salario;

    // Construtor
    public Funcionario(String nome, Cargo cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método para exibir informações do funcionário
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: R$" + salario);
    }
}

public class SistemaFuncionarios {
    public static void main(String[] args) {
        // Usando Array normal para armazenar os funcionários
        Funcionario[] funcionariosArray = new Funcionario[10];
        
        // Usando ArrayList para armazenar os funcionários
        List<Funcionario> funcionariosList = new ArrayList<>();
        
        // Usando Vector para armazenar os funcionários
        Vector<Funcionario> funcionariosVector = new Vector<>();

        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n*** Menu ***");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Mostrar Funcionários");
            System.out.println("3. Editar Funcionário");
            System.out.println("4. Excluir Funcionário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarFuncionario(funcionariosArray, funcionariosList, funcionariosVector, scanner);
                    break;
                case 2:
                    mostrarFuncionarios(funcionariosArray, funcionariosList, funcionariosVector);
                    break;
                case 3:
                    editarFuncionario(funcionariosArray, funcionariosList, funcionariosVector, scanner);
                    break;
                case 4:
                    excluirFuncionario(funcionariosArray, funcionariosList, funcionariosVector, scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    // Método para adicionar funcionário
    public static void adicionarFuncionario(Funcionario[] funcionariosArray, List<Funcionario> funcionariosList, Vector<Funcionario> funcionariosVector, Scanner scanner) {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        Cargo cargo;
        do {
            System.out.println("Escolha o cargo do funcionário:");
            System.out.println(Arrays.toString(Cargo.values()));
            String cargoStr = scanner.next();
            try {
                cargo = Cargo.valueOf(cargoStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Cargo inválido. Escolha um cargo da lista.");
                cargo = null;
            }
        } while (cargo == null);

        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();

        Funcionario novoFuncionario = new Funcionario(nome, cargo, salario);
        funcionariosArray[buscarProximaPosicao(funcionariosArray)] = novoFuncionario;
        funcionariosList.add(novoFuncionario);
        funcionariosVector.add(novoFuncionario);
    }

    // Método para mostrar funcionários
    public static void mostrarFuncionarios(Funcionario[] funcionariosArray, List<Funcionario> funcionariosList, Vector<Funcionario> funcionariosVector) {
        System.out.println("\nFuncionários (Array):");
        for (Funcionario funcionario : funcionariosArray) {
            if (funcionario != null) {
                funcionario.mostrarInformacoes();
            }
        }

        System.out.println("\nFuncionários (ArrayList):");
        for (Funcionario funcionario : funcionariosList) {
            funcionario.mostrarInformacoes();
        }

        System.out.println("\nFuncionários (Vector):");
        for (Funcionario funcionario : funcionariosVector) {
            funcionario.mostrarInformacoes();
        }
    }

    // Método para editar funcionário
    public static void editarFuncionario(Funcionario[] funcionariosArray, List<Funcionario> funcionariosList, Vector<Funcionario> funcionariosVector, Scanner scanner) {
        System.out.print("Digite o nome do funcionário que deseja editar: ");
        String nome = scanner.nextLine();

        Funcionario funcionario = buscarFuncionario(nome, funcionariosArray, funcionariosList, funcionariosVector);
        if (funcionario != null) {
            System.out.println("Digite as novas informações do funcionário:");
            System.out.print("Digite o nome do funcionário: ");
            String novoNome = scanner.nextLine();
            Cargo cargo;
            funcionario.setNome(novoNome);
            do {
                System.out.println("Escolha o cargo do funcionário:");
                System.out.println(Arrays.toString(Cargo.values()));
                String cargoStr = scanner.next();
                try {
                    cargo = Cargo.valueOf(cargoStr.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Cargo inválido. Escolha um cargo da lista.");
                    cargo = null;
                }
            } while (cargo == null);
            funcionario.setCargo(cargo);
            System.out.print("Digite o salário do funcionário: ");
            double salario = scanner.nextDouble();
            funcionario.setSalario(salario);
            System.out.println("Funcionário editado com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Método para excluir funcionário
    public static void excluirFuncionario(Funcionario[] funcionariosArray, List<Funcionario> funcionariosList, Vector<Funcionario> funcionariosVector, Scanner scanner) {
        System.out.print("Digite o nome do funcionário que deseja excluir: ");
        String nome = scanner.nextLine();

        Funcionario funcionario = buscarFuncionario(nome, funcionariosArray, funcionariosList, funcionariosVector);
        if (funcionario != null) {
            removerFuncionario(funcionario, funcionariosArray, funcionariosList, funcionariosVector);
            System.out.println("Funcionário excluído com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Método para buscar a próxima posição disponível no Array
    public static int buscarProximaPosicao(Funcionario[] funcionariosArray) {
        for (int i = 0; i < funcionariosArray.length; i++) {
            if (funcionariosArray[i] == null) {
                return i;
            }
        }
        return -1;
    }

    // Método para buscar um funcionário por nome
    public static Funcionario buscarFuncionario(String nome, Funcionario[] funcionariosArray, List<Funcionario> funcionariosList, Vector<Funcionario> funcionariosVector) {
        for (Funcionario funcionario : funcionariosArray) {
            if (funcionario != null && funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }

        for (Funcionario funcionario : funcionariosList) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }

        for (Funcionario funcionario : funcionariosVector) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }

        return null;
    }

    // Método para remover um funcionário
    public static void removerFuncionario(Funcionario funcionario, Funcionario[] funcionariosArray, List<Funcionario> funcionariosList, Vector<Funcionario> funcionariosVector) {
        for (int i = 0; i < funcionariosArray.length; i++) {
            if (funcionariosArray[i] == funcionario) {
                funcionariosArray[i] = null;
                break;
            }
        }
        funcionariosList.remove(funcionario);
        funcionariosVector.remove(funcionario);
    }
}
