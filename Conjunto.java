import java.util.ArrayList;
import java.util.ListIterator;

class Conjunto
{
	ArrayList<Integer> elementos = new ArrayList<>();
	
	void insereElementos(int... elemento)
	{
		for (int e : elemento)
		{
			elementos.add(e);
		}
	}

	boolean verificaPertinencia(int elemento)
	{
		return elementos.contains(elemento);
	}

	boolean verificaSubconjunto(Conjunto conjunto)
	{
		return this.elementos.containsAll(conjunto.elementos);		
	}

	Conjunto uniaoConjunto(Conjunto conjunto)
	{
		Conjunto uniao = new Conjunto();
		uniao.elementos.addAll(this.elementos);
		ListIterator<Integer> iterator = conjunto.elementos.listIterator();
		while (iterator.hasNext()) 
		{
			int elemento = iterator.next();
			if (!(uniao.elementos.contains(elemento))) 
			{
				uniao.elementos.add(elemento);	
			}
		}
		return uniao;
	}
	
	Conjunto interseccaoConjunto(Conjunto conjunto)
	{
		Conjunto interseccao = new Conjunto();
		interseccao.elementos.addAll(this.elementos);
		interseccao.elementos.removeIf(elemento -> !(conjunto.elementos.contains(elemento) ));
		return interseccao;
	}

	Conjunto diferencaConjunto(Conjunto conjunto)
	{
		Conjunto diferenca = new Conjunto();
		diferenca.elementos.addAll(this.elementos);
		diferenca.elementos.removeIf(elemento -> conjunto.elementos.contains(elemento) );
		return diferenca;
	}
}
