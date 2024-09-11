package com.treelibrary.Impl;

import com.treelibrary.Node;
import com.treelibrary.RBT;
import com.treelibrary.RBTNode;


public class RBTImpl<T extends Comparable<T>> extends BSTImpl<T> implements RBT<T> {

     private RBTNode<T> rootNode;

     public RBTImpl() {
        rootNode = null;
     }

    @Override
    public  T remove(RBTNode<T> node) {
        return null;
    }
    @Override
    public void clear() {

    }

    @Override
    public RBTNode<T> insert(T data) {

        return null;
    }

    public void rotateRight(RBTNode<T> node) {
        RBTNode<T> parent = (RBTNode<T>) node.getParent();
        RBTNode<T> leftChild = (RBTNode<T>) node.getLeft();

        node.setLeft(leftChild.getRight());

        if (leftChild.getRight() != null) {
            leftChild.getRight().setParent(node);
        }

        leftChild.setRight(node);
        node.setParent(leftChild);

        replaceParentsChild(parent, node, leftChild);
    }

    private void replaceParentsChild(RBTNode<T> parent, RBTNode<T> oldChild, RBTNode<T> newChild) {
        if (parent == null) {
            setRoot(newChild);
          } else if (parent.getLeft() == oldChild) {
            parent.setLeft(newChild);
          } else if (parent.getRight() == oldChild) {
            parent.setRight(newChild);
          } else {
            throw new IllegalStateException("Node is not a child of its parent");
          }
        
          if (newChild != null) {
            newChild.setParent(parent);
          }
    }

    public void rotateLeft(RBTNode<T> node) {
        RBTNode<T> parent = (RBTNode<T>) node.getParent();
        RBTNode<T> rightChild = (RBTNode<T>) node.getRight();

        node.setRight(rightChild.getLeft());

        if (rightChild.getLeft() != null) {
            rightChild.getLeft().setParent(node);
        }

        rightChild.setLeft(node);
        node.setParent(rightChild);

        replaceParentsChild(parent, node, rightChild);
    }
}
