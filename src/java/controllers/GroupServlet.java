/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Twiz
 */
@WebServlet(name = "GroupServlet", urlPatterns =
{
    "/GroupServlet"
})
public class GroupServlet extends HttpServlet
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
            String viewGroup = request.getParameter("viewgroupname");
            String joinGroup = request.getParameter("joingroupname");
            String makeGroup = request.getParameter("creategroup");
            if(viewGroup != null)
            {
                System.out.println(viewGroup);
                System.out.println(" VIEW CORRECT!!");
                
            } else if(joinGroup != null)
            {
                System.out.println(joinGroup);
                System.out.println("JOIN CORRECT!!");
            } else if(makeGroup != null)
            {
                
                String groupName = request.getParameter("groupname");
                String groupDesc = request.getParameter("groupdescription");
                beans.GroupDetailsBean gdb = new beans.GroupDetailsBean(groupName, groupDesc, memberBean.getId());
                gdb.persist();
                ArrayList<beans.GroupDetailsBean> groupMemberList = gdb.getMemberGroups(memberBean.getId());
                session.setAttribute("groupmemberlist", groupMemberList);
            }else
            {
                
                beans.GroupDetailsBean gdb = new beans.GroupDetailsBean();
                ArrayList<beans.GroupDetailsBean> groupMemberList = gdb.getMemberGroups(memberBean.getId());
                ArrayList<beans.GroupDetailsBean> fullGroupList = gdb.getAllGroups();
                session.setAttribute("groupmemberlist", groupMemberList);
                
                
            }
            response.sendRedirect("groups.jsp");
        }catch(SQLException e)
        {
            e.printStackTrace();
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
