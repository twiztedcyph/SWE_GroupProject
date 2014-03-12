<%-- 
    Document   : CreateGoal
    Created on : 06-Mar-2014, 21:31:01
    Author     : Liam
--%>

<%@page import="java.util.ArrayList"%>
<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="ashCSS.css" />
        <title>Health Tracker</title>
        <script type="text/javascript">
            function redirect()
            {
                window.location = "useRegister.jsp";
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
        <%
    //Beans.MessageBean messageBean = new Beans.MessageBean();
    //ArrayList<Beans.MessageBean> newMessages = new ArrayList();
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
    %>
        <div id ="header">
            <a href="index.jsp" id="homelink"></a>
            <div id ="loginBox">
                <form method="post" action="/SWE_GroupProject/LogInServlet" onsubmit="return checkForm();">
                    <div>
                        <p>Username:<input type="text" id="loginFormUser" name="username" /></p>
                        <p>Password:<input type="password" id="loginFormPass" name="password" /></p>
                        <p><input type="submit" value="Submit" /></p>
                        <input type="button" name="complete1" onclick="redirect('useRegister.jsp');" value="Register" />
                    </div>
                </form>
            </div>
            <ul id = "navmenu">
                <li><a href="index.jsp">HOME</a></li>
                <li><a href="index.jsp">NULL</a></li>		
                <li><a href="index.jsp">NULL</a></li>
                <li><a href="index.html">NULL</a></li>
            </ul>
            <div id="search">
                <form action="/SystemsCoursework/SearchServe" method="get">
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
        <div id="p1">
            <p>Sorry but you can't use this feature without being logged in,
                    why not log in or create an account?
              </p> 
        </div>
    </div>
<% }  else if( memberBean.getAccessType().equals("user")) { %>
 <div id ="header">
            <a href="index.jsp" id="homelink"></a>
            <div id ="loginBox">
                Welcome back User <%= memberBean.getUserName()%>.
                <form method="get" action="/SystemsCoursework/LogInServe">
                    <p>
                        <input type="hidden" name="logout" value="logout" />
                        <input type="submit" name="" value="Logout" />
                    </p>
                </form>
            </div>
            <ul id = "navmenu">
                <li><a href="index.jsp">1</a></li>
                <li><a href="accountAdmin.jsp">2</a></li>		
                <li><a href="festivalControl.jsp">3</a></li>
                <li><a href="messages.jsp">4<span style="color: red; background: #000;"></span></a></li>
            </ul>
            <div id="search">
                <form action="/SystemsCoursework/SearchServe" method="post">
                    <p>
                    Google
                    <input type="radio" name="searchType" checked="checked" value="google" />
                    This site
                    <input type="radio" name="searchType"  value="thisSite" />
                    <input type="text" name="theSearch" size="30" />
                    <input type="submit" value="Submit" />
                    </p>
                </form>
            </div>
        </div>

        <div id ="maindiv">
            <br /><br />
            <div id="p1">
                    <form name="CreateGoal" action="CreateGoalServlet" method="post">
                        <table>
                            <tr>
                                <td>
                                    <input type="hidden" name="member" value="<%= memberBean.getId() %>" />
                                    Will you be creating this goal for yourself or one of your groups?
                                </td>
                            </tr>
                            <tr><td><p></p></td></tr>
                            <tr>
                                <td>
                                    <input type="radio" name="goalFor" value="false" />Myself
                                    <input type="radio" name="goalFor" value="true" />One of my groups
                                </td>
                            </tr>
                            <tr><td><p></p></td></tr>
                            <tr>
                                <td>  
                                    Start Date:
                                    <input type="date" name="startDate" />
                                </td>
                            </tr>
                            <tr><td><p></p></td></tr>
                            <tr>
                                <td>
                                    End Date:   
                                    <input type="date" name="endDate" />
                                </td>
                            </tr>
                            <tr><td><p></p></td></tr>
                            <tr>
                                <td>
                                    About Your target:
                                </td>
                            </tr>
                            <tr><td><p></p></td></tr>
                            <tr>
                                <td>
                                I want to
                                    <select name="category">
                                        <option value ="lose">Lose</option>
                                        <option value ="gain">Gain</option>
                                    </select>
                                    <input type="text" name="aim" />
                                    KG of
                                    <select name="type">
                                        <option value ="weight">Weight</option>
                                        <option value="bodyFatPercentage">Body Fat</option>
                                        <option value="BMI">Body Mass Index</option>
                                        <option value="muscleMass">Muscle Mass</option>
                                    </select>
                                </td>
                            </tr>
                            <tr><td><p></p></td></tr>
                            <tr>
                                <td>
                                      <input type="submit" action="Submit" />
                                </td>
                            </tr>
                        </table>
                    </form>
                <br /><br />

                <% } else { %>
                   
                <% } %>
          
            </div>
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
        
    </body>
</html>
