/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 1;
        int r = mountainArr.length() - 2;
        int mountainEleIdx = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mMid = mountainArr.get(mid);
            int mMidNext = mountainArr.get(mid + 1);
            int mMidPrev = mountainArr.get(mid - 1);
            if (mMid > mMidNext && mMid > mMidPrev) {
                mountainEleIdx = mid;
                break;
            } else if (mMid > mMidNext) r = mid - 1;
            else l = mid + 1;
        }
        if (mountainArr.get(mountainEleIdx) == target) return mountainEleIdx;

        int leftSearch = binarySearchAsc(mountainArr, 0, mountainEleIdx - 1, target);
        if (leftSearch != -1) return leftSearch;
        int rightSearch = binarySearchDesc(mountainArr, mountainEleIdx + 1, mountainArr.length() - 1, target);
        return rightSearch;
    }

    private int binarySearchAsc(MountainArray mArr, int l, int r, int target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        int midEle = mArr.get(mid);
        if (midEle == target) return mid;
        else if (midEle > target) return binarySearchAsc(mArr, l, mid - 1, target);
        else return binarySearchAsc(mArr, mid + 1, r, target);
    }

    private int binarySearchDesc(MountainArray mArr, int l, int r, int target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        int midEle = mArr.get(mid);
        if (midEle == target) return mid;
        else if (midEle > target) return binarySearchAsc(mArr, mid + 1, r, target);
        else return binarySearchAsc(mArr, l, mid - 1, target);
    }
}