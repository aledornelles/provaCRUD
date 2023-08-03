package provacrud;

import javax.swing.JOptionPane;
import java.util.ArrayList;



public class Main {
    private String nome;
    private String qtd;
    private String valor;

    public Main(String nome, String qtd, String valor) {
        this.nome = nome;
        this.qtd = qtd;
        this.valor = valor;
    }

    public static void main(String[] args) {
        ArrayList<Main> produto = new ArrayList<>();

        while (true) {
            String[] opcoes = { "Adicionar", "Estoque", "Atualizar", "Deletar", "Sair" };
            int escolha = JOptionPane.showOptionDialog(null, "JõJoias:", "Ecommerce",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0: 
                    String nome = JOptionPane.showInputDialog("Nome do produto:");
                    String qtd = JOptionPane.showInputDialog("Qtd estoque");
                    String valor = JOptionPane.showInputDialog(("Valor produto "));
                    produto.add(new Main(nome, qtd, valor));
                    break;

                case 1: 
                    StringBuilder output = new StringBuilder("JõJoias\n");
                    produto.stream().map((prod) -> {
                        output.append("\nProduto: ").append(prod.nome);
                return prod;
            }).map((prod) -> {
                output.append("\nQtd estoque: ").append(prod.qtd);
                return prod;
            }).forEachOrdered((prod) -> {
                output.append("\nValor produto: " + "R$ ").append(prod.valor).append("\n");
            });
                    JOptionPane.showMessageDialog(null, output.toString());
                    break;

                case 2: 
                    int indexToUpdate = Integer.parseInt(JOptionPane.showInputDialog("Qual o indice do produto para atualizar"));
                    if (indexToUpdate >= 0 && indexToUpdate < produto.size()) {
                        Main prodToUpdate = produto.get(indexToUpdate);
                        nome = JOptionPane.showInputDialog("Digite novo produto");
                        qtd = JOptionPane.showInputDialog("Digite a nova qtd");
                        valor = JOptionPane.showInputDialog("Digite o novo valor");
                        prodToUpdate.nome = nome;
                        prodToUpdate.qtd = qtd;
                        prodToUpdate.valor = valor;
                        JOptionPane.showMessageDialog(null, "produto atualizado");
                    } else {
                        JOptionPane.showMessageDialog(null, "produto nao encontrado");
                    }
                    break;

                case 3: 
                    int indexToDelete = Integer.parseInt(JOptionPane.showInputDialog("Digite o índice do produto para excluir"));
                    if (indexToDelete >= 0 && indexToDelete < produto.size()) {
                        produto.remove(indexToDelete);
                        JOptionPane.showMessageDialog(null, "produto excluído com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "produto nao encontrado inválido!");
                    }
                    break;

                case 4: 
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
  
    }
}