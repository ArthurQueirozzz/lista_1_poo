/* 
1. Herança em Java é um conceito da Programação Orientada a Objetos (POO) que permite que uma classe herde propriedades e métodos de outra classe. O principal benefício da herança é o reaproveitamento de código, o que significa que podemos criar novas classes baseadas em classes existentes, sem a necessidade de reescrever código.
Exemplo: se você tiver uma classe `Animal` com métodos comuns a todos os animais, pode criar uma classe `Cachorro` que herda da classe `Animal`, sem precisar duplicar os métodos comuns.

2. O modificador `super` é utilizado para acessar membros (atributos e métodos) de uma classe pai (superclasse) a partir de uma classe filha (subclasse). Ele é útil, por exemplo, para chamar o construtor da classe pai ou acessar um método ou atributo que foi sobrescrito na subclasse.

3. Polimorfismo é a capacidade de um objeto assumir várias formas. Em Java, isso pode ser alcançado através de herança e interfaces, permitindo que diferentes classes implementem métodos de forma distinta. Um exemplo prático seria uma classe `Animal` com um método `emitirSom()`. A classe `Cachorro` poderia sobrescrever esse método para emitir "latido", enquanto a classe `Gato` faria o mesmo, mas com "miado". Isso torna o código mais flexível e reutilizável.
*/

public class AtividadeJava {

    // 4 - Herança Simples
    public static class Pessoa {
        private String nome;
        private int idade;

        // Construtor
        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        // Método para exibir informações
        public void exibirInformacoes() {
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
        }
    }

    public static class Aluno extends Pessoa {
        private String matricula;

        // Construtor
        public Aluno(String nome, int idade, String matricula) {
            super(nome, idade); // Chama o construtor da classe Pessoa
            this.matricula = matricula;
        }

        // Sobrescrita do método exibirInformacoes
        @Override
        public void exibirInformacoes() {
            super.exibirInformacoes(); // Chama o método da classe Pessoa
            System.out.println("Matrícula: " + matricula);
        }
    }

    // 5 - Herança com Métodos Sobrescritos
    public static class Funcionario {
        private String nome;
        private double salario;

        // Construtor
        public Funcionario(String nome, double salario) {
            this.nome = nome;
            this.salario = salario;
        }

        // Método para calcular bônus (10%)
        public double calcularBonus() {
            return salario * 0.10;
        }
    }

    public static class Gerente extends Funcionario {

        // Construtor
        public Gerente(String nome, double salario) {
            super(nome, salario); // Chama o construtor da classe Funcionario
        }

        // Sobrescrita do método calcularBonus (20% para Gerente)
        @Override
        public double calcularBonus() {
            return super.calcularBonus() * 2; // Bônus de 20% para o gerente
        }
    }

    // 6 - Polimorfismo em Ação
    public static class Animal {
        public void emitirSom() {
            System.out.println("Som genérico de animal");
        }
    }

    public static class Cachorro extends Animal {
        @Override
        public void emitirSom() {
            System.out.println("Latido");
        }
    }

    public static class Gato extends Animal {
        @Override
        public void emitirSom() {
            System.out.println("Miado");
        }
    }

    // 7 - Herança Múltipla através de Interfaces
    public interface Trabalhador {
        void trabalhar();
    }

    public static class Estudante {
        private String nome;
        private String curso;

        // Construtor
        public Estudante(String nome, String curso) {
            this.nome = nome;
            this.curso = curso;
        }

        // Métodos da classe Estudante
        public void exibirInformacoes() {
            System.out.println("Nome do Estudante: " + nome);
            System.out.println("Curso: " + curso);
        }
    }

    public static class Estagiario extends Estudante implements Trabalhador {
        public Estagiario(String nome, String curso) {
            super(nome, curso); // Chama o construtor da classe Estudante
        }

        // Implementação do método da interface Trabalhador
        @Override
        public void trabalhar() {
            System.out.println("Estagiário trabalhando...");
        }
    }

    public static void main(String[] args) {
        // 4 - Testando a Herança Simples
        Aluno aluno = new Aluno("Maria", 20, "12345");
        aluno.exibirInformacoes(); // Exibe informações do aluno

        // 5 - Testando Herança com Métodos Sobrescritos
        Funcionario funcionario = new Funcionario("Carlos", 3000.0);
        Gerente gerente = new Gerente("Ana", 5000.0);
        
        System.out.println("Bônus do Funcionário: R$" + funcionario.calcularBonus());
        System.out.println("Bônus do Gerente: R$" + gerente.calcularBonus());

        // 6 - Testando Polimorfismo em Ação
        Animal[] animais = new Animal[2];
        animais[0] = new Cachorro();
        animais[1] = new Gato();

        for (Animal animal : animais) {
            animal.emitirSom(); // Chama o método emitido de forma polimórfica
        }

        // 7 - Testando Herança Múltipla através de Interfaces
        Estagiario estagiario = new Estagiario("João", "Engenharia");
        estagiario.exibirInformacoes();
        estagiario.trabalhar(); // Chama o método da interface
    }
}
