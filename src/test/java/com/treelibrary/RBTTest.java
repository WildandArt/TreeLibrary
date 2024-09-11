package com.treelibrary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import com.treelibrary.Impl.RBTNodeImpl;
import com.treelibrary.Impl.RBTImpl;

import static org.junit.jupiter.api.Assertions.*;




public class RBTTest {

private RBT<Integer> rbt;

    @BeforeEach
    public void setup() {
        rbt = new RBTImpl<>();
    }
    @Test
    public void testRotateLeft() {

        RBTNode<Integer> node5 = new RBTNodeImpl<>(5);
        RBTNode<Integer> node2 = new RBTNodeImpl<>(2);
        RBTNode<Integer> node8 = new RBTNodeImpl<>(8);
        RBTNode<Integer> node12 = new RBTNodeImpl<>(12);
        RBTNode<Integer> node10 = new RBTNodeImpl<>(10);
        RBTNode<Integer> node6 = new RBTNodeImpl<>(6);
        RBTNode<Integer> node9 = new RBTNodeImpl<>(9);

        node5.setLeft(node2);
        node5.setRight(node10);
        node2.setParent(node5);
        node10.setParent(node5);

        node10.setRight(node12);
        node10.setLeft(node8);

        node12.setParent(node10);
        node8.setParent(node10);

        node8.setRight(node9);
        node8.setLeft(node6);

        node6.setParent(node8);
        node9.setParent(node8);

        //Before Rotation
        //     5
        //     / \
        //    2   10
        //        /  \
        //       8    12
        //      / \
        //     6   9
  
        rbt.rotateLeft(node5);

        assertEquals(node10.getRight(), node12);
        assertEquals(node10.getLeft(), node5);
        
        //After Rotation
        //     10
        //     /  \
        //    5    12
        //   / \
        //  2   8
        //     / \
        //    6   9

        assertEquals(node10, node5.getParent());
        assertEquals(node10, node12.getParent());

        assertEquals(node5.getRight(), node8);
        assertEquals(node5.getLeft(), node2);

        assertEquals(node5, node8.getParent());
        assertEquals(node5, node2.getParent());

        assertEquals(node8.getRight(), node9);
        assertEquals(node8.getLeft(), node6);

        assertEquals(node8, node9.getParent());
        assertEquals(node8, node6.getParent());


    }
    @Test
    public void testRotateRight() {
        // Create the nodes
        RBTNode<Integer> node12 = new RBTNodeImpl<>(12);
        RBTNode<Integer> node10 = new RBTNodeImpl<>(10);
        RBTNode<Integer> node15 = new RBTNodeImpl<>(15);
        RBTNode<Integer> node5 = new RBTNodeImpl<>(5);
        RBTNode<Integer> node7 = new RBTNodeImpl<>(7);
        RBTNode<Integer> node3 = new RBTNodeImpl<>(3);

        // Manually set up the tree structure before rotation
        node12.setLeft(node10);
        node12.setRight(node15);
        node10.setParent(node12);
        node15.setParent(node12);

        node10.setLeft(node5);
        node5.setParent(node10);

        node5.setLeft(node3);
        node5.setRight(node7);
        node3.setParent(node5);
        node7.setParent(node5);
        // Before:
        //         12
        //         /  \
        //       10    15
        //      /
        //     5
        //    / \
        //   3   7

        //After:
        //         10
        //        /   \
        //     5       12
        //    / \        \
        //   3   7        15

        rbt.rotateRight(node12);

        assertEquals(node10.getRight(), node12); // Node 12 should be the right child of node 10
        assertEquals(node10.getLeft(), node5);   // Node 5 should still be the left child of node 10
        assertEquals(node12.getRight(), node15); // Node 15 should still be the right child of node 12
        assertEquals(node12.getLeft(), null);    // Node 12 should no longer have a left child
        assertEquals(node12.getParent(), node10); // Node 12's parent should now be node 10

        assertEquals(node5.getLeft(), node3);    // Node 3 should still be the left child of node 5
        assertEquals(node5.getRight(), node7);   // Node 7 should still be the right child of node 5
        assertEquals(node5.getParent(), node10); // Node 5's parent should now be node 10

        assertEquals(node3.getParent(), node5);  // Node 3's parent should still be node 5
        assertEquals(node7.getParent(), node5);  // Node 7's parent should still be node 5
    }

    @Test
    public void testInsert() {

        RBTNode<Integer> node10 = rbt.insert(10);
        assertEquals(node10.getData(), 10);
        
    }
    @Test
    public void testRemove() {
        
    }
    @Test
    public void testClear() {
        
    }
}