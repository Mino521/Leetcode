class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> set;
        for(String s : wordList){
            set = new HashSet<>();
            for(int i = 0; i < s.length(); i++){
                char[] cs = s.toCharArray();
                char ci = cs[i];
                for(char j = 'a'; j <= 'z'; j++)
                    if(j != ci){
                        cs[i] = j;
                        String ns = new String(cs);
                        if(wordSet.contains(ns))
                            set.add(ns);
                    }
            }
            map.put(s, set);
        }
        set = new HashSet<>();
        for(int i = 0; i < beginWord.length(); i++){
            char[] cs = beginWord.toCharArray();
            char ci = cs[i];
            for(char j = 'a'; j <= 'z'; j++)
                if(j != ci){
                    cs[i] = j;
                    String ns = new String(cs);
                    if(wordSet.contains(ns))
                        set.add(ns);
                }
        }
        map.put(beginWord, set);
        return bfs(beginWord, endWord, map);
    }

    public int bfs(String cur, String target, Map<String, Set<String>> map){
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(cur);
        visited1.add(cur);
        queue2.offer(target);
        visited2.add(target);
        int cnt = 1;
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            if (queue1.size() > queue2.size()) {
                Queue<String> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size = queue1.size();
            while (size-- > 0) {
                String next = queue1.poll();
                //System.out.println(next + ": " + map.get(next).toString());
                for (String s : map.get(next)) {
                    if (!visited1.contains(s)) {
                        if (queue2.contains(s))
                            return cnt + 1;
                        visited1.add(s);
                        queue1.offer(s);
                        //System.out.print(s+" ");
                    }
                }
            }
            cnt++;
            //System.out.println();
        }
        return 0;
    }
}