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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Twiz
 */
public class FoodServlet extends HttpServlet
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            HttpSession session = request.getSession();
            beans.MemberBean memberBean = (beans.MemberBean) session.getAttribute("userdetails");
            String s = request.getParameter("lifestyle_submit");
            String viewFoodRequest = request.getParameter("view_food_history");
            if(s != null && s.equals("Submit"))
            {
                String foodName = request.getParameter("foodname");
                Date dateEaten = Date.valueOf(request.getParameter("dateeaten"));
                Time timeEaten = Time.valueOf(request.getParameter("timeeaten") + ":00");
                double protein = Double.parseDouble(request.getParameter("protein"));
                double carbs = Double.parseDouble(request.getParameter("carbs"));
                double unsatFat = Double.parseDouble(request.getParameter("unsatfat"));
                double satFat = Double.parseDouble(request.getParameter("satfat"));
                double sugar = Double.parseDouble(request.getParameter("sugar"));
                double salt = Double.parseDouble(request.getParameter("salt"));
                double kCal = Double.parseDouble(request.getParameter("kcal"));
                int member_id = memberBean.getId();
                System.out.println(foodName);
                beans.FoodBean foodBean = new beans.FoodBean(member_id, 
                        foodName, dateEaten, timeEaten, protein, carbs, 
                        unsatFat, satFat, kCal, sugar, salt);
                foodBean.persist();
                session.setAttribute("msg", "Your meal was added.");
                request.getRequestDispatcher("food.jsp").forward(request, response);
            }else if(viewFoodRequest != null && viewFoodRequest.equals("Veiw food history"))
            {
                beans.FoodBean foodBean = new beans.FoodBean();
                ArrayList<beans.FoodBean> foodList = foodBean.getFood(memberBean.getId());
                session.setAttribute("foodlist", foodList);
                response.sendRedirect("viewfood.jsp");
            }else
            {
                beans.FoodBean foodBean = (beans.FoodBean) session.getAttribute("foodlist");
                
            }
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
