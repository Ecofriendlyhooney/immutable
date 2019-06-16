package immutable;

public final class ImmutableStack<T> implements Stack<T>{

	public final Stack<T> push(T t){		
		return new ImmutableStack<T>(t, this);
	}
	
	public final Stack<T> pop(){
		return tail;
	}
	
	public final T head(){
		return head;
	}
	
	public final boolean isEmpty(){
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public final static Stack getEmptyStack(){
		return EmptyStack.getInstance();
	}
	
	private final T head;
	private final Stack<T> tail;
	
	private ImmutableStack(T head, Stack<T> tail){
		this.head = head;
		this.tail = tail;
	}
	
	private static final class EmptyStack<T> implements Stack<T>{
		
		@SuppressWarnings("rawtypes")
		private final static EmptyStack emptyStack = new EmptyStack();
		
		//  #Removes the element at the beginning of the immutable queue, and returns the new queue.
		@SuppressWarnings("rawtypes")
		public final static EmptyStack getInstance(){
			return emptyStack;
		}
		
		public final Stack<T> push(T t){			
			return new ImmutableStack<T>(t, this);
		}
		
		public final Stack<T> pop() throws Exception{
			throw new Exception("Stack is empty.");
		}
		
		public final T head() throws Exception{
			throw new Exception("Stack is empty.");
		}
		
		public final boolean isEmpty(){
			return true;
		}
	}
} 