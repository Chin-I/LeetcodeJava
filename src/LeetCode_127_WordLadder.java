/**
 * Created by Gene on 8/3/17.
 */
public class LeetCode_127_WordLadder {

    //Discussion Two Start 84%
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)){      // update
            return 0;
        }

        Set<String> wordSet = new HashSet<>(); //update
        for (String s : wordList) {
            wordSet.add(s);
        }

        // public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet   = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();

            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }

    /*
    //Discussion Tri 57%  https://discuss.leetcode.com/topic/88958/trie-with-bidirectional-bfs-as-alternative
    private static final int ALPHABET_FIRST_CHAR = 'a';
    private static final int ALPHABET_LAST_CHAR = 'z';
    private static final int ALPHABET_SIZE = ALPHABET_LAST_CHAR - ALPHABET_FIRST_CHAR + 1;

    private static class TrieItem {
        String Word = null; // a little memory overhead for convenience
        boolean[] Visit = new boolean[2]; //0: coming from start, 1: coming from end
        TrieItem[] Next = new TrieItem[ALPHABET_SIZE];

        void add(String word) {
            TrieItem ti = this;
            for(int i = 0; i < word.length(); i++) {
                ti = ti.getOrAddNext(word.charAt(i));
            }
            ti.Word = word;
        }

        TrieItem getNext(char c) {
            return Next[c - ALPHABET_FIRST_CHAR];
        }

        TrieItem find(String word) {
            TrieItem ti = this;
            for(int i = 0; ti != null && i < word.length(); i++) {
                ti = ti.getNext(word.charAt(i));
            }
            return ti;
        }

        TrieItem getOrAddNext(char c) {
            int i = c - ALPHABET_FIRST_CHAR;
            TrieItem ti = Next[i];
            if(ti != null) return ti;
            ti = new TrieItem();
            Next[i] = ti;
            return ti;
        }
    }

    private static boolean findExactAndVisit(TrieItem ti, String wordToFind, int frontierId) {
        ti = ti.find(wordToFind);
        if(ti != null) ti.Visit[frontierId] = true;
        return ti != null;
    }

    private static boolean findSimilarAndVisit(TrieItem ti, String wordToFind, int frontierId,
                                               List<String> nextWords) {
        class StackItem {
            int Index;
            boolean CanChangeOne;
            TrieItem TrieItem;
            StackItem(int index, boolean canChangeOne, TrieItem trieItem) {
                Index = index;
                CanChangeOne = canChangeOne;
                TrieItem = trieItem;
            }
        }

        int n = wordToFind.length();
        Stack<StackItem> s = new Stack<>();
        s.push(new StackItem(0, true, ti));
        while(!s.empty()) {
            StackItem si = s.pop();
            if (si.Index == n) {
                if (!si.CanChangeOne && (si.TrieItem.Word != null) && !si.TrieItem.Visit[frontierId]) {
                    if (si.TrieItem.Visit[frontierId ^ 1]) return true; // visited with both frontiers
                    si.TrieItem.Visit[frontierId] = true; // mark as visited
                    nextWords.add(si.TrieItem.Word); // add to next words
                }
                continue;
            }
            char currentChar = wordToFind.charAt(si.Index);
            TrieItem next = si.TrieItem.getNext(currentChar);
            if (next != null) {
                s.push(new StackItem(si.Index + 1, si.CanChangeOne, next));
            }
            if (si.CanChangeOne) {
                for (char c = ALPHABET_FIRST_CHAR; c <= ALPHABET_LAST_CHAR; c++) {
                    if (c == currentChar) continue;
                    next = si.TrieItem.getNext(c);
                    if (next != null)
                        s.push(new StackItem(si.Index + 1, false, next));
                }
            }
        }
        return false;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(endWord == null || beginWord == null) return 0;

        TrieItem trie = new TrieItem();
        for(String word : wordList) trie.add(word); // create trie

        int distance = 1; // minimal distance if start and end are not equal (sequence length = distance + 1)
        int frontierId = 0; // 0: from beginWord, 1: from endWord
        LinkedList<String> q = new LinkedList<>(Arrays.asList(beginWord, null, endWord, null)); // queue
        findExactAndVisit(trie, beginWord, 0); // visit start word if present
        if(!findExactAndVisit(trie, endWord, 1)) return 0; // end word is not in wordList
        if(endWord.equals(beginWord)) return 1; // special case, end = start and end is in wordList
        while(q.size() > 2) {
            String current = q.poll();
            if(current == null) { // marks end of frontier, start and end alternate
                q.add(null);
                distance++;
                frontierId ^= 1;
            } else if(findSimilarAndVisit(trie, current, frontierId, q)) {
                return distance + 1; // since sequence length is asked
            }
        }
        return 0;
    }
    */
        /*


    */

    /*
     //Discussion Update 65%
     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                char[] arr = s.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == arr[j]) continue;
                        arr[j] = c;
                        String test = String.valueOf(arr);
                        if (test.equals(endWord)) return step + 1;
                        if (set.contains(test)) {
                            queue.offer(test);
                            set.remove(test);
                        }
                    }
                    arr[j] = original;
                }
            }
            step++;
        }
        return 0;
    }
        */


}
