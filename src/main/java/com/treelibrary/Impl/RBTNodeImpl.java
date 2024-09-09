package com.treelibrary.Impl;

import com.treelibrary.RBTNode;
import com.treelibrary.Node;

public class RBTNodeImpl<T> implements RBTNode<T> {

    private T data;
    private Node<T> left, right, parent;
    private boolean isRed;

    public RBTNodeImpl(T data) {
        this.data = data;
        this.isRed = true;
    }
    @Override
    public boolean isRed() {
        return isRed;
    }

    @Override
    public void setRed(boolean isRed) {
        this.isRed = isRed;
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

    @Override
    public Node<T> getParent() {
        return parent;
    }

    @Override
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    @Override
    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public boolean isLeftChild() {
        return parent != null && parent.getLeft() == this;
    }

    @Override
    public boolean isRightChild() {
        return parent != null && parent.getRight() == this;
    }

    @Override
    public boolean hasRightChild() {
        return right != null;
    }

    @Override
    public boolean hasLeftChild() {
        return left != null;
    }

    @Override
    public boolean hasOneChild() {
        return (left != null && right == null) || (right != null && left == null);
    }
}
