package br.com.ifood.domain;

import java.util.*;

public class CadastroFuncionario {

    public static void main(String[] args) {

        Map<Integer, Gerente> gerente = new HashMap<>();

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n=====[Cadastro de Funcionários]=====");
            System.out.println("[1] Cadastrar Gerente");
            System.out.println("[2] Lista de Gerentes [total]");
            System.out.println("[3] Gerente com maior salário");
            System.out.println("[4] Gerente com menor salário");
            System.out.println("[5] Total salário de todos os Gerentes");
            System.out.println("[6] Total gerentes por turno");
            System.out.println("[7] Sair");
            System.out.print("Opção => ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    i++;
                    cadastrarGerente(gerente);
                    break;
                case 2:
                    listarGerente(gerente);
                    break;
                case 3:
                    maiorSalarioGerente(gerente);
                    break;
                case 4:
                    menorSalarioGerente(gerente);
                    break;
                case 5:
                    System.out.println("Total salário dos gerentes: " + totalSalarioGerente(gerente));
                    break;
                case 6:
                    quantidadeGerentesPorTurno(gerente);
                    break;
                case 7:
                    System.exit(0);
                default:
                    return;
            }
    }
}

    /**
     *  / INICIO DAS FUNÇÕES /
     */
    static int i = 0;

    public static void cadastrarGerente(Map<Integer, Gerente> gerenteMap) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Digite o nome do gerente: ");
        String nome = sc.nextLine();
        System.out.print("Digite a idade: ");
        Integer idade = sc.nextInt();
        System.out.print("Digite o salário: R$");
        Double salario = sc.nextDouble();
        System.out.print("Turno: ");
        String turno = sc.next().toLowerCase();

        gerenteMap.put(i, new Gerente(nome, idade, salario, turno));
        sc.nextLine();
    }

    public static void listarGerente(Map<Integer, Gerente> gerenteMap) {
        System.out.println("============================[Lista Gerentes]============================");
        for (Map.Entry<Integer, Gerente> entry : gerenteMap.entrySet()) {
            if (entry != null) {
                System.out.println(entry.getKey() +
                        " - Nome: " + entry.getValue().getNome() +
                        "\tIdade: " + entry.getValue().getIdade() +
                        "\tSalário: " + String.format("R$%.2f", entry.getValue().getSalario()) +
                        "\tTurno: " + entry.getValue().getTurno());
            }
        }
        System.out.println("Total: " + totalGerente(gerenteMap));
    }

    public static Integer totalGerente(Map<Integer, Gerente> gerenteMap) {
        return gerenteMap.size();
    }

    public static void maiorSalarioGerente(Map<Integer, Gerente> gerenteMap) {
        Set<Map.Entry<Integer, Gerente>> entries = gerenteMap.entrySet();
        Double maiorSalario = 0d;
        String gerenteComMaiorSalario = "";
        for (Map.Entry<Integer, Gerente> entry : entries){
            if (entry.getValue().getSalario() > maiorSalario){
                maiorSalario = entry.getValue().getSalario();
                gerenteComMaiorSalario = entry.getValue().getNome();
            }
        }
        System.out.println("========Gerente com maior salário========");
        System.out.println("Gerente: " + gerenteComMaiorSalario + " | Salário: " + String.format("R$%.2f", maiorSalario));
    }

    public static void menorSalarioGerente(Map<Integer, Gerente> gerenteMap) {
        Set<Map.Entry<Integer, Gerente>> entries = gerenteMap.entrySet();
        Double menorSalario = 10000d;
        String gerenteComMenorSalario = "";
        for (Map.Entry<Integer, Gerente> entry : entries){
            if (entry.getValue().getSalario() < menorSalario){
                menorSalario = entry.getValue().getSalario();
                gerenteComMenorSalario = entry.getValue().getNome();
            }
        }
        System.out.println("========Gerente com menor salário========");
        System.out.println("Gerente: " + gerenteComMenorSalario + " | Salário: " + String.format("R$%.2f", menorSalario));
    }

    public static String totalSalarioGerente(Map<Integer, Gerente> gerenteMap) {
        Double soma = 0d;
        for (Map.Entry<Integer, Gerente> entry : gerenteMap.entrySet()) {
            soma += entry.getValue().getSalario();
        }
        return String.format("R$%.2f", soma);
    }
    
    public static void quantidadeGerentesPorTurno(Map<Integer, Gerente> gerenteMap) {
        int qtdManha = 0, qtdTarde = 0, qtdNoite = 0;
        for (Map.Entry<Integer, Gerente> entry : gerenteMap.entrySet()) {
            if (entry.getValue().getTurno().equals("manhã")) {
                qtdManha++;
            } else if (entry.getValue().getTurno().equals("tarde")) {
                qtdTarde++;
            } else if (entry.getValue().getTurno().equals("noite")) {
                qtdNoite++;
            }
        }
        System.out.println("========Quantidade de gerentes por turno=========");
        System.out.println("Manhã: " + qtdManha + " | Tarde: " + qtdTarde + " | Noite: " + qtdNoite);
    }
}
