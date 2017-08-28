package com.ed.servlet;

import com.alibaba.fastjson.JSON;
import com.ed.domain.Kind;
import com.ed.service.KindService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/jsp/Kind")
public class KindServlet extends BaseServlet{
    public String getKind(HttpServletRequest request, HttpServletResponse response) {
        List<Kind> kindList = KindService.getKind();
        //将list转换为json格式的字符串
        String jsonString = JSON.toJSONString(kindList, true);
        //将jsonString写回到客户端
        response.setContentType("text/html;charset = utf-8");
        try {
            response.getWriter().print(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
