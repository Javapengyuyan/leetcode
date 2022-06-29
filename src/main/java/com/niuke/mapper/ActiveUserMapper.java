package com.niuke.mapper;

import com.niuke.entity.ActiveUser;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ActiveUserMapper {

    int deleteByPrimaryKey(Integer mappingId);

    int insert(ActiveUser record);

    int insertSelective(ActiveUser record);

    ActiveUser selectByPrimaryKey(Integer mappingId);

    int updateByPrimaryKeySelective(ActiveUser record);

    int updateByPrimaryKey(ActiveUser record);

    /**
     * 根据用户Id查询激活用户
     * @param userId 用户Id
     * @return
     */
    List<ActiveUser> selectByUserId(@Param("userId") Integer userId);

    /***
     * 获取激活信息
     * @param userId
     * @return
     */
    ActiveUser selectActivitedByUserId(@Param("userId") Integer userId);

    /**
     * 查询用户购买产品
     * @param userId
     * @return
     */
    List<ActiveUser> selectUserProduct(@Param("userId") Integer userId);

    /**
     * 根据用户Id和 产品Id或日期 查询服务过期时间
     * @param productId
     * @param userId
     * @param date
     * @return
     */
    Map selectServiceDate(@Param("productId") Integer productId, @Param("userId") Integer userId, @Param("date") Integer date);

    List<ActiveUser> selectActiveUserlist(@Param("activeOnly") Boolean activeOnly, @Param("uid") Integer uid);


    List<ActiveUser> selectActiveUserByGroupIdAndUserId(@Param("groupId") Integer groupId, @Param("userId") Integer userId);

    /**
     * 根据产品Id和用户Id查询
     * @param productId
     * @param userId
     * @return
     */
    List<ActiveUser> selectByProductIdAndUserId(@Param("productId") Integer productId, @Param("userId") Integer userId);

    /**
     * 查询用户的最新激活记录
     * @param
     * @author happy-sc
     * @date 2017/4/10 17:00
     */
    ActiveUser selectNewActive(@Param("userId") Integer userId, @Param("date") Integer date);

    List<ActiveUser> selectByProductId(Integer productId);
}