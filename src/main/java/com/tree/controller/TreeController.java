package com.tree.controller;

import com.tree.model.Node;
import com.tree.service.TreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/v1")
public class TreeController {
    private final TreeService treeService;

    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping("/trees")
    public ResponseEntity<Node<String>> getTree() {

        Node<String> root = treeService.createTree();
        return new ResponseEntity<>(root, HttpStatus.OK);

    }
}
