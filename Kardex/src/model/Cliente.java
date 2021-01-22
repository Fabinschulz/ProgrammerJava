package model;

	public class Cliente {

		private int id;
		private String cpf;
		private String nome;
		private String celular;
		private String email;
		
		public Cliente() {
			super();
		}

		public Cliente(int id, String cpf, String nome, String celular, String email) {
			super();
			setId(id);
			setCpf(cpf);
			setNome(nome);
			setCelular(celular);
			setEmail(email);
		}

		public int getId() {
			return id;
		}

		private void setId(int id) {
			this.id = id;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			if (nome.isEmpty()) {
				throw new IllegalArgumentException("Nome não pode ser vazio!");
			} else if (nome.isBlank()) {
				throw new IllegalArgumentException("Nome não pode ser em branco!");
			} else if (nome.length() < 5) {
				throw new IllegalArgumentException("Nome deve ter mais de 4 letras!");
			} else {
				this.nome = nome;
			}
		}

		public String getCelular() {
			return celular;
		}

		public void setCelular(String celular) {
			if (celular.isBlank()) {
				throw new IllegalArgumentException("Não pode estar em branco!");
			} else if ((!celular.isEmpty()) && (celular.length() != 15)) {
				throw new IllegalArgumentException("Deve estar no formato (XX) XXXXX-XXXX");
			} else {
				this.celular = celular;
			}		
			this.celular = celular;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nome=" + nome + "]";
		}	
		
	}


