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
        <link rel="stylesheet" type="text/css" href="ashCSS.css" />
        <title>Profile page</title>
     
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
        <div id ="backImageLeft"></div>
        <div id ="backImageRight"></div>
    <%
        beans.MemberBean memberBean = (beans.MemberBean) session.getAttribute("userdetails");
        if(memberBean == null)
        {
            // This user is not logged in so cannot access this page.
            session.setAttribute("msg", "You must be logged in to view that page.");
            response.sendRedirect("index.jsp");
        }else if(memberBean.getAccessType().equals("user"))
        {
           //Logged in.....
            String message = (String) session.getAttribute("msg");
        if (message != null)
        {
%>
            <script>showMsg('<%= message%>');</script>
<%
            session.removeAttribute("msg");
        }
        
        if(session.getAttribute("lifestlye") == null ||session.getAttribute("healthprofile") == null )
        {
            request.getRequestDispatcher("ProfileServlet").forward(request, response);
        }
        beans.LifeStyleBean lifeStyleBean = (beans.LifeStyleBean) session.getAttribute("lifestlye");
        beans.HealthProfileBean healthBean = (beans.HealthProfileBean) session.getAttribute("healthprofile");
%>
    
    <div id ="header">
            <a href="index.jsp" id="homelink"><img src="Images/logo.jpg"></img></a>
            <div id ="loginBox">
                <div>
                    Welcome back User <%= memberBean.getUserName()%>.
                    <form method="get" action="/SWE_GroupProject/LogInServlet">
                        <p>
                            <input type="hidden" name="logout" value="logout" />
                            <input type="submit" name="" value="Logout" />
                        </p>
                    </form>
                </div>
                
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
        </div>
        <div id ="maindiv">
            <br /><br />
                                                          
                <% 
                
                if(healthBean.getUserHeight() != 0)
                    
                {
                    
                  
               %>
                <form method="post" action="/SWE_GroupProject/ProfileServlet">
                    <table id ="adminTableOne">
                        
                        <tr>
                            <td>Username:</td> <td><%= memberBean.getUserName() %></td><td></td>
                        </tr>
                        <tr>
                            <td>First Name:</td> <td> <%= memberBean.getFirstName() %></td><td></td>
                        </tr>
                        <tr>
                            <td>Last Name:</td> <td><%= memberBean.getLastName() %></td><td></td>
                        </tr>
                        <tr>
                            <td>Date of birth:</td> <td><%= memberBean.getDateOfBirth() %></td><td></td>
                        </tr>
                        <tr>
                            <td>Height:</td> <td><%= healthBean.getUserHeight() %></td><td><input type="text" name="new_height" value="" /></td><td><input type="radio" name="selector" value="height" /></td>
                        </tr>
                        <tr>
                            <td>Weight:</td> <td><%= healthBean.getUserWeight() %></td><td><input type="text" name="new_weight" value="" /></td><td><input type="radio" name="selector" value="weight" /></td>
                        </tr>
                        <tr>
                            <td>BMI:</td> <td><%= healthBean.getUserBMI() %></td><td><input type="bmi" name="new_bmi" value="" /></td><td><input type="radio" name="selector" value="bmi" /></td>
                        </tr>
                        <tr>
                            <td>Body Fat:</td> <td><%= healthBean.getUserBodyFatPercent() %></td><td><input type="text" name="new_bodyfat" value="" /></td><td><input type="radio" name="selector" value="bodyfat" /></td>
                        </tr>
                        <tr>
                            <td>Password:</td> <td> ********** </td><td><input type="text" name="new_pass" pattern =".{5,20}[A-Za-z-0-9]+" 
                                                    title="At least 5 charecters. Uppercase, Lowercase and Numbers Only!" /></td><td><input type="radio" name="selector" value="pass" checked="" /></td>
                        </tr>
                        <tr>
                            <td>Email:</td> <td><%= memberBean.getEmailAddress() %></td><td><input type="email" name="new_email" value="" /></td><td><input type="radio" name="selector" value="email" /></td>
                        </tr>
                        
                        <tr><td>Password:</td><td> <input type="text" name="currentPass" /></td><td><input type="submit" value="submit" /></td></tr>

                    </table>
                </form>
                            <%
                            
                }else
                {
                            
                            
                            %>
                            
                         
                      
                    <form id ="regForm" method="post" action="/SWE_GroupProject/HealthProfileServlet" >
                       <table id ="adminTableOne"> 
                    <h2> <%= memberBean.getFirstName() %> we need your details</h2>
                    <label>Your weight :</label><input type="text" name="weight" pattern ="[0-9]+" required title="Numbers Only!"/><br />
                    <label>Your Height :</label><input type="text" name="height" pattern ="[0-9]+" required Title="Only Numbers" /><br />
                    <label>Your BMI :</label><input type="text" name="bmi" pattern ="[0-9]+" required Title="Only Numbers" /><br />
                    <label>Your body fat percentage :</label><input type="text" name="bodyfat" pattern ="[0-9]+" required Title="Only Numbers"/><br />
                    <label>Your Resting heart rate :</label><input type="text" name="rHeart" pattern ="[0-9]+" required Title="Only Numbers" /><br />
                    <label>Your peak heart rate :</label><input type="text" name="pHeart" pattern ="[0-9]+" required Title="Only Numbers" /><br />
                    
                    <br /><br />    
                    <input type="submit" value="Submit" />
                    <input type="reset" value="Clear" id="reset_button"/>     

                </form>
                            
                            <%
                    
                }
                    
                    %>
                            
                            
                            
                <div style="clear:both;"></div>  
                <br />

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
    
    <%
        }else if(memberBean.getAccessType().equals("admin"))
        {
    %>
    
    Admin page....
    
    <%
        }
    %>
    </body>
</html>
