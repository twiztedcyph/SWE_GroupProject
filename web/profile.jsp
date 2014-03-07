<%-- 
    Document   : profile
    Created on : 05-Mar-2014, 14:02:53
    Author     : Twiz
--%>

<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="iancss.css" />
        <title>Profile page</title>
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
                <li><a href="benefits.jsp">BENEFITS</a></li>		
                <li><a href="defaultFestival.jsp">FESTIVALS</a></li>
                <li><a href="aboutUs.html">ABOUT US</a></li>
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
                <p style="text-align: justify;padding-left:10px;padding-right:10px;">
                    Blaaa blaaa

                </p>
                <br /><br />



                <span id="bannerAdvertsLeft">

                    
                </span>
                <span id="bannerAdvertsRight">   
                    




                </span>

                <br /><br /><br /><br /><br /><br /><br /><br /><br />
                <p id ="p2"> Previously Featured Festivals:</p>

                <ul id="gallery">

                    <li> <a href=""><img src="" alt="image" /></a>
                    </li>
                    <li> <a href=""><img src="" alt="image" /></a>
                    </li>
                    <li> <a href=""><img src="" alt="image" /></a>
                    </li>
                    <li> <a href=""><img src="" alt="image" /></a>
                    </li>
                    <li> <a href=""><img src="" alt="image" /></a>
                    </li>
                    <li> <a href=""><img src="" alt="image" /></a>
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