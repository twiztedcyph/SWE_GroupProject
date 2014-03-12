<%-- 
    Document   : profile
    Created on : 05-Mar-2014, 14:02:53
    Author     : Twiz
--%>

<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="ashCSS.css" />
        <title>Profile page</title>
    </head>
    <body>
        <div id ="backImageLeft"></div>
        <div id ="backImageRight"></div>
    <%
        beans.MemberBean memberBean = (beans.MemberBean) session.getAttribute("userdetails");
        if(memberBean == null)
        {
    %>
        <div id ="header">
            <a href="index.jsp" id="homelink"></a>
            <div id ="loginBox">
                
            </div>
            <ul id = "navmenu">
                <li><a href="index.jsp">HOME</a></li>
                <li><a href="benefits.jsp">BENEFITS</a></li>		
                <li><a href="defaultFestival.jsp">TESTIMONIALS</a></li>
                <li><a href="aboutUs.html">ABOUT US</a></li>
            </ul>
            <div id="search">
                <form action="/SystemsCoursework/SearchServlet" method="get">
                    <p>
                    Search
                    <input type="hidden" name="searchType" value="google" />
                    <input type="text" name="theSearch" size="30" />
                    <input type="submit" value="Submit" />
                    </p>
                </form>
            </div>
        </div>
        <div id ="maindiv">
            <br /><br />
            
            <br />
        </div>
        <div id = "footer">
            <br />
            <br />   
            <table id = "footerTable">
                <tr>
                    <td><a href="index.jsp">HOME</a></td>
                    <td><a href="benefits.jsp">BENEFITS</a></td>	
                    <td><a href="testimonials.html">TESTIMONIALS</a></td>
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
        }else if(memberBean.getAccessType().equals("user"))
        {
           //Logged in.....
    %>
    
    <div id ="header">
            <a href="index.jsp" id="homelink"></a>
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
                <li><a href="benefits.jsp">BENEFITS</a></li>		
                <li><a href="defaultFestival.jsp">TESTIMONIALS</a></li>
                <li><a href="aboutUs.html">ABOUT US</a></li>
            </ul>
            <div id="search">
                <form action="/SystemsCoursework/SearchServlet" method="get">
                    <p>
                    Search
                    <input type="hidden" name="searchType" value="google" />
                    <input type="text" name="theSearch" size="30" />
                    <input type="submit" value="Submit" />
                    </p>
                </form>
            </div>
        </div>
        <div id ="maindiv">
            <br /><br />
                                                          
                <p id ="p2">User profile</p>
                <form method="post" action="/SWE_GroupProject/ProfileServlet">
                    <table id ="adminTableOne">
                        <tr>
                            <td>Username:</td> <td><%= memberBean.getUserName() %></td><td></td>
                        </tr>
                        <tr>
                            <td>Password:</td> <td><%= memberBean.getPassword() %></td><td><input type="submit" name="change_pass" value="Change" /></td>
                        </tr>
                        <tr>
                            <td>First Name:</td> <td> <%= memberBean.getFirstName() %></td><td></td>
                        </tr>
                        <tr>
                            <td>Last Name:</td> <td><%= memberBean.getLastName() %></td><td></td>
                        </tr>
                        <tr>
                            <td>Date of birth:</td> <td><%= memberBean.getDateOfBirth() %></td><td></td>
                        </tr>
                        <tr>
                            <td>Email:</td> <td><%= memberBean.getEmailAddress() %></td><td><input type="submit" name="change_email" value="Change" /></td>
                        </tr>
                    </table>
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
