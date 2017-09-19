package com.ed.servlet;

import com.ed.dao.KindDao;
import com.ed.domain.Kind;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet(urlPatterns = "/admin/adminKind")
public class AdminKindServlet extends BaseServlet {
    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        List<Kind> kindList = KindDao.getKind();
        request.setAttribute("list",kindList);
        return "/admin/category/list.jsp";
    }

    public String addUI(HttpServletRequest request, HttpServletResponse response) {
        return "/admin/home.jsp";
    }
}
