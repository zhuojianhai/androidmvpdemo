package com.zjh.javademo.datastructor.tree;

import com.zjh.javademo.datastructor.tree.printer.BinaryTreeInfo;

import java.util.Comparator;

/***
 * 二叉搜索树
 * 遍历
 * 根据根节点访问顺序，可以分为4中访问顺序
 * 前序遍历
 * 中序遍历
 * 后续遍历
 * 层级遍历
 * @param <E>
 */
public class BinarySearchTreeVistor<E> implements BinaryTreeInfo {

    private int size = 0;//大小
    private Node<E> root = null;//树的根节点

    public Node<E> getRoot() {
        return root;
    }

    //jdk 提供的元素比较器接口
    private Comparator comparator;

    public BinarySearchTreeVistor(){
        this(null);
    }

    public BinarySearchTreeVistor(Comparator<E> comparator){
        this.comparator = comparator;
    }

    public  void preorderTraversal(){
        preorderTraversal(root);
    }

    /**
     * 前序遍历
     * 递归调用
     * @param node
     */
    private void preorderTraversal(Node<E> node){
        if (node == null) return;
        System.out.println("当前节点元素值："+node.elment);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }


    public void postorderTraversal(){
        postorderTraversal(root);
    }

    /**
     * 后续遍历
     * @param root
     */
    private void postorderTraversal(Node<E> root){

        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.elment);

    }
    public void add(E element){
        //如果是第一次添加元素
        if (root == null){
            root = new Node<>(element,null);
            size ++;
            return;
        }

        Node<E> parent = root;
        Node<E> node = root;

        int com = 0;

        //得到当前元素需要插入的父节点，以及需要插入的位置
        while (node!=null){
            parent = node;
            com = compare(element,node.elment);
            if (com >0){
                node = node.right;
            }else  if(com<0){
                node = node.left;
            }else { //相等 默认不处理
                return;
            }
        }

        Node<E> addNode = new Node<>(element,parent);
        if (com>0){
            parent.right = addNode;
        }else{
            parent.left = addNode;
        }
        size++;
    }

    private int compare(E e1,E e2){
        if (comparator!=null){
            return comparator.compare(e1,e2);
        }
        return ((Comparable)e1).compareTo(e2);
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return((Node<E>)node).elment;
    }

    static class Node<E>{
        E elment;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E elment,Node<E> parent){
            this.elment = elment;
            this.parent = parent;
        }

        public E getElment() {
            return elment;
        }

        public void setElment(E elment) {
            this.elment = elment;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }
    }
}
