
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
                        <p>Not registered?...<input type="button" name="complete1" onclick="redirect('registration.jsp');" value="Register" /></p>
                    </div>
                </form>
            </div>
            <ul id = "navmenu">
                <li><a href="index.jsp">HOME</a></li>
                <li><a href="benefits.jsp">BENEFITS</a></li>		
                <li><a href="testimonials.jsp">TESTIMONIALS</a></li>
                <li><a href="aboutUs.jsp">ABOUT US</a></li>
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
    } else if (memberBean.getAccessType().equals("admin"))
    {
        //Logged in as admin
        //newMessages = messageBean.getAllNewMessages(userBean.getUsername());
%>
        <div id ="header">
            <a href="index.jsp" id="homelink"><img src="Images/logo.jpg"></img></a>
            <div id ="loginBox">
                Welcome back administrator <%= memberBean.getUserName()%>.
                <form method="get" action="/SWE_GroupProject/LogInServlet">
                    <p>
                        <input type="hidden" name="logout" value="logout" />
                        <input type="submit" name="" value="Logout" />
                    </p>
                </form>
            </div>
            <ul id = "navmenu">
                <li><a href="index.jsp">MESSAGE CONTROL</a></li>
                <li><a href="registration.jsp">USER CONTROL</a></li>		
                <li><a href="goals.jsp">GOAL CONTROL</a></li>
                <li><a href="groups.jsp">GROUP CONTROL  <span style="color: red; background: #000;"></span></a></li>
            </ul>
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
    }else if (memberBean.getAccessType().equals("user"))
    {
        if(request.getAttribute("unReadMessages") == null) 
              {
                  System.out.println("Message lists are null");
                  System.out.println("Redirecting.............");
                  request.getRequestDispatcher("MessageServlet").forward(request, response);
              }
        else
        {
            System.out.println("Messages are not null.");
        }
        //Logged in as a regular user
        //newMessages = messageBean.getAllNewMessages(userBean.getUsername());
        String message = (String) session.getAttribute("msg");
        if (message != null)
        {
%>
            <script>showMsg('<%= message%>');</script>
<%
            session.removeAttribute("msg");
        }
%>
        <jsp:useBean id="unReadMessages" type="ArrayList<MessageDetailRecipients>" scope="request" />
        <jsp:useBean id="readMessages" type="ArrayList<MessageDetailRecipients>" scope="request" />
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
                <h1>Send messages to other users!</h1>
                <table>
                <form name="sendMessage" action="MessageServlet" method="post" id="sendMessage">
                    <tr>
                        <p>Are you sending this message to an individual or a group?</p>
                        
                    </tr>
                    <tr>
                        <td>
                             <input type="radio" name="messageFor" value="false" checked />Individual
                             <input type="radio" name="messageFor" value="true" />Group
                        </td>
                </tr>
                <tr>
                    <td>Recipient(s) Comma Separated
                        <input type="hidden" name="sender" value="<%= memberBean.getId()%>" />
                        <input type="hidden" value="send" name="formType" />
                    </td>
                        <td><input type="submit" value="Send Message"/></td>
                </tr> 
                 <tr>
                     <td>Subject<input type="text" name="subject" value="Subject...."</td>   
                 </tr>
                </form> 
                </table> 
                <textarea rows="1" cols="100" name="recipients" form="sendMessage"></textarea> 
                <textarea rows="25" cols="100" name="messageDetail" form="sendMessage"></textarea>
                
                
            
                <p style="text-align: justify; padding-left:10px; padding-right:10px;">
                    Messages!
                </p>
                <div style="clear:both;"></div>  
                <br />
                <br />
                <h1>You have <%=unReadMessages.size() %> unread messages!</h1>
            <% if (unReadMessages.size() != 0)
            {
                %><table id="adminTableOne">
                    <tr>
                        <td>Date Sent</td>
                        <td>Subject</td>
                        <td>Sender</td>
                    </tr>
                    <%
                for(int i = 0; i < unReadMessages.size(); i++)
                { 
                    MessageDetailRecipients tempMessage = new MessageDetailRecipients(); 
                    tempMessage = unReadMessages.get(i);
                    %>
                    <tr id="goalInProgress">
                        <td><%= tempMessage.getSendDate() %> <%= tempMessage.getSendTime() %></td>
                        <td><%= tempMessage.getSubject() %>
                            <td><%= tempMessage.getSenderID() %></td>
                            <td>
                            <form action="MessageServlet" method="post">
                                <input type="hidden" value="<%=tempMessage.getMessageID()%>" name="messageID" />
                                <input type="hidden" value="view" name="formType" />
                                <input type="submit" value="View Message" />
                            </form>   
                                
                            <form action="MessageServlet" method="post">
                                <input type="hidden" value="<%=tempMessage.getMessageID()%>" name="messageID" />
                                <input type="hidden" value="Read" name="formType" />
                                <input type="submit" value="Mark Read" />
                            </form>   
 
                            <form action="MessageServlet" method="post">
                                <input type="hidden" value="<%=tempMessage.getSenderID() %>" name="goalID" />
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
                <br />
                <br />
                <h1>You have <%=readMessages.size() %> read messages!</h1>
            <% if (readMessages.size() != 0)
            {
                %><table id="adminTableOne">
                    <tr>
                        <td>Date Sent</td>
                        <td>Subject</td>
                        <td>Sender</td>
                    </tr>
                    <%
                for(int i = 0; i < readMessages.size(); i++)
                { 
                    MessageDetailRecipients tempMessage = new MessageDetailRecipients(); 
                    tempMessage = readMessages.get(i);
                    %>
                    <tr id="goalFailed">
                        <td><%= tempMessage.getSendDate() %> <%= tempMessage.getSendTime() %></td>
                        <td><%= tempMessage.getSenderID() %></td>
                        <td><%= tempMessage.getSubject() %></td>
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
                                <input type="hidden" value="<%=tempMessage.getSenderID() %>" name="goalID" />
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
