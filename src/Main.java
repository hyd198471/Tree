public class Main {

    public static void main(String[] args) {
        Node<String> root = createTree();

        printNode(root, "\t");

        System.out.println(ifNodeExists(root,"node111"));

        System.out.println(ifNodeExists(root,"node21"));

    }

    public static boolean ifNodeExists(Node<String> searchNode, String data) {
        if(searchNode == null) {
            return false;
        }
        if(searchNode.getData().equals(data)) {
            return true;
        }

        for(Node<String> node : searchNode.getChildren()) {
            boolean found = ifNodeExists(node,data);
            if(found) {
                return true;
            }
        }
        return false;
    }


    private static Node<String> createTree() {
        Node<String> root = new Node<>("root");

        Node<String> node1 = new Node<>("node1");

        Node<String> node2 = new Node<>("node2");

        Node<String> node11 = new Node<>("node11");

        Node<String> node12 = new Node<>("node12");

        Node<String> node111 = new Node<>("node111");
        Node<String> node112 = new Node<>("node112");
        Node<String> node113 = new Node<>("node113");

        Node<String> node21 = new Node<>("node21");
        root.addChild(node1);
        root.addChild(node2);

        node1.addChild(node11);
        node1.addChild(node12);

        node2.addChild(node21);

        node11.addChild(node111);
        node11.addChild(node112);
        node11.addChild(node113);

        return root;

    }

    private static void printNode(Node<String> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each -> printNode(each, appender + appender));

    }
}
