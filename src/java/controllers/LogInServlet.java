
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.crypto.spec.SecretKeySpec;
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
@WebServlet(name = "LogInServlet", urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int logCount = 0;
    private long currentTime;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        if(logCount < 5)
        {
        try
            {
                currentTime = System.currentTimeMillis();
                session.setMaxInactiveInterval(5*60);
                if(request.getParameter("logout") == null)
                {
                    ++logCount;
                    System.out.println(logCount);
                    String userName, plainPassword;
                    userName = request.getParameter("username");
                    plainPassword = request.getParameter("password");
                    //misc.MakeSha makeSha = new misc.MakeSha();
                    //misc.EncyptDecrypt encDec = new misc.EncyptDecrypt();
                    //misc.KeyMaker km = new misc.KeyMaker();
                    //byte[] keyByte = km.makeKeyDriver("testingtestingonetwothree");
                    //SecretKeySpec sks = new SecretKeySpec(keyByte, "AES");
                    //String encPass = encDec.encrypt(plainPassword, sks);
                    //String strongPass = makeSha.makeHash(encPass);
                    //System.out.println(strongPass);
                    response.sendRedirect("");

                    try
                    {
                        beans.MemberBean mb = new beans.MemberBean();
                        mb = mb.retrieveOne(userName);
                        if(mb != null)
                        {
                            if(plainPassword.equals(mb.getPassword()))
                            {
                                System.out.println("Logged in");
                                session.setAttribute("userdetails", mb);
                                System.out.println(session.getMaxInactiveInterval());
                                logCount = 0;
                            }else
                            {
                                
                                session.setAttribute("loginstatus", "fail");
                                
                            }
                        }else
                        {
                            session.setAttribute("loginstatus", "fail");
                        }
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }else
                {
                    session.invalidate();
                    response.sendRedirect("index.jsp");
                }
            } finally
            {            
                out.close();
            }
        } else
        {
            try
            {
                if(System.currentTimeMillis() >= (currentTime + 60000))
                {
                    logCount = 0;
                    response.sendRedirect("index.jsp");
                }else
                {
                    session.setAttribute("msg", "Too many incorrect login attempts. Please wait 5 minutes before trying again.");
                    response.sendRedirect("index.jsp");
                }
            }finally
            {
                out.close();
            }
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
