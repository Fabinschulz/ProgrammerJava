package model;

import java.util.Date;

public class Entrada extends Kardex {
		
		private Fornecedor fornecedor;

		public Entrada() {
			super();
		}
		
		public Entrada(int id, 
				       Produto produto,
				       Fornecedor fornecedor,
				       Date data, 
				       String doc, 
				       int qtde, 
				       double valor) {
			super(id,produto,data,doc,qtde,valor);
			setFornecedor(fornecedor);
			produto.entrada(this);
		}

		public Fornecedor getFornecedor() {
			return fornecedor;
		}

		public void setFornecedor(Fornecedor fornecedor) {
			if (fornecedor == null) {
				throw new IllegalArgumentException("Fornecedor não pode ser nulo!");
			}
			this.fornecedor = fornecedor;
		}
		
		@Override
		public String toString() {
			return "Entrada [id=" + getId() + 
					", produto=" + getProduto().getNome() + 
					", fornecedor=" + fornecedor.getNome() + 
					//", data=" + getData() + 
					", qtde=" + getQtde() + 
					", valor=" + getValor() + "]";
		}
		
	}

		
	
		

		