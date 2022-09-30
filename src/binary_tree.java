public class binary_tree<E extends Comparable<E>> implements Comparable<binary_tree>{
    Node<E> root;
    int numbers_element;
    public binary_tree(){
        numbers_element = 0;
        root = new Node<E>(null,null,null);
    }
    public void add_tree(E element){
        int result;
        if(numbers_element == 0){
            root.setItem(element);
            numbers_element++;
        }else if(numbers_element > 0){
            Node<E> node_element = new Node<E>(element,null,null);
            Node<E> direction = root;
            result = direction.compareTo(node_element);
            while (result != 0) {
                if (result > 0) {//когда следующий элемент меньше
                    if(direction.getLeft() == null) {
                        direction.setLeft(node_element);
                        numbers_element++;
                        //System.out.println("1 : " + result);
                        break;
                    }else{

                        direction = direction.getLeft();
                        result = direction.compareTo(node_element);
                    }
                } else if (result < 0) {//когда следующей элемент больше
                    if(direction.getRight() == null){
                        direction.setRight(node_element);
                        numbers_element++;
                        break;
                    }else{
                        direction = direction.getLeft();
                        result = direction.compareTo(node_element);
                    }
                    System.out.println("-1 " + result);
                }
            }
        }
    }

    public int compareTo(binary_tree o){
        int result = this.root.compareTo(o.root);
        return result;
    }
    /*public int compareTo(binary_tree o){
        //Node<T> root_copy = o.root;
        int result = root.compareTo(o.root);
        return result;
    }*/

    private class Node<E extends Comparable<E>> implements Comparable<Node<E>>{
        E item;
        Node<E> left;
        Node<E> right;
        private Node(E item, Node<E> left, Node<E> right){
            this.item = item;
            this.left = left;
            this.right = right;
        }
        public void setItem(E item){
            this.item = item;
        }
        public void setLeft(Node<E> left){
            this.left = left;
        }
        public void setRight(Node<E> right){
            this.right = right;
        }
        public E getItem(){
            return item;
        }
        public Node<E> getLeft(){
            return left;
        }
        public Node<E> getRight(){
            return right;
        }
        public int compareTo(Node<E> o){
            int result = this.item.compareTo(o.item);
            //return result;
            return result;
        }
        
        public String toString(){
            return left + " " + item + " " + right;
       }

    }
}
