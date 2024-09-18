package com.treelibrary.Impl;

import com.treelibrary.Node;
import com.treelibrary.RBTNode;

public class RBTNodeImpl<T> extends NodeImpl<T> implements RBTNode<T> {

    private boolean isRed;
    private RBTNode<T> left;
    private RBTNode<T> right;
    private RBTNode<T> parent;

    public RBTNodeImpl(T data) {
        super(data);
        this.isRed = true;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    
    @Override
    public boolean isRed() {
        return isRed;
    }

    @Override
    public boolean isBlack() {
        return this == null || this.isRed() == false;
    }

    @Override
    public void setRed(boolean isRed) {
        this.isRed = isRed;
    }

    @Override
    public RBTNode<T> getLeft() {
        return left;
    }

    @Override
    public void setLeft(RBTNode<T> left) {
        this.left = left;
    }

    @Override
    public RBTNode<T> getRight() {
        return right;
    }

    @Override
    public void setRight(RBTNode<T> right) {
        this.right = right;
    }

    @Override
    public RBTNode<T> getParent() {
        return parent;
    }

    @Override
    public void setParent(RBTNode<T> parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {

        return (!hasLeftChild()) && (!hasRightChild());

    }
    public boolean hasRightChild() {

        return null != this.getRight();

    }
    public boolean hasLeftChild() {

        return null != this.getLeft();

    }

    public boolean hasOneChild() {

        return (this.hasRightChild() && !this.hasLeftChild()) || this.hasLeftChild() && !this.hasRightChild();
    
    }


    @Override
    public boolean isLeftChild() {

        return (null != parent) && (parent.getLeft() == this);
        
    }

    @Override
    public boolean isRightChild() {

        return (null != parent) && (parent.getRight() == this);

    }
    @Override
    public RBTNode<T> getSibling(RBTNode<T> node) {
        RBTNode<T> parent = node.getParent();

      if (node == parent.getLeft()) {

        return parent.getRight();

      } 
      else if (node == parent.getRight()) {

        return parent.getLeft();

      } else {

        throw new IllegalStateException("Parent is not a child of its grandparent");
        
      }
    }


}
