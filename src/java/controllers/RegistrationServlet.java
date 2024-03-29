package controllers;

import JoinedBeans.MessageDetailRecipients;
import beans.GoalBean;
import beans.MemberBean;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Calendar;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static misc.Email.validateEmail;

/**
 *
 * @author Warren
 */
@WebServlet(name = "RegistrationServlet",
        urlPatterns = {"/RegistrationServlet"})

public class RegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //referer to send the user back to the page he/she came from.
            String referer = request.getHeader("Referer").replace("http://localhost:8080/SWE_GroupProject/", "");
            
            beans.MemberBean memberBean, mb = null;
            //Get the session
            HttpSession session = request.getSession();
            if(session != null)     //Check if the session is null.
            {
                mb = (MemberBean) session.getAttribute("userdetails");
            }
            
            //if the user is a member.
            if(mb!= null && mb.getAccessType().equals("user"))
            {
                session.setAttribute("msg", "You are already registered!");
                response.sendRedirect("index.jsp");
            }
            //if the user is a visitor.
            if(mb == null)
            {
                //get input paramaters
                String username = request.getParameter("username");
                System.out.println(username);
                String passwordOne = request.getParameter("passwordOne");
                System.out.println(passwordOne);
                String passwordTwo = request.getParameter("passwordTwo");
                String firstname = request.getParameter("forename");
                String lastname = request.getParameter("surname");
                Date dateOfBirth = Date.valueOf(request.getParameter("dob"));
                String email = request.getParameter("email");
                String accessType = "user";
                Calendar ageCheck = Calendar.getInstance();
                ageCheck.add(Calendar.YEAR, -18);
                Calendar dob = Calendar.getInstance();
                dob.setTime(dateOfBirth);
                //Password check
                if(validateEmail(email)==false){
                    session.setAttribute("msg", "Invalid Email Address Entered");
                    response.sendRedirect("registration.jsp");
                }else if(ageCheck.getTimeInMillis() - dob.getTimeInMillis() < 0)
                {
                    session.setAttribute("msg", "Invalid Date of Birth");
                    response.sendRedirect("registration.jsp");
                }else
                {
                if(passwordOne.equals(passwordTwo))
                {
                    //encryption settings.
                    misc.MakeSha makeSha = new misc.MakeSha();
                    misc.EncyptDecrypt encDec = new misc.EncyptDecrypt();
                    misc.KeyMaker km = new misc.KeyMaker();
                    byte[] keyByte = km.makeKeyDriver("testingtestingonetwothree");
                    SecretKeySpec sks = new SecretKeySpec(keyByte, "AES");
                    String encPass = encDec.encrypt(passwordOne, sks);
                    String strongPass = makeSha.makeHash(encPass);
                    try
                    {
                        //Persist the information
                        String encFName = encDec.encrypt(firstname, sks);
                        String encSName = encDec.encrypt(lastname, sks);
                        String encEmail = encDec.encrypt(email, sks);
                        String encAT = encDec.encrypt(accessType, sks);
                        
                        memberBean = new beans.MemberBean(username, strongPass, encFName, encSName, encEmail, encAT, dateOfBirth);
                        int returnedNum = memberBean.persist();
                        beans.HealthProfileBean healthBean = new beans.HealthProfileBean(0,0,0,0,0,0,returnedNum);
                        healthBean.persist();
                        session.setAttribute("healthprofile", healthBean);
                        
             
                        if(accessType.equals("user"))
                        {
                            System.out.println("Persist success.");
                            session.setAttribute("msg", "Thank you for registering!");
                            request.setAttribute("username", username);
                            request.setAttribute("password", passwordOne);
  
                            request.getRequestDispatcher("LogInServlet").forward(request,response);
                            return;
                            
                        }else
                        {
                            System.out.println("Persist fail.");
                            System.out.println(accessType);
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        //Exception handling
                    } catch (Exception ex)
                    {
                        //Send error message
                        ex.printStackTrace();
                        session.setAttribute("msg", "There was an error entering your details. Please try again.");
                        response.sendRedirect(referer);
                    }
                }else
                {
                    session.setAttribute("msg", "Passwords must match. Please try again.");
                    response.sendRedirect("registration.jsp");
                }}
                
            //if the user is a visitor.   
            }else if(mb!= null && mb.getAccessType().equals("admin"))
            {
                //Get the input parameters.
                String username = request.getParameter("username");
                String passwordOne = request.getParameter("passwordOne");
                String passwordTwo = request.getParameter("passwordTwo");
                String firstname = request.getParameter("forename");
                String lastname = request.getParameter("surname");
                Date dateOfBirth = Date.valueOf(request.getParameter("dob"));
                String email = request.getParameter("email");
                String regType = request.getParameter("userType");
                
                //Password match check
                if(passwordOne.equals(passwordTwo))
                {
                    //Encryption inputs
                    misc.MakeSha makeSha = new misc.MakeSha();
                    misc.EncyptDecrypt encDec = new misc.EncyptDecrypt();
                    misc.KeyMaker km = new misc.KeyMaker();
                    byte[] keyByte = km.makeKeyDriver("testingtestingonetwothree");
                    SecretKeySpec sks = new SecretKeySpec(keyByte, "AES");
                    String encPass = encDec.encrypt(passwordOne, sks);
                    String strongPass = makeSha.makeHash(encPass);
                    try
                    {
                        memberBean = new beans.MemberBean(username, passwordTwo, firstname, lastname, email, regType, dateOfBirth);
                        
                        memberBean.persist();
                        
                        if(memberBean.getAccessType().equals("admin"))
                        {
                            System.out.println("Persist success.");
                            session.setAttribute("msg", "The new admin has been registered!");
                            response.sendRedirect("index.jsp");
                        }else
                        {
                            System.out.println("Persist fail.");
                        }
                    } catch (SQLException ex)
                    {
                        session.setAttribute("msg", "That username already exists. Please try another");
                        response.sendRedirect(referer);
                    }
                }else
                {
                    response.sendRedirect(referer);
                    session.setAttribute("msg", "Passwords do not match");
                }
            }
        } finally
        {            
            out.close();
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
