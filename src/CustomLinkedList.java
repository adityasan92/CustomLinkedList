import java.util.*; 
public class CustomLinkedList {
	private Node head;
	private int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomLinkedList list = new CustomLinkedList();
		list.add(4);
		/*list.add("Hello World");
		list.add("as World");
		list.add("new World");
		list.add(4);
		list.add("as World");
		list.add("new World");
		list.add(4);
		list.add("as World");
		list.add(4);
		list.add("Hello World");
		list.add("as World");
		list.add("new World");
		list.add(4);
		list.add("as World");
		list.add("asdsad World");*/
		list.add(7);
		list.add(3);
		list.add(8);
		list.add(9);
		list.add(1);
		list.add(2);
		list.add(7);
		
		//list.printList();
		//list.removeDuplicate();
		//list.removeDuplicateBuffer();
		//Object value = list.findKthElementLast(3);
		//System.out.println(value);
		//list.removeNode(3);
		list.partition(9);
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
	
	public void removeDuplicate(){	
		Node currentNode = head.getNextNode();
		Node prevNode = null;
		HashMap<Object,Boolean> map = new HashMap<Object,Boolean>();
		while(currentNode != null){
			//System.out.println(currentNode.getData());
			if(map.containsKey(currentNode.getData())){
				//System.out.println("There is a duplicate:" + map.containsKey(currentNode.getData()));
				Node nextNode = currentNode.getNextNode();
				/*if(nextNode != null){
					currentNode.setData(nextNode.getData());
					currentNode.setNextNode(nextNode.getNextNode());
				}*/
				prevNode.setNextNode(nextNode);
			}else{
				map.put(currentNode.getData(), false);
				prevNode = currentNode; 
			}
			
			currentNode = currentNode.getNextNode();
			
		}
	}
	
	public void removeDuplicateBuffer(){	
		
		Node currentNode = head.getNextNode();
		
		while(currentNode != null){
			Object data = currentNode.getData();
			Node racer = currentNode; 
			while(racer.getNextNode() != null){
				Node nextNode = racer.getNextNode();
				if(data == nextNode.getData()){
					racer.setNextNode(nextNode.getNextNode());
				}else{
					racer = racer.getNextNode();
				}
			}
			currentNode = currentNode.getNextNode();
		}
		
	}
	
	public Object findKthElementLast(int k){
		
		Node bufferNode = head.getNextNode();
		Node finalNode = head.getNextNode();
		int count = 1; 
		while(bufferNode.getNextNode() != null){
			if(count >= k){
				finalNode = finalNode.getNextNode();
			}
			bufferNode = bufferNode.getNextNode();
			count++;
		}
		return finalNode.getData(); 
	}
	
	public void removeNode(int k){
		
		Node bufferNode = head.getNextNode();
		int count =1;
		while(bufferNode.getNextNode() != null){
			if(count == k){
				bufferNode.setData(bufferNode.getNextNode().getData());
				bufferNode.setNextNode(bufferNode.getNextNode().getNextNode());
			}
			count++;
			bufferNode =bufferNode.getNextNode();
		}
			
	}
	
	public void partition(int k){
		Node startBeforeList = null;
		Node endBeforeList = null;
		Node startLastList = null;
		Node endLastList = null;
		Node startBuffer = head.getNextNode();

		while(startBuffer != null){
			//System.out.println((Integer)startBuffer.getData());
			if((Integer)startBuffer.getData() <k ){
				if(startBeforeList == null){
					startBeforeList = startBuffer;
					endBeforeList = startBeforeList;
				}else{
					endBeforeList.setNextNode(startBuffer);
					endBeforeList = startBuffer;
				}
			}else{
				if(startLastList == null){
					startLastList = startBuffer;
					endLastList = startLastList;
				}else{
					endLastList.setNextNode(startBuffer);
					endLastList = startBuffer;
				}
			}
			
			startBuffer = startBuffer.getNextNode();
		}
		
		//merge the list
		if(startBeforeList != null){
			head.setNextNode(startBeforeList);
			endBeforeList.setNextNode(startLastList);
		}else{
			head.setNextNode(startLastList);
		}
	}
	
	public CustomLinkedList addLinkedList(CustomLinkedList a, CustomLinkedList b) 
	{
	
		
		return a;
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
		
		public void setData(Object newData){
			nodeData = newData; 
		}
	}
	
}
