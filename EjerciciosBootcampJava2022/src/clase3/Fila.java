package clase3;

/**
*
* @author Mateo Valdesolo
* 
*/
public class Fila<T> {
	
	private Node<T> head;
	private Node<T> tail;

	public Fila() {
        this.head = null;
        this.tail = null;
    }

	public void add(T value) {
		// Pone un elemento en la cola
		Node<T> newNode = new Node<T>(value, null);
		if (isEmpty()) {
			this.head = newNode;
		} else {
			this.tail.setLink(newNode);
		}
		this.tail = newNode;
	}

	public T remove() {
		// Saca un elemento si la cola no esta vacia
		T value = null;
		if (!isEmpty()) {
			value = this.head.getValue();
			this.head = this.head.getLink();
			if (this.head == null) {
				this.tail = null;
			}
		}
		return value;
	}
	
	public boolean isEmpty() {
        // Retorna true si esta vacia la cola, false en caso contrario
        return this.head == null;
    }
	
	public void clean() {
        // Vacia la cola
        this.head = null;
        this.tail = null;
    }
	
    @Override
    public String toString() {
        // Retorna un string con los elementos de la cola
        String ret = "";
        if (isEmpty()) {
            ret = "La cola esta vacia";
        } else {
            // Se ubica para recorrer la pila
            Node<T> aux = this.head;
            ret = "[";
            while (aux != null) {
                // Agrega el texto del elem y avanza
                ret = ret + aux.getValue().toString();
                aux = aux.getLink();
                if (aux != null) {
                    ret += ",";
                }
            }
            ret += "]";
        }
        return ret;
    }
}
