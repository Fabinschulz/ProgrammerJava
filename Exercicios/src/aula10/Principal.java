package aula10;

	public class Principal {

		public static void main(String[] args) {
	
	Consumidor c1 = new Consumidor("Robert Metcalfe",
								   "bob@ethernet.com",
								   11122233344L,
								   5511999999999L);
	c1.telegram = "@rdrudi";
	System.out.println(c1.nome);
	c1.pagar();
	
	Empresa e1 = new Empresa("Sadia S/A",
							 "compras@sadia.com",
							 111222333000199L,
							 "+55 (11) 1234-5678 ramal 27",
							 30);
	e1.telegram = "@sadia";
	e1.setPrazo(30);  
	e1.setPrazo(-1000);
	System.out.println(e1.nome + " : " + e1.getPrazo());
	e1.pagar();
	
}

}
