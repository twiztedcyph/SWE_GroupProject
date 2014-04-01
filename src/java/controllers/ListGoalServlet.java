/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import beans.GoalBean;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Liam
 */
public class ListGoalServlet extends HttpServlet
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
            //All the necessary pieces of information for a goal are objtained
            HttpSession session = request.getSession();
            beans.MemberBean memberBean = (beans.MemberBean) session.getAttribute("userdetails");
            
            if(memberBean != null)
            {
                ArrayList<GoalBean> goalsList = memberBean.getGoalList();
                ArrayList<GoalBean> inProgressGoals = new ArrayList<>();
                ArrayList<GoalBean> failedGoals = new ArrayList<>();
                ArrayList<GoalBean> completeGoals = new ArrayList<>();
                
                if(!goalsList.isEmpty())
                {
                    Calendar calLocal = new GregorianCalendar();
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); 
                    String localDateFormatted = dateFormatter.format(calLocal.getTime());  
                    java.sql.Date localDate = java.sql.Date.valueOf(localDateFormatted);
                
                    for(GoalBean tempGoal : goalsList)
                    {
                        
                        int dateDifference = tempGoal.getGoalEndDate().compareTo(localDate);
                        if(tempGoal.getGoalProgress() >= 100)
                        {
                            completeGoals.add(tempGoal);
                        }
                        else if(tempGoal.getGoalProgress() < 100 && dateDifference < 0)
                        {
                            failedGoals.add(tempGoal);
                        }
                        else
                        {
                            inProgressGoals.add(tempGoal); 
                        }
                     }
                }
                
                
                
               //Set the patient in the request
                request.setAttribute("goalsList", goalsList);
                request.setAttribute("completeGoals", completeGoals);
                request.setAttribute("failedGoals", failedGoals);
                request.setAttribute("inProgressGoals", inProgressGoals);
               

                request.getRequestDispatcher("goal.jsp").forward(
                              request, response);
            }
            else
            {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
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
