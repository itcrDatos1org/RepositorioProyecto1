package Kevin;

/*
 * Last input, First Output
 */

public class pila<T> {
	private node<T> tail;
	private node<T> head;
	private int capacidad;
	
	public pila(){
		this.tail = null;
		this.head = null;
		this.capacidad = 0;
		this.tail.setNext(null);
		this.tail.setPrev(null);
		this.head.setNext(null);
		this.head.setPrev(null);
	}

	public void add(T dato){
		node<T> nodo = new node<T>(dato);
		if (capacidad == 0){
			this.head = nodo;
			this.tail = nodo;
			capacidad ++;
		} else{
			node<T> current = tail;
			nodo.setPrev(current);
			current.setNext(nodo);
			this.tail = nodo;
			tail.setNext(null);
			capacidad ++;
		}
	}
	
	public node<T> get(){
		return this.tail;
	}
	
	public node<T> obtener(){
		node<T> current = tail;
		this.tail = tail.getPrev();
		return current;
	}
	
	public int getCapacidad(){
		return capacidad;
	}
}
