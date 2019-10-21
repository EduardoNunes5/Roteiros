package adt.stack;

import adt.linkedList.SingleLinkedListNode;

/**
 * Classe que representa um apilha implementada usando-se um noh de uma lista
 * simplesmente ligada, como estrutura sobrejacente. 
 * 
 * Restricoes:
 * - voce DEVE obedecer a politica de acesso e complexidade dos metodos de pilha, ou seja, todos em O(1).
 * - voce NÃO pode usar memoria extra (estrutura auxiliar)
 * - qualquer metodo auxiliar que voce necessite DEVE ser implementado nesta classe
 * - voce NÃO pode modificar a classe SingleLinkedListNode
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class StackSingleLinkedListNodeImpl<T> implements Stack<T> {
	
	private SingleLinkedListNode<T> top;
	private int tamMax;
	private int numElem = 0;

	/**
	 * A pilha para ser criada precisa ter um tamanho maximo
	 * @param tamanhoMaximo
	 */
	public StackSingleLinkedListNodeImpl(int tamanhoMaximo) {
		this.top = new SingleLinkedListNode<T>();
		this.tamMax = tamanhoMaximo;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(element == null) return;

		if(isFull()){
			throw new StackOverflowException();
		}

		SingleLinkedListNode<T> newTop = new SingleLinkedListNode(element, new SingleLinkedListNode<>());
		newTop.setNext(top);
		this.top = newTop;
		this.numElem++;

	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()){
			throw new StackUnderflowException();
		}
		T toRemove = this.top.getData();
		this.top = top.getNext();
		this.numElem--;
		return toRemove;
	}

	@Override
	public T top() {
		return this.top.getData();
	}

	@Override
	public boolean isEmpty() {
		return this.numElem == 0  && this.tamMax != this.numElem;
	}

	@Override
	public boolean isFull() {
		return this.numElem >= tamMax;
	}

}
