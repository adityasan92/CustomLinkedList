
public class CustomLinkedList {
	private Node head;
	private int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomLinkedList list = new CustomLinkedList();
		list.add(4);
		list.add("Hello World");
		list.add("new World");
		list.printList();
	}
	
	public CustomLinkedList(){
		head = new Node(null);
		count =0; 
	}
	
	public void add(Object data){
	   Node tempNode = new Node(data);
	   Node currentNode = head; 
	   
	   while(currentNode.getNextNode() != null){
		   currentNode = currentNode.getNextNode();
	   }
	   
	  currentNode.setNextNode(tempNode);
	  count++; 
	}
	
	public void printList(){
		Node currentNode = head.getNextNode();
		
		while(currentNode.getNextNode() != null){
			
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
		System.out.println(currentNode.getData());
	}
	
	private class Node{
		
		Node next = null;
		Object nodeData; 
		
		public Node(Object data){
			nodeData = data;
		}
		
		public Object getData(){
			return nodeData;
		}
		
		public Node getNextNode(){
			return next; 
		}
		
		public void setNextNode(Node newNode){
			next = newNode; 
		}
		
	}
	
}
