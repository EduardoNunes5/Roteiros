package adt.bst;

import adt.bt.BT;
import adt.bt.BTNode;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> search(T element) {
		if(element == null) return new BSTNode<>();

		if(isEmpty()) return new BSTNode<>();
		else{
			return search(element, this.root);
		}
	}


	private  BSTNode<T> search(T element, BTNode<T> node){

		if(node.isEmpty()) return new BSTNode<>();

		if(node.getData() == element) return (BSTNode<T>) node;

		if(element.compareTo(node.getData()) < 0)
			return search(element, node.getLeft());
		else
			return search(element, node.getRight());

	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode max = null;

		BSTNode aux = this.root;
		while(!aux.isEmpty()){
			aux = (BSTNode) aux.getRight();
			max = aux;
		}

		return max;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode min = null;

		BSTNode aux = this.root;
		while(!aux.isEmpty()){
			aux = (BSTNode) aux.getLeft();
			min = aux;
		}

		return min;
	}

	@Override
	public BSTNode<T> sucessor(T element) {

	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		List<T> list = new ArrayList<>();
		if(isEmpty()) return (T[]) list.toArray();

		return preOrder(list, this.root);

	}

	private T[] preOrder(List list, BTNode<T> node){
		return null;
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
