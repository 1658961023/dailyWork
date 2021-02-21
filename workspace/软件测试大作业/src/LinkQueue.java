
public class LinkQueue {
		private class Node{
			private String[] e;
			//private int e;
			private Node next = null;
			
			public Node(String[] e){
				this.e = e;			
			}
		}
		
		private Node front;
		private Node rear;
		private int size;
		
		public LinkQueue(){
			this.front = null;
			this.rear = null;
			this.size = 0;
		}
		
		public boolean isEmpty(){
			return size == 0;
		}
		
		public boolean add(String[] e){
			if(isEmpty()){
				this.front = new Node(e);
				this.rear = this.front;
			} else {
				Node newNode = new Node(e);
				rear.next = newNode;
				rear = newNode;
			}
			
			size ++;
			return true;
		}
		
		public String[] get(int n){
			if (isEmpty()){
				throw new RuntimeException("队列为空");
			} else {
				Node goal = this.front;
				for (int i = 0 ; i < n; i++){
					goal = goal.next;
				}
				return goal.e;
			}
		}
		
		public Node getNode(int n){
			if (isEmpty()){
				throw new RuntimeException("队列为空");
			} else {
				Node goal = this.front;
				for (int i = 0 ; i < n; i++){
					goal = goal.next;
				}
				return goal;
			}
		}
		
		public void toHead(int n){
			if (isEmpty()){
				throw new RuntimeException("队列为空");
			}else if (n == 0){
				return;
			}else {
				Node n_goal = getNode(n);
				Node lastGoal = getNode(n-1);
				lastGoal.next = n_goal.next;
				
				Node t = this.front;
				this.front = n_goal;
				n_goal.next = t;
			}
		}
		
		//出队
		
		public String[] poll(){ 
			if (isEmpty()){
				throw new RuntimeException("队列为空");
			} else {
				String[] value = this.front.e;
				this.front = this.front.next;
				this.size --;
				return value;
			}
		}
		public int queueSize(){
			return this.size;
		}
		
//		public static void main(String[] args){
//			LinkQueue que = new LinkQueue();
//			que.add(1);
//			que.add(2);
//			que.add(3);
//			que.add(4);
//			que.add(5);
//			
//			que.toHead(3);
//			que.toHead(3);
//			
//			while(que.queueSize() != 0){
//				System.out.println(que.poll());
//			}
//			
//		}
}
