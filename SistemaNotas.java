// Sistema de Notas Professor Carlos Case DTI

import java.util.*;

class Aluno {
    String nome;
    double[] notas = new double[5];
    double frequencia;

    public Aluno(String nome, double[] notas, double frequencia) {
        this.nome = nome;
        this.notas = notas;
        this.frequencia = frequencia;
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }
}

public class SistemaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();

        System.out.println("Digite os dados dos alunos (nome, 5 notas de 0 a 10 e frequência (0 a 100, sem %)). Digite 'resumo' para encerrar:");
        while (true) {
            String linha = scanner.nextLine();
            if (linha.equalsIgnoreCase("resumo")) break;

            String[] partes = linha.split(" ");
            if (partes.length != 7) {
                System.out.println("Formato inválido. Exemplo correto: João 7 8 6 9 10 80");
                continue;
            }

            try {
                String nome = partes[0];
                double[] notas = new double[5];
                boolean notaValida = true;

                for (int i = 0; i < 5; i++) {
                    notas[i] = Double.parseDouble(partes[i + 1]);
                    if (notas[i] < 0 || notas[i] > 10) {
                        notaValida = false;
                    }
                }

                if (!notaValida) {
                    System.out.println("Erro: Todas as notas devem estar entre 0 e 10.");
                    continue;
                }

                double frequencia = Double.parseDouble(partes[6]);
                if (frequencia < 0 || frequencia > 100) {
                    System.out.println("Erro: Frequência deve estar entre 0 e 100.");
                    continue;
                }

                alunos.add(new Aluno(nome, notas, frequencia));
            } catch (NumberFormatException e) {
                System.out.println("Erro: use apenas números válidos para notas e frequência.");
            }
        }

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno inserido.");
            return;
        }

        // Médias por disciplina
        double[] mediaDisciplinas = new double[5];
        for (Aluno aluno : alunos) {
            for (int i = 0; i < 5; i++) {
                mediaDisciplinas[i] += aluno.notas[i];
            }
        }
        for (int i = 0; i < 5; i++) {
            mediaDisciplinas[i] /= alunos.size();
        }

        // Média da turma geral
        double somaMediaGeral = 0;
        for (Aluno aluno : alunos) {
            somaMediaGeral += aluno.calcularMedia();
        }
        double mediaTurma = somaMediaGeral / alunos.size();

        // Impressão do resumo
        System.out.println("\n== Dados dos alunos ==");
        for (Aluno aluno : alunos) {
            System.out.printf("%s %.2f %.1f%%\n", aluno.nome, aluno.calcularMedia(), aluno.frequencia);
        }

        System.out.println("\n== Média da turma por disciplina ==");
        for (int i = 0; i < 5; i++) {
            System.out.printf("Disciplina %d: %.2f\n", i + 1, mediaDisciplinas[i]);
        }

        /*Fiquei em duvida se era pra considerar os alunos acima da media geral
        da turma, ou acima da media da turma por disciplina(o que ocasionaria em algo
        um pouco mais extenso.)*/

        System.out.println("\n== Alunos com média acima da média da turma ==");
        boolean encontrou = false;
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() > mediaTurma) {
                System.out.println(aluno.nome);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println();

        System.out.println("\n== Alunos com frequência abaixo de 75% ==");
        encontrou = false;
        for (Aluno aluno : alunos) {
            if (aluno.frequencia < 75) {
                System.out.println(aluno.nome);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println();

        scanner.close();
    }
}
