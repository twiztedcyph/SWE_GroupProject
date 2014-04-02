/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ash
 */
@WebServlet(name = "HealthProfileServlet", urlPatterns = {"/HealthProfileServlet"})
public class HealthProfileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            beans.MemberBean memberBean = (beans.MemberBean) session.getAttribute("userdetails");
            
           
            double userHeight = Double.valueOf(request.getParameter("height"));
            double userWeight = Double.valueOf(request.getParameter("weight"));
            double userBMI = Double.valueOf(request.getParameter("bmi"));
            double userBF = Double.valueOf(request.getParameter("bodyfat"));
            int restHeartRate = Integer.parseInt(request.getParameter("rHeart"));
            int peakHeartRate = Integer.parseInt(request.getParameter("pHeart"));
            int member_id = memberBean.getId();
                
            beans.HealthProfileBean healthBean = new beans.HealthProfileBean(userHeight,
                    userWeight, userBMI, userBF, restHeartRate, peakHeartRate, member_id);

            healthBean.update();
            session.removeAttribute("healthprofile");
            session.setAttribute("healthprofile", healthBean);
            session.setAttribute("msg", "Your details were added.");
            request.getRequestDispatcher("profile.jsp").forward(request, response);
            
            
        }catch (SQLException sqle)
        {
            System.out.println("EXCEPTION HERE!!!");
            sqle.printStackTrace();
        }
     }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
