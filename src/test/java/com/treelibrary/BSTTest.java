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
        assertEquals(null, bst.getRoot());
        assertEquals(0, bst.count());

    }

    @Test
    public void testInsert() {
        // Test to insert elements and validate structure
    }

    @Test
    public void testCount() {
        // Test to count the number of elements in the BST
    }

    @Test
    public void testFind() {
        // Test to find an element in the BST
    }

    @Test
    public void testRemove() {
        // Test to remove elements from the BST and validate the structure
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
        // Test to find the in-order successor of a given node
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
