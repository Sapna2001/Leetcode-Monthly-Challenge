/*
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B
*/

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] result = new int[A.length];
        // descending order
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for (int i = 0; i < B.length; i++) 
            maxHeap.offer(new int[] {i, B[i]});
        int slow = 0, fast = A.length - 1;
        
        while (!maxHeap.isEmpty()) {
            int[] b = maxHeap.poll();
            // result[index]
            result[b[0]] = b[1] >= A[fast] ? A[slow++] : A[fast--];
        }
        return result;
    }
}

// O(n logn)
