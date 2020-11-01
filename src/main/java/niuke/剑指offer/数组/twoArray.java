package niuke.剑指offer.数组;

/**
 * 二维递增数组，判断是否含有这个数
 *
 * 二分查找法
 *
 */
public class twoArray {
    public static void main(String[] args) {
        

    }

    public boolean Find(int target, int [][] array) {
        int x = 0;
        int y = array[0].length-1;
        while (x<array.length && y>0){
            if (array[x][y] == target){
                return true;
            }else if (array[x][y] > target){
                y--;
            }else if (array[x][y] < target){
                x++;
            }
        }
        return false;
    }

}
