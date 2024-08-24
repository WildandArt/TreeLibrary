package com.treelibrary.Impl;

import com.treelibrary.Node;
public class NodeImpl<T> implements Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public NodeImpl(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
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
}
