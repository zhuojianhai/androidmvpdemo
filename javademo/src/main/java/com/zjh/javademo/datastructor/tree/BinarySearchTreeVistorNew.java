package com.zjh.javademo.datastructor.tree;

import com.zjh.javademo.datastructor.tree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
public class BinarySearchTreeVistorNew<E> implements BinaryTreeInfo {

    private int size = 0;//大小
    private Node<E> root = null;//树的根节点

    public Node<E> getRoot() {
        return root;
    }

    //jdk 提供的元素比较器接口
    private Comparator comparator;

    public BinarySearchTreeVistorNew(){
        this(null);
    }

    public BinarySearchTreeVistorNew(Comparator<E> comparator){
        this.comparator = comparator;
    }

    public  void preorderTraversal(){
        preorderTraversal(root);
    }

    /**
     * 前序遍历
     * 非递归调用
     * @param node
     */
    private void preorderTraversal(Node<E> node){
        System.out.println("非递归方式的 前序遍历");
        if (node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()){
            Node<E> outNode = stack.pop();
            System.out.println(outNode.elment);
            //栈是先进后出，（这点是前序遍历，根-左-右）所以要先把右节点先放入栈中，这点 要注意！！！
            if (outNode.right!=null){

                stack.push(outNode.right);
            }
            if (outNode.left!=null){
                stack.push(outNode.left);
            }
        }
    }


    public void postorderTraversal(){
        postorderTraversal(root);
    }

    /**
     * 后续遍历
     * 非递归方式实现，主要借助栈数据结构
     * @param root
     */
    private void postorderTraversal(Node<E> root){

        if (root == null) return;
        Stack<Node> stack  = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.elment);
            while (node.left!=null){
                stack.push(node.left);
                node = node.left;
            }


        }

    }

    /**
     * 层序遍历
     * 需要借助队列来实现树的层序遍历
     * 队是先进先出
     */
    public void levelOrderTraversal(){
        levelOrderTraversal(root);
    }
    private void levelOrderTraversal(Node<E> root){
        if (root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        //入队
        queue.offer(root);
        //队列不为空，不断从队列头取节点
        while (!queue.isEmpty()){
            //取头结点
            Node<E> node = queue.poll();

            System.out.println(node.elment);

            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }

        }


    }

    public void revertTree(){
        revertTree(root);
    }
    /**
     * 二叉树翻转
     * @param root
     */
    public Node<E> revertTree(Node<E> root){
        if (root == null) return root;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            Node<E> temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left!=null){
                queue.add(node.left);
            }

            if (node.right!=null){
                queue.add(node.right);
            }

        }
        return root;
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
