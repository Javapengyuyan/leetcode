package com.niuke.service.impl;

import com.niuke.entity.ActiveUser;
import com.niuke.mapper.ActiveUserMapper;
import com.niuke.service.TranscationalServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author: long
 * @create: 2022-06-28 14:36
 * @Description 事务注解测试
 *       ---@Transactional注解只对RuntimeException及其子类、error子类生效
 *
 * Throwable是所有的父类，下包含error、exception两个。
 *      exception可以细分为IOException和RuntimeException。
 *
 **/

@Service
public class TranscationalServiceTestImpl implements TranscationalServiceTest {

    @Autowired
    private ActiveUserMapper activeUserMapper;

    @Override
    public void addUser() {

    }

    @Override
    public void updateUser() {
        /**
         * 测试事务：
         * 1、事务调用非事务public方法--生效
         * 2、事务调用非事务private方法--生效
         * 3、非事务调用事务protected方法--不生效
         * 4、非事务调用事务public方法--不生效
         * 5、测试protected方法修饰的事务--不生效
         *    private修饰的方法，idea会提示报错
         */
        noTransacl();
        ArrayList arrayList = null;
        arrayList.add("aa");
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void noTransacl(){
        ActiveUser activeUser = new ActiveUser();
        activeUser.setMappingId(185657);
        activeUser.setUserId(2);
        activeUser.setProductName("测试");
        //activeUser.setProductName("事务回滚");
        activeUser.setGroupName("汇正赢家");
        activeUser.setGroupNameEn("hzyj");
        int i = activeUserMapper.updateByPrimaryKey(activeUser);
        System.out.println("更新成功数量:"+i);
    }

    /**
     * 2、定义的传播行为
     * 3、不能回滚被try catch的异常
     * 4、只能对在被Spring 容器扫描到的类下的方法生效。
     *
     */
    @Transactional(rollbackFor = RuntimeException.class,propagation = Propagation.MANDATORY)
    protected void addTest(){


    }
    /**
     * Propagation
     * Mandatory
     *
     */

}
