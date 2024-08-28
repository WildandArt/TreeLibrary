package com.treelibrary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.treelibrary.Impl.BSTImpl;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

    private BST<Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new BSTImpl<>();
    }

    @Test
    public void testIsEmpty() {
        assertEquals(true, bst.isEmpty());
        assertEquals(0, bst.count());

    }

    @Test
    public void testInsert() {
        Node <Integer> node7 = bst.insert(7);
        assertEquals(node7.getData(), 7);
        assertEquals(bst.count(), 1);

        Node <Integer> node8 = bst.insert(8);
        assertEquals(bst.count(), 2);

        Node <Integer> node9 = bst.insert(9);
        assertEquals(bst.count(), 3);

        Node <Integer> node2 = bst.insert(2);
        System.out.print(bst.toString());
        assertEquals(node7.getRight(), node8);
        assertEquals(node7.getLeft(), node2);
        assertEquals(node8.getLeft(), null);
        assertEquals(node8.getRight(), node9);

        assertEquals(bst.count(), 4);

    }

    @Test
    public void testCount() {
        assertEquals(true, bst.isEmpty());
    }

    @Test
    public void testFind() {
        // Test to find an element in the BST
    }

    @Test
    public void testRemoveEmpty() {
       
        assertEquals(null,  bst.remove(bst.getRoot()));
    }
    @Test
    public void testRemoveLeaf() {
       Node<Integer> node8 = bst.insert(8);
       assertEquals(bst.count(), 1);
       assertEquals(8, bst.remove(node8));
       assertEquals(bst.count(), 0);
       Node<Integer> node17 = bst.insert(17);
       Node<Integer> node4 = bst.insert(4);
       Node<Integer> node3 = bst.insert(3);

       assertEquals(3, bst.remove(node3));
       assertEquals(4, bst.remove(node4));

       assertEquals(bst.count(), 1);
    }


    @Test
    public void testRemoveOneChild() {
       Node<Integer> node17 = bst.insert(17);
       Node<Integer> node4 = bst.insert(4);
       Node<Integer> node3 = bst.insert(3);
       assertEquals(4, bst.remove(node4));


    }
    @Test
    public void testRemove2Children() {
       
    }

    @Test
    public void testFindMin() {
        // Test to find the minimum value in the BST
    }

    @Test
    public void testFindMax() {
        // Test to find the maximum value in the BST
    }

    @Test
    public void testNext() {

        Node<Integer> node20 = bst.insert(20);
        Node<Integer> node22 = bst.insert(22);
        Node<Integer> node8 = bst.insert(8);
        Node<Integer> node12 = bst.insert(12);
        Node<Integer> node10 = bst.insert(10);
        Node<Integer> node14 = bst.insert(14);
        Node<Integer> node4 = bst.insert(4);

        System.out.println(bst.toString());

       assertEquals(bst.next(node12), node14);
       //highest value in a tree
       assertEquals(bst.next(node22), null);

       assertEquals(bst.next(node8), node10);
       assertEquals(bst.next(node20), node22);

       //no right tree, going up with the parent
       assertEquals(bst.next(node14), node20);
    }

    @Test
    public void testPrev() {
        // Test to find the in-order predecessor of a given node
    }

    @Test
    public void testTraverseInOrder() {
        // Test to traverse the BST in in-order and validate the traversal
    }

    @Test
    public void testTraversePreOrder() {
        // Test to traverse the BST in pre-order and validate the traversal
    }

    @Test
    public void testTraversePostOrder() {
        // Test to traverse the BST in post-order and validate the traversal
    }

    @Test
    public void testHeight() {
        // Test to calculate the height of the BST
    }

    @Test
    public void testClear() {
        // Test to clear the BST and validate it is empty afterwards
    }
}
