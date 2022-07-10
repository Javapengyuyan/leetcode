package com.niuke.service.impl;

import com.niuke.entity.ActiveUser;
import com.niuke.mapper.ActiveUserMapper;
import com.niuke.service.TranscationalServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;

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
 * Propagation、Mandatory
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
     * 配置不回滚类型就不会回滚？？
     */
    @Transactional(rollbackFor = Exception.class,noRollbackFor = RestClientException.class
    ,propagation = Propagation.MANDATORY)
    public void noRollBack(){

    }



    /**
     * spring的事务是对数据库的事务的封装,最后本质的实现还是在数据库,
     * 假如数据库不支持事务的话,spring的事务是没有作用的.数据库的事务说简单就只有开启,回滚和关闭,
     * spring对数据库事务的包装,原理就是拿一个数据连接,根据spring的事务配置,操作这个数据连接对数
     * 据库进行事务开启,回滚或关闭操作.但是spring除了实现这些,还配合spring的传播行为对事务进行了
     * 更广泛的管理.其实这里还有个重要的点,那就是事务中涉及的隔离级别,以及spring如何对数据库的隔离
     * 级别进行封装.事务与隔离级别放在一起理解会更好些
     *
     */
    @Transactional(rollbackFor = RuntimeException.class,
            propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public void test(){

    }

}
