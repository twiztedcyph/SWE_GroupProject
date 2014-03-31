<%-- 
    Document   : exercise
    Created on : 31-Mar-2014, 13:46:21
    Author     : Ash
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="ashCSS.css" />
        <title>Lifestyle Details</title>
        <script type="text/javascript">
            function redirect()
            {
                window.location = "registration.jsp";
            }

            function showMsg(msgVar)
            {
                window.alert(msgVar);
            }
        </script>
    </head>
    <body>
        <div id ="backImageLeft" ></div>
        <div id ="backImageRight"></div>
<%
    beans.MemberBean memberBean = (beans.MemberBean) session.getAttribute("userdetails");
    if (memberBean == null)
    {
        //not logged in..
        String message = (String) session.getAttribute("msg");
        if (message != null)
        {
%>
            <script>showMsg('<%= message%>');</script>
<%
            session.removeAttribute("msg");
        }
        session.setAttribute("msg", "You must be logged in to view that page.");
        response.sendRedirect("index.jsp");
    }else if(memberBean.getAccessType().equals("user"))
    {
        ArrayList<beans.ExerciseBean> exerciseList = (ArrayList<beans.ExerciseBean>) session.getAttribute("exerciselist");
        if(exerciseList == null)
        {
            System.out.println("Before request");
            request.getRequestDispatcher("ExerciseServlet").forward(request, response);
            System.out.println("After request");
        }
        String message = (String) session.getAttribute("msg");
        if (message != null)
        {
%>
            <script>showMsg('<%= message%>');</script>
<%
            session.removeAttribute("msg");
            
        }
        // Logged in
%>
        <div id ="header">
            <a href="index.jsp" id="homelink"><img src="Images/logo.jpg" alt="home" /></a>
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
                <li><a href="index.jsp">Home</a></li>
                <li><a href="profile.jsp">My Profile</a></li>		
                <li><a href="goal.jsp">Goals</a></li>
                <li><a href="messages.jsp">Groups<span style="color: red; background: #000;"></span></a></li>
            </ul>
            <div id="search">
                <form action="/SystemsCoursework/SearchServe" method="post">
                    <p>
                    Google
                    <input type="radio" name="searchType" checked="checked" value="google" />
                    This site
                    <input type="radio" name="searchType"  value="thisSite" />
                    </p>
                    <input type="text" placeholder="Search..." name="theSearch"  size="30" />
                    <input type="submit" value="Submit" />
                </form>
            </div>
        </div>

        <div id ="maindiv">
            <br />
            <br />
            <h1>Exercise History</h1>
            <br />
            <br />
            <form method="post" action="/SWE_GroupProject/ExerciseServlet">
                <table id="messageDisplay">
                    <tr>
                        <th>Exercise Type</th>
                        <th>Date </th>
                        <th>Time </th>
                        <th>View</th>
                    </tr>
<%
            for(beans.ExerciseBean exercise : exerciseList)
            {
%>  

                    <tr>
                        <td> <%= exercise.getExerciseType() %> </td>
                        <td> <%= exercise.getExerciseDate() %> </td>
                        <td> <%= exercise.getExerciseTime().toString().replace(":00", "") %> </td>
                        <td>
                            <input type="hidden" name="fname" value=" <%= exercise.getExerciseType() %> " />
                            <input type="submit" value="Submit" /> 
                        </td>
                    </tr>
<%
            }
%>
                </table>
            </form>
            <br />
            <form> 
                <input type=button 
                value="Back to exercise entry"
                onClick="self.location='exercises.jsp'">
            </form>
            <br />
            <br />    
        </div>
        <div id = "footer">
            <br />
            <br />   
            <table id = "footerTable">
                <tr>
                    <td><a href="index.jsp">HOME</a></td>
                    <td><a href="accountAdmin.jsp">USER CONTROL</a></td>	
                    <td><a href="festivalControl.jsp">FESTIVAL CONTROL</a></td>
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
%>
    </body>
</html>
