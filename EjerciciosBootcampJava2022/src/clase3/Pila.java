package clase3;

/**
 *
 * @author mateo
 */
public class Pila<T> {

	private Node<T> top;

	public Pila() {
		this.top = null;
	}

	public void push(T nuevoElem) {
		// Agrega un elemento de la pila
		Node<T> newNode = new Node<T>(nuevoElem, this.top);
		this.top = newNode;
	}

	public T pop() {
		// Quita un elemento de la pila
		T value;
		if (this.top == null) {
			// La pila esta vacia
			value = null;
		} else {
			value = this.top.getValue();
			this.top = top.getLink();
		}
		return value;
	}

	@Override
	public String toString() {
		// Devuelve la pila en un string
		String ret = "";
		if (this.top == null) {
			ret = "La pila esta vacia";
		} else {
			// Se ubica para recorrer la pila
			Node<T> aux = this.top;
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