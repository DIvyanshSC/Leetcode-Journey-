class MedianFinder {

    int count=0;
    ArrayList<Integer> list;
    public MedianFinder() {
        list=new ArrayList<>();
    }
    
    public void addNum(int num) {
        int index = Collections.binarySearch(list, num); // provides the -ve position value of element
        if (index < 0) index = ~index;           //converting -ve to actual postion value
        list.add(index,num);
        count++;
    }
    
    public double findMedian() {
        double median=-1.0;
        if(count%2==0){
            median=list.get(count/2-1)+list.get(count/2);
            median=median/2.0;
        }
        else{
            median=list.get(count/2);
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */