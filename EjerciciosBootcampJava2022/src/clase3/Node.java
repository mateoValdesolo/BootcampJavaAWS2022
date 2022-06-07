package clase3;

/**
*
* @author Mateo Valdesolo
* 
*/
class Node<T> {

   private T value;
   private Node<T> link;

   //Constructores
   public Node(T value, Node<T> link) {
       this.value = value;
       this.link = link;
   }

   //Modificadores
   public void setValue(T value) {
       this.value = value;
   }

   public void setLink(Node<T> link) {
       this.link = link;
   }

   //Observadores
   public T getValue() {
       return value;
   }

   public Node<T> getLink() {
       return link;
   }

}