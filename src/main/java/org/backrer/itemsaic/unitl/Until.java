package org.backrer.itemsaic.unitl;

import java.util.Random;
import java.util.Set;

public class Until{
    public static boolean Contains(int[] ints,int ina){
        for (int a : ints){
            if (a == ina){
                return true;
            }
        }
        return false;
    }
    public static String RandomSetString(Set<String> stringSet){
        // 使用随机数生成器
        Random random = new Random();

        // 获取Set的大小
        int setSize = stringSet.size();

        // 生成一个随机的索引
        int randomIndex = random.nextInt(setSize);

        // 遍历Set并找到随机索引对应的元素
        int currentIndex = 0;
        for (String element : stringSet) {
            if (currentIndex == randomIndex) {
                return element;
            }
            currentIndex++;
        }
        return null;
    }

}
