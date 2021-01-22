package controller;

import java.util.ArrayList;
import java.util.Date;

import model.Cliente;
import model.Entrada;
import model.Fornecedor;
import model.Kardex;
import model.Produto;
import model.Saida;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Produto> produtos = seedProduto();
		Produto p = produtos.get(3);
		
		ArrayList<Fornecedor> fornecedores = seedFornecedor();
		Fornecedor f = fornecedores.get(0);
			
		ArrayList<Cliente> clientes = seedCliente();
		Cliente c = clientes.get(0);
		
		/*
		 * Kardex não pode ser instanciado pois é 
		 * uma classe abstrata - gerada por herança
		 */
		//Kardex k = seedKardex(p);

		System.out.println(p);
		Entrada e = seedEntrada(p,f);
		System.out.println(e);
		System.out.println(p);
		Saida s = seedSaida(p,c);
		System.out.println(s);
		System.out.println(p);
		
	}
	
	public static Saida seedSaida(Produto p, Cliente c) {
		int id = 1;
	    Date data = new Date("01/21/2021"); 
	    String doc = "NF 888";
	    int qtde = 5;
	    double valor = 450.00;
	    Saida s = new Saida(id,p,c,data,doc,qtde,valor);
	    return s;		
	}
	
	public static Entrada seedEntrada(Produto p, Fornecedor f) {
		int id = 1;
	    Date data = new Date("01/20/2021"); 
	    String doc = "NF 999";
	    int qtde = 20;
	    double valor = 350.00;
	    Entrada e = new Entrada(id,p,f,data,doc,qtde,valor);
	    return e;
	}

	public static ArrayList<Cliente> seedCliente() {
		ArrayList<Cliente> lista = new ArrayList<>();

		lista.add(new Cliente(1,"005.421.980-96",
					"William Gates III","(11) 91111-2222",
					"bill@microsoft.com"));
		lista.add(new Cliente(2,"034.750.010-20",
					"Elon Musk","(11) 99999-9999",
					"elon@spacex.com"));		
		lista.add(new Cliente(3,"393.892.870-06",
					"Nikola Tesla","(11) 98765-4321",
					"nikola@tesla.com"));
		
		return lista;
	}
	
	public static ArrayList<Fornecedor> seedFornecedor() {
		ArrayList<Fornecedor> lista = new ArrayList<>();

		lista.add(new Fornecedor (1,"46.388.927/0001-41",
				  "Microsoft Corporation","1112345678",
				  "vendas@microsoft.com"));
		lista.add(new Fornecedor (2,"13.433.432/0001-38",
				  "Kingston Cards","2122225555",
				  "vendas@kingston.com"));
		lista.add(new Fornecedor (3,"07.720.304/0001-72",
				  "Samsung Inc.","1199999999",
				  "sales@samsung.com"));	
		
		return lista;
	}
	
	public static ArrayList<Produto> seedProduto() {
		ArrayList<Produto> lista = new ArrayList<>();
		
		int id = 1;
		String nome = "Pente de memória 16GB DDR4 2666Mhz";
		String localizacao = "Prateleira 3 Caixa 5";
		int qtdeMaxima = 100;
		int qtdeMinima = 20;
		int qtdeEstoque = 80;
		Produto p = new Produto(id,nome,localizacao,
								qtdeMaxima,qtdeMinima,qtdeEstoque);
		lista.add(p);
		
		lista.add(new Produto(2,"Teclado ABNT para notebook",
				  "Prateleira 4 Caixa 2",200,10,10));
		lista.add(new Produto(3,"Monitor Full HD IPS 23.4",
				  "Prateleira 7",50,5,5));
		lista.add(new Produto(4,"Mouse Gamer 2400 5 botões",
				  "Prateleira 4 Caixa 5",200,10,30));
		lista.add(new Produto(5,"Headset BM800",
				  "Prateleira 2 Caixa 10",100,10,20));

		return lista;
	}
	
//	public static Kardex seedKardex(Produto p) {
//		int id = 1;
//		Date data = new Date("19/01/2021");
//		String doc = "NF 1234";
//		int qtde = 10;
//		double valor = 1000;	
//		Kardex k = new Kardex(id,p,data,doc,qtde,valor);
//		return k;
//	}
	
}