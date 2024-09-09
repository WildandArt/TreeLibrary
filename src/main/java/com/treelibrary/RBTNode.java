package com.treelibrary;

public interface RBTNode<T> extends Node<T> {
    boolean isRed();
    void setRed(boolean isRed);
}
