// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Example 1:

// Input: [3,2,1,5,6,4] and k = 2
// Output: 5
// Example 2:

// Input: [3,2,3,1,2,4,5,5,6] and k = 4
// Output: 4

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return -1;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < k; i ++) {
            arr.add(nums[i]);
        }
        for (int i = (k-2)/2; i >= 0; i --) {
            minHeapify(i, arr);
        }
        for (int i = k; i < nums.length; i ++) {
            if (nums[i] > arr.get(0)) {
                arr.set(0, nums[i]);
                minHeapify(0, arr);
            }
        }
        return arr.get(0);
    }
        
    private void minHeapify(int index, List<Integer> arr) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;
        if (left < arr.size() && arr.get(smallest) > arr.get(left))
            smallest = left;
        if (right < arr.size() && arr.get(smallest) > arr.get(right))
            smallest = right;
        if (smallest != index) {
            int temp = arr.get(smallest);
            arr.set(smallest, arr.get(index));
            arr.set(index, temp);
            minHeapify(smallest, arr);
        }
    }
}
