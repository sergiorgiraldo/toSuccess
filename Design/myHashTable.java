public class myHashTable<K, V> {
	
	Node[] bucket;
	int capacity;
	
	public class Node<K, V> {
		
		K key;
		V value;
		Node<K, V> next;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
	}
	
	public myHashTable(int capacity) {
		
		bucket = new Node[capacity];
		//size = 0;
		this.capacity = capacity;
		
	}
	
	public int myHashValue(K key) {
		
		return Math.abs(key.hashCode())% bucket.length;
		
	}
	
	public Node getNodeforKey(K key) {
		
		int idx = myHashValue(key);
		Node current = bucket[idx];
		
		while (current != null) {
			
			if (current.key.equals(key)) {
				
				return current;
				
			}
			
			current = current.next;
		}
		return null;
		
	}
	
	public void put(K k, V v) {
		
		Node node = getNodeforKey(k);
		
		// already exsits, update value
		if (node != null) {
			
			node.value = v;
			return;
			
		}
		
		node = new Node(k, v);
		int idx = myHashValue(k);
		Node current = bucket[idx];
			
		if (current == null) {
			
			bucket[idx] = node;
			
		}else{
			
			while (current != null && current.next != null){
				
				current = current.next;
				
			}	
			
			current.next = node;
			
		}
	}
	
	public V get(K key) {
		
		Node node = getNodeforKey(key);
		
		return node == null ? null : (V)node.value;
		
	}
	
	public static void main(String[] args) {
		
		myHashTable<String, String> table = new myHashTable<String, String>(10);
		
		table.put("A", "1");
		System.out.println(table.get("A"));
		
		table.put("A", "2");
		System.out.println(table.get("A"));
		
		table.put("B", "2");
		System.out.println(table.get("B"));
		
		table.put("C", "3");
		System.out.println(table.get("C"));
	}
	
}
