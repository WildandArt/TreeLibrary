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



}
