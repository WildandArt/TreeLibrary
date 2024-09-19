package com.treelibrary.Impl;

import java.util.ArrayList;
import java.util.List;

import com.treelibrary.RBT;
import com.treelibrary.RBTNode;


public class RBTImpl<T extends Comparable<T>> extends BSTImpl<T> implements RBT<T> {

     public RBTImpl() {
        super();
     }

    // @Override
    // public  T remove(RBTNode<T> node) {
    //     return null;
    // }
    @Override
    public T remove(T data) {

      RBTNode<T> node = find(data);

      if (node == null) {
        return null;
      }

      T removedData = node.getData();

      RBTNode<T> movedUpNode;
      boolean deletedNodeColor;

      if (node.hasOneChild()) {

        movedUpNode = deleteNodeWithZeroOrOneChild(node);
        deletedNodeColor = node.isRed();

      }
      else {//has 2 children
         //find inorder successor of current node)
         RBTNode<T> inOrderSuccessor = findMin(node.getRight());
    
         // Copy inorder successor's data to current node (keep its color!)
         node.setData(inOrderSuccessor.getData()); 
     
         // Delete inorder successor just as we would delete a node with 0 or 1 child
         movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
         deletedNodeColor = inOrderSuccessor.isRed();
      }

      if (deletedNodeColor == false) {
        fixRedBlackPropertiesAfterDelete(movedUpNode);
        // Remove the temporary NIL node
        if (movedUpNode instanceof NilNode) {
          replaceParentsChild(movedUpNode.getParent(), movedUpNode, null);
        }
      }
      return removedData;
    }

    public List<T> inOrderTraversal() {

    List<T> result = new ArrayList<>();
    inOrderTraversalHelper(this.getRoot(), result);
    return result;

}

private void inOrderTraversalHelper(RBTNode<T> node, List<T> result) {

    if (node == null || node instanceof NilNode) return;

    inOrderTraversalHelper(node.getLeft(), result);
    result.add(node.getData());
    inOrderTraversalHelper(node.getRight(), result);

}

    private void fixRedBlackPropertiesAfterDelete(RBTNode<T> node) {
      // Case 1: Examined node is root, end of recursion
      if (node == getRoot()) {
        return;
      }
    
      RBTNode<T> sibling = node.getSibling();
    
      // Case 2: Red sibling
      if (sibling.isRed()) {
        handleRedSibling(node, sibling);
        sibling = node.getSibling(); // Get new sibling for fall-through to cases 3-6
      }
    
      // Cases 3+4: Black sibling with two black children
      if (sibling.getLeft().isBlack() && sibling.getRight().isBlack()) {
        sibling.setRed(true);
    
        // Case 3: Black sibling with two black children + red parent
        if (node.getParent().isRed()) {
          node.getParent().setRed(false);
        }
    
        // Case 4: Black sibling with two black children + black parent
        else {
          fixRedBlackPropertiesAfterDelete(node.getParent());
        }
      }
    
      // Case 5+6: Black sibling with at least one red child
      else {
        handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
      }
    }

    private void handleRedSibling(RBTNode<T> node, RBTNode<T> sibling) {
      //Recolor...
      sibling.setRed(false);
      node.getParent().setRed(true);
    
      // ... and rotate
      if (node == node.getParent().getLeft()) {
        rotateLeft(node.getParent());
      } else {
        rotateRight(node.getParent());
      }
    }
    private void handleBlackSiblingWithAtLeastOneRedChild(RBTNode<T> node, RBTNode<T> sibling) {
      boolean nodeIsLeftChild = node.isLeftChild();
    
      // Case 5: Black sibling with at least one red child + "outer nephew" is black
      // --> Recolor sibling and its child, and rotate around sibling
      if (nodeIsLeftChild && (sibling.getRight()).isBlack()) {
        sibling.getLeft().setRed(false);
        sibling.setRed(true);
        rotateRight(sibling);
        sibling = node.getParent().getRight();
      } 
      else if (!nodeIsLeftChild && sibling.getLeft().isBlack()) {
        sibling.getRight().setRed(false);
        sibling.setRed(true);
        rotateLeft(sibling);
        sibling = node.getParent().getLeft();
      }
    
      // Fall-through to case 6...
    
      // Case 6: Black sibling with at least one red child + "outer nephew" is red
      // --> Recolor sibling + parent + sibling's child, and rotate around parent
      sibling.setRed(node.getParent().isRed());
      node.getParent().setRed(false);
      if (nodeIsLeftChild) {
        sibling.getRight().setRed(false);
        rotateLeft(node.getParent());
      } else {
        sibling.getLeft().setRed(false);
        rotateRight(node.getParent());
      }
    }
    
   
    @Override
    public void clear() {

    }
    
    @Override
    public RBTNode<T> find(T data) {
        RBTNode<T> iterator = (RBTNode<T>) getRoot(); // Safely cast to RBTNode<T>

        while (iterator != null) {
            int comparison = data.compareTo(iterator.getData());

            if (comparison == 0) {
                return iterator;
            }

            if (comparison < 0) {
                iterator = (RBTNode<T>) iterator.getLeft();
            } else {
                iterator = (RBTNode<T>) iterator.getRight();
            }
        }
        return null;
    }
    @Override
    public RBTNode <T> findMin(RBTNode <T> root) {

        if (root == null) {
            return null;
        }

        RBTNode<T> iterator = root;

        while (iterator.getLeft() != null) {

            iterator = iterator.getLeft();

        }

        return iterator;
    }

    @Override
    public RBTNode<T> getRoot() {
        return (RBTNode<T>) super.getRoot();  // Safely cast to RBTNode<T>
    }

    @Override
    public RBTNode<T> insert(T data) {

        
        RBTNode <T> iterator = (RBTNode <T>) this.getRoot();
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
        if (parent == null) {
            setRoot(rightChild);  
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
    public RBTNode<T> deleteNodeWithZeroOrOneChild(RBTNode<T> node) {
      // Node has ONLY a left child --> replace by its left child
      RBTNode<T> parent = (RBTNode<T>) node.getParent();
      RBTNode<T> leftChild = (RBTNode<T>) node.getLeft();
      if (node.hasLeftChild() && (node.hasOneChild())) {
        replaceParentsChild(parent, node, leftChild);
        return (RBTNode<T>) node.getLeft(); // moved-up node
    }

      // Node has ONLY a right child --> replace by its right child
      else if (node.hasRightChild() && node.hasOneChild()) {
        replaceParentsChild(node.getParent(), node, node.getRight());
        return node.getRight(); // moved-up node
      }

      // Node has no children -->
      // * node is red --> just remove it
      // * node is black --> replace it by a temporary NIL node (needed to fix the R-B rules)
      else {
        RBTNode<T> newChild = node.isRed() == false ? new NilNode() : null;
        replaceParentsChild(node.getParent(), node, newChild);
        return newChild;
      }
  }
  private static class NilNode<T> extends RBTNodeImpl<T> {
    private NilNode() {
      super(null);
      this.setRed(false);
    }
  }
  

}
