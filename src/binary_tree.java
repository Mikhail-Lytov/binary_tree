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
                if (result > 0 && result < 2147483647) {//когда следующий элемент меньше
                    if(direction.getLeft() == null) {
                        direction.setLeft(node_element);
                        numbers_element++;
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
                        direction = direction.getRight();
                        result = direction.compareTo(node_element);
                    }
                }else if(result == 2147483647){
                    break;
                }
            }
        }
    }
    public String search(E element){
        try {
            int result;
            Node<E> node_element = new Node<E>(element, null, null);
            Node<E> direction = root;
            if (numbers_element != 0) {
                result = direction.compareTo(node_element);
            } else {
                return "not found";
            }
            while (result != 0) {
                if (result > 0) {//когда следующий элемент меньше
                    if (direction.getLeft() == null) {
                        if ((result = direction.compareTo(node_element)) == 0) {
                            return "found";
                        } else {
                            return "not found";
                        }
                    } else {
                        direction = direction.getLeft();
                        result = direction.compareTo(node_element);
                    }
                } else if (result < 0) {//когда следующей элемент больше
                    if (direction.getRight() == null) {
                        if ((result = direction.compareTo(node_element)) == 0) {
                            return "found";
                        } else {
                            return "not found";
                        }
                    } else {
                        direction = direction.getRight();
                        result = direction.compareTo(node_element);
                    }
                }
            }
            if (result == 0) {
                return "found";
            } else {
                return "Problem is in search";
            }
        }catch (NullPointerException e){
            System.out.println("looked beyond the tree");
            return "Problems";
        }
    }




    private void search_tree_element(Node<E> element){
        System.out.println(element.getItem());
        if(element.getLeft() != null) {
            search_tree_element(element.left);
        }
        if(element.getRight() != null) {
            search_tree_element(element.right);
        }

    }
    public void search_tree(){
        System.out.println("Начало ");
        E element = root.item;
        if(root.getLeft() == null && root.getRight() == null){
            System.out.println(root.item);
        }
        if(element != null){
            System.out.println(element);
            if(root.getLeft() != null) {
                search_tree_element(root.left);
            }else System.out.println(element);
            if(root.getRight() != null) {
                search_tree_element(root.right);
            }else{
                System.out.println(element);
            }
        }
    }
    public void clear(){
        root.setRight(null);
        root.setLeft(null);
        root.setItem(null);
        numbers_element = 0;
        System.gc();
    }
    public int compareTo(binary_tree o){
        try {
            int result = this.root.compareTo(o.root);
            return result;
        }catch (ClassCastException e){
            System.out.println("Invalid value entered");
            return 2147483647;
        }
    }

    public void copy(binary_tree original) {
        root.setRight(original.root.getRight());
        root.setLeft(original.root.getLeft());
        Node<E> copy = original.root;
        root.setItem(copy.getItem());
        numbers_element = original.numbers_element;
        cyclic_copying(root);
    }
     public void cyclic_copying(Node<E> next){
        Node<E> copy = next;
        copy.setItem(next.getItem());
        copy.setLeft(next.getLeft());
        copy.setRight(next.getRight());
        if(next.getRight() != null){
            cyclic_copying(next.getRight());
        }
        if(next.getLeft() != null){
            cyclic_copying(next.getLeft());
        }
    }


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
            try {
                int result = this.item.compareTo(o.item);
                //return result;
                return result;
            }catch (ClassCastException e){
                System.out.println("Invalid value entered");
                return 2147483647;
            }
        }
        
        public String toString(){
            return left + " " + item + " " + right;
       }

    }
}
