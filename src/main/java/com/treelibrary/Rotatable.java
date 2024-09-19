package com.treelibrary;

public interface Rotatable<T, N extends Node<T>> {
    N rotateLeft(N node);
    N rotateRight(N node);
}
