import java.util.ArrayList;

class Main
{
	public static void main (String args[])
	{
		Main main = new Main();
		Conjunto c1 = new Conjunto();
		c1.insereElementos(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // 10 primeiros naturais
		Conjunto c2 = new Conjunto();
		c2.insereElementos(2, 4, 6, 8, 10); // 5 primeiros pares
		Conjunto c3 = new Conjunto();
		c3.insereElementos(1, 3, 5, 7, 9); // 5 primeiros ímpares
		Conjunto c4 = new Conjunto();
		c4.insereElementos(2, 3, 5, 7, 11, 13, 17, 19, 23, 29); // 10 primeiros primos
		
		System.out.println("--------- INÍCIO DOS TESTES -----------");
		System.out.println("\nC4 SUBCONJUNTO DE SI MESMO: "+c4.verificaSubconjunto(c4)); // Se c4 é subconjunto de si mesmo
		
		// Verifica pertinência dos elementos do conjunto 2 no conjunto 1
		System.out.println("--------- PERSISTÊNCIA DO C2 NO C1 ---------");
		main.pertinente(c1, c2);
		// Verifica pertinência dos elementos do conjunto 3 no conjunto 1
		System.out.println("--------- PERSISTÊNCIA DO C3 NO C1 ---------");
		main.pertinente(c1, c3);
		// Verifica pertinência dos elementos do conjunto 4 no conjunto 1
		System.out.println("--------- PERSISTÊNCIA DO C4 NO C1 ---------");
		main.pertinente(c1, c4);
		System.out.println("\n---------------- FIM -----------------");

		// Verifica se a união do conjunto 2 e 3 é igual a 1
		Conjunto uniaoc2c3 = new Conjunto();
		uniaoc2c3 = c2.uniaoConjunto(c3);
		Boolean igual = false;
		if (c1.verificaSubconjunto(uniaoc2c3) && c1.diferencaConjunto(uniaoc2c3).elementos.isEmpty())
		{
			igual = true;
		}
		System.out.println("c2Uc3 = c1 ? "+igual);

		// Verifica se a intersecção dos conjuntos 1 e 2 é vazia
		Conjunto interseccao = new Conjunto();
		interseccao = c1.interseccaoConjunto(c2);
		System.out.println("c1 interseccao c2 = {} ? "+interseccao.elementos.isEmpty());

		// Verifica a diferença entre os conjuntos 1 e 2
		Conjunto diferenca = new Conjunto();
		diferenca = c1.diferencaConjunto(c2);
		System.out.println("Diferença entre os conjuntos 1 e 2:");
		main.printAll(diferenca);
	
		Conjunto c5 = new Conjunto();
		c5.insereElementos(1, 2, 3, 4);
		Conjunto c6 = new Conjunto();
		c6.insereElementos(1, 2);
		Conjunto produto = c5.produtoCartesiano(c6);
		main.printProduto(produto);
	}	

	void printAll(Conjunto c)
	{	
		for (int i = 0; i < c.elementos.size(); i++) 
		{
			System.out.println("Elemento: "+c.elementos.get(i));
		}
	}

	void printProduto(Conjunto c) {
    		for (Object conjunto : c.elementos) {
        		Conjunto par = (Conjunto) conjunto;
        		System.out.println("Par: (" + par.elementos.get(0) + ", " + par.elementos.get(1) + ")");
    		}
	}

	void pertinente(Conjunto c1, Conjunto c2)
	{
		for (int i = 0; i < c2.elementos.size(); i++)
		{
			System.out.println("Elemento "+c2.elementos.get(i)+"="+c1.verificaPertinencia(c2.elementos.get(i)));
		}
	}
}
