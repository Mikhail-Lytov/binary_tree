public class test_binary_tree {
    public static void main(String[] args) {
        binary_tree tree = new binary_tree();
        tree.add_element("Privet");
        tree.add_element(12);
        tree.search_element(12);
        System.out.println("тут");
        binary_tree copy_tree = new binary_tree();
        copy_tree.copy_tree(tree);
        copy_tree.clear_tree();
        //copy_tree.search_element(12);

    }
}
