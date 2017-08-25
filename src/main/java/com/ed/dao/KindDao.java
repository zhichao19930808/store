package com.ed.dao;

import com.ed.domain.Kind;
import com.ed.utils.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class KindDao {
    public static List<Kind> getKind() {
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
        String sql = "select * from db_store.kind";
        List<Kind> kindList = null;
        try {
            kindList = queryRunner.query(sql, new BeanListHandler<Kind>(Kind.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kindList;
    }
}
