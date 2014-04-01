/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import JoinedBeans.MessageDetailRecipients;
import beans.MemberBean;
import beans.MessageDetailsBean;
import beans.MessageRecipientsBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Liam
 */
public class MessageServlet extends HttpServlet
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
        try
        { 
            HttpSession session = request.getSession();
            if(session.getAttribute("userdetails") == null)
            {
              session.setAttribute("msg", "Sorry, you must be logged in to view messages.");
              response.sendRedirect("index.jsp");
              return;
           }
            
            MemberBean memberBean = (MemberBean)session.getAttribute("userdetails");
            String formType = request.getParameter("formType");
            
             if(request.getParameter("formType") == null || formType == null)
             {
                 ArrayList<MessageDetailRecipients> readMessages = MessageDetailRecipients.getMyRead(memberBean.getId(), true);
                 ArrayList<MessageDetailRecipients> unReadMessages = MessageDetailRecipients.getMyRead(memberBean.getId(), false);
                 
                 request.setAttribute("readMessages", readMessages);
                 request.setAttribute("unReadMessages", unReadMessages);
                 System.out.println("Sending Back to messages page......");
                 request.getRequestDispatcher("messages.jsp").forward(request, response);
                 return;
             }
             
            if(formType.equals("send"))
            {
                boolean isGroupMessage  = Boolean.parseBoolean(request.getParameter("messageFor"));
                if(!isGroupMessage)
                {
                    String messageDetail = request.getParameter("messageDetail");
                    
                    if(messageDetail.length() > 2000)
                    {
                            session.setAttribute("msg", "Sorry, your message was a little bit too long,  please consider shortening.");
                            response.sendRedirect("messages.jsp");
                            return;  
                    }
                    String [] recipients = request.getParameter("recipients").split(",");
                    int sender = Integer.parseInt(request.getParameter("sender"));

                    String subject = request.getParameter("subject");
                    MessageDetailsBean messageDetails = new MessageDetailsBean(sender, messageDetail, subject);

                    for(String recipient: recipients)
                    {
                        MemberBean recipientBean = MemberBean.retrieveOne(recipient);
                        if(recipientBean == null || recipientBean.getId() == 0)
                        {
                            session.setAttribute("msg", "Sorry, user "+ recipient + " does not exist.");
                            response.sendRedirect("messages.jsp");
                            return;
                        }
                    }

                    int newMessageID = messageDetails.persist();


                    for(String recipient: recipients)
                    {
                        MemberBean recipientBean = MemberBean.retrieveOne(recipient);
                        int recipientID = recipientBean.getId();
                        MessageRecipientsBean messageRecipients = new MessageRecipientsBean(newMessageID, recipientID, true, false);
                        messageRecipients.persist();
                    }

                    session.setAttribute("msg", "Message Sent!");
                    response.sendRedirect("messages.jsp");
                    return;    
                  }
                else
                {
                    session.setAttribute("msg", "Sorry, group messages not yet supported.");
                    response.sendRedirect("messages.jsp");
                    return;
                }
           }
           else if(formType.equals("view"))
            {
                int messageID = Integer.parseInt(request.getParameter("messageID"));
                int userID = memberBean.getId();
                MessageRecipientsBean.readUnread(messageID, userID, true);
                MessageDetailsBean messageToView =  MessageDetailsBean.findByID(messageID);
                request.setAttribute("messageToView", messageToView);
                request.getRequestDispatcher("viewMessage.jsp").forward(request, response);
            }
           else if(formType.equals("delete"))
           {
               int messageID = Integer.parseInt(request.getParameter("messageID"));
               int userID = memberBean.getId();
               MessageRecipientsBean.deleteMessage(messageID, userID);
               session.setAttribute("msg", "Message Deleted.");
               response.sendRedirect("messages.jsp");
               return;
           }
           else if(formType.equals("read"))
           {
               int messageID = Integer.parseInt(request.getParameter("messageID"));
               int userID = memberBean.getId();
               MessageRecipientsBean.readUnread(messageID, userID, true);
               response.sendRedirect("messages.jsp");
               return;
           }
            else if(formType.equals("unread"))
           {
               int messageID = Integer.parseInt(request.getParameter("messageID"));
               int userID = memberBean.getId();
               MessageRecipientsBean.readUnread(messageID, userID, false);
               session.removeAttribute("unRead");
               ArrayList<MessageDetailRecipients> unRead = MessageDetailRecipients.getMyRead(memberBean.getId(), false);
               session.setAttribute("unRead", unRead);
               response.sendRedirect("messages.jsp");
               return;
           }
              
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);       
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
