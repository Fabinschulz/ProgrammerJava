package model;

import java.util.Date;

public class Saida extends Kardex  {
	 
	private Cliente cliente;
	
	public Saida() {
		super();
	}
	
	public Saida(int id, 
		       Produto produto,
		       Cliente cliente,
		       Date data, 
		       String doc, 
		       int qtde, 
		       double valor) {
		super(id,produto,data,doc,qtde,valor);
		setCliente(cliente);
		produto.saida(this);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("Cliente não pode ser nulo!");
		}
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return "Saída [id=" + getId() + 
				", produto=" + getProduto().getNome() + 
				", cliente=" + cliente.getNome() + 
				//", data=" + getData() + 
				", qtde=" + getQtde() + 
				", valor=" + getValor() + "]";
	}	

}