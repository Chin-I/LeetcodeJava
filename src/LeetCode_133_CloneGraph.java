/**
 * Created by Gene on 7/12/17.
 */
public class LeetCode_133_CloneGraph {
    //Keen BFS 56%
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if (node == null){
            return node;
        }
        return BFSHelper(node);
    }

    private UndirectedGraphNode BFSHelper(UndirectedGraphNode node){
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();

        Deque<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();

        queue.offerLast(node);
        map.put(node, new UndirectedGraphNode(node.label));

        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.pollFirst();
            UndirectedGraphNode copy = map.get(cur);
            for(UndirectedGraphNode nei:cur.neighbors){
                UndirectedGraphNode newNei = map.get(nei);
                if (newNei == null){
                    queue.offerLast(nei);
                    map.put(nei,new UndirectedGraphNode(nei.label));
                }
                copy.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }

    /*
    //Keen DFS 63%
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return node;
        }

        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        return DFSHelper(node,map);
    }
    private UndirectedGraphNode DFSHelper(UndirectedGraphNode node,Map<UndirectedGraphNode,UndirectedGraphNode> map){
        map.put(node, new UndirectedGraphNode(node.label));
        for(UndirectedGraphNode nei: node.neighbors){
            UndirectedGraphNode newNei = map.get(nei);
            if (newNei == null){
                newNei = DFSHelper(nei,map);
            }
            map.get(node).neighbors.add(newNei);
        }
        return map.get(node);
    }
    */

    //Solution DFS 63%
    /*
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode cloneGraph = new UndirectedGraphNode(node.label);
        map.put(cloneGraph.label, cloneGraph);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            cloneGraph.neighbors.add(cloneGraph(neighbor));
        }
        return cloneGraph;
    }
    */
}
