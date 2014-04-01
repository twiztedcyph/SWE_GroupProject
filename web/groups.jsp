
<%@page import="java.util.ArrayList"%>
<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="ashCSS.css" />
        <title>The Health Tracker - Groups</title>
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
                    window.alert("Username field is empty!");
                    document.getElementById('loginFormUser').focus();
                    return false;
                }else if(password.value === "")
                {
                    window.alert("Password field is empty!");
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
    if (memberBean == null)
    {
        //not logged in..
        session.setAttribute("msg", "You must be logged in to view that page.");
        response.sendRedirect("index.jsp");
    } else if (memberBean.getAccessType().equals("admin"))
    {
        //Logged in as admin
        String message = (String) session.getAttribute("msg");
        if (message != null)
        {
%>
            <script type="text/javascript">showMsg('<%= message%>');</script>
<%
            session.removeAttribute("msg");
        }
    }else if (memberBean.getAccessType().equals("user"))
    {
        //Logged in as a regular user
        
        if(request.getAttribute("groupmemberlist") == null)
        {
            request.getRequestDispatcher("GroupServlet").forward(request, response);
        }
        
        ArrayList<beans.GroupDetailsBean> groupMemberList 
                = (ArrayList<beans.GroupDetailsBean>) 
                request.getAttribute("groupmemberlist");
        
        ArrayList<beans.GroupDetailsBean> groupNonMemberList 
                = (ArrayList<beans.GroupDetailsBean>) 
                request.getAttribute("groupnonmemberlist");
        
        String message = (String) session.getAttribute("msg");
        if (message != null)
        {
%>
<script type="text/javascript">showMsg('<%= message%>');</script>
<%
            session.removeAttribute("msg");
        }
%>
        <div id ="header">
            <a href="index.jsp" id="homelink"><img src="Images/logo.jpg" alt="home"></img></a>
            <div id ="loginBox">
                Welcome back User <%= memberBean.getUserName()%>.
                <form method="get" action="/SWE_GroupProject/LogInServlet">
                    <p>
                        <input type="hidden" name="logout" value="logout" />
                        <input type="submit" name="" value="Logout" />
                    </p>
                </form>
            </div>
            <ul id = "navmenu">
                <li><a href="index.jsp">HOME</a></li>
                <li><a href="profile.jsp">PROFILE</a></li>		
                <li><a href="goal.jsp">GOALS</a></li>
                <li><a href="groups.jsp">GROUPS<span style="color: red; background: #000;"></span></a></li>
            </ul>
            <div id="search">
                <form action="/SystemsCoursework/SearchServe" method="post">
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
        <div id ="maindiv">
            <br /><br />
            <div>
                <h1>Hello <%= memberBean.getFirstName()%>, welcome back!</h1>
                <br />
                <h3>
                    Groups you are a member of:
                </h3>
                
                <table id="messageDisplay">
<%
            for(beans.GroupDetailsBean gdb : groupMemberList)
            {
%>
                    <tr>
                        <td> <%= gdb.getGroupName() %> </td>
                        <td> <%= gdb.getGroupDescription() %> </td>
                        <td>
                            <form method="post" action="/SWE_GroupProject/GroupServlet">
                                <input type="hidden" name="viewgroupname" value="<%= gdb.getGroupName() %>" />
                                <input type="submit" value="View" />
                            </form>
                        </td>
                    </tr>
<%
            }
%>
                </table>
                
                <br />
                <h3>
                    Groups you are a not member of:
                </h3>
                
                <table id="messageDisplay">
<%
            for(beans.GroupDetailsBean gtdb : groupNonMemberList)
            {
%>
                    <tr>
                        <td> <%= gtdb.getGroupName() %> </td>
                        <td> <%= gtdb.getGroupDescription() %> </td>
                        <td>
                            <form method="post" action="/SWE_GroupProject/GroupServlet">
                                <input type="hidden" name="joingroupname" value="<%= gtdb.getGroupName() %>" />
                                <input type="submit" value="Join" />
                            </form>
                        </td>
                    </tr>
<%
            }
%>
                </table>
            </div>
            <br />
        </div>
        <div id = "footer">
            <br />
            <br />   
            <table id = "footerTable">
                <tr>
                    <td><a href="index.jsp">BENEFITS</a></td>
                    <td><a href="testimonials.jsp">TESTIMONIALS</a></td>	
                    <td><a href="aboutUs.jsp">ABOUT US</a></td>
                    <td><a href="messages.jsp">MESSAGES</a></td>
                </tr>
                <tr>
                    <td></td>
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
            <p>Designed and created by Ian, Ash, Liam and Warren</p>

        </div>
                 <%
    } 
        //Logged in as admin
        //newMessages = messageBean.getAllNewMessages(userBean.getUsername());
%>
    </body>
</html>
