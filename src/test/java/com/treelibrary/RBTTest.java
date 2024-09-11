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

        rbt.rotateRight();

        assertEquals(node10.getRight(), node12);
        assertEquals(node10.getLeft(), node5);

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