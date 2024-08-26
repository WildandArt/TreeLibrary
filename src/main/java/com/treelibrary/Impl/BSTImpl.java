package com.treelibrary.Impl;

import java.util.function.Consumer;

import com.treelibrary.BST;
import com.treelibrary.Node;
import com.treelibrary.Impl.NodeImpl;


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
        count = nodeCounter( iter);

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
                    return newNode;

                }

                iterator = iterator.getLeft();
                
            }
            if (data.compareTo(iterator.getData()) > 0) {

                if (null == iterator.getRight()) {

                    iterator.setRight(newNode);
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

        objectString.append(node.getData().toString());
        recursiveToString(node.getLeft(), objectString);
        recursiveToString(node.getRight(), objectString);

    }
    

    @Override
    public T remove(Node<T> node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Node <T> findMin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findMin'");
    }

    @Override
    public Node <T> findMax() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findMax'");
    }

    @Override
    public Node <T> next(Node <T> node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public Node <T> prev(Node <T> node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prev'");
    }

    @Override
    public void traverseInOrder(Consumer action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'traverseInOrder'");
    }

    @Override
    public void traversePreOrder(Consumer action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'traversePreOrder'");
    }

    @Override
    public void traversePostOrder(Consumer action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'traversePostOrder'");
    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

}
