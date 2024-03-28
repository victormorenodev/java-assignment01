
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
		
		System.out.println("--------- INCIO DOS TESTES -----------");
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
		
		// Testa o produto cartesiano
		Conjunto c5 = new Conjunto();
		c5.insereElementos(1, 2, 3, 4);
		Conjunto c6 = new Conjunto();
		c6.insereElementos(1, 2);
		Conjunto produto = c5.produtoCartesiano(c6);
		main.printProduto(produto);

		// Testa o conjunto potência
		Conjunto c7 = new Conjunto();
		c7.insereElementos(1, 2, 3, 4);
		Conjunto potencia = c7.conjuntoPotencia();
		main.printPotencia(potencia);

		// Testa DeMorgan
		Conjunto c8 = new Conjunto();
		Conjunto c9 = new Conjunto();
		c8.insereElementos(1, 2, 3, 5);
		c9.insereElementos(8, 7, 6, 4);
		System.out.println("\nTESTE DE MORGAN -> ~(A U B) === ~A ^ ~B e ~(A ^ B) === ~A U ~B:");
		System.out.println(main.testeDeMorgan(c8, c9));
	}	

	void printAll(Conjunto c)
	{	
		for (int i = 0; i < c.elementos.size(); i++) 
		{
			System.out.println("Elemento: "+c.elementos.get(i));
		}
	}

	void printProduto(Conjunto c) 
	{
		System.out.println("\n--------------- TESTE DE PRODUTO CARTESIANO ---------------");
    		for (Object conjunto : c.elementos) 
		{
        		Conjunto par = (Conjunto) conjunto;
        		System.out.println("Par: (" + par.elementos.get(0) + ", " + par.elementos.get(1) + ")");
		}
		System.out.println("--------------- FIM ---------------");	
	}

	void printPotencia(Conjunto c) 
	{	
		System.out.println("\n--------------- TESTE DO CONJUNTO POTÊNCIA ---------------");
    		for (Object conjunto : c.elementos) 
		{
			Conjunto subConjunto = (Conjunto) conjunto;
			System.out.print("[");
			for (int i = 0; i < subConjunto.elementos.size(); i++)
			{
				System.out.print(subConjunto.elementos.get(i));
				if (i+1 < subConjunto.elementos.size())
				{
					System.out.print(",");
				}
			}
			System.out.print("]\n");
		}
		System.out.println("--------------- FIM ---------------");	
	}

	void pertinente(Conjunto c1, Conjunto c2)
	{
		for (int i = 0; i < c2.elementos.size(); i++)
		{
			System.out.println("Elemento "+c2.elementos.get(i)+"="+c1.verificaPertinencia(c2.elementos.get(i)));
		}
	}

	Boolean testeDeMorgan(Conjunto a, Conjunto b)
	{
		Conjunto universo = new Conjunto();
		for (int i = 0; i < 50; i++)
		{
			universo.insereElementos(i);
		}
		Conjunto uniao = a.uniaoConjunto(b);
		Conjunto interseccao = a.interseccaoConjunto(b);
		
		Conjunto uniaoComplemento1 = new Conjunto();
		Conjunto uniaoComplemento2 = new Conjunto();
		Conjunto interseccaoComplemento1 = new Conjunto();
		Conjunto interseccaoComplemento2 = new Conjunto();

		uniaoComplemento1 = universo.diferencaConjunto(uniao);  
		uniaoComplemento2 = (universo.diferencaConjunto(a)).interseccaoConjunto(universo.diferencaConjunto(b));
		
		Boolean uniaoIgual = false;
		Boolean interseccaoIgual = false;

		if (uniaoComplemento1.verificaSubconjunto(uniaoComplemento2) && uniaoComplemento1.diferencaConjunto(uniaoComplemento2).elementos.isEmpty())
		{
			uniaoIgual = true;
		}
		
		interseccaoComplemento1 = universo.diferencaConjunto(interseccao);  
		interseccaoComplemento2 = (universo.diferencaConjunto(a)).uniaoConjunto(universo.diferencaConjunto(b));
		
		if (interseccaoComplemento1.verificaSubconjunto(interseccaoComplemento2) && interseccaoComplemento1.diferencaConjunto(interseccaoComplemento2).elementos.isEmpty())
		{
			interseccaoIgual = true;
		}
		
		return (uniaoIgual == true && interseccaoIgual == true);
	}
}

