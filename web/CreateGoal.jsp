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
        <link rel="stylesheet" type="text/css" href="myCSS.css" />
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
        <div id ="header">
            <a href="index.jsp" id="homelink"></a>
            <div id ="loginBox">
                <form method="post" action="/SystemsCoursework/LogInServe" onsubmit="return checkForm();">
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
                <%  
                    if(session.getAttribute("member") == null){  
                 %>       
                <p style="text-align: justify;padding-left:10px;padding-right:10px;">
                    <form name="CreateGoal" action="CreateGoal" method="post">
                        <table>
                            <tr>
                                <td><input type="hidden" name="member" value="$Member.memberID">
                                Will you be creating this goal for yourself or one of your groups?
                                </td> 
                            </tr>
                            <tr>
                                <td>
                                    <input type="radio" name="goalFor" value="myself">Myself
                                    <input type="radio" name="goalFor" value="group">One of my groups
                                </td>
                            </tr>
                            <tr></tr>
                            <tr>
                                <td>Start Date:</td>
                            </tr>
                            <tr>
                                <td><input type="date" name="startDate"></td>
                            </tr>
                            <tr></tr>
                            <tr>
                                <td>End Date:</td>
                            </tr>
                             <tr>
                                <td><input type="date" name="endDate"></td>
                            </tr>
                            <tr></tr>
                            <tr>
                                <td>Progress:</td>
                            </tr>
                            <tr>
                                <td>Your target:</td>
                            </tr>
                        </table>
                    </form>
                </p>
                <br /><br />

                <% } else { %>
                <p>Sorry but you can't use this feature without being logged in,
                    why not log in or create an account?
                </p>    
                <% } %>
                <span id="bannerAdvertsLeft">

                    
                </span>
                <span id="bannerAdvertsRight">   
                    




                </span>

                <br /><br /><br /><br /><br /><br /><br /><br /><br />
                <p id ="p2"> Previously Featured Festivals:</p>

                <ul id="gallery">

                    <li> <a href="http://www.downloadfestival.co.uk/"><img src="Images/local/logo-download-2011.gif" alt="image" /></a>
                    </li>
                    <li> <a href="http://www.vfestival.com/"><img src="Images/local/vfest.jpg" alt="image" /></a>
                    </li>
                    <li> <a href="http://www.latitudefestival.com/"><img src="Images/local/Latitude.jpg" alt="image" /></a>
                    </li>
                    <li> <a href="http://www.bestival.net/"><img src="Images/local/bestival.jpg" alt="image" /></a>
                    </li>
                    <li> <a href="http://www.glastonburyfestivals.co.uk/"><img src="Images/local/glastonbury-logo.gif" alt="image" /></a>
                    </li>
                    <li> <a href="http://www.isleofwightfestival.com/"><img src="Images/local/isleOfWhite.jpg" alt="image" /></a>
                    </li>

                </ul>


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
