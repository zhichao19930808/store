package com.ed.servlet;

import com.ed.dao.KindDao;
import com.ed.domain.Kind;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
@WebServlet(urlPatterns = "/admin/adminKind")
public class AdminKindServlet extends BaseServlet {
    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        List<Kind> kindList = KindDao.getKind();
        request.setAttribute("list",kindList);
        return "/admin/category/list.jsp";
    }

    public String addUI(HttpServletRequest request, HttpServletResponse response) {
        return "/admin/category/add.jsp";
    }

    public String addKind(HttpServletRequest request, HttpServletResponse response) {
        Kind kind = new Kind();
        try {
            BeanUtils.populate(kind,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        KindDao.addKind(kind);
        return "adminKind?ac=findAll";
    }

    public String getKindById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Kind kind =KindDao.findKindById(id);
        request.setAttribute("kind",kind);
        return "/admin/category/edit.jsp";
    }

    public String updateKind(HttpServletRequest request, HttpServletResponse response) {
        Kind kind = new Kind();
        try {
            BeanUtils.populate(kind,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        KindDao.updateKind(kind);
        return "adminKind?ac=findAll";
    }
    public String deleteKindById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        KindDao.deleteKindById(id);
        return "adminKind?ac=findAll";
    }
}
