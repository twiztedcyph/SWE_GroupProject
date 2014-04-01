<%-- 
    Document   : registration
    Created on : 07-Mar-2014, 12:56:46
    Author     : Warren
--%>

<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="ashCSS.css" />
        <title>Registration Page</title>
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
        <%
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
        <div id ="backImageLeft"></div>
        <div id ="backImageRight"></div>

        <div id ="header">
            <a href="index.jsp" id="homelink"><img src="Images/logo.jpg"></img></a>
            <div id ="loginBox">
                <form method="post" action="/SWE_GroupProject/RegistrationServlet" onsubmit="return checkForm();">
                    <div>
                        Username:<input type="text" id="loginFormUser" name="username" />
                        Password:<input type="password" id="loginFormPass" name="password" />
                        <input type="submit" value="Submit" />
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
                <br /><br />

                <p> Registration Form</p>
                <br /><br /><br />

                <form id ="regForm" method="post" action="/SWE_GroupProject/RegistrationServlet" tag="Create Logon">


                    <label>Username :</label><input type="text" name="username" pattern =".{5,20}[A-Za-z-0-9]+" required title="Uppercase, Lowercase and Numbers Only!"/><br />
                    <label>Password :</label><input type="password" name="passwordOne" 
                                                    pattern =".{5,20}[A-Za-z-0-9]+" 
                                                    required title="At least 5 charecters. Uppercase, Lowercase and Numbers Only!"/><br />
                    <label>Confirm Password :</label><input type="password" name="passwordTwo" 
                                                            pattern =".{5,20}[A-Za-z-0-9]+" 
                                                            required title="Uppercase, Lowercase and Numbers Only!"/><br />
                    <label>Forename :</label><input type="text" name="forename" pattern ="[A-Za-z]+" required Title="No Special Charecters" /><br />
                    <label>Surname :</label><input type="text" name="surname" pattern ="[A-Za-z]+" required Title="No Special Charecters" /><br />
                    <label>Date of Birth :</label><input type="date" name="dob" required/><br />
                    <label>Email :</label><input type="email" name="email" required/><br />

                    <br /><br />    
                    <input type="submit" value="Submit" />
                    <input type="reset" value="Clear" id="reset_button"/>     

                </form>


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
        %>

        <div id ="backImageLeft"></div>
        <div id ="backImageRight"></div>

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
                <p style="text-align: justify;padding-left:10px;padding-right:10px;">
                    Register Now!
                </p>

                <p> Registration Form</p>

                <form method="post" action="/SWE_GroupProject/RegistrationServlet" tag="Create Logon">
                    <div align="center">
                        <div align="right" style="width: 35%">
                            Username *          : <input type="text" name="username" /><br />
                            Password *          : <input type="password" name="passwordOne" /><br />
                            Confirm Password *  : <input type="password" name="passwordTwo" /><br />
                            Forename *          : <input type="text" name="forename" /><br />
                            Surname *           : <input type="text" name="surname" /><br />
                            Date of Birth *     : <input type="date" name="dob" /><br />
                            Email *             : <input type="text" name="email" /><br />
                            User Type *         : <select name="userType"><option 
                                    value="user">Standard User</option><option value="admin">
                                    Administrator</option></select><br />

                            <div align="right" style="width: 35%">
                                <input type="submit" value="Submit" />
                            </div>
                        </div>
                    </div>
                </form>


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
            }
        %>
    </body>

</html>
