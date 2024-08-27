package com.treelibrary;

import java.util.function.Consumer;

public interface BST<T> {

    public Node<T> getRoot();
    boolean isEmpty();
    int count();
    Node<T> insert(T data);
    Node<T> find(T data);
    T remove(Node<T> node);
    Node<T> findMin(Node <T> root);
    Node<T> findMax(Node <T> root);
    Node<T> next(Node<T> node);
    Node<T> prev(Node<T> node);

    /**
     * Traverses the BST in in-order and performs an action on each node.
     * 
     * @param action the action to be performed on each node.
     */
    void traverseInOrder(Consumer<T> action);

    /**
     * Traverses the BST in pre-order and performs an action on each node.
     * 
     * @param action the action to be performed on each node.
     */
    void traversePreOrder(Consumer<T> action);

    /**
     * Traverses the BST in post-order and performs an action on each node.
     * 
     * @param action the action to be performed on each node.
     */
    void traversePostOrder(Consumer<T> action);

    int height();
    void clear();
}
