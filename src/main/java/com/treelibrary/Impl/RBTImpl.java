package com.treelibrary.Impl;

import com.treelibrary.RBT;
import com.treelibrary.RBTNode;


public class RBTImpl<T extends Comparable<T>> extends BSTImpl<T> implements RBT<T> {

     public RBTImpl() {
        super();
     }

    @Override
    public  T remove(RBTNode<T> node) {
        return null;
    }
    @Override
    public void clear() {

    }
    // public RBTNode<T> getRoot() {
    //     return rootNode;
    // }

    @Override
    public RBTNode<T> insert(T data) {

        
        RBTNode <T> iterator = (RBTNode <T>) getRoot();
        RBTNode <T> parent = null;
        
        while (null != iterator) {
            parent = iterator;

            if (data.compareTo(iterator.getData()) == 0) {
                
                throw new IllegalArgumentException("BST already contains a node with key " + data);
                
            }
            
            if (data.compareTo(iterator.getData()) < 0) {
                
                iterator = (RBTNode <T>) iterator.getLeft();
                
            }
            else if(data.compareTo(iterator.getData()) > 0) {
                
                iterator = (RBTNode <T>) iterator.getRight();
                
            }
        }
        
        RBTNode <T> newNode = new RBTNodeImpl <T>(data);
        newNode.setRed(true);
        
        if(parent == null) {
            setRoot(newNode);  
        } 
        else if(data.compareTo(parent.getData()) < 0) {
            parent.setLeft(newNode);
        }
        else {
            parent.setRight(newNode);
        }
        newNode.setParent(parent);

        fixImbalanceAfterInsert(newNode);

        return newNode;

    }
    private void fixImbalanceAfterInsert(RBTNode<T> node) {
        RBTNode <T> parent = (RBTNode <T>) node.getParent();

        // Case 1: Parent is null, we've reached the root, the end of the recursion
        if (parent == null) {
          // Uncomment the following line if you want to enforce black roots (rule 2):
          // node.color = BLACK;
          return;
        }
      
        // Parent is black --> nothing to do
        if (parent.isRed() == false) {
          return;
        }
      
        // From here on, parent is red
        RBTNode <T> grandparent =  (RBTNode <T>) parent.getParent();
      
        // Case 2:
        // Not having a grandparent means that parent is the root. If we enforce black roots
        // (rule 2), grandparent will never be null, and the following if-then block can be
        // removed.
        if (grandparent == null) {
          // As this method is only called on red nodes (either on newly inserted ones - or -
          // recursively on red grandparents), all we have to do is to recolor the root black.
          parent.setRed(false);
          return;
        }
      
        // Get the uncle (may be null/nil, in which case its color is BLACK)
        RBTNode <T> uncle = getUncle(parent);
      
        // Case 3: Uncle is red -> recolor parent, grandparent and uncle
        if (uncle != null && uncle.isRed()) {
          parent.setRed(false);
          grandparent.setRed(true);
          uncle.setRed(false);
      
          // Call recursively for grandparent, which is now red.
          // It might be root or have a red parent, in which case we need to fix more...
          fixImbalanceAfterInsert(grandparent);
        }
      
        // Parent is left child of grandparent
        else if (parent == grandparent.getLeft()) {
          // Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
          if (node == parent.getRight()) {
            rotateLeft(parent);
      
            // Let "parent" point to the new root node of the rotated sub-tree.
            // It will be recolored in the next step, which we're going to fall-through to.
            parent = node;
          }
      
          // Case 5a: Uncle is black and node is left->left "outer child" of its grandparent
          rotateRight(grandparent);
      
          // Recolor original parent and grandparent
          parent.setRed(false);
          grandparent.setRed(true);
        }
      
        // Parent is right child of grandparent
        else {
          // Case 4b: Uncle is black and node is right->left "inner child" of its grandparent
          if (node == parent.getLeft()) {
            rotateRight(parent);
      
            // Let "parent" point to the new root node of the rotated sub-tree.
            // It will be recolored in the next step, which we're going to fall-through to.
            parent = node;
          }
      
          // Case 5b: Uncle is black and node is right->right "outer child" of its grandparent
          rotateLeft(grandparent);
      
          // Recolor original parent and grandparent
          parent.setRed(false);
          grandparent.setRed(true);
        }
    }

    private RBTNode<T> getUncle(RBTNode<T> parent) {

        RBTNode<T> grandParent = (RBTNode<T>) parent.getParent();
        if (grandParent.getLeft() == parent) {
            return (RBTNode<T>) grandParent.getRight();
        }
        else if (grandParent.getRight() == parent) {
            return (RBTNode<T>) grandParent.getLeft();
        }
        else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
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

        if (parent == null) {
            setRoot(leftChild);  
        }
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
