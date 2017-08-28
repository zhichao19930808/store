package com.ed.service;

import com.ed.dao.KindDao;
import com.ed.domain.Kind;

import java.util.List;

public class KindService {
    public static List<Kind> getKind() {
        return KindDao.getKind();
    }
    public static Kind findKindById(int id) {
        return KindDao.findKindById(id);
    }
}
