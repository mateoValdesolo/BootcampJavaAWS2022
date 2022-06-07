package clase3;

/**
 *
 * @author Mateo Valdesolo
 * 
 */
public class BinaryTree<T extends Comparable<T>> {

	private BTNode<T> root;

	public BinaryTree() {
		this.root = null;
	}

	public boolean belongs(T value) {
		/*
		 * Devuelve verdadero si el elemento recibido por parametro esta en el Arbol y
		 * falso en caso contrario.
		 */
		boolean success = false;
		if (!isEmpty()) {
			success = belongsAux(this.root, value);
		}
		return success;
	}

	private boolean belongsAux(BTNode<T> node, T value) {
		boolean success = false;
		int compar = node.getValue().compareTo(value);
		if (compar == 0) {
			success = true;
		} else {
			if (compar < 0) {
				if (node.getRight() != null) {
					success = belongsAux(node.getRight(), value);
				}
			} else {
				if (node.getLeft() != null) {
					success = belongsAux(node.getLeft(), value);
				}
			}
		}
		return success;
	}

	public boolean add(T value) {
		/*
		 * Recibe un elemento y lo agrega en el Arbol de manera ordenada. Si el elemento
		 * ya se encuentra en el Arbol no se realiza la insercion. Devuelve verdadero si
		 * el elemento se agrega a la estructura y falso en caso contrario.
		 */
		boolean success = true;
		if (isEmpty()) {
			this.root = new BTNode<T>(value, null, null);
		} else {
			success = addAux(this.root, value);
		}
		return success;
	}

	private boolean addAux(BTNode<T> node, T value) {
		boolean success = true;
		int compar = value.compareTo(node.getValue());
		if (compar == 0) {
			// Elemento repetido
			success = false;
		} else {
			if (compar < 0) {
				// Elem es menor a nodo.getElem()
				// Si tiene HI baja a la izquierda, sino agrega elem
				if (node.getLeft() != null) {
					success = addAux(node.getLeft(), value);
				} else {
					node.setLeft(new BTNode<T>(value, null, null));
				}
			} else {
				// Elemento mayor que nodo.getElem()
				// Si tiene HD baja a la derecha, sino agrega elemento
				if (node.getRight() != null) {
					success = addAux(node.getRight(), value);
				} else {
					node.setRight(new BTNode<T>(value, null, null));
				}
			}
		}
		return success;
	}

	public boolean remove(T value) {
		/*
		 * Recibe el elemento que se desea eliminar y se procede a removerlo del Arbol.
		 * Si no se encuentra el elemento no se puede realizar la eliminacion. Devuelve
		 * verdadero si el elemento se elimina de la estructura y falso en caso
		 * contrario.
		 */
		boolean success = false;
		if (belongs(value)) {
			success = removeAux(this.root, value, null);
		}
		return success;
	}

	private boolean removeAux(BTNode<T> node, T value, BTNode<T> father) {
		int compar = node.getValue().compareTo(value);
		boolean success = true;
		if (node != null) {
			if (compar == 0) {
				// Caso 1: Sin hijos.
				if (node.getRight() == null && node.getLeft() == null) {
					case1(father, value);
				} else {
					// Caso 2: Con hijo derecho o izquierdo.
					if (node.getRight() != null && node.getLeft() == null) {
						case2(node, father, 'R');
					} else {
						if (node.getLeft() != null && node.getRight() == null) {
							case2(node, father, 'L');
						} else {
							// Caso 3: con ambos hijos.
							case3(node);
						}
					}
				}
			} else {
				father = node;
				if (compar > 0) {
					success = removeAux(node.getLeft(), value, father);
				} else {
					success = removeAux(node.getRight(), value, father);
				}
			}
		}
		return success;
	}

	private void case1(BTNode<T> father, T value) {
		// Eliminacion de hoja.
		if (father == null) {
			this.root = null;
		} else {
			if (father.getRight().getValue().compareTo(value) == 0) {
				father.setRight(null);
			} else {
				father.setLeft(null);
			}
		}
	}

	private void case2(BTNode<T> node, BTNode<T> father, char pos) {
		// Eliminacion con 1 hijo.
		/*
		 * if(padre.getIzquierdo() != null &&
		 * padre.getIzquierdo().getElem().compareTo(nodo.getElem()) == 0){ if (pos ==
		 * 'R'){ padre.setIzquierdo(nodo.getDerecho()); } else {
		 * padre.setIzquierdo(nodo.getIzquierdo()); } }else { if (pos == 'R'){
		 * padre.setDerecho(nodo.getDerecho()); } else {
		 * padre.setDerecho(nodo.getIzquierdo()); } }
		 */
		if (pos == 'R') {
			if (father.getLeft() != null && father.getLeft().getValue().compareTo(node.getValue()) == 0) {
				father.setLeft(node.getRight());
			} else {
				father.setRight(node.getRight());
			}
		} else {
			if (father.getLeft() != null && father.getLeft().getValue().compareTo(node.getValue()) == 0) {
				father.setLeft(node.getLeft());
			} else {
				father.setRight(node.getLeft());
			}
		}
	}

	private void case3(BTNode<T> node) {
		// Eliminacion con dos hijos.
		BTNode<T> aux, father = null;
		if (node.getLeft().getRight() == null) {
			node.setValue(node.getLeft().getValue());
			node.setLeft(node.getLeft().getLeft());
		} else {
			aux = node.getLeft();
			while (aux.getRight() != null) {
				father = aux;
				aux = aux.getRight();
			}
			father.setRight(null);
			node.setValue(aux.getValue());
		}
	}

	public boolean isEmpty() {
		/*
		 * Devuelve falso si hay al menos un elemento en el Arbol y verdadero en caso
		 * contrario.
		 */
		return this.root == null;
	}

	public void clean() {
		/*
		 * Vacia la estructura.
		 */
		this.root = null;
	}
    
    public String toString() {
        /*
         * Genera y devuelve una cadena de caracteres que indica cual es la raiz del
         * Arbol y quienes son los hijos de cada nodo.
         */
        String ret = "[]";
        if (!isEmpty()) {
            ret = toStringAux(this.root, "");
        }
        return ret;
    }
		 
	public String inOrder() {
		// Retorna un string con los elementos del arbol listados en inorden.
		String ret = "";
		if (!isEmpty()) {
			ret = inOrderAux(this.root, ret);
		}
		return ret;
	}

	private String inOrderAux(BTNode<T> node, String str) {
		// Metodo recursivo que recorre el arbol en inorden y los agrega al string.
		if (node != null) {
			str = inOrderAux(node.getLeft(), str);
			str += node.getValue() + " ";
			str = inOrderAux(node.getRight(), str);
		}
		return str;
	}
	
	public String preOrder() {
		// Retorna un string con los elementos del arbol listados en preorden.
		String ret = "";
		if (!isEmpty()) {
			ret = preOrderAux(this.root, ret);
		}
		return ret;
	}

	private String preOrderAux(BTNode<T> node, String str) {
		// Metodo recursivo que recorre el arbol en preorden y los agrega al string.
		if (node != null) {
			str += node.getValue() + " ";
			str = preOrderAux(node.getLeft(), str);
			str = preOrderAux(node.getRight(), str);
		}
		return str;
	}
	
	public String postOrder() {
		// Retorna un string con los elementos del arbol listados en posorden.
		String ret = "";
		if (!isEmpty()) {
			ret = postOrderAux(this.root, ret);
		}
		return ret;
	}

	private String postOrderAux(BTNode<T> node, String str) {
		// Metodo recursivo que recorre el arbol en posorden y los agrega al string.
		if (node != null) {
			str = postOrderAux(node.getLeft(), str);
			str = postOrderAux(node.getRight(), str);
			str += node.getValue() + " ";
		}
		return str;
	}

    private String toStringAux(BTNode<T> node, String str) {
        if (node != null) {
        	BTNode<T> left = node.getLeft(), right = node.getRight();
            str += "Nodo: " + node.getValue();
            if (left != null && right != null) {
                str += " HI: " + left.getValue();
                str += " HD: " + right.getValue() + "\n";
            } else {
                if (left == null && right == null) {
                    str += " HI: - ";
                    str += " HD: - " + "\n";
                } else {
                    if (left == null) {
                        str += " HI: -";
                        str += " HD: - " + right.getValue() + "\n";
                    } else {
                        if (right == null) {
                            str += " HI: " + left.getValue();
                            str += " HD: - " + "\n";
                        }
                    }
                }
            }
            str = toStringAux(left, str);
            str = toStringAux(right, str);
        }
        return str;
    }

}
