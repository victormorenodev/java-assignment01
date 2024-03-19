class Main
{
	public static void main (String args[])
	{
		Conjunto c1 = new Conjunto();
		c1.insereElemento(1);
		/*Conjunto c2 = new Conjunto();
		Conjunto c3 = new Conjunto();
		Conjunto c4 = new Conjunto();
		c.insereElemento(1);
		c.insereElemento(2);
		c.insereElemento(3);
		Conjunto c2 = new Conjunto();
		c2.insereElemento(1);
		c2.insereElemento(2);
		c2.insereElemento(4);
		c2.insereElemento(5);
		Conjunto diferenca = new Conjunto();
		diferenca = c2.diferencaConjunto(c);*/
		Main main = new Main();

		main.printAll(c1);
	}

	void printAll(Conjunto c)
	{	
		for (int i = 0; i < c.elementos.size(); i++) 
		{
			System.out.println("Elemento: "+c.elementos.get(i));
		}
	}	
}
