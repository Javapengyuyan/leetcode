package com.designPatterns.behaviorModel.responsibilityPattern;

import lombok.Data;

@Data
public class Result {

    public Boolean isRatify;

    public String reason;

    public Result(boolean isRatify, String info) {
        super();
        this.isRatify = isRatify;
        this.reason = info;
    }


}
