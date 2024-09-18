package com.treelibrary;

public interface RBTNode<T> extends Node<T> {
    void setRed(boolean isRed);
    void setLeft(RBTNode<T> left);
    void setRight(RBTNode<T> right);
    void setParent(RBTNode<T> parent);
    boolean isRed();
    RBTNode<T> getLeft();
    RBTNode<T> getRight();
    RBTNode<T> getParent();
    RBTNode<T> getSibling();
    boolean isBlack();
}
