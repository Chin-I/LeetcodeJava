/**
 * Created by Gene on 7/19/17.
 */
public class LeetCode_146_LRUCache {
    // Keen 80%
/*
class Node{
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class LRUCache {

    private Map<Integer,Node> map;
    private int cap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<Integer,Node>();
        this.cap = capacity;
        this.head = new Node(Integer.MIN_VALUE,0);
        this.tail = new Node(Integer.MAX_VALUE,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node cur = map.get(key);
        if (cur == null){
            return -1;
        }
        int res = cur.val;
        removeNode(cur);
        addAtHead(cur);
        return res;
    }

    public void put(int key, int value) {
        Node cur = map.get(key);
        if (cur != null){
            cur.val = value;
            removeNode(cur);
            addAtHead(cur);
        }else{
            cur = new Node(key,value);
            if (map.size() == cap){
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            addAtHead(cur);
            map.put(key,cur);
        }
    }

    private void addAtHead(Node toAdd){
        toAdd.next = head.next;
        toAdd.next.prev = toAdd;
        toAdd.prev = head;
        head.next = toAdd;
    }

    private void removeNode(Node toRmv){
        toRmv.prev.next = toRmv.next;
        toRmv.next.prev = toRmv.prev;
        toRmv.prev = null;
        toRmv.next = null;
    }
}
*/


//Solution lazy 90%
    import java.util.LinkedHashMap;
    public class LRUCache {
        private LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;
        public LRUCache(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }
        public int get(int key) {
            return map.getOrDefault(key, -1);
        }
        public void put(int key, int value) {
            map.put(key, value);
        }
    }
}
