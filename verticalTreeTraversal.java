class Solution {
    
    class Pair {
        TreeNode n;
        int col, row;   // add row
        Pair(TreeNode n, int col, int row) {
            this.n = n;
            this.col = col;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // col -> row -> sorted values
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));  // root at col=0, row=0

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode curr = p.n;
            int col = p.col;
            int row = p.row;

            mp.putIfAbsent(col, new TreeMap<>());
            mp.get(col).putIfAbsent(row, new PriorityQueue<>());
            mp.get(col).get(row).offer(curr.val);

            if (curr.left != null) {
                q.add(new Pair(curr.left, col - 1, row + 1));
            }
            if (curr.right != null) {
                q.add(new Pair(curr.right, col + 1, row + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Map<Integer, PriorityQueue<Integer>> rows : mp.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            ans.add(colList);
        }

        return ans;
    }
}
