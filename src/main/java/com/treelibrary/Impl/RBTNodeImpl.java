package com.treelibrary.Impl;

import com.treelibrary.RBTNode;

public class RBTNodeImpl<T> extends NodeImpl<T> implements RBTNode<T> {

    private boolean isRed;

    public RBTNodeImpl(T data) {
        super(data);
        this.isRed = true;
    }
    
    @Override
    public boolean isRed() {
        return isRed;
    }

    @Override
    public void setRed(boolean isRed) {
        this.isRed = isRed;
    }
    
}
