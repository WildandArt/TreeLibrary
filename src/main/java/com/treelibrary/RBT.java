package com.treelibrary;

public interface RBT<T> extends BST<T> {
    T remove(RBTNode<T> node);
    void clear();
    RBTNode<T> insert(T data);
    void rotateRight(RBTNode<T> node);
    void rotateLeft(RBTNode<T> node);
}
