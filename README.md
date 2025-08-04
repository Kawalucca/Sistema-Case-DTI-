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

### Pré-requisitos
- Java JDK 8 ou superior instalado
- Terminal ou IDE Java (ex: VSCode, IntelliJ, NetBeans)

### Instruções
1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/Sistema-Notas-Case-DTI.git
cd Sistema-Notas-Case-DTI
javac Aluno.java SistemaNotas.java
java SistemaNotas
Entrada de dados João 7 8 6 9 10 80
