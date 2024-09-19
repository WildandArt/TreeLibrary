package com.treelibrary.Impl;

import com.treelibrary.AVLNode;

public class AVLNodeImpl<T> extends NodeImpl<T> implements AVLNode<T> {

    int height;
    AVLNode<T> right;
    AVLNode<T> left;
    AVLNode<T> parent;
    
    public AVLNodeImpl(T data) {

        super(data);
        right = null;
        left = null;
        parent = null;

    }

    @Override
    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    @Override
    public void setRight(AVLNode<T> right) {
        this.right = right;
    }
    @Override
    public AVLNode<T> getLeft() {
       return left;
    }

    @Override
    public AVLNode<T> getRight() {
       return right;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }

    

}
