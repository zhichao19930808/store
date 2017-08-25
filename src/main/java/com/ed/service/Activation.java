package com.ed.service;

import com.ed.dao.UserDao;

public class Activation{

    public static String activation(String code) {
        if (UserDao.selectByCode(code) != null) {
            UserDao.activation(code);
            return "激活成功";
        } else {
            return "失败：未知异常，请重新激活";
        }
    }
}
