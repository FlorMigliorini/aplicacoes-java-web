//package com.jpaprojeto.servlets;
//
//import com.jpaprojeto.dao.JPAAutomovelDao;
//import com.jpaprojeto.entity.Automovel;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author florm
// */
//@WebServlet(name = "VisualizaAutomovelServlet", urlPatterns = {"/visualizar"})
//public class VisualizaAutomovelServlet extends HttpServlet {
//
////    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
////            throws ServletException, IOException {
////        response.setContentType("text/html;charset=UTF-8");
////
////    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
////        processRequest(request, response);
//
//        JPAAutomovelDao dao = new JPAAutomovelDao();
//        Automovel auto = dao.busca(request.getParameter("id"));
//        
//        // coloca as informações no request para seguirem adiante
//        request.setAttribute("modelo", auto.getModelo());
//        request.setAttribute("anoModelo", auto.getAnoModelo());
//        
//        RequestDispatcher rd = request.getRequestDispatcher("/visualiza.jsp");
//        
//        // encaminha para o JSP, levando o request com os dados
//        rd.forward(request, response);
//
//        PrintWriter out = response.getWriter();
//
//        /* TODO output your page here. You may use following sample code. */
//        out.println("<html>");
//        out.println("<body>");
//        out.println("Modelo: " + auto.getModelo() + "<br />");
//        out.println("Ano do Modelo: " + auto.getAnoModelo() + "<br />");
//        out.println("</html>");
//        out.println("</body>");
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//}
