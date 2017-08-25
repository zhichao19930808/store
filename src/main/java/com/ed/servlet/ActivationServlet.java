package com.ed.servlet;
import com.ed.service.Activation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/activation")
public class ActivationServlet extends BaseServlet{
    public String activation(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String msg = Activation.activation(code);
        request.setAttribute("msg",msg);
        return "/jsp/msg.jsp";
    }
}
