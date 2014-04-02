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

                if (username.value === "")
                {
                    window.alert("User Name Field is Empty");
                    document.getElementById('loginFormUser').focus();
                    return false;
                } else if (password.value === "")
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
            if (memberBean == null) {
                //not logged in..
                String message = (String) session.getAttribute("msg");
                if (message != null) {
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
            <nav>
                <ul>
                    <li><a href="index.jsp">HOME</a></li>
                    <td><a href="benefits.jsp">BENEFITS</a></td>
                    <td><a href="testimonials.jsp">TESTIMONIALS</a></td>	
                    <td><a href="aboutUs.jsp">ABOUT US</a></td>
                </ul>
            </nav>
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
                    <td><a href="index.jsp">HOME</a></td>
                    <td><a href="benefits.jsp">BENEFITS</a></td>
                    <td><a href="testimonials.jsp">TESTIMONIALS</a></td>	
                    <td><a href="aboutUs.jsp">ABOUT US</a></td>
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
        <% } else if (memberBean.getAccessType().equals("user")) { %>
        <% if (request.getAttribute("goalsList") == null) {
                System.out.println("Redirecting.............");
                request.getRequestDispatcher("ListGoalServlet").forward(request, response);
            }
            String message = (String) session.getAttribute("msg");
            if (message != null) {
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
                Welcome back <%= memberBean.getUserName()%>!
                <form method="get" action="/SWE_GroupProject/LogInServlet">
                    <p>
                        <input type="hidden" name="logout" value="logout" />
                        <input type="submit" name="" value="Logout" />
                    </p>
                </form>
                <h2 id="messagesH2"><a href="MessageServlet"><%=unRead.size()%> New Messages</a></h2>
            </div>
            <nav>
                <ul>
                    <li id="nav ul li2"><a href="index.jsp">HOME</a></li>
                    <li><a href="profile.jsp"><%= memberBean.getFirstName().toUpperCase()%></a>
                        <ul>
                            <li><a href="profile.jsp">PROFILE</a></li>
                            <li><a href="goal.jsp">GOALS</a></li>
                            <li><a href="groups.jsp">GROUPS</a></li>
                        </ul>
                    </li>		
                    <li><a href="food.jsp">LIFESTYLE</a>
                        <ul>
                            <li><a href="food.jsp">FOODS</a></li>
                            <li><a href="exercises.jsp">EXERCISES</a></li>

                        </ul>
                    </li>
                    <li><a href="messages.jsp">MESSAGES</a></li>
                </ul>
            </nav>
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
            <br />
            <br />
            <div id ="testimonialsDiv">
                <h1>Create or Edit Goals!</h1>
                <form method="post" name="GoalServlet" action="CreateGoalServlet" >
                    <table id="adminTableOne">
                        <tr>
                            Will you be creating this goal for yourself or one of your groups?
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <p>Myself</p><input type="radio" name="goalFor" value="false" checked />    
                            </td>
                            <td>
                                <p>A Group</p><input type="radio" name="goalFor" value="true" />
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>  
                                Start Date:
                            </td>
                            <td>
                                <input type="date" name="startDate" />
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                End Date:   
                            </td>
                            <td>
                                <input type="date" name="endDate" />
                            </td>
                            <td></td>
                        </tr>
                    </table>

                    <table id="adminTableOne">
                        <tr>
                            <h2>Your Target</h2>
                        </tr>
                    </table>

                    <table id="adminTableOne">
                        <tr>
                            I want to
                            <select name="category">
                                <option value ="lose">lose</option>
                                <option value ="gain">gain</option>
                            </select>
                            <input id="weight" type="text" name="aim" pattern=".{1,2}[0-9]+"  required/>
                            <select name="weight">
                                <option value="kilograms">kilograms (kg)</option>
                                <option value="pounds">pounds (lb)</option>
                                <option value="pounds">stone (st)</option>
                            </select>
                            of
                            <select name="type">
                                <option value="bodyFatPercentage">body fat</option>
                                <option value="muscleMass">muscle mass</option>
                            </select>
                            !
                        </tr>
                        <tr>
                            <input type="hidden" value="create" name="formType" />
                            <input id="submit1" type="submit" action="Submit Goal" />
                        </tr>

                    </table>
                </form>
            </div>
            <h2>Your Current Goals</h2>
            <% if (inProgressGoals.size() != 0) {
            %><table id="adminTableOne">
                <tr><td>Goal Start Date</td><td>Goal End Date</td><td>Category</td><td>Type</td><td>Aim</td><td>Progress</td></tr>
                <%
                    for (int i = 0; i < inProgressGoals.size(); i++) {
                        GoalBean tempGoal = new GoalBean();
                        tempGoal = inProgressGoals.get(i);
                %>
                <tr id="goalInProgress">
                    <td><%=tempGoal.getGoalStartDate()%></td>
                    <td><%=tempGoal.getGoalEndDate()%></td>
                    <td><%=tempGoal.getCategory()%></td>
                    <td><%=tempGoal.getType()%></td>
                    <td><%=tempGoal.getAim()%></td>
                    <td><%=tempGoal.getGoalProgress()%>%</td>
                    <td>
                        <form action="CreateGoalServlet" method="post">
                            <input type="hidden" value="<%=tempGoal.getID()%>" name="goalID" />
                            <input type="hidden" value="delete" name="formType" />
                            <input type="submit" value="Delete Goal" />
                        </form>   
                    </td>
                    <td>
                        <form action="CreateGoalServlet" method="post">
                            <input type="hidden" value="<%=tempGoal.getID()%>" name="goalID" />
                            <input type="hidden" value="update" name="formType" />
                            <input type="submit" value="Edit Goal" />
                        </form>   
                    </td>
                </tr>
                <% } %>

            </table>
            <br />


            <br />
            <% }
                if (completeGoals.size() != 0) {
            %>
            <h2>Your Completed Goals</h2>
            <table id="adminTableOne">
                <tr><td>Goal Start Date</td><td>Goal End Date</td><td>Category</td><td>Type</td><td>Aim</td><td>Progress</td></tr>
                <%
                    for (int i = 0; i < completeGoals.size(); i++) {
                        GoalBean tempGoal = new GoalBean();
                        tempGoal = completeGoals.get(i);

                %><tr id="goalComplete">
                    <td><%=tempGoal.getGoalStartDate()%></td>
                    <td><%=tempGoal.getGoalEndDate()%></td>
                    <td><%=tempGoal.getCategory()%></td>
                    <td><%=tempGoal.getType()%></td>
                    <td><%=tempGoal.getAim()%></td>
                    <td><%=tempGoal.getGoalProgress()%>%</td>
                    <td>
                        <form action="CreateGoalServlet" method="post">
                            <input type="hidden" value="<%=tempGoal.getID()%>" name="goalID" />
                            <input type="hidden" value="delete" name="formType" />
                            <input type="submit" value="Delete Goal" />
                        </form>   
                    </td>
                </tr>
                <% }
                %></table>
            <br />
            <br />
            <% }
                if (failedGoals.size() != 0) {
            %>
            <h2>Goals You Failed</h2>
            <table id="adminTableOne">
                <tr><td>Goal Start Date</td><td>Goal End Date</td><td>Category</td><td>Type</td><td>Aim</td><td>Progress</td></tr>
                <%
                    for (int i = 0; i < failedGoals.size(); i++) {
                        GoalBean tempGoal = new GoalBean();
                        tempGoal = failedGoals.get(i);

                %><tr id="goalFailed">
                    <td><%=tempGoal.getGoalStartDate()%></td>
                    <td><%=tempGoal.getGoalEndDate()%></td>
                    <td><%=tempGoal.getCategory()%></td>
                    <td><%=tempGoal.getType()%></td>
                    <td><%=tempGoal.getAim()%></td>
                    <td><%=tempGoal.getGoalProgress()%>%</td>
                    <td>
                        <form action="CreateGoalServlet" method="post">
                            <input type="hidden" value="<%=tempGoal.getID()%>" name="goalID" />
                            <input type="hidden" value="delete" name="formType" />
                            <input type="submit" value="Delete Goal" />
                        </form>   
                    </td>
                </tr>
                <% }
                %></table> 
                <%} else { %> 
            <h3> You don't have any goals right now, why not create one above?</h3>
            <% } %>
            <br /><br />

        </div>
        <div id = "footer">
            <br />
            <br />   
            <table id = "footerTable">
                <tr>
                    <td><a href="index.jsp">HOME</a></td>
                    <td><a href="benefits.jsp">BENEFITS</a></td>
                    <td><a href="testimonials.jsp">TESTIMONIALS</a></td>	
                    <td><a href="aboutUs.jsp">ABOUT US</a></td>
                    <td><a href="messages.jsp">MESSAGES</a></td>
                </tr>
                <tr>
                    <td><a href="profile.jsp">PROFILE</a></td>		
                    <td><a href="goal.jsp">GOALS</a></td>
                    <td><a href="food.jsp">FOODS</a></td>
                    <td><a href="exercises.jsp">EXERCISES</a></td>
                    <td><a href="groups.jsp">GROUPS</a></td>
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
        <% } else { %>

        <% }%>
    </body>
</html>
