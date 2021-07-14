class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<>();
        curList.add(1);
        ans.add(curList);
        for(int i = 1; i < numRows; i++){
            int last = 0;
            List<Integer> newList = new ArrayList<>();
            for(Integer integer : curList){
                if(last != 0){
                    newList.add(last+integer);
                }
                else{
                    newList.add(1);
                }
                last = integer;
            }
            newList.add(1);
            ans.add(newList);
            curList = newList;
        }
        return ans;
    }
}