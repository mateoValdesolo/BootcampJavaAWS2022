package clase3;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author Mateo Valdesolo
* 
*/
public class FilaCollection<T> {

	private List<T> list = new ArrayList<T>();
	private int index = 0;

	public void add(T value) {
		/* Agrega un elemento a la Cola */
		if (value != null) {
			list.add(value);
		}
	}

	public T remove() {
		/* Elimina un elemento de la Cola y lo retorna */
		if (index >= list.size()) {
			return null;
		}
		index++;
		return list.get(index - 1);
	}

}