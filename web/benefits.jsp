
<%@page import="JoinedBeans.MessageDetailRecipients"%>
<%@page import="java.util.ArrayList"%>
<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="ashCSS.css" />
        <title>The Health Tracker - Benefits</title>
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
                <h1>Benefits of Joining SimplyHealth!</h1>
                <div id ="testimonialsDiv">
                    <p>
                        In case you're wondering if it's worth joining us, here are
                        some reasons why we think it's a no-brainer!
                    </p>
                </div>
                <div id ="benefitsDiv">
                    <table>
                        <tr><h3>- Medical studies have shown that keeping &nbsp a food journal
                                can help DOUBLE your &nbsp&nbspweight loss, or increase muscle gain!</h3></tr>
                        <tr><h3>- Keep track of your nutritional intake!</h3></tr>	
                        <tr><h3>- Keep track of your exercise regime!</h3></tr>
                        <tr><h3>- It's quick and easy!</h3></tr>
                        <tr><h3>- We will never bother you with emails!</h3></tr>
                        <tr><h3>- We have genuine <a href="testimonials.jsp"> TESTIMONIALS!</a></h3></tr>
                        <tr><h3>- Do it all completely FREE!</h3></tr>
                    </table>
                </div>
                <p>
                    All you need to do is become a member, why not <a href="registration.jsp"> REGISTER NOW!?</a>
                </p>
                <h2>Stay fit and healthy the easy way!</h2>
                <div id ="testimonialsDiv">
                    <p>
                        We have created a free website that makes calorie counting, food tracking
                        and exercise logging easier that ever! There are no gimmicks or fad diets
                        that give you healthy, concrete results. Keeping track of the foods you
                        eat and the exercise you do is the only way to really see what works for
                        you. Let us help you achieve your goals and feel great doing it!

                        After all, our goal is simply health.
                    </p>
                </div>

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
                <h1>Benefits (ADMIN)</h1>
                <div id ="testimonialsDiv">
                    <p>
                        There is nothing to do here!
                    </p>
                </div>
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
            //Logged in as a regular user
            //newMessages = messageBean.getAllNewMessages(userBean.getUsername());
%>
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
                    <li><a href="goal.jsp">LIFESTYLE</a>
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
                <h1>You're already a member!</h1>
                <div id ="testimonialsDiv">
                    <p>
                        We decided to leave this page here for you. Just in case you need to
                        convince someone else to join!
                    </p>
                </div>
                <div id ="benefitsDiv">
                    <table>
                        <tr><h3>- Medical studies have shown that keeping &nbsp a food journal
                                can help DOUBLE your &nbsp&nbspweight loss, or increase muscle gain!</h3></tr>
                        <tr><h3>- Keep track of your nutritional intake!</h3></tr>	
                        <tr><h3>- Keep track of your exercise regime!</h3></tr>
                        <tr><h3>- It's quick and easy!</h3></tr>
                        <tr><h3>- We will never bother you with emails!</h3></tr>
                        <tr><h3>- We have genuine <a href="testimonials.jsp"> TESTIMONIALS!</a></h3></tr>
                        <tr><h3>- Do it all completely FREE!</h3></tr>
                    </table>
                </div>
                <p>
                    All you need to do is become a member, why not <a href="registration.jsp"> REGISTER NOW!?</a>
                </p>
                <h2>Stay fit and healthy the easy way!</h2>
                <div id ="testimonialsDiv">
                    <p>
                        We have created a free website that makes calorie counting, food tracking
                        and exercise logging easier that ever! There are no gimmicks or fad diets
                        that give you healthy, concrete results. Keeping track of the foods you
                        eat and the exercise you do is the only way to really see what works for
                        you. Let us help you achieve your goals and feel great doing it!

                        After all, our goal is simply health.
                    </p>
                </div>

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
            <p>Designed and created by Ian, Ash, Liam and Warren</p>

        </div>
        <%
            }
//Logged in as admin
            //newMessages = messageBean.getAllNewMessages(userBean.getUsername());
%>
    </body>
</html>
