package com.treelibrary;

public interface RBT<T> extends BST<T> {
    T remove(Node<T> node);
    void clear();
    Node<T> insert(T data);
}
