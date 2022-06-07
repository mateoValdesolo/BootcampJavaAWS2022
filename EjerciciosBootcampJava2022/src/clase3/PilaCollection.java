package clase3;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author Mateo Valdesolo
* 
*/
public class PilaCollection<T> {

	private List<T> list = new ArrayList<T>();

	public void push(T value) {
		list.add(value);
	}

	public T pop() {
		if (list.isEmpty()) {
			return null;
		}
		return list.remove(list.size() - 1);
	}

}
