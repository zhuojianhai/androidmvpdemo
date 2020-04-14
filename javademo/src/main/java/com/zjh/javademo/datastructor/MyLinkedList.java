package com.zjh.javademo.datastructor;

import java.util.LinkedList;

/***
 * 双向列表
 * @param <E>
 */
public class MyLinkedList<E> {
    private static class MyNode<E>{
        E data;
        MyNode pre;
        MyNode next;
        public MyNode(){

        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public MyNode getPre() {
            return pre;
        }

        public void setPre(MyNode pre) {
            this.pre = pre;
        }

        public MyNode getNext() {
            return next;
        }

        public void setNext(MyNode next) {
            this.next = next;
        }
    }

    private MyNode first=null;
    private MyNode last=null;
    private int size=0;

    public void add(E element){

        MyNode<E> newNode = new MyNode<>();

        if(first == null){
            newNode.setPre(null);
            newNode.setData(element);
            newNode.setNext(null);

            first = newNode;
            last = newNode;
        }else{
            newNode.setPre(last);
            newNode.setData(element);
            newNode.setNext(null);

            last.setNext(newNode);
            last = newNode;

        }
        size++;
    }

    public void adde(E data){
        MyNode<E> n = new MyNode<>();
        if(first == null){
            n.setPre(null);
            n.setData(data);
            n.setNext(null);

            first = n;
            last = n;
        }else{
            n.setPre(last);
            n.setData(data);
            n.setNext(null);

            last.setNext(n);//设置之前最后一个节点的下一个节点为当前节点
            last = n;//更新当前节点为最后一个节点
        }
    }

    public void add(int index,E data){

        MyNode<E> temp = node(index);

        MyNode<E> n = new MyNode<>();
        if(temp!=null){

            n.setPre(temp.pre);   //当前的节点指向原先节点的前一节点
            temp.pre.setNext(n);      //原先节点后继指向当前节点

            n.setData(data);
            n.setNext(temp);
            temp.setPre(n);

        }
        size++;
    }
    public <E> E get(int index){
        MyNode<E> temp = node(index);

        if(temp !=null){
            return temp.getData();
        }
        return null;

    }


    public void remove(int index){
        MyNode temp = node(index);
        if(temp == null) return;

        MyNode pre = temp.pre; //当前节点的前一个节点
        MyNode next = temp.next;//当前节点的后一个节点
        temp.data = null;


        temp.pre.setNext(next);
        temp.next.setPre(pre);
        size--;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    /***
     * 获取指定node
     * @param index
     * @return
     */
    public MyNode node(int index){
        MyNode<E> temp = null;
        if(first!=null){
            temp = first;
        }

        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        if(temp!=null){
            return  temp;
        }
        return null;
    }
    public int getSize() {
        return size;
    }



    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("demo");
        System.out.println(linkedList.getSize());
        System.out.println(linkedList.get(0));
        linkedList.add(1,"world");

        System.out.println(linkedList.get(1));

        linkedList.remove(1);
        System.out.println(linkedList.size);
    }
}
