import java.io.*;
import java.util.*;

class LinkedStack implements IStackable {
    private LinkedList listaLinked = new LinkedList();

    // Quantos elementos
    public int size () {
        return listaLinked.size();
    }

    // Empilha inteiro
    public void push (int v) {
        listaLinked.addFirst(v);
    }

    // Desempilha inteiro
    public int pop () {
        int removivel;
        int tamanhoLista = listaLinked.size();

        if (tamanhoLista > 0) {
            removivel = (int)listaLinked.removeFirst();
            return removivel;
        } else {
            return -1;
        } 
    }
}
