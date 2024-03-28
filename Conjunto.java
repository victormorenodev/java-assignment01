
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Collections;

class Conjunto
{
	ArrayList<Object> elementos = new ArrayList<>();
	
	void insereElementos(Object... elemento)
	{
		for (Object e : elemento)
		{
			elementos.add(e);
		}
	}

	boolean verificaPertinencia(Object elemento)
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
		ListIterator<Object> iterator = conjunto.elementos.listIterator();
		while (iterator.hasNext()) 
		{
			Object elemento = iterator.next();
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

	Conjunto produtoCartesiano(Conjunto conjunto)
	{
		Conjunto produto = new Conjunto();
		for (int j = 0; j < conjunto.elementos.size(); j++)
		{
			for (int k = 0; k < this.elementos.size(); k++)
			{
				Conjunto par = new Conjunto();
				par.insereElementos(this.elementos.get(k));
				par.insereElementos(conjunto.elementos.get(j));
				produto.insereElementos(par);
			}
		}
		return produto;
	}

	Conjunto conjuntoPotencia() 
	{
        	Conjunto potencia = new Conjunto();
        	int n = this.elementos.size();
        	int totalSubconjuntos = 1 << n; // Calcula 2^n
        	for (int i = 0; i < totalSubconjuntos; i++) 
		{
            		Conjunto subconjunto = new Conjunto();
            		for (int j = 0; j < n; j++) 
			{
                		if ((i & (1 << j)) > 0) 
				{
                    			subconjunto.insereElementos(this.elementos.get(j));
                		}
            		}
            		potencia.insereElementos(subconjunto);
        	}
        	return potencia;
    	}
}
