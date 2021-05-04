package GraphAlgorithm.ChapterOne;

public class BinarySearch {

    /**
     * 升序排列数组中查找目标值的第一个和最后一个
     * 通过二分查找最左边界和最右边界
     *
     * @param args
     */
    public static void main(String[] args) {
        int number = 6;
        int[] ints = {10,8,8,5,3,1,1};
        int left = 0;
        int right = ints.length-1;
        int mx = (left+right)>>>1;
        System.out.println(mx);
        System.out.println("left:"+left);
        System.out.println("right:"+right);

        int[] numbers = {1,2,5,6,6,8,8,10};
        System.out.println(binarySearch(6,numbers));
        System.out.println(binary(6,numbers));


    }

    /**
     * 查找左边界
     */
    public static int binarySearch(int number,int[] ints){
        if (ints == null){
            return -1;
        }
        int left = 0;
        int right = ints.length-1;

        while (left<right){
            int mid = (left + right)/2;
            if (number < ints[mid]){
                right = mid-1;
            }else if (number > ints[mid]){
                left = mid + 1;
            }else if (number == ints[mid]){
                //查找左边界，从右边逼近
                right = mid;
            }
        }
        if (number == ints[left]){
            return left;
        }
        return -1;
    }

    /**
     * 查找右边界
     * @return
     */
    public static int binary(int number,int[] ints){
        if (ints == null){
            return -1;
        }
        int left = 0;
        int right = ints.length-1;
        while (left<right){
            int mid = (left+right+1)/2;
            if (number<ints[mid]){
                right = mid-1;
            }else if (number>ints[mid]){
                left = mid+1;
            }else {
                left = mid+1;
            }

        }
        if (number == ints[right-1]){
            return right-1;
        }

        return -1;
    }



}
