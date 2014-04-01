<%-- 
    Document   : CreateGoal
    Created on : 06-Mar-2014, 21:31:01
    Author     : Liam
--%>

<%@page import="JoinedBeans.MessageDetailRecipients"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.GoalBean"%>
<%@page import="java.util.GregorianCalendar" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

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
        <div id="backImageLeft"></div>
        <div id="backImageRight"></div>
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
             <a href="index.jsp" id="homelink"><img src="Images/logo.jpg"></img></a>
            <div id ="loginBox">
                <form method="post" action="/SWE_GroupProject/LogInServlet" onsubmit="return checkForm();">
                    <div>
                        Username:<input type="text" id="loginFormUser" name="username" />
                        Password:<input type="password" id="loginFormPass" name="password" />
                        <input type="submit" value="Submit" />
                        <p>Not registered?...<input type="button" name="complete1" onclick="redirect('useRegister.jsp');" value="Register" /></p>
                    </div>
                </form>
            </div>
            <ul id = "navmenu">
                <li><a href="index.jsp">HOME</a></li>
                <td><a href="benefits.jsp">BENEFITS</a></td>
                <td><a href="testimonials.jsp">TESTIMONIALS</a></td>	
                <td><a href="aboutUs.jsp">ABOUT US</a></td>
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
    <div id ="maindiv">
        <br /><br />
            <h1>Sorry but you can't use this feature without being logged in,
                    why not log in or create an account?
              </h1> 
    </div>
    <div id = "footer">
            <br />
            <br />   
            <table id = "footerTable">
                <tr>
                    <td><a href="benefits.jsp">BENEFITS</a></td>
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
            <p>Designed and created by Ian Weeks and Ashley Moore</p>

        </div>
<% }  else if( memberBean.getAccessType().equals("user")) { %>
        <% if(request.getAttribute("goalsList") == null) 
              {
                  System.out.println("Redirecting.............");
                  request.getRequestDispatcher("ListGoalServlet").forward(request, response);
              }
        String message = (String) session.getAttribute("msg");
        if (message != null)
        {
%>
            <script>showMsg('<%= message%>');</script>
<%
            session.removeAttribute("msg");
        }
%>
 <jsp:useBean id="goalsList" type="ArrayList<GoalBean>" scope="request" />
 <jsp:useBean id="completeGoals" type="ArrayList<GoalBean>" scope="request" />
 <jsp:useBean id="failedGoals" type="ArrayList<GoalBean>" scope="request" />
 <jsp:useBean id="inProgressGoals" type="ArrayList<GoalBean>" scope="request" />
 <jsp:useBean id="unRead" type="ArrayList<MessageDetailRecipients>" scope="session" />
 <div id ="header">
            <a href="index.jsp" id="homelink"><img src="Images/logo.jpg"></img></a>
            <div id ="loginBox">
                Welcome back User <%= memberBean.getUserName()%>.
                <form method="get" action="/SWE_GroupProject/LogInServlet">
                    <p>
                        <input type="hidden" name="logout" value="logout" />
                        <input type="submit" name="" value="Logout" />
                    </p>
                </form>
                <h2><a href="MessageServlet"><%=unRead.size()%> New Messages</a></h2>
            </div>
            <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="profile.jsp"><%= memberBean.getFirstName() %></a>
                    <ul>
                        <li><a href="profile.jsp">My Profile</a></li>
                        <li><a href="goal.jsp">My Goals</a></li>
                        <li><a href="groups.jsp">My Groups</a></li>
                    </ul>
                </li>		
                <li><a href="goal.jsp">Lifestyle</a>
                    <ul>
                        <li><a href="foods.jsp">Foods</a></li>
                        <li><a href="exercises.jsp">Exercises</a></li>
                        
                    </ul>
                </li>
                <li><a href="food.jsp">Other?</a></li>
            </ul>
            </nav>
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
            <br />
            <br />
            <h1>Create A New Goal</h1>
                    <form method="post" name="GoalServlet" action="CreateGoalServlet" >
                        <table id="adminTableOne">
                            <tr>
                                <td>
                                    Will you be creating this goal for yourself or one of your groups?
                                </td>
                            </tr>
                            <tr><td><p></p></td></tr>
                            <tr>
                                <td>
                                    <input type="radio" name="goalFor" value="false" checked />Myself
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
                                    <input type="text" name="aim" pattern=".{1,2}[0-9]+"  required/>
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
                                    <input type="hidden" value="create" name="formType" />
                                    <input type="submit" action="Submit" />
                                </td>
                            </tr>
                        </table>
                    </form>
                <br /><br />
            <h1>Your Current Goals</h1>
            <% if (inProgressGoals.size() != 0)
            {
                %><table id="adminTableOne">
                    <tr><td>Goal Start Date</td><td>Goal End Date</td><td>Category</td><td>Type</td><td>Aim</td><td>Progress</td></tr>
                    <%
                for(int i = 0; i < inProgressGoals.size(); i++)
                { 
                    GoalBean tempGoal = new GoalBean(); 
                    tempGoal = inProgressGoals.get(i);
                    %>
                    <tr id="goalInProgress">
                        <td><%=tempGoal.getGoalStartDate() %></td>
                        <td><%=tempGoal.getGoalEndDate() %></td>
                        <td><%=tempGoal.getCategory() %></td>
                        <td><%=tempGoal.getType() %></td>
                        <td><%=tempGoal.getAim() %></td>
                        <td><%=tempGoal.getGoalProgress() %>%</td>
                        <td>
                            <form action="CreateGoalServlet" method="post">
                                <input type="hidden" value="<%=tempGoal.getID() %>" name="goalID" />
                                <input type="hidden" value="delete" name="formType" />
                                <input type="submit" value="Delete Goal" />
                            </form>   
                        </td>
                         <td>
                            <form action="CreateGoalServlet" method="post">
                                <input type="hidden" value="<%=tempGoal.getID() %>" name="goalID" />
                                <input type="hidden" value="update" name="formType" />
                                <input type="submit" value="Edit Goal" />
                            </form>   
                        </td>
                    </tr>
                <% } %>

                </table>
                <br />
              
                
                <br />
                <% } if(completeGoals.size() != 0)
                {
                    %>
                    <h1>Your Completed Goals</h1>
                    <table id="adminTableOne">
                    <tr><td>Goal Start Date</td><td>Goal End Date</td><td>Category</td><td>Type</td><td>Aim</td><td>Progress</td></tr>
                    <%
                    for(int i = 0; i < completeGoals.size(); i++)
                    {
                        GoalBean tempGoal = new GoalBean();
                        tempGoal = completeGoals.get(i);
                        
                        %><tr id="goalComplete">
                        <td><%=tempGoal.getGoalStartDate() %></td>
                        <td><%=tempGoal.getGoalEndDate() %></td>
                        <td><%=tempGoal.getCategory() %></td>
                        <td><%=tempGoal.getType() %></td>
                        <td><%=tempGoal.getAim() %></td>
                        <td><%=tempGoal.getGoalProgress() %>%</td>
                        <td>
                            <form action="CreateGoalServlet" method="post">
                                <input type="hidden" value="<%=tempGoal.getID() %>" name="goalID" />
                                <input type="hidden" value="delete" name="formType" />
                                <input type="submit" value="Delete Goal" />
                            </form>   
                        </td>
                    </tr>
                   <% }
                    %></table>
                    <br />
                    <br />
                    <% } if(failedGoals.size() != 0)
                    {
                       %>
                       <h1>Goals You Failed</h1>
                    <table id="adminTableOne">
                    <tr><td>Goal Start Date</td><td>Goal End Date</td><td>Category</td><td>Type</td><td>Aim</td><td>Progress</td></tr>
                    <%
                    for(int i = 0; i < failedGoals.size(); i++)
                    {
                        GoalBean tempGoal = new GoalBean();
                        tempGoal = failedGoals.get(i);
                        
                        %><tr id="goalFailed">
                        <td><%=tempGoal.getGoalStartDate() %></td>
                        <td><%=tempGoal.getGoalEndDate() %></td>
                        <td><%=tempGoal.getCategory() %></td>
                        <td><%=tempGoal.getType() %></td>
                        <td><%=tempGoal.getAim() %></td>
                        <td><%=tempGoal.getGoalProgress() %>%</td>
                        <td>
                            <form action="CreateGoalServlet" method="post">
                                <input type="hidden" value="<%=tempGoal.getID() %>" name="goalID" />
                                <input type="hidden" value="delete" name="formType" />
                                <input type="submit" value="Delete Goal" />
                            </form>   
                        </td>
                    </tr>
                   <% }
                    %></table> 
                    <%}
               else { %> 
            <h1> You don't have any goals right now, why not create one above?</h1>
            <% } %>
            <br /><br />
            
        </div>
<div id = "footer">
            <br />
            <br />   
            <table id = "footerTable">
                <tr>
                    <td><a href="benefits.jsp">BENEFITS</a></td>
                    <td><a href="testimonials.jsp">TESTIMONIALS</a></td>	
                    <td><a href="aboutUs.jsp">ABOUT US</a></td>
                    <td><a href="messages.jsp">MESSAGES</a></td>
                </tr>
                <tr>
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
                <% } else { %>
                   
                <% } %>
    </body>
</html>
