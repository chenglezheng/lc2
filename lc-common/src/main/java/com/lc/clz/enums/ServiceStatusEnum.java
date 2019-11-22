package com.lc.clz.enums;

/**
 * @author chenglezheng
 * @date 2019-11-22 11:05
 */
public enum ServiceStatusEnum {

    getServiceStatus;

    /**
     * 服务未发现
     * @return
     */
    public Integer serviceNotFound(){
        return 404;
    }

    /**
     * 服务异常
     * @return
     */
    public Integer serviceException(){
        return 500;
    }


}
