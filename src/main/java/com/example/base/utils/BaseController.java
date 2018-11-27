package com.example.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Auther: Administrator
 * @Date: 2018-09-15 10:05
 * @Description:
 */
public class BaseController {
    protected Logger logger= LoggerFactory.getLogger(getClass());
    @ExceptionHandler(Exception.class)
    public JSONResult handleException(Exception e) {
        e.printStackTrace();
        JSONResult jsons = new JSONResult();
        jsons.setMsg(e.getMessage());
        jsons.setCode(404);
        return jsons;
    }
}
