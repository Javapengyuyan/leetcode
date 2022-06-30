package com.designPatterns.structalModel.AdapterPattern;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: long
 * @create: 2022-06-30 11:43
 * @Description
 **/

@Data
@Slf4j
public class ForeignCenter {
    private String name;
    public String Name;

    public void 进攻(){
        log.info("外籍中锋{}进攻",name);
    }

    public void 防守(){
        log.info("外籍中锋{}防守",name);
    }


}
