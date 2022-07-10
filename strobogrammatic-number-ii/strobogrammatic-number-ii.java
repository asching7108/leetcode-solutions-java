class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> list = new ArrayList();
        if (n % 2 == 1) {
            Collections.addAll(list, "0", "1", "8");
        } else {
            list.add("");
        }
        for (int i = n; i >= 2; i -= 2) {
            List<String> newList = new ArrayList();
            for (String s : list) {
                Collections.addAll(newList,
                                   "1" + s + "1",
                                   "8" + s + "8",
                                   "6" + s + "9",
                                   "9" + s + "6");
                if (i > 3) {
                    newList.add("0" + s + "0");
                }
            }
            list = newList;
        }
        return list;
    }
}