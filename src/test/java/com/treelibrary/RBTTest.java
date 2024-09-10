package com.treelibrary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import com.treelibrary.Impl.RBTImpl;

import static org.junit.jupiter.api.Assertions.*;




public class RBTTest {

private RBT<Integer> rbt;

    @BeforeEach
    public void setup() {
        rbt = new RBTImpl<>();
    }

    @Test
    public void testInsert() {

        rbt.insert(10);
        
    }
    @Test
    public void testRemove() {
        
    }
    @Test
    public void testClear() {
        
    }
}