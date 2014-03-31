

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ExerciseServlet", urlPatterns = {"/ExerciseServlet"})
public class ExerciseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            beans.MemberBean memberBean = (beans.MemberBean) session.getAttribute("userdetails");
            String s = request.getParameter("exercise_submit");
            if(s != null && s.equals("Submit"))
            {
                Date exerciseDate = Date.valueOf(request.getParameter("date"));
                Time exerciseTime = Time.valueOf(request.getParameter("time")+ ":00");
                String intensity = request.getParameter("intensity");
                String type = request.getParameter("type");
                int duration = Integer.parseInt(request.getParameter("duration"));
                int member_id = memberBean.getId();
                
                beans.ExerciseBean exerciseBean = new beans.ExerciseBean(type, intensity,
                        exerciseDate, exerciseTime, duration, member_id );
                
                exerciseBean.persist();
                session.setAttribute("msg", "Your exercise was added.");
                request.getRequestDispatcher("exercises.jsp").forward(request, response);
            }else
            {
                beans.ExerciseBean exerciseBean = new beans.ExerciseBean();
                ArrayList<beans.ExerciseBean> exerciseList = exerciseBean.getExercise(memberBean.getId());
                session.setAttribute("exerciselist", exerciseList);
                response.sendRedirect("viewExercises.jsp");
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
