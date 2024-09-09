package com.treelibrary.Impl;

import java.util.function.Consumer;

import com.treelibrary.BST;
import com.treelibrary.Node;


public class BSTImpl<T extends Comparable<T>> implements BST<T> {

    private Node<T> rootNode;

    public BSTImpl() {
        rootNode = null;
    }



    @Override
    public boolean isEmpty() {
        return (null == getRoot());
    }

    public Node<T> getRoot() {
        return rootNode;
    }

    @Override
    public int count() {
        int count  = 0;
        Node <T> iter = this.getRoot();
        count = nodeCounter(iter);

        return count;
    }
    private int nodeCounter(Node<T> node) {

        if (null == node) {
            return 0;
        }

        return 1 + nodeCounter( node.getLeft()) + nodeCounter(node.getRight());

    }

    @Override
    public Node<T> insert(T data) {

        Node<T> newNode = new NodeImpl<T>(data);

        if ( rootNode == null) {

            rootNode = newNode;
            return rootNode;

        }

        Node <T> iterator = rootNode;

        while ( null != iterator) {


            if (data.compareTo(iterator.getData()) < 0) {

                if (null == iterator.getLeft()) {

                    iterator.setLeft(newNode);
                    newNode.setParent(iterator);
                    return newNode;

                }

                iterator = iterator.getLeft();
                
            }
            if (data.compareTo(iterator.getData()) > 0) {

                if (null == iterator.getRight()) {

                    iterator.setRight(newNode);
                    newNode.setParent(iterator);
                    return newNode;

                }

                iterator = iterator.getRight();
                
            }
        }

        return newNode;
    }

    @Override
    public Node<T> find(T data) {
        
        Node <T> iterator = rootNode;

        while (null != iterator) {

            if (data.compareTo(iterator.getData()) == 0) {

                return iterator;
                
            }

            if (data.compareTo(iterator.getData()) < 0) {

                iterator = iterator.getLeft();
                
            }
            if (data.compareTo(iterator.getData()) > 0) {

                iterator = iterator.getRight();
                
            }
        }
        return null;
    }
    @Override
    public String toString() {

        StringBuilder objectString = new StringBuilder("|");
        Node <T> iterator = this.getRoot();
        recursiveToString(iterator, objectString);
         return objectString.toString();

    }

    private void recursiveToString(Node<T> node, StringBuilder objectString) {

        if (null == node) {
            return;
        }

        objectString.append(" " + node.getData().toString());
        recursiveToString(node.getLeft(), objectString);
        recursiveToString(node.getRight(), objectString);

    }
    

    @Override
    public T remove(Node<T> node) {

        if (null == node) {
            return null;
        }

        T data = node.getData();
        //3 cases to consider: node to delete is a leaf
        if (node.isLeaf()) {

            if (node.isLeftChild()) {

                node.getParent().setLeft(null);

            }
            else if (node.isRightChild()) {

                node.getParent().setRight(null);

            }
            else {//root
                rootNode = null;
            }

            return data;
        }
        // node to delete has one child
        if (node.hasOneChild() && node.hasRightChild()) {

            if (node.isLeftChild()) {
                node.getParent().setLeft(node.getRight());
            } else if (node.isRightChild()) {
                node.getParent().setRight(node.getRight());
            } else { // Node is the root
                rootNode = node.getRight();
            }

            node.getRight().setParent(node.getParent());

            return data;
        }
        if (node.hasOneChild() && node.hasLeftChild()) {
            if (node.isLeftChild()) {
                node.getParent().setLeft(node.getLeft());
            } else if (node.isRightChild()) {
                node.getParent().setRight(node.getLeft());
            } else { // Node is the root
                rootNode = node.getLeft();
            }
            node.getLeft().setParent(node.getParent());
            return data;
        }
        //node to delete has 2 children
        if (node.hasLeftChild() && node.hasRightChild()) {

            Node<T> successor = next(node);

            node.setData(successor.getData());

            remove(successor);
        }


       return data;
    }

    


    @Override
    public Node <T> findMin(Node <T> root) {

        if (root == null) {
            return null;
        }

        Node<T> iterator = root;

        while (iterator.getLeft() != null) {

            iterator = iterator.getLeft();

        }

        return iterator;
    }

    @Override
    public Node <T> findMax(Node <T> root) {

        if (root == null) {
            return null;
        }

        Node<T> iterator = root;

        while (iterator.getRight() != null) {

            iterator = iterator.getRight();

        }

        return iterator;

    }

    @Override
    public Node <T> next(Node <T> node) {//inorder successor

        Node <T> successor = null;

       if(node.hasRightChild()) {

           return findMin(node.getRight());

       }
       //if node is maximum int the tree
       if (findMax(rootNode) == node ) {

            return null;

       }
       
        Node<T> iterator = node;
        Node<T> iteratorParent = node.getParent(); 
       //find node that is a left child of its parent, the parent is a successor
        while (iteratorParent != null && iterator == iteratorParent.getRight()) {

            iterator =  iteratorParent;
            iteratorParent = iterator.getParent();
            
        }

       return iteratorParent;
    }

    @Override
    public Node <T> prev(Node <T> node) {//predecessor
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prev'");
    }

    @Override
    public void traverseInOrder(Consumer<T> action) {
        traverseInOrderRecursively(rootNode, action);
    }
    private void traverseInOrderRecursively(Node<T> root, Consumer<T> action){

        if (root == null) {
            return;
        }

        traverseInOrderRecursively(root.getLeft(), action);
        action.accept(root.getData());
        traverseInOrderRecursively(root.getRight(), action);
    }

    @Override
    public void traversePreOrder(Consumer<T> action) {
        traversePreOrderRecursively(rootNode, action);
    }
    private void traversePreOrderRecursively(Node<T> root, Consumer<T> action){

        if (root == null) {
            return;
        }
        action.accept(root.getData());

        traversePreOrderRecursively(root.getLeft(), action);
        traversePreOrderRecursively(root.getRight(), action);
    }

    @Override
    public void traversePostOrder(Consumer<T> action) {
        traversePostOrder(rootNode, action);
    }
    
    private void traversePostOrder(Node<T> root, Consumer<T> action){

        if (root == null) {
            return;
        }

        traversePostOrder(root.getLeft(), action);
        traversePostOrder(root.getRight(), action);

        action.accept(root.getData());
    }
    @Override
    public int height() {
        if(isEmpty()) {
            return -1;
        }
        return maxDepth(rootNode);
    }

    private int maxDepth(Node<T> node) {

        if (node == null){
            return -1;
        }

        int rightDepth = maxDepth(node.getRight());
        int leftDepth = maxDepth(node.getLeft());

        return Math.max(rightDepth, leftDepth) + 1;
    }

    @Override
    public void clear() {
        //because java has garbage collector we could just use rootNode = null;
        clearTree(rootNode);
    }

    private void clearTree(Node<T> root) {
        if (root == null) {
            return;
        }

        clearTree(root.getLeft());
        clearTree(root.getRight());

        root.setLeft(null);
        root.setRight(null);
        root.setData(null);
    }
}
