class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            if(diff(s,beginWord) == 1){
                set.add(s);
            }
        }
        map.put(beginWord, set);
        for(String s : wordList){
            set = new HashSet<String>();
            for(String ss : wordList){
                if(diff(s, ss) == 1)
                    set.add(ss);
            }
            map.put(s,set);
        }
        return bfs(beginWord, endWord, map);
    }

    public int bfs(String cur, String target, Map<String, Set<String>> map){
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(cur);
        visited.add(cur);
        int cnt = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0) {
                String next = queue.poll();
                //System.out.println(next + ": " + map.get(next).toString());
                for (String s : map.get(next)) {
                    if (!visited.contains(s)) {
                        if (s.equals(target))
                            return cnt + 1;
                        visited.add(s);
                        queue.offer(s);
                        //System.out.print(s+" ");
                    }
                }
            }
            cnt++;
            //System.out.println();
        }
        return 0;
    }

    public int diff(String a, String b){
        char[] ca = a.toCharArray(), cb = b.toCharArray();
        int cnt = 0;
        for(int i = 0; i < a.length(); i++)
            if(ca[i] != cb[i])
                cnt++;
        return cnt;
    }
}