package com.tree.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tree.model.Node;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class TreeService {

    private final ObjectMapper objectMapper= new ObjectMapper();

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


    public Node<String> getTreeFromFile() {
        Path path = Paths.get("sample",
                              "tree.json");

        Node<String> root= null;
        try {
            root = objectMapper.readValue(path.toFile(),
                                   Node.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;

    }

    public void printNode(Node<String> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each -> printNode(each, appender + appender));
    }

}
