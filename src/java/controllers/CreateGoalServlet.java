/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Liam
 */
@WebServlet(name = "CreateGoalServlet", urlPatterns =
{
    "/CreateGoalServlet"
})
public class CreateGoalServlet extends HttpServlet
{

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
            throws ServletException, IOException
    {
        
        
        try
        {
            HttpSession session = request.getSession();
            beans.MemberBean memberBean = (beans.MemberBean) session.getAttribute("userdetails");
            memberBean.getGoalList();
            //All the necessary pieces of information for a goal are objtained
            
            int submitterID = memberBean.getId();
            boolean isGroupGoal  = Boolean.parseBoolean(request.getParameter("goalFor"));

            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate =  Date.valueOf(request.getParameter("endDate"));

            Double aim = Double.parseDouble(request.getParameter("aim"));
            
            String category = request.getParameter("category");
            
            String type = request.getParameter("type");


            
            //Then used to construct a goal object
            beans.GoalBean  goal = new beans.GoalBean(submitterID, isGroupGoal, startDate, endDate, aim, category, type); 
            goal.persist();
            //Which is then persisted to the database
               
            //Then send to the view
            request.getRequestDispatcher("ListGoalServlet").forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("goal.jsp").forward(request, response);
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
