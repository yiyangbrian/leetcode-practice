import java.util.Arrays;

class MedianFinder {
    int[] arr;
    int size;

    public MedianFinder() {
        arr = new int[50000];
        size = 0;
    }

    public void addNum(int num) {
        arr[size] = num;
        size ++;
    }

    public double findMedian() {
        Arrays.sort(arr, 0, size);
        if(size % 2 == 1) {
            return (double)arr[size / 2];
        } else {
            return (double)(arr[size / 2 - 1] + arr[size / 2]) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
