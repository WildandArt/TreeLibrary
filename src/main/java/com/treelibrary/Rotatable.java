package com.treelibrary;

public interface Rotatable<T> {
    void rotateLeft(Node<T> node);
    void rotateRight(Node<T> node);
}
