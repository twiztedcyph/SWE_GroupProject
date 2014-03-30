<%-- 
    Document   : lifestyle
    Created on : 24-Mar-2014, 13:46:21
    Author     : Twiz
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
        ArrayList<beans.FoodBean> foodList = (ArrayList<beans.FoodBean>) session.getAttribute("foodlist");
        if(foodList == null)
        {
            request.getRequestDispatcher("FoodServlet").forward(request, response);
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
            <h1>Lifestyle details.</h1>
            <br />
            <h2></h2>
            <p></p>
            <form method="post" action="/SWE_GroupProject/FoodServlet">
                <table id="adminRegTable">
                    <tr>
                        <td>Food name</td><td></td><td><input type="text" name="foodname" required="" /></td>
                    </tr>
                    <tr>
                        <td>Date eaten</td><td></td><td><input type="date" name="dateeaten" required="" /></td>
                    </tr>
                    <tr>
                        <td>Time eaten</td><td></td><td><input type="time" name="timeeaten" required="" /></td>
                    </tr>
                    <tr>
                        <td>Protein / 100g</td><td></td><td><input type="text" name="protein" required="" /></td>
                    </tr>
                    <tr>
                        <td>Carbs / 100g</td><td></td><td><input type="text" name="carbs" required="" /></td>
                    </tr>
                    <tr>
                        <td>Fats<br />Unsaturated</td><td></td><td><input type="text" name="unsatfat" required="" /></td>
                    </tr>
                    <tr>
                        <td>Fats<br />Saturated</td><td></td><td><input type="text" name="satfat" required="" /></td>
                    </tr>
                    <tr>
                        <td>Sugar / 100g</td><td></td><td><input type="text" name="sugar" required=""/></td>
                    </tr>
                    <tr>
                        <td>Salt / 100g</td><td></td><td><input type="text" name="salt" required="" /></td>
                    </tr>
                    <tr>
                        <td>KiloCalories  / 100g</td><td></td><td><input type="text" name="kcal" required="" /></td>
                    </tr> 
                    <tr>
                        <td></td><td><input type="submit" name="lifestyle_submit" value="Submit"/></td><td></td>
                    </tr>
                </table>
            </form>
            <br />
            <h2>Food history</h2>
            <table>
<%
            for(beans.FoodBean fb : foodList)
            {
%>
                <tr>
                    <td> <%= fb.getFoodName() %> </td>
                </tr>
<%
            }
%>
            </table>
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
