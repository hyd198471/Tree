package com.tree.service;

import com.tree.model.Node;
import org.springframework.stereotype.Service;

@Service
public class TreeService {

    public boolean ifNodeExists(Node<String> searchNode, String data) {
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


    public Node<String> createTree() {
        Node<String> root = new Node<>(0L,"root");

        Node<String> node1 = new Node<>(1L,"node1");

        Node<String> node2 = new Node<>(2L,"node2");

        Node<String> node11 = new Node<>(3L,"node11");

        Node<String> node12 = new Node<>(4L,"node12");

        Node<String> node111 = new Node<>(5L,"node111");
        Node<String> node112 = new Node<>(6L,"node112");
        Node<String> node113 = new Node<>(7L,"node113");

        Node<String> node21 = new Node<>(8L,"node21");
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

    public void printNode(Node<String> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each -> printNode(each, appender + appender));
    }

}
