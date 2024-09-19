package com.treelibrary;

public interface AVLNode<T> extends Node<T> {

    void setLeft(AVLNode<T> left);
    void setRight(AVLNode<T> right);
    AVLNode<T> getLeft();
    AVLNode<T> getRight();
    int getHeight();
    void setHeight(int height);    

}
