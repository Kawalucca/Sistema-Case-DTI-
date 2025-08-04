# Sistema-Case-DTI-
Este projeto foi desenvolvido para o processo seletivo da DTI Digital.  
Consiste em um sistema de linha de comando em Java que permite ao professor Carlos inserir notas e frequência dos alunos, com geração de relatórios automáticos.

---

## Funcionalidades

- Cadastro de alunos com:
  - Nome
  - Notas de 5 disciplinas (valores entre 0 e 10)
  - Frequência (entre 0% e 100%)

- Cálculos automáticos:
  - Média individual de cada aluno
  - Média da turma em cada disciplina
  - Média geral da turma
  - Lista de alunos com média **acima da média da turma**
  - Lista de alunos com **frequência abaixo de 75%**

---

## Como executar o sistema

1. Certifique-se de ter o Java instalado (JDK 8+).

2. Compile os arquivos:

```bash
javac Aluno.java SistemaNotas.java
