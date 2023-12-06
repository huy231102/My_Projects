/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.*;
import entity.Account;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author HUY
 */
public class ChangePassControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("ChangePass.jsp");
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String pass1= request.getParameter("pass1");
        String pass2= request.getParameter("pass2");
        String pass3= request.getParameter("pass3");
        
        HttpSession session= request.getSession();
        Account a= (Account) session.getAttribute("acc");
        
        DAO d= new DAO();
        
        if(pass3.equals(a.getPass())){
            if (pass1.equals(pass2)) {
                d.changePass(a.getId(), pass1);
                session.removeAttribute("acc");
                response.sendRedirect("Login.jsp");
            } else {
                String mess = "Re-enter wrong! Try Again";
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
            }
        }else{
            String mess = "Current pass wrong! Try Again";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
