package com.treelibrary;

public class AVLImpl<T extends Comparable<T>> implements Rotatable<T, AVLNode<T>> {

    @Override
    public AVLNode<T> rotateLeft(AVLNode<T> node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotateLeft'");
    }

    @Override
    public AVLNode<T> rotateRight(AVLNode<T> node) {
        AVLNode<T> leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());

        leftChild.setRight(node);

        updateHeight(node);
        updateHeight(leftChild);
      
        return leftChild;

    }

    public void updateHeight(AVLNode<T> node) {

        int leftHeight = node.getRight().getHeight();
        int rightHeight = node.getLeft().getHeight();

        node.setHeight(Math.max(leftHeight, rightHeight) + 1);

    }

    private int height(AVLNode<T> node) {
        return node == null ? -1 : node.getHeight();
    }
    private int balanceFactor(AVLNode<T> node) {
        return height(node.getRight()) - height(node.getLeft());
    }
}
