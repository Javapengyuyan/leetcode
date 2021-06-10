package niuke.byteDance;

import java.util.Random;

public class Try_DIr10For7 {

    /**
     * 将筛子看作6进制数据，然后得到一个两位六进制数字，转为10进制
     * 根据需要平均的那个数的余数个数（如：7，余数有0-6）求得最小的均分次数
     * （如1-36除以7余数从0-6，取到35即可，36会导致余数1多一个），然后等值求结果
     *
     * @param args
     */
    public static void main(String[] args) {
        int things = 7; //7件事需要平均
        int times = 0; //需要ROLL的次数
        int maxTimes = 7; //最多ROLL7次，7位6进制数字，很大了O.O
        int total = 0; //得到的6进制数字最多能表示多少个10进制数字
        int uselessNums = 0; //需要舍去的数字个数；
        for(int i = 0; i < maxTimes; i++) {
            times ++;
            total = (int)Math.pow(6, i+1);

            if(total >= things) {
                System.out.println("一共需要ROLL"+times+"次~~~");
                uselessNums = total - total/things*things;
                break;
            }
        }

        Random random = new Random();

        int totalTimes = 0; //总共尝试的次数;

        for(int i = 0; i < 50; i++) {
            totalTimes ++;
            int number = 0; //本次ROLL到的数字
            int realNumber = 0; //在things范围内得到的有效数字；
            for(int j = 0; j < times; j++) {
                number += random.nextInt(5)*(int)Math.pow(6, j);
            }
            number ++;

            if(number >= total - uselessNums) {
                System.out.println("本次ROLL到的数字为" + number + "不是有效数字，重新来过~~");
                continue;
            } else {
                realNumber = number % things + 1;
                System.out.println("ROLL点成功，一共尝试了：" + totalTimes + "次，ROLL到的数字为：" + number + "  判定数字为：" + realNumber);
                //return realNumber;
            }
        }
        //return -1;


    }

}
