package com.example.practice_02;

import java.io.*;

        import jakarta.servlet.ServletContext;

        import jakarta.servlet.http.*;
        import jakarta.servlet.annotation.*;

@WebServlet(name = "HelloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ServletContext application = getServletContext();
        String lang = request.getParameter("language");
        String action = request.getParameter("action");

        if ("submit".equals(action) && lang != null) {
            Integer count = (Integer) application.getAttribute(lang);
            count = (count != null) ? count + 1 : 1;
            application.setAttribute(lang, count);
        }
          if("delete".equals(action)) {
            application.removeAttribute("Java");
            application.removeAttribute("C#");
            application.removeAttribute("C++");
          }
        response.sendRedirect("index.jsp");
    }
}