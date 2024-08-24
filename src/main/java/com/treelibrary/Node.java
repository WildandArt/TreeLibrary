package com.treelibrary;

public interface Node<T> {
    T getData();
    void setData(T data);

    Node<T> getLeft();
    void setLeft(Node<T> left);

    Node<T> getRight();
    void setRight(Node<T> right);
}
