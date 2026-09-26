class MedianFinder {

    private List<Double> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int idx = findIndex(num);
        list.add(idx, (double)num);
    }

    public double findMedian() {
        int size = list.size();
        if (size % 2 == 0) {
            return (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
        } else {
            return list.get(size / 2);
        }
    }

    private int findIndex(int num) {
        if (list.size() == 0) return 0;
        if (list.size() == 1) return list.get(0) > num ? 0 : 1;
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            double midEle = list.get(mid);
            if (mid == 0 && midEle >= num) return mid;
            if (mid > 0 && midEle >= num && list.get(mid - 1) <= num) return mid;
            else if (midEle > num) r = mid - 1;
            else l = mid + 1;
        }
        return list.size();
    }
}
