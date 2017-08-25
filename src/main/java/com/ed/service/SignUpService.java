package com.ed.service;

import com.ed.dao.UserDao;
import com.ed.domain.User;
import com.ed.utils.MailUtils;

public class SignUpService {
    public static void SignUp(User user) {
        UserDao.SignUp(user,"SignUp");
        String emailsMessage = "欢迎您成为我们的一员，<a href ='http://localhost:8080/jsp/activation?ac=activation&&code="+user.getCode()+"'>点此激活</a>";
        System.out.println(emailsMessage+"----发送邮件===---");
        MailUtils.sendMail(user.getEmail(), emailsMessage);//收件人地址，邮件内容
    }
}
