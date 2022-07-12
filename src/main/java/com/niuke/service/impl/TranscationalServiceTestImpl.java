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

    /**
     * 事务实现原理：以及非事务调用事务不生效原因：
     *
     * spring 在扫描bean的时候会扫描方法上是否包含@Transactional 事务注解，如果包含，
     * 则 spring会为这个bean动态地生成一个子类（即代理类，proxy），代理类是继承原来那个bean。
     *
     * 当这个有事务注解的方法被调用的时候，实际上是由代理类来调用的，代理类在调用之前就会开启事务
     * （transaction） 。
     *
     * 但是，如果先调用一个没有事务的方法，然通这个方法再去有事务，由于该方法的调用并没有通过代理类，
     * 而是直接通过原来的那个bean，所以就不会启动transaction，我们看到的现象就是 @Transactional
     * 注解无效。
     *
     * 总结：
     * 同一个类中，一个没有事务的方法A，去调用另一个有事务的方法B时，因为是直接调用，
     * 而不是调用的代理类，所以事务不起用的。
     *
     */

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

    /**
     * 1、rollbackFor的异常要和throws一样
     * @throws Exception
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void testThrow() throws Exception {
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserId(191);
        activeUser.setGroupName("测试");
        activeUser.setGroupNameEn("");
        activeUserMapper.updateByPrimaryKey(activeUser);
        throw new Exception("Exception抛出异常");
    }

    /**
     * 也可以写多个Exception
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public void testTwoException(){
        throw new RuntimeException("RuntimeException");
    }

    /**
     * try catch后不会回滚
     *
     */
    @Transactional
    public void testTryCatch(){
        try {
            System.out.println("输出");
        }catch (Exception e){

        }
    }

}
