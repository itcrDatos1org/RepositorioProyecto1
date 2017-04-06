package com.progra1.ESTDAT;

import java.awt.*;

public class lista<T> {
    private node<T> head;
    private int capacidad;

    public lista() {
        this.head = null;
        this.capacidad = 0;
    }

    public void add(T data) {
        if (capacidad == 0) {
            node<T> aux = new node<T>(data);
            this.head = aux;
            head.setNext(null);
            capacidad++;
        } else {
            node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            node<T> aux = new node<T>(data);
            aux.setNext(null);
            current.setNext(aux);
            capacidad++;
        }
    }

    private void delete(int posicion) {
        int pos_aux = posicion;
        node<T> current = head;
        if (pos_aux == 0) {
            this.head = current.getNext();
            capacidad--;
        } else if (pos_aux == capacidad) {
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
            capacidad--;
        } else {
            while (pos_aux != 2) {
                current = current.getNext();
                pos_aux--;
            }
            current.setNext(current.getNext().getNext());
            capacidad--;
        }

    }

    public void delete(T dato) {
        int pos_aux = 0;
        node<T> current = head;
        if (current.getData() == dato) {
            delete(pos_aux);
        } else {
            current = current.getNext();
            pos_aux++;
            while (current.getData() != dato) {
                current = current.getNext();
                pos_aux++;
            }
            delete(pos_aux);
        }
    }

    public T getI(int i){
        node<T> aux = this.getHead();
        int x = 0;
        while(x != i){
            aux = aux.getNext();
            x++;
        }
        return aux.getData();
    }
    public node<T> getHead() {
        return head;
    }

    public void setHead(node<T> head) {
        this.head = head;
    }


    public int capacidad() {
        return capacidad;
    }




}

