// Given a non-empty array of integers, return the k most frequent elements.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] heap = new int[k];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        insertMap(hm, nums);
        
        int i = 0;
        for (Integer key : hm.keySet()) {
            if (i < k) {
                heap[i++] = key;
                if (i == k) {
                    for (int j = (k-2)/2; j >=0; j --)
                        minHeap(j, k, heap, hm);
                }
            } else {
                if (hm.get(key) > hm.get(heap[0])) {
                    heap[0] = key;
                    minHeap(0, heap.length, heap, hm);
                }
            }
        }
        return heap;
    }
    
    private void insertMap(HashMap<Integer,Integer> hm, int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            if (hm.containsKey(nums[i]))
                hm.put(nums[i], hm.get(nums[i]) + 1);
            else
                hm.put(nums[i], 1);
        }
    }
    
    private void minHeap(int index, int size, int[] heap, HashMap<Integer,Integer> hm) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;
        if (left < size && hm.get(heap[smallest]) > hm.get(heap[left]))
            smallest = left;
        if (right < size && hm.get(heap[smallest]) > hm.get(heap[right]))
            smallest = right;
        if (smallest != index) {
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            minHeap(smallest, size, heap, hm);
        }
    }
}
