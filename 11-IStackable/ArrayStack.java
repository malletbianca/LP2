import java.io.*;
import java.util.*;

class ArrayStack implements IStackable {
	private ArrayList listaArray = new ArrayList();

	// Quantos elementos
	public int size () {
    return listaArray.size();
	}

	// Empilha inteiro
  public void push (int v) {
    listaArray.add(v);
  }

  // Desempilha inteiro
   public int pop () {
     int removivel;
     int tamanhoLista = listaArray.size();

     if (tamanhoLista > 0) {
       removivel = (int)listaArray.remove(tamanhoLista - 1);
       return removivel;
     } else {
       return -1;
     }
   }
}
