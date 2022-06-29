package com.niuke.entity;

import lombok.Data;

/**
 * desc:激活的用户
 *
 */
@Data
public class ActiveUser {

    /**
     * ID
     */
    private Integer mappingId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 用户UID
     */
    private Integer userId;

    /**
     * 产品ID
     */
    private Integer productId;

    /**
     * 服务开始时间
     */
    private Integer startDate;

    /**
     * 服务结束时间
     */
    private Integer endDate;

    /**
     * 服务状态 [未服务：0，服务中：1]
     */
    private Integer activeFlag;

    /**
     * 产品组名称
     */
    private String groupName;

    private Integer groupId;

    /** 产品种类标识 [荐股：0，投顾：1] */
    private Byte productType;
    /**产品组英文名称**/
   private  String  groupNameEn;

    public void setProductName(String productName) { this.productName = productName; }

    public String getProductName() {
        if(productName != null) {
            productName = productName.replaceAll("_[0-9]+", "");
        }
        return productName;
    }

}