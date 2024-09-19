package com.treelibrary;

import java.util.List;

public interface RBT<T> extends BST<T> {
    T remove(T data);
    void clear();
    RBTNode<T> insert(T data);
    void rotateRight(RBTNode<T> node);
    void rotateLeft(RBTNode<T> node);
    RBTNode<T> getRoot();
    RBTNode<T> find(T data);
    RBTNode<T> deleteNodeWithZeroOrOneChild(RBTNode<T> node);
    RBTNode<T> findMin(RBTNode <T> root);
    public List<T> inOrderTraversal();
}
