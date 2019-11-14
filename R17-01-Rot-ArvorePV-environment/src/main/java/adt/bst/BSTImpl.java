package adt.bst;

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
		return height((BSTNode<T>)root);
	}
	
	private int height(BSTNode<T> node) {
		if(node.isEmpty()) return -1;
		
		return 1+ Math.max(height((BSTNode<T>)node.getLeft()), height((BSTNode<T>)node.getRight()));
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, root);
	}
	
	private BSTNode<T> search(T element, BSTNode<T> node){
		if(node.isEmpty() || element == null) return new BSTNode<T>();
		
		if(element.compareTo(node.getData()) == 0) return node;
		
		if(element.compareTo(node.getData()) < 0) return search(element, (BSTNode<T>) node.getLeft());
		
		else
			return search(element, (BSTNode<T>) node.getRight());
		
		
	}

	@Override
	public void insert(T element) {
		insert(element, (BSTNode<T>) root);
	}
	
	private void insert(T element, BSTNode<T> node) {
		if(element != null) {
			if(node.isEmpty()) {
				node.setData(element);
				node.setLeft(new BSTNode<T>());
				node.setRight(new BSTNode<T>());
				node.getLeft().setParent(node);
				node.getRight().setParent(node);
				return;
			}
			
			if(element.compareTo(node.getData()) < 0) {
				insert(element, (BSTNode<T>) node.getLeft());
			}
			else if(element.compareTo(node.getData()) > 0)
				insert(element, (BSTNode<T>)node.getRight());
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(root);
	}
	
	private BSTNode<T> maximum(BSTNode<T> node){
		if(node == null || node.isEmpty()) return null;
		
		if(node.getRight() == null || node.getRight().isEmpty()) return node;
		
		return maximum((BSTNode<T>) node.getRight());
		
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(root);
	}
	
	private BSTNode<T> minimum(BSTNode<T> node){
		if(node == null || node.isEmpty()) return null;
		
		if(node.getLeft() == null || node.getLeft().isEmpty()) return node;
		
		return minimum((BSTNode<T>) node.getLeft());
		
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> procurado = search(element);
		BSTNode<T> result = null;
		if(procurado != null && !procurado.isEmpty()) {
			if(procurado.getRight() != null && !procurado.getRight().isEmpty()) {
				result = minimum((BSTNode<T>) procurado.getRight());
			}
			else {
				BSTNode<T> ascProcurado = (BSTNode<T>) procurado.getParent();
				while(ascProcurado.getParent() != null && !ascProcurado.getParent().isEmpty() && 
						ascProcurado.getData().compareTo(procurado.getData()) < 0) {
						ascProcurado = (BSTNode<T>) ascProcurado.getParent();
				}
				result = ascProcurado;
			}
		}
		return result;
		
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> procurado = search(element);
		BSTNode<T> result = null;
		if(procurado != null && !procurado.isEmpty()) {
			if(procurado.getRight() != null && !procurado.getRight().isEmpty()) {
				result = maximum((BSTNode<T>) procurado.getLeft());
			}
			else {
				BSTNode<T> ascProcurado = (BSTNode<T>) procurado.getParent();
				while(ascProcurado.getParent() != null && !ascProcurado.getParent().isEmpty() && 
						ascProcurado.getData().compareTo(procurado.getData()) > 0) {
						ascProcurado = (BSTNode<T>) ascProcurado.getParent();
				}
				result = ascProcurado;
			}
		}
		return result;
	}

	@Override
	public void remove(T element) {
		if(element != null) {
			BSTNode<T> removido = search(element);
			remove(removido);
		}
	}
	
	private void remove(BSTNode<T> removido) {
		if(!removido.isEmpty()) {
			if(removido.isLeaf()) {
				removido.setData(null);
			}
			else if(!removido.getLeft().isEmpty() && removido.getRight().isEmpty()) {
				troca((BSTNode<T>) removido.getLeft(), removido);
			}
			else if(!removido.getRight().isEmpty() && removido.getLeft().isEmpty()) {
				troca((BSTNode<T>) removido.getRight(), removido);
			}
			else {
				
			}
		}
	}
	
	private void troca(BSTNode<T> auxNode, BSTNode<T> node) {
		
		if(node.getParent() == null) {
			auxNode.setParent(null);
			this.root = auxNode;
		}
		else {
			if(node.getParent().getLeft().getData().equals(node.getData())) {
				node.getParent().setLeft(auxNode);
			}
			else {
				node.getParent().setRight(auxNode);
			}
		}
		
		auxNode.setParent(node.getParent());
		
		
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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
