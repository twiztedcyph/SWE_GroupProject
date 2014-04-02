
<%@page import="JoinedBeans.MessageDetailRecipients"%>
<%@page import="java.util.ArrayList"%>
<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="ashCSS.css" />
        <title>The Health Tracker - Messages</title>
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

                if (username.value === "")
                {
                    window.alert("Username field is empty!");
                    document.getElementById('loginFormUser').focus();
                    return false;
                } else if (password.value === "")
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
                        <p>Not registered?...<input type="button" name="complete1" onclick="redirect('registration.jsp');" value="Register" /></p>
                    </div>
                </form>
            </div>
            <nav>
                <ul>
                    <li><a href="index.jsp">HOME</a></li>
                    <li><a href="benefits.jsp">BENEFITS</a></li>		
                    <li><a href="testimonials.jsp">TESTIMONIALS</a></li>
                    <li><a href="aboutUs.jsp">ABOUT US</a></li>
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
            <div>
                <p style="text-align: justify; padding-left:10px; padding-right:10px;">
                    Messages!
                </p>

                <p style="text-align: justify; padding-left:20px; padding-right:100px;">
                    Unfortunately, only members can use this feature.

                    Register <a href="registration.jsp"> HERE!</a> It's free!
                </p>

                <div style="clear:both;"></div>  
                <br />

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

        <%
        } else if (memberBean.getAccessType().equals("admin")) {
            //Logged in as admin
            //newMessages = messageBean.getAllNewMessages(userBean.getUsername());
%>
        <div id ="header">
            <a href="index.jsp" id="homelink"><img src="Images/logo.jpg"></img></a>
            <div id ="loginBox">
                Welcome back <%= memberBean.getUserName()%> (ADMIN)
                <form method="get" action="/SWE_GroupProject/LogInServlet">
                    <p>
                        <input type="hidden" name="logout" value="logout" />
                        <input type="submit" name="" value="Logout" />
                    </p>
                </form>
            </div>
            <nav>
                <ul>
                    <li><a href="index.jsp">HOME</a></li>
                    <li><a href="profile.jsp">ADMINISTRATION</a>
                        <ul>
                            <li><a href="profile.jsp">USERS</a></li>	
                            <li><a href="goal.jsp">GOALS</a></li>
                            <li><a href="groups.jsp">GROUPS</a></li>
                            <li><a href="messages.jsp">MESSAGES</a></li>
                        </ul>
                    </li>
                    <li><a href="food.jsp">FOODS<span style="color: red; background: #000;"></span></a>
                        <ul>
                            <li><a href="food.jsp">ADD FOODS</a></li>	
                            <li><a href="food.jsp">EDIT FOODS</a></li>
                        </ul>
                    </li>
                    <li><a href="exercises.jsp">EXERCISES<span style="color: red; background: #000;"></span></a>
                        <ul>
                            <li><a href="exercises.jsp">ADD EXERCISES</a></li>	
                            <li><a href="exercises.jsp">EDIT EXERCISES</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <div id="search">
                <form action="/SystemsCoursework/SearchServe" method="post">
                    <p>
                        Google
                        <input type="radio" name="searchType" checked="checked" value="google" />
                        This site
                        <input type="radio" name="searchType"  value="thisSite" />
                        <input type="text"placeholder="Search..." name="theSearch"  size="30" />
                        <input type="submit" value="Submit" />
                    </p>
                </form>
            </div>
        </div>
        <div id ="maindiv">
            <br /><br />
            <div>
                <h1>Hello <%= memberBean.getFirstName()%>! (ADMIN)</h1>

                <p>
                    Messages!
                </p>

                <p>
                    Send messages to other users.

                    Manage other users messages.
                </p>

                <div style="clear:both;"></div>  
                <br />

            </div>
            <br />
        </div>
        <div id = "footer">
            <br />
            <br />   
            <table id = "footerTable">
                <tr>
                    <td><a href="profile.jsp">USERS</a></td>
                    <td><a href="goal.jsp">GOALS</a></td>
                    <td><a href="groups.jsp">GROUPS</a></td>
                    <td><a href="messages.jsp">MESSAGES</a></td>	
                    <td><a href="food.jsp">FOODS</a></td>
                    <td><a href="exercises.jsp">EXERCISES</a></td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href="index.jsp">HOME</a></td>
                    <td><a href="benefits.jsp">BENEFITS</a></td>
                    <td><a href="testimonials.jsp">TESTIMONIALS</a></td>	
                    <td><a href="aboutUs.jsp">ABOUT US</a></td>
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
        } else if (memberBean.getAccessType().equals("user")) {
            if (request.getAttribute("unReadMessages") == null) {
                System.out.println("Message lists are null");
                System.out.println("Redirecting.............");
                request.getRequestDispatcher("MessageServlet").forward(request, response);
            } else {
                System.out.println("Messages are not null.");
            }
//Logged in as a regular user
            //newMessages = messageBean.getAllNewMessages(userBean.getUsername());
            String message = (String) session.getAttribute("msg");
            if (message != null) {
        %>
        <script>showMsg('<%= message%>');</script>
        <%
                session.removeAttribute("msg");
            }
        %>
        <jsp:useBean id="unReadMessages" type="ArrayList<MessageDetailRecipients>" scope="request" />
        <jsp:useBean id="readMessages" type="ArrayList<MessageDetailRecipients>" scope="request" />
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
            <br /><br />
            <div>
                <h1>Send or Read Messages!</h1>
                <form name="sendMessage" action="MessageServlet" method="post" id="sendMessage">
                    <p>Are you sending this message to an individual or a group?</p>
                    <p><input type="radio" name="messageFor" value="false" checked />Individual
                        <input type="radio" name="messageFor" value="true" />Group</p>


                    <p>Add Recipient(s) (Comma Separated) </p>
                    <p><textarea rows="1" cols="100" name="recipients" form="sendMessage"></textarea></p>
                    <p>Subject</p>
                    <p><textarea rows="1" cols="100" name="subject" form="sendMessage"></textarea></p>
                    <input type="hidden" name="sender" value="<%= memberBean.getId()%>" />
                    <input type="hidden" value="send" name="formType" />
                    <p><textarea rows="10" cols="100" name="messageDetail" form="sendMessage"></textarea></p>
                    <p><input type="submit" value="Send Message"/></p>
                </form> 
                <div style="clear:both;"></div>  
                <br />
                <br />
                <h3>You have <%=unReadMessages.size()%> unread messages!</h3>
                <% if (unReadMessages.size() != 0) {
                %><table id="adminTableOne">
                    <tr>
                        <td>Date Sent</td>
                        <td>Subject</td>
                        <td>Sender</td>
                    </tr>
                    <%
                        for (int i = 0; i < unReadMessages.size(); i++) {
                            MessageDetailRecipients tempMessage = new MessageDetailRecipients();
                            tempMessage = unReadMessages.get(i);
                    %>
                    <tr id="goalInProgress">
                        <td><%= tempMessage.getSendDate()%> <%= tempMessage.getSendTime()%></td>
                        <td><%= tempMessage.getSubject()%>
                            <td><%= tempMessage.getSenderName()%></td>
                            <td>
                                <form action="MessageServlet" method="post">
                                    <input type="hidden" value="<%=tempMessage.getMessageID()%>" name="messageID" />
                                    <input type="hidden" value="view" name="formType" />
                                    <input type="submit" value="View Message" />
                                </form>   

                                <form action="MessageServlet" method="post">
                                    <input type="hidden" value="<%=tempMessage.getMessageID()%>" name="messageID" />
                                    <input type="hidden" value="read" name="formType" />
                                    <input type="submit" value="Mark Read" />
                                </form>   

                                <form action="MessageServlet" method="post">
                                    <input type="hidden" value="<%=tempMessage.getMessageID()%>" name="messageID" />
                                    <input type="hidden" value="delete" name="formType" />
                                    <input type="submit" value="Delete" />
                                </form>   
                            </td>
                    </tr>
                    <% } %>
                </table>
                <br />
                <br />
                <% }%>
                <br />
                <br />
                <h3>You have <%=readMessages.size()%> read messages!</h3>
                <% if (readMessages.size() != 0) {
                %><table id="adminTableOne">
                    <tr>
                        <td>Date Sent</td>
                        <td>Subject</td>
                        <td>Sender</td>
                    </tr>
                    <%
                        for (int i = 0; i < readMessages.size(); i++) {
                            MessageDetailRecipients tempMessage = new MessageDetailRecipients();
                            tempMessage = readMessages.get(i);
                    %>
                    <tr id="goalFailed">
                        <td><%= tempMessage.getSendDate()%> <%= tempMessage.getSendTime()%></td> 
                        <td><%= tempMessage.getSubject()%></td>
                        <td><%= tempMessage.getSenderName()%></td>

                        <td>
                            <form action="MessageServlet" method="post">
                                <input type="hidden" value="<%=tempMessage.getMessageID()%>" name="messageID" />
                                <input type="hidden" value="view" name="formType" />
                                <input type="submit" value="View Message" />
                            </form>   

                            <form action="MessageServlet" method="post">
                                <input type="hidden" value="<%=tempMessage.getMessageID()%>" name="messageID" />
                                <input type="hidden" value="unread" name="formType" />
                                <input type="submit" value="Mark Unread" />
                            </form>   

                            <form action="MessageServlet" method="post">
                                <input type="hidden" value="<%=tempMessage.getMessageID()%>" name="messageID" />
                                <input type="hidden" value="delete" name="formType" />
                                <input type="submit" value="Delete" />
                            </form>   
                        </td>
                    </tr>
                    <% } %>
                </table>
                <br />
                <br />
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
        <%
            }
//Logged in as admin
            //newMessages = messageBean.getAllNewMessages(userBean.getUsername());
%>
    </body>
</html>
