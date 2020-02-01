package com.techno;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.sun.xml.internal.ws.api.message.Message;

import java.util.Iterator;

public class MyList<T> implements Iterator<T> {

    private int size = 0;
    private Node head;
    private Node iterNode = head;

    public MyList(){}

    public MyList(T t1, T t2){
        add(t1);
        add(t2);
    }

    public int getSize(){
        return size;
    }

    private void add(T data,Node node){
        if (node.link == null)
            node.link = new Node(data);
        else add(data, node.link);
    }

    public void add(T data){
        if (head==null)
            head = new Node(data);
        else
            add(data,head);
        size++;
        iterNode = head;
    }

    @Override
    public String toString() {
        String string = "[";
        for (int i = 0; i < size - 1; i++) {
            string+= get(i) + ", ";
        }
        string+= get(size - 1) + "]";
        return string;
    }

    public void remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
        if (index == 0) {
            head = head.link;
        } else {
            Node pref = head;
            for (int i = 0; i < index - 1; i++)
                pref = pref.link;
            pref.link = pref.link.link;
        }
        iterNode = head;
        size--;

    }

    private T get(int index, Node node){
        if (index==0) return node.data;
        else return get(index-1,node.link);
    }

    public T get(int index){
        if (index>=size || index<0)
            throw new IndexOutOfBoundsException("index: "+index+" size: "+size);
        return get(index,head);
    }

    @Override
    public boolean hasNext() {
        if (iterNode == null){
            iterNode = head;
            return  false;
        }
        else return true;
    }

    @Override
    public T next() {
        T data = iterNode.data;
        iterNode = iterNode.link;
        return data;
    }

    private class Node{
        T data;
        Node link = null;

        private Node(T data){
            this.data = data;
        }
    }
}