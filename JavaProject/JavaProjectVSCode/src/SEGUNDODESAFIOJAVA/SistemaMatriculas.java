package SEGUNDODESAFIOJAVA;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaMatriculas {
    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Horario> horarios = new ArrayList<>();
    private List<Matricula> matriculas = new ArrayList<>();

    public static void main(String[] args) {
        SistemaMatriculas sistema = new SistemaMatriculas();
        sistema.menu();
    }

    public void menu() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Manutenção de pessoas");
            System.out.println("2. Manutenção de disciplinas");
            System.out.println("3. Manutenção de horário");
            System.out.println("4. Manutenção de matrículas");
            System.out.println("5. Exibir horário");
            System.out.println("6. Exibir matrícula do estudante");
            System.out.println("7. Exibir disciplinas por professor/tutor");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    manutencaoPessoas(scanner);
                    break;
                case 2:
                    manutencaoDisciplinas(scanner);
                    break;
                case 3:
                    manutencaoHorario(scanner);
                    break;
                case 4:
                    manutencaoMatriculas(scanner);
                    break;
                case 5:
                    exibirHorario();
                    break;
                case 6:
                    exibirMatriculaEstudante(scanner);
                    break;
                case 7:
                    exibirDisciplinasPorProfessorTutor(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void manutencaoPessoas(Scanner scanner) {
        System.out.println("Manutenção de Pessoas:");
        System.out.println("1. Adicionar Pessoa");
        System.out.println("2. Atualizar Pessoa");
        System.out.println("3. Remover Pessoa");
        System.out.println("4. Listar Pessoas");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                adicionarPessoa(scanner);
                break;
            case 2:
                atualizarPessoa(scanner);
                break;
            case 3:
                removerPessoa(scanner);
                break;
            case 4:
                listarPessoas();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void adicionarPessoa(Scanner scanner) {
        System.out.print("Tipo de Pessoa (1-Professor, 2-Tutor, 3-Estudante): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Matricula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

            // Check if the registration number already exists
        if (encontrarPessoaPorMatricula(matricula) != null) {
            System.out.println("Matricula já existe. Não é possível adicionar uma pessoa com a mesma matricula.");
            return;
    }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        switch (tipo) {
            case 1:
                System.out.print("Titulação: ");
                String titulacao = scanner.nextLine();

                System.out.print("Valor Hora: ");
                float valorHora = scanner.nextFloat();

                pessoas.add(new Professor(matricula, nome, endereco, titulacao, valorHora));
                break;

            case 2:
                System.out.print("Salário Mensal: ");
                float salarioMensal = scanner.nextFloat();
                scanner.nextLine(); // Consumir a nova linha

                System.out.print("Área de Formação: ");
                String areaFormacao = scanner.nextLine();

                pessoas.add(new Tutor(matricula, nome, endereco, salarioMensal, areaFormacao));
                break;

            case 3:
                System.out.print("Ano de Ingresso: ");
                int anoIngresso = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                System.out.print("Curso: ");
                String curso = scanner.nextLine();

                pessoas.add(new Estudante(matricula, nome, endereco, anoIngresso, curso));
                break;

            default:
                System.out.println("Tipo de pessoa inválido!");
        }
    }

    private void atualizarPessoa(Scanner scanner) {
        System.out.print("Matricula da pessoa a ser atualizada: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pessoa pessoa = encontrarPessoaPorMatricula(matricula);
        if (pessoa == null) {
            System.out.println("Pessoa não encontrada!");
            return;
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        pessoa.setNome(nome);
        pessoa.setEndereco(endereco);

        if (pessoa instanceof Professor) {
            Professor professor = (Professor) pessoa;

            System.out.print("Titulação: ");
            String titulacao = scanner.nextLine();

            System.out.print("Valor Hora: ");
            float valorHora = scanner.nextFloat();

            professor.setTitulacao(titulacao);
            professor.setValorHora(valorHora);

        } else if (pessoa instanceof Tutor) {
            Tutor tutor = (Tutor) pessoa;

            System.out.print("Salário Mensal: ");
            float salarioMensal = scanner.nextFloat();
            scanner.nextLine(); // Consumir a nova linha

            System.out.print("Área de Formação: ");
            String areaFormacao = scanner.nextLine();

            tutor.setSalarioMensal(salarioMensal);
            tutor.setAreaFormacao(areaFormacao);

        } else if (pessoa instanceof Estudante) {
            Estudante estudante = (Estudante) pessoa;

            System.out.print("Ano de Ingresso: ");
            int anoIngresso = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            System.out.print("Curso: ");
            String curso = scanner.nextLine();

            estudante.setAnoIngresso(anoIngresso);
            estudante.setCurso(curso);
        }

        System.out.println("Pessoa atualizada com sucesso!");
    }

    private void removerPessoa(Scanner scanner) {
        System.out.print("Matricula da pessoa a ser removida: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pessoa pessoa = encontrarPessoaPorMatricula(matricula);
        if (pessoa == null) {
            System.out.println("Pessoa não encontrada!");
            return;
        }

        pessoas.remove(pessoa);
        System.out.println("Pessoa removida com sucesso!");
    }

    private void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        System.out.println("Lista de Pessoas:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }

    private Pessoa encontrarPessoaPorMatricula(int matricula) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getMatricula() == matricula) {
                return pessoa;
            }
        }
        return null;
    }

    private void manutencaoDisciplinas(Scanner scanner) {
        System.out.println("Manutenção de Disciplinas:");
        System.out.println("1. Adicionar Disciplina");
        System.out.println("2. Atualizar Disciplina");
        System.out.println("3. Remover Disciplina");
        System.out.println("4. Listar Disciplinas");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                adicionarDisciplina(scanner);
                break;
            case 2:
                atualizarDisciplina(scanner);
                break;
            case 3:
                removerDisciplina(scanner);
                break;
            case 4:
                listarDisciplinas();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void adicionarDisciplina(Scanner scanner) {
        System.out.print("Tipo de Disciplina (1-Presencial, 2-EAD): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Ementa: ");
        String ementa = scanner.nextLine();

        switch (tipo) {
            case 1:
                System.out.print("Número de Aulas: ");
                int numeroAulas = scanner.nextInt();

                disciplinas.add(new DisciplinaPresencial(codigo, nome, ementa, numeroAulas));
                break;

            case 2:
                System.out.print("Número de Unidades: ");
                int numeroUnidades = scanner.nextInt();

                disciplinas.add(new DisciplinaEAD(codigo, nome, ementa, numeroUnidades));
                break;

            default:
                System.out.println("Tipo de disciplina inválido!");
        }
    }

    private void atualizarDisciplina(Scanner scanner) {
        System.out.print("Código da disciplina a ser atualizada: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Disciplina disciplina = encontrarDisciplinaPorCodigo(codigo);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Ementa: ");
        String ementa = scanner.nextLine();

        disciplina.setNome(nome);
        disciplina.setEmenta(ementa);

        if (disciplina instanceof DisciplinaPresencial) {
            DisciplinaPresencial disciplinaPresencial = (DisciplinaPresencial) disciplina;

            System.out.print("Número de Aulas: ");
            int numeroAulas = scanner.nextInt();

            disciplinaPresencial.setNumeroAulas(numeroAulas);

        } else if (disciplina instanceof DisciplinaEAD) {
            DisciplinaEAD disciplinaEAD = (DisciplinaEAD) disciplina;

            System.out.print("Número de Unidades: ");
            int numeroUnidades = scanner.nextInt();

            disciplinaEAD.setNumeroUnidades(numeroUnidades);
        }

        System.out.println("Disciplina atualizada com sucesso!");
    }

    private void removerDisciplina(Scanner scanner) {
        System.out.print("Código da disciplina a ser removida: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Disciplina disciplina = encontrarDisciplinaPorCodigo(codigo);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        disciplinas.remove(disciplina);
        System.out.println("Disciplina removida com sucesso!");
    }

    private void listarDisciplinas() {
        System.out.println("Lista de Disciplinas:");
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina);
        }
    }

    private void manutencaoHorario(Scanner scanner) {
        System.out.println("Manutenção de Horário:");
        System.out.println("1. Adicionar Horário");
        System.out.println("2. Atualizar Horário");
        System.out.println("3. Remover Horário");
        System.out.println("4. Listar Horários");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                adicionarHorario(scanner);
                break;
            case 2:
                atualizarHorario(scanner);
                break;
            case 3:
                removerHorario(scanner);
                break;
            case 4:
                listarHorarios();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void adicionarHorario(Scanner scanner) {
        System.out.print("Código da Disciplina: ");
        int codigoDisciplina = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Disciplina disciplina = encontrarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        System.out.print("Matricula do Professor: ");
        int matriculaProfessor = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pessoa pessoa = encontrarPessoaPorMatricula(matriculaProfessor);
        if (pessoa == null || !(pessoa instanceof Professor)) {
            System.out.println("Professor não encontrado ou matrícula inválida!");
            return;
        }

        Professor professor = (Professor) pessoa;

        System.out.print("Número de Vagas: ");
        int numeroVagas = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Dia da Semana: ");
        String diaSemana = scanner.nextLine();

        System.out.print("Turno (Manhã/Noite): ");
        String turno = scanner.nextLine();

        Horario horario = new Horario(disciplina, professor, numeroVagas, diaSemana, turno);
        horarios.add(horario);
        System.out.println("Horário adicionado com sucesso!");
    }

    private Disciplina encontrarDisciplinaPorCodigo(int codigo) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo() == codigo) {
                return disciplina;
            }
        }
        return null;
    }

    private void atualizarHorario(Scanner scanner) {
        System.out.print("Código da Disciplina no Horário a ser atualizado: ");
        int codigoDisciplina = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Horario horario = encontrarHorarioPorDisciplina(codigoDisciplina);
        if (horario == null) {
            System.out.println("Horário não encontrado!");
            return;
        }

        System.out.print("Matricula do Professor: ");
        int matriculaProfessor = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Professor professor = (Professor) encontrarPessoaPorMatricula(matriculaProfessor);
        if (professor == null) {
            System.out.println("Professor não encontrado!");
            return;
        }

        System.out.print("Número de Vagas: ");
        int numeroVagas = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        horario.setProfessor(professor);
        horario.setNumeroVagas(numeroVagas);

        if (horario.getDisciplina() instanceof DisciplinaPresencial) {
            System.out.print("Dia da Semana: ");
            String diaSemana = scanner.nextLine();

            System.out.print("Turno: ");
            String turno = scanner.nextLine();

            horario.setDiaSemana(diaSemana);
            horario.setTurno(turno);
        } else if (horario.getDisciplina() instanceof DisciplinaEAD) {
            System.out.print("Matricula do Tutor: ");
            int matriculaTutor = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            Tutor tutor = (Tutor) encontrarPessoaPorMatricula(matriculaTutor);
            if (tutor == null) {
                System.out.println("Tutor não encontrado!");
                return;
            }

            horario.setTutor(tutor);
        }

        System.out.println("Horário atualizado com sucesso!");
    }

    private void removerHorario(Scanner scanner) {
        System.out.print("Código da Disciplina no Horário a ser removido: ");
        int codigoDisciplina = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Horario horario = encontrarHorarioPorDisciplina(codigoDisciplina);
        if (horario == null) {
            System.out.println("Horário não encontrado!");
            return;
        }

        horarios.remove(horario);
        System.out.println("Horário removido com sucesso!");
    }

    private void listarHorarios() {
        if (horarios.isEmpty()) {
            System.out.println("Nenhum horário cadastrado.");
            return;
        }

        System.out.println("Lista de Horários:");
        for (Horario horario : horarios) {
            System.out.println(horario);
        }
    }

    private Horario encontrarHorarioPorDisciplina(int codigoDisciplina) {
        for (Horario horario : horarios) {
            if (horario.getDisciplina().getCodigo() == codigoDisciplina) {
                return horario;
            }
        }
        return null;
    }

    private void manutencaoMatriculas(Scanner scanner) {
        System.out.println("Manutenção de Matrículas:");
        System.out.println("1. Adicionar Matrícula");
        System.out.println("2. Atualizar Matrícula");
        System.out.println("3. Remover Matrícula");
        System.out.println("4. Listar Matrículas");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                adicionarMatricula(scanner);
                break;
            case 2:
                atualizarMatricula(scanner);
                break;
            case 3:
                removerMatricula(scanner);
                break;
            case 4:
                listarMatriculas();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void adicionarMatricula(Scanner scanner) {
        System.out.print("Matricula do Estudante: ");
        int matriculaEstudante = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Estudante estudante = (Estudante) encontrarPessoaPorMatricula(matriculaEstudante);
        if (estudante == null) {
            System.out.println("Estudante não encontrado!");
            return;
        }

        System.out.print("Código da Disciplina no Horário: ");
        int codigoDisciplina = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Horario horario = encontrarHorarioPorDisciplina(codigoDisciplina);
        if (horario == null) {
            System.out.println("Horário não encontrado!");
            return;
        }

        matriculas.add(new Matricula(estudante, horario));
        System.out.println("Matrícula adicionada com sucesso!");
    }

    private void atualizarMatricula(Scanner scanner) {
        System.out.print("Matricula do Estudante: ");
        int matriculaEstudante = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Código da Disciplina no Horário: ");
        int codigoDisciplina = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Matricula matricula = encontrarMatricula(matriculaEstudante, codigoDisciplina);
        if (matricula == null) {
            System.out.println("Matrícula não encontrada!");
            return;
        }

        System.out.print("Novo Código da Disciplina no Horário: ");
        int novoCodigoDisciplina = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Horario novoHorario = encontrarHorarioPorDisciplina(novoCodigoDisciplina);
        if (novoHorario == null) {
            System.out.println("Novo horário não encontrado!");
            return;
        }

        matricula.setHorario(novoHorario);
        System.out.println("Matrícula atualizada com sucesso!");
    }

    private void removerMatricula(Scanner scanner) {
        System.out.print("Matricula do Estudante: ");
        int matriculaEstudante = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Código da Disciplina no Horário: ");
        int codigoDisciplina = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Matricula matricula = encontrarMatricula(matriculaEstudante, codigoDisciplina);
        if (matricula == null) {
            System.out.println("Matrícula não encontrada!");
            return;
        }

        matriculas.remove(matricula);
        System.out.println("Matrícula removida com sucesso!");
    }

    private void listarMatriculas() {
        System.out.println("Lista de Matrículas:");
        for (Matricula matricula : matriculas) {
            System.out.println(matricula);
        }
    }

    private Matricula encontrarMatricula(int matriculaEstudante, int codigoDisciplina) {
        for (Matricula matricula : matriculas) {
            if (matricula.getEstudante().getMatricula() == matriculaEstudante &&
                matricula.getHorario().getDisciplina().getCodigo() == codigoDisciplina) {
                return matricula;
            }
        }
        return null;
    }

    private void exibirHorario() {
        listarHorarios();
    }

    private void exibirMatriculaEstudante(Scanner scanner) {
        System.out.print("Matricula do Estudante: ");
        int matriculaEstudante = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Estudante estudante = (Estudante) encontrarPessoaPorMatricula(matriculaEstudante);
        if (estudante == null) {
            System.out.println("Estudante não encontrado!");
            return;
        }

        System.out.println("Matrículas do Estudante:");
        for (Matricula matricula : matriculas) {
            if (matricula.getEstudante().equals(estudante)) {
                System.out.println(matricula);
            }
        }
    }

    private void exibirDisciplinasPorProfessorTutor(Scanner scanner) {
        System.out.print("Matricula do Professor/Tutor: ");
        int matriculaProfessorTutor = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pessoa professorTutor = encontrarPessoaPorMatricula(matriculaProfessorTutor);
        if (professorTutor == null) {
            System.out.println("Professor/Tutor não encontrado!");
            return;
        }

        System.out.println("Disciplinas do Professor/Tutor:");
        for (Horario horario : horarios) {
            if (horario.getProfessor().equals(professorTutor) || 
                (horario.getTutor() != null && horario.getTutor().equals(professorTutor))) {
                System.out.println(horario.getDisciplina());
            }
        }
    }
}
