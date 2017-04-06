package com.progra1.ESTDAT;

public class node <T>{
    private node<T> next;
    private T data;
    private node<T> prev;

    public node (T dato){
        this.data = dato;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public node<T> getNext() {
        return next;
    }

    public void setNext(node<T> next) {
        this.next = next;
    }

    public node<T> getPrev() {
        return prev;
    }

    public void setPrev(node<T> prev) {
        this.prev = prev;
    }

}
