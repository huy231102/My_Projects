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
import entity.Product;
import jakarta.servlet.http.Cookie;
import java.util.List;
import entity.*;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author HUY
 */
public class ShowCartControl extends HttpServlet {
   
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
        
        Cookie arr[]= request.getCookies();
        DAO dao= new DAO();
        String txt="";
        
        if(arr!=null){
            for(Cookie o: arr){
                if(o.getName().equals("id")){
                    txt= txt+o.getValue();
                }
            }
        }
        
        String num= request.getParameter("num");
        String id= request.getParameter("id");
        if(txt.isEmpty()){
            txt=id+":"+num;
        }else{
            txt=txt+"_"+id+":"+num;
        }
        Cookie c=new Cookie("id",txt);
        c.setMaxAge(60*60*24);
        response.addCookie(c);
        
        Order order= new Order(txt);
        List<Cart> listCart= order.getCarts();
        
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if(a!=null){
            for (int i = 0; i < listCart.size(); i++) {
                listCart.get(i).setAccountId(a.getId());
            } 
        }else{
            for (int i = 0; i < listCart.size(); i++) {
                listCart.get(i).setAccountId(0);
            }
        }
        
        int n;
        if(listCart!=null){
            n=listCart.size();
        }else
            n=0;
       
        List<Product> listProducts= new ArrayList<>();
        for(Cart o: listCart){
            Product b= dao.getProductByID(o.getProductId()+"");
            listProducts.add(b);
        }
        
        request.setAttribute("listP", listProducts);
        request.setAttribute("size", n);
        request.setAttribute("listO", listCart);
        request.setAttribute("m", order.getTotalMoney());

        request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
