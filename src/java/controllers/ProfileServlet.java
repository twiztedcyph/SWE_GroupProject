/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Twiz
 */
public class ProfileServlet extends HttpServlet
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
            /* TODO output your page here. You may use following sample code. */
            if(request.getParameter("selector").equals("pass"))
            {
                try
                {
                    memberBean.changePassword(request.getParameter("new_pass"));
                } catch (Exception e)
                {
                    System.out.println(e);
                }
                session.setAttribute("msg", "Your password has been updated.");
                try
                {
                    session.setAttribute("userdetails", memberBean.retrieveOne(memberBean.getUserName()));
                } catch (Exception e)
                {
                    System.out.println(e);
                }
            }else if(request.getParameter("selector").equals("email"))
            {
                try
                {
                    String email = request.getParameter("new_email");
                    if(misc.Email.validateEmail(email))
                    {
                        memberBean.changeEmail(email);
                    }else
                    {
                        session.setAttribute("msg", "The email address was not valid.");
                        System.out.println("NOT VALID");
                    }
                } catch (Exception e)
                {
                    System.out.println(e);
                }
                session.setAttribute("msg", "Your email address has been updated.");
                try
                {
                    session.setAttribute("userdetails", memberBean.retrieveOne(memberBean.getUserName()));
                } catch (Exception e)
                {
                    System.out.println(e);
                }
            }
            response.sendRedirect("profile.jsp");
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
