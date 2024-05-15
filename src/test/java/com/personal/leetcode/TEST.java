package com.personal.leetcode;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.middleware.zookeeper.case1.zkClient;

import java.util.ArrayList;

public class TEST {
    public static void main(String[] args) {
        Integer currentLevel = 6;
        findLevel(currentLevel);
        //test();
        String s = new String("http12345");
        //System.out.println(s.startsWith("hts"));
        //向上取整
        System.out.println(Math.ceil(4.331));
        //向下取整
        System.out.println(Math.floor(4.331));
        //四舍五入
        System.out.println(Math.round(4.331));

        System.out.println(Math.ceil(4.5));
        System.out.println(Math.floor(4.5));
        System.out.println(Math.round(4.5));
        try {
            Class.forName("");
            Class<? extends String> aClass = "com.middleware.zookeeper.case1.zkClient".getClass();
            zkClient zkClient = new zkClient();
            Class<? extends com.middleware.zookeeper.case1.zkClient> aClass1 = zkClient.getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static public void test(){
        Long workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr()) >> 16 & 31 ;
        System.out.println("workId:"+workId);
        Long dataCenterId = 1L;
        System.out.println("dataCenterId:"+dataCenterId);
        Snowflake snowflake = IdUtil.getSnowflake(workId,dataCenterId);
        System.out.println("雪花生成结果:"+snowflake);
        long nextId = snowflake.nextId();
        System.out.println(nextId);

    }

    static public void findLevel(Integer currentLevel){
        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        for (int i = 0; i < list.size(); i++) {
            Integer start = list.get(i);
            if (start > currentLevel){
                resultList.add(list.get(i));
                resultList.add(list.get(i+1));
                break;
            }
            if (start == currentLevel && i != list.size()-1){
                resultList.add(list.get(i));
                resultList.add(list.get(i+1));
                break;
            }
            if (i == list.size()-1){
                resultList.add(list.get(list.size()-2));
                resultList.add(list.get(list.size()-1));
                break;
            }
        }
        System.out.printf(JSONUtil.toJsonStr(resultList));

    }



}
