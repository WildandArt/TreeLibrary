package com.treelibrary.Impl;

import com.treelibrary.Node;
public class NodeImpl<T> implements Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    public NodeImpl(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public Node<T> getLeft() {
        return left;
    }

    @Override
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    @Override
    public Node<T> getRight() {
        return right;
    }

    @Override
    public void setRight(Node<T> right) {
        this.right = right;
    }

    public boolean isLeaf() {

        return (!hasLeftChild()) && (!hasRightChild());

    }
    public boolean hasRightChild() {

        return null != this.getRight();

    }
    public boolean hasLeftChild() {

        return null != this.getLeft();

    }

    @Override
    public Node<T> getParent() {
        return parent;
    }

    @Override
    public void setParent(Node<T> node) {
        
        this.parent = node;

    }

    @Override
    public boolean isLeftChild() {

        return (null != parent) && (parent.getLeft() == this);
        
    }

    @Override
    public boolean isRightChild() {

        return (null != parent) && (parent.getRight() == this);

    }
}
