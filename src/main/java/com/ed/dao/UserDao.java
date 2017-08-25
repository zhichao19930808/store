package com.ed.dao;


import com.ed.domain.User;
import com.ed.utils.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import java.sql.SQLException;
import java.util.List;

public class UserDao {
    public static void SignUp(User user,String use) {
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
        String sql = "INSERT INTO db_store.user(userName, password, name, sex, email, telephone, birthday, code) VALUES (?,?,?,?,?,?,?,?)";
        if (select(user,use) == null) {
            try {
                queryRunner.update(sql, user.getUserName(), user.getPassword(), user.getName(), user.getSex(), user.getEmail(), user.getTelephone(), user.getBirthday(), user.getCode());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static User selectByCode(String code) {
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
        String sql = "SELECT * FROM db_store.user where code = ?";
        User user = null;
        try {
            user= queryRunner.query(sql, new BeanHandler<User>(User.class), code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static User select(User user,String use) {
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
        String signUp = "SELECT * FROM db_store.user WHERE userName=?";
        String signIn = "SELECT * FROM db_store.user WHERE userName=? and password = ?";
        User user1 = null;
        try {
            if (use.equals("SignUp")) {
                user1= queryRunner.query(signUp, new BeanHandler<User>(User.class), user.getUserName());
            }
            if (use.equals("SignIn")) {
                user1= queryRunner.query(signIn, new BeanHandler<User>(User.class), user.getUserName(),user.getPassword());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user1;
    }

    public static void activation(String code) {
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
        String sql = "UPDATE db_store.user SET state = 1 WHERE code = ?";
        try {
            queryRunner.update(sql,code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
