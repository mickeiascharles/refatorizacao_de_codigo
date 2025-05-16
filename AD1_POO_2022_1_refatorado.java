import java.util.Scanner;

public class AD1_POO_2022_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----Sistema de Cadastro de Clientes e Produtos----");

        Cliente cliente = new Cliente();
        Produto produto = new Produto();

        // Cadastro do Cliente
        System.out.println("Informe os dados do cliente:");
        System.out.print("Nome: ");
        cliente.setNome(sc.nextLine());

        System.out.print("CPF: ");
        cliente.setCpf(sc.nextLine());

        System.out.print("Telefone: ");
        cliente.setTelefone(sc.nextLine());

        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println(cliente);

        // Cadastro do Produto
        System.out.println("\nInforme os dados do produto:");
        System.out.print("Nome do produto: ");
        produto.setNome(sc.nextLine());

        System.out.print("Preço: ");
        while (!produto.setPreco(sc.nextLine())) {
            System.out.print("Preço inválido. Informe um número válido para o preço: ");
        }

        System.out.print("Quantidade em estoque: ");
        while (!produto.setQuantidade(sc.nextLine())) {
            System.out.print("Quantidade inválida. Informe um número inteiro válido: ");
        }

        System.out.println("\nProduto cadastrado com sucesso!");
        System.out.println(produto);

        sc.close();
    }
}

class Cliente {
    private String nome;
    private String cpf;
    private String telefone;

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim();
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.trim();
    }

    @Override
    public String toString() {
        return "Cliente{" +
               "Nome='" + nome + '\'' +
               ", CPF='" + cpf + '\'' +
               ", Telefone='" + telefone + '\'' +
               '}';
    }
}

class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    // Valida e define o preço. Retorna false se o valor for inválido.
    public boolean setPreco(String precoStr) {
        try {
            double preco = Double.parseDouble(precoStr.replace(',', '.'));
            if (preco < 0) return false;
            this.preco = preco;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Valida e define a quantidade. Retorna false se inválido.
    public boolean setQuantidade(String quantidadeStr) {
        try {
            int quantidade = Integer.parseInt(quantidadeStr);
            if (quantidade < 0) return false;
            this.quantidade = quantidade;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Produto{" +
               "Nome='" + nome + '\'' +
               ", Preço=" + preco +
               ", Quantidade=" + quantidade +
               '}';
    }
}
