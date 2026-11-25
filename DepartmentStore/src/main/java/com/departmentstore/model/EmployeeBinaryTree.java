/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.model;

import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author gabri
 */
public class EmployeeBinaryTree {

    private TreeNode root;

    public EmployeeBinaryTree() {
        root = null;
    }

    // Level-Order Insertion
    public void insert(Employee employee) {

        TreeNode newNode = new TreeNode(employee);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            // Insert on the left
            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            }

            queue.add(current.getLeft());

            // Insert on the right
            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            }

            queue.add(current.getRight());
        }
    }

    // Level-Order Traversal
    public void levelOrderTraversal() {

        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("\nLevel-Order Traversal:");

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            System.out.println(current.getEmployee().getName());

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    // Tree Height
    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Node Count
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.getLeft())
                 + countNodes(node.getRight());
    }
}