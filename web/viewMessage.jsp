<%-- 
    Document   : profile
    Created on : 05-Mar-2014, 14:02:53
    Author     : Twiz
--%>

<%@page import="beans.MessageDetailsBean;"%>
<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="ashCSS.css" />
        <title>Profile page</title>
        <script type="text/javascript">
            function redirect()
            {
                window.location = "registration.jsp";
            }

            function showMsg(msgVar)
            {
                window.alert(msgVar);
            }
            
            function checkForm()
            {
                var username = document.getElementById('loginFormUser');
                var password = document.getElementById('loginFormPass');
                
                if(username.value === "")
                {
                    window.alert("User Name Field is Empty");
                    document.getElementById('loginFormUser').focus();
                    return false;
                }else if(password.value === "")
                {
                    window.alert("Password field is empty");
                    document.getElementById('loginFormPass').focus();
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div id ="backImageLeft"></div>
        <div id ="backImageRight"></div>
    <%
        beans.MemberBean memberBean = (beans.MemberBean) session.getAttribute("userdetails");
        if(memberBean == null)
        {
            // This user is not logged in so cannot access this page.
            session.setAttribute("msg", "You must be logged in to view that page.");
            response.sendRedirect("index.jsp");
        }else if(memberBean.getAccessType().equals("user"))
        {
           //Logged in.....
            String message = (String) session.getAttribute("msg");
        if (message != null)
        {
%>
            <script>showMsg('<%= message%>');</script>
<%
            session.removeAttribute("msg");
        }
%>
    
    <div id ="header">
            <a href="index.jsp" id="homelink"><img src="Images/logo.jpg"></img></a>
            <div id ="loginBox">
                <div>
                    Welcome back User <%= memberBean.getUserName()%>.
                    <form method="get" action="/SWE_GroupProject/LogInServlet">
                        <p>
                            <input type="hidden" name="logout" value="logout" />
                            <input type="submit" name="" value="Logout" />
                        </p>
                    </form>
                </div>
                
            </div>
            <ul id = "navmenu">
                <li><a href="index.jsp">HOME</a></li>
                <li><a href="profile.jsp">MY PROFILE</a></li>		
                <li><a href="goal.jsp">GOALS</a></li>
                <li><a href="groups.jsp">GROUPS</a></li>
            </ul>
             <div id="search">
                <form action="/SystemsCoursework/SearchServe" method="get">
                    <p>
                    Google
                    <input type="radio" name="searchType" checked="checked" value="google" />
                    This site
                    <input type="radio" name="searchType"  value="thisSite" />
                    </p>
                    <input type="text"placeholder="Search..." name="theSearch"  size="30" />
                    <input type="submit" value="Submit" />
                    
                </form>
            </div>
            </div>
        </div>
        <div id ="maindiv">
            <% if(request.getAttribute("messageToView") == null) 
              {
                  System.out.println("Redirecting.............");
                  request.getRequestDispatcher("messages.jsp").forward(request, response);
              }
            %>

 <jsp:useBean id="messageToView" type="MessageDetailsBean" scope="request" />
            <br /><br />
                                                          
                <p id ="p2">Edit Goal</p>
                
                    <table id ="adminTableOne">
                        
                        <tr>
                            <td>Message Sent At:</td> <td><%= messageToView.getSendDate() %> <%=messageToView.getSendTime() %> </td>
                        </tr>
                        <tr>
                            <td>Message Sent By:</td> <td> <%=messageToView.getSenderID() %></td>
                        </tr>
                        <tr>
                            <td>Subject:</td><td><%= messageToView.getSubject() %></td>
                        </tr>
                        
                    </table>
                        <br/>
                        <textarea rows="25" cols="100" name="messageDetail" form="sendMessage" readonly><%= messageToView.getText()%></textarea>
                       
                        <br /><br />
                <form method="post" action="/SWE_GroupProject/MessageServlet">
                        <input type="hidden" value="<%= messageToView.getId() %>" name="messageID" />
                        <input type="hidden" value="delete" name="formType" />
                        <input type="Submit" value="Delete Message" />
                </form>

                <div style="clear:both;"></div>  
                <br />

            <br />
        </div>
        <div id = "footer">
            <br />
            <br />   
            <table id = "footerTable">
                <tr>
                    <td><a href="index.jsp">HOME</a></td>
                    <td><a href="benefits.jsp">BENEFITS</a></td>	
                    <td><a href="defaultFestival.jsp">FESTIVALS</a></td>
                    <td><a href="aboutUs.html">ABOUT US</a></td>
                </tr>
                <tr>
                    <td><a href="useRegister.jsp">USER REGISTRATION</a></td>
                    <td></td>	
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>		
                    <td></td>
                    <td></td>
                </tr>
            </table>

            <br />
            <p>Designed and created by Ian Weeks and Ashley Moore</p>

        </div>
    
    <%
        }else if(memberBean.getAccessType().equals("admin"))
        {
    %>
    
    Admin page....
    
    <%
        }
    %>
    </body>
</html>