public class test_binary_tree {
    public static void main(String[] args) {
        binary_tree tree = new binary_tree();
        tree.add_tree(8);
        tree.add_tree(3);
        tree.add_tree(1);
        tree.add_tree(6);
        tree.add_tree( 4);
        tree.add_tree( 7);
        tree.add_tree( 10);
        tree.add_tree( 14);
        tree.add_tree( 13);
        binary_tree tree1 = new binary_tree<>();
        tree1.copy(tree);
        //tree.clear();
        System.out.println(tree1.search(13));
        System.out.println(tree1.search(4));
        System.out.println(tree1.search(8));
        System.out.println(tree1.search(2));

        tree1.search_tree();
    }
}
