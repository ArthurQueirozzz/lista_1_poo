/* 
1-Encapsulamento é um conceito da Programação Orientada a Objetos (POO) que significa "esconder" os detalhes internos de uma classe. Ou seja, a classe controla o acesso aos seus dados, permitindo que outras classes interajam com ela, mas sem poder modificar diretamente seus atributos.
A importância do encapsulamento é garantir que os dados dentro de uma classe sejam usados de forma segura e controlada. Isso evita que outras partes do programa alterem os dados de maneira indesejada, mantendo o programa mais organizado e confiável. 

2-Construtor padrão: É o construtor que a linguagem cria automaticamente para você quando você não define nenhum. Ele não recebe nenhum parâmetro e simplesmente cria o objeto com valores padrão (como 0 ou null).
Construtor parametrizado: É um construtor que você define e que recebe parâmetros. Você passa valores para o construtor na hora de criar o objeto, e ele usa esses valores para inicializar o objeto de uma forma mais específica.

3-Se uma classe não tiver um construtor definido por você, o compilador vai criar um construtor padrão automaticamente. Esse construtor vai inicializar os atributos da classe com valores padrão. No entanto, se você definir um construtor, o construtor padrão não será mais gerado automaticamente.
*/

4 e 5-
public class ContaBancaria {
    // Atributos da conta
    private String titular;
    private double saldo;

    // Construtor para criar uma conta
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para depositar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    // Método para sacar
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }

    // Método para exibir saldo
    public void exibirSaldo() {
        System.out.println("Saldo de " + titular + ": R$" + saldo);
    }

    public static void main(String[] args) {
        // Criando uma conta bancária e testando os métodos
        ContaBancaria conta = new ContaBancaria("João", 500.0);
        conta.exibirSaldo(); // Exibe o saldo inicial
        conta.depositar(150.0); // Deposita R$150,00
        conta.sacar(100.0); // Saca R$100,00
        conta.exibirSaldo(); // Exibe o saldo após as operações
    }
}

6-
public class Produto {
    // Atributos do produto
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    // Construtor para criar um produto
    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Método para adicionar estoque
    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque += quantidade;
        }
    }

    // Método para remover estoque
    public void removerEstoque(int quantidade) {
        if (quantidade > 0 && quantidadeEstoque >= quantidade) {
            quantidadeEstoque -= quantidade;
        } else {
            System.out.println("Estoque insuficiente ou quantidade inválida!");
        }
    }

    // Método para exibir informações do produto
    public void exibirInformacoes() {
        System.out.println("Produto: " + nome);
        System.out.println("Preço: R$" + preco);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
    }

    public static void main(String[] args) {
        // Criando um produto e testando os métodos
        Produto produto = new Produto("Notebook", 3500.0, 10);
        produto.exibirInformacoes();
        produto.adicionarEstoque(5); // Adiciona 5 unidades ao estoque
        produto.removerEstoque(3); // Remove 3 unidades do estoque
        produto.exibirInformacoes(); // Exibe as informações do produto após as operações
    }
}

7-
public class Carro {
    // Atributos do carro
    private String marca;
    private String modelo;
    private int ano;
    private int velocidadeAtual;

    // Construtor para criar um carro
    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidadeAtual = 0; // Inicia a velocidade com 0
    }

    // Método para acelerar
    public void acelerar(int valor) {
        if (valor > 0) {
            velocidadeAtual += valor;
        }
    }

    // Método para frear
    public void frear(int valor) {
        if (valor > 0) {
            velocidadeAtual -= valor;
            if (velocidadeAtual < 0) {
                velocidadeAtual = 0; // Não permite velocidade negativa
            }
        }
    }

    // Método para exibir informações do carro
    public void exibirInformacoes() {
        System.out.println("Carro: " + marca + " " + modelo + " (" + ano + ")");
        System.out.println("Velocidade atual: " + velocidadeAtual + " km/h");
    }

    public static void main(String[] args) {
        // Criando um carro e testando os métodos
        Carro carro = new Carro("Fiat", "Uno", 2015);
        carro.exibirInformacoes();
        carro.acelerar(50); // Acelera o carro
        carro.frear(20); // Diminui a velocidade
        carro.exibirInformacoes(); // Exibe as informações do carro após as operações
    }
}
