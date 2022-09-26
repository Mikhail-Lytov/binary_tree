public class binary_tree<T> {
    Node<T> root = new Node<T>(null,null,null);
    int numbers_element;

    public binary_tree(){
        numbers_element = 0;
    }
    public void add_element(T element){
        if(numbers_element > 0) {
            Node<T> check = root;
            for (int i = 0; i < numbers_element - 1; i++) {
                check = check.getRight();
            }

            Node<T> next = new Node<T>(element, check, null);
            //System.out.println(next);
            check.setRight(next);

        }else if (numbers_element == 0){
            root.setItem(element);
            //System.out.println(root);
            //numbers_element++;
        }
        numbers_element++;
    }
    public void search_element(T element){
        Node<T> check = root;
        boolean flag = true;
        for(int i = 0; i < numbers_element; i++){
            if(element == check.getItem()){
                System.out.println(check);
                flag = false;
            }else check = check.getRight();

        }
        if(flag) {
            System.out.println("Не найдено");
        }
    }
    public void clear_tree(){
        root.setRight(null);
    }
    public void copy_tree(binary_tree<T> original){
        Node<T> copy = original.root;
        root = copy;
        numbers_element = original.numbers_element;
        for(int i = 0; i <= numbers_element; i++){
            root.right = copy.right;
        }
    }



    private static class Node<T>{
        T item;
        Node<T> left;
        Node<T> right;
        private Node(T item, Node<T> left, Node<T> right){
            this.item = item;
            this.left = left;
            this.right = right;
        }
        public void setItem(T item){
            this.item = item;
        }
        public void setLeft(Node<T> left){
            this.left = left;
        }
        public void setRight(Node<T> right){
            this.right = right;
        }
        public T getItem(){
            return item;
        }
        public Node<T> getLeft(){
            return left;
        }
        public Node<T> getRight(){
            return right;
        }
       /* public String toString(){
            return "Лежит между " + left + " и " + right + " Элемент " + item;
        }*/
    }
}
