/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.DAO;
import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author HUY
 */
public class ManagerLogControl extends HttpServlet {
   
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
        HttpSession session= request.getSession();
        Account a= (Account)session.getAttribute("acc");
        String accountId="";
        
        if(a!=null){
            accountId= a.getId()+"";
        }
        
        DAO dao= new DAO();
        List<Log> listL= dao.getAllLogByAccountId(accountId);
        request.setAttribute("listL", listL);
        searchIn.put("productId","ProuctID");
        searchIn.put("amount","Amount");
        searchIn.put("address","Address");
        searchIn.put("number","Phone");
        searchIn.put("date","Date");
        request.setAttribute("search", searchIn);
        
        double totalMoney=0;
        for(Log s: listL){
            int amount= s.getAmount();
            double price= dao.getProductByID(s.getProductId()+"").getPrice();
            totalMoney= totalMoney+(amount*price);
        }
        
        request.setAttribute("totalMoney", totalMoney);
        request.getRequestDispatcher("ManagerLog.jsp").forward(request, response);
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
    
    HashMap<String, String> searchIn=new HashMap<>();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Vector<String> listChecked= new Vector<>();
        for (Map.Entry<String, String> entry : searchIn.entrySet()) {
            String key = entry.getKey();
            if (request.getParameter("chk"+key)!=null) {
                listChecked.add(key);
            }
        }
        String sql="";
        if (listChecked.size()==0) {
            sql="select nothing";
        }else{
            String s1="";
            for(String s2: listChecked){
                s1 += "" + s2 + " like CONCAT('%',?,'%') or ";
            }
            
            s1=s1.substring(0,s1.length()-4);
            sql="select * from Log_HE172180 where "+s1;
        }
        
        DAO d= new DAO();
        
        String txt= request.getParameter("txtSearchLog");
        List<Log> e=d.SearchLog(sql,txt,listChecked.size());
        request.setAttribute("data",e);
        request.getRequestDispatcher("SearchedLog.jsp").forward(request, response);
        e.clear();
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
