package backEnd;
import java.util.ArrayList;

public class Testes {

	public static void main(String[] args)
	{
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		for(Produtos produto : Produtos.values()) {
			produtos.add(new Produto(produto.getNome(), produto.getValorUnitario(), produto.getPromocao()));
		}
		
		Caixa checkout = new Caixa(produtos);
		checkout.adicionaProduto(Produtos.A.getNome());
		checkout.adicionaProduto(Produtos.A.getNome());
		checkout.adicionaProduto(Produtos.A.getNome());
		checkout.adicionaProduto(Produtos.C.getNome());
		checkout.adicionaProduto(Produtos.C.getNome());
		checkout.adicionaProduto(Produtos.C.getNome());
		System.out.println(checkout.toString());
		System.out.println(checkout.getPreco());
		System.out.println(checkout.getDesconto());
		System.out.println(checkout.getPrecoTotal());
		System.out.println("-----------------------------------");
		checkout.removeProduto(Produtos.A.getNome());
		System.out.println(checkout.toString());
		System.out.println(checkout.getPreco());
		System.out.println(checkout.getDesconto());
		System.out.println(checkout.getPrecoTotal());
		
		// Teste 1 (caixa zerado)
		System.out.println("\nTeste1:");
		checkout = new Caixa(produtos);
		checkout.adicionaProduto("A");
		System.out.println(checkout.getPrecoTotal() == 50);
		System.out.println(checkout.getDesconto() == 0);
		checkout.adicionaProduto("A");
		System.out.println(checkout.getPrecoTotal() == 100);
		System.out.println(checkout.getDesconto() == 0);
		checkout.adicionaProduto("A");
		System.out.println(checkout.getPrecoTotal() == 130);
		System.out.println(checkout.getDesconto() == 20);
		checkout.adicionaProduto("A");
		System.out.println(checkout.getPrecoTotal() == 180);
		System.out.println(checkout.getDesconto() == 20);
		checkout.adicionaProduto("A");
		System.out.println(checkout.getPrecoTotal() == 230);
		System.out.println(checkout.getDesconto() == 20);
		checkout.adicionaProduto("A");
		System.out.println(checkout.getPrecoTotal() == 260);
		System.out.println(checkout.getDesconto() == 40);
		checkout.removeProduto("A");
		System.out.println(checkout.getPrecoTotal() == 230);
		System.out.println(checkout.getDesconto() == 20);

		
		// Teste 2 (caixa zerado)
		System.out.println("\nTeste2:");
		checkout = new Caixa(produtos);
		checkout.adicionaProduto("D");
		System.out.println(checkout.getPrecoTotal() == 15);
		System.out.println(checkout.getDesconto() == 0);
		checkout.adicionaProduto("A");
		System.out.println(checkout.getPrecoTotal() == 65);
		System.out.println(checkout.getDesconto() == 0);
		checkout.adicionaProduto("B");
		System.out.println(checkout.getPrecoTotal() == 95);
		System.out.println(checkout.getDesconto() == 0);
		checkout.adicionaProduto("A");
		System.out.println(checkout.getPrecoTotal() == 145);
		System.out.println(checkout.getDesconto() == 0);
		checkout.adicionaProduto("B");
		System.out.println(checkout.getPrecoTotal() == 160);
		System.out.println(checkout.getDesconto() == 15);
		checkout.adicionaProduto("A");
		System.out.println(checkout.getPrecoTotal() == 190);
		System.out.println(checkout.getDesconto() == 35);
		checkout.removeProduto("A");
		System.out.println(checkout.getPrecoTotal() == 160);
		System.out.println(checkout.getDesconto() == 15);
		checkout.removeProduto("B");
		System.out.println(checkout.getPrecoTotal() == 145);
		System.out.println(checkout.getDesconto() == 0);
		
		// Teste 3 (caixa zerado)
		checkout = new Caixa(produtos);
		System.out.println("\nTeste3:");
		checkout.adicionaProduto("C");
		System.out.println(checkout.getPrecoTotal() == 20);
		System.out.println(checkout.getDesconto() == 0);
		checkout.adicionaProduto("C");
		System.out.println(checkout.getPrecoTotal() == 40);
		System.out.println(checkout.getDesconto() == 0);
		checkout.adicionaProduto("C");
		System.out.println(checkout.getPrecoTotal() == 40);
		System.out.println(checkout.getDesconto() == 20);
		checkout.adicionaProduto("C");
		System.out.println(checkout.getPrecoTotal() == 60);
		System.out.println(checkout.getDesconto() == 20);
		checkout.removeProduto("C");
		System.out.println(checkout.getPrecoTotal() == 40);
		System.out.println(checkout.getDesconto() == 20);
		checkout.removeProduto("C");
		System.out.println(checkout.getPrecoTotal() == 40);
		System.out.println(checkout.getDesconto() == 0);
		
		// Teste 4 (caixa zerado)
		checkout = new Caixa(produtos);
		System.out.println("\nTeste4:");
		checkout.adicionaProduto("C");
		System.out.println(checkout.getPrecoTotal() == 20);
		System.out.println(checkout.getDesconto() == 0);
		checkout.adicionaProduto("B");
		System.out.println(checkout.getPrecoTotal() == 50);
		System.out.println(checkout.getDesconto() == 0);
		checkout.adicionaProduto("B");
		System.out.println(checkout.getPrecoTotal() == 65);
		System.out.println(checkout.getDesconto() == 15);
		checkout.removeProduto("B");
		System.out.println(checkout.getPrecoTotal() == 50);
		System.out.println(checkout.getDesconto() == 0);

	}
}
