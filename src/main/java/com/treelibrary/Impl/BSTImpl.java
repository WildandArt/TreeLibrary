package com.treelibrary.Impl;

import java.util.function.Consumer;

import com.treelibrary.BST;
import com.treelibrary.Node;
import com.treelibrary.Impl.NodeImpl;


public class BSTImpl<T> implements BST<T>{

    private Node<T> rootNode;

    public BSTImpl() {
        rootNode = null;
    }



    @Override
    public boolean isEmpty() {
        return (null == getRoot());
    }

    private Node<T> getRoot() {
        return rootNode;
    }

    @Override
    public int count() {
        int count  = 0;

        nodeCounter(count, this.getRoot());

        return count;
    }
    private void nodeCounter(int count, Node<T> node) {

        if (null == node) {
            return;
        }

        count += 1;
        nodeCounter(count, node.getLeft());
        nodeCounter(count, node.getRight());

    }

    @Override
    public Node<T> insert(T data) {

        Node<T> node = new NodeImpl<T>(data);

        if ( rootNode == null) {
            rootNode = node;
        }

        Node <T> iterator = rootNode;

        while ( null != iterator) {
            

        }

        
        return node;
    }

    @Override
    public Node find(Object data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public Object remove(Node node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Node findMin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findMin'");
    }

    @Override
    public Node findMax() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findMax'");
    }

    @Override
    public Node next(Node node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public Node prev(Node node) {
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
