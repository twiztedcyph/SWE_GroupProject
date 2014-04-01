
<%@page import="java.sql.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.GoalBean"%>
<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="ashCSS.css" />
        <title>The Health Tracker</title>
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
        <div id ="backImageLeft"></div>
        <div id ="backImageRight"></div>
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
                    <li><a href="aboutUs.jsp">ABOUT US</a> </li>
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

            <h1>Welcome to SimplyHealth!</h1>
            <div id ="testimonialsDiv">
                <p>
                    We are pleased to announce the launch of our new and exiting health 
                    tracking website. SimplyHealth offers you the opportunity to get access
                    to our extensive nutrition database absolutely FREE!

                    All you need to do is become a member!
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
            <br />

            <span id="randomBanner">

                <%
                    java.util.Random random = new java.util.Random();

                    String[] banners = new String[4];
                    int index = 0;

                    banners[0] = "<a href = 'http://www.vfestival.co.uk'><img src='Images/banner0.jpg' alt='image'/></a>";
                    banners[1] = "<a href = 'http://www.facebook.com/SkateandSurfFest'><img src='Images/banner1.jpg' alt='image'/></a>";
                    banners[2] = "<a href = 'http://www.nhs.uk/Pages/HomePage.aspx'><img src='Images/banner2.png' alt='image'/></a>";
                    banners[3] = "<a href = 'http://www.redcross.org/news/event/Red-Cross-For-the-Love-of-Chocolate-Festival'><img src='Images/banner3.jpg' alt='image'/></a>";
                    index = random.nextInt(4);


                %>
                <%= banners[index]%>
            </span>

            <br />    
            <h2>It really works!</h2>
            <div id ="testimonialsDiv">
                <p>
                    "The SimplyHealth tracker has been instrumental to my weight loss. 
                    I've tried countless times to lose weight but nothing worked. 
                    Anything restrictive and I would just gain the weight right back. 
                    But it really works. SimplyHealth makes counting calories SO easy. 
                    I log onto the site every day and I'm proud to say I haven't 
                    missed a single day of logging in. The community aspect on this 
                    site is amazing and I've made some really great friends throughout 
                    this journey. I can't wait to continue losing weight with SimplyHealth!"
                </p>
                <h3>Joost Noppen (peshwari_naan)</h3>
            </div>
            <br />   
            <h2>It's so easy to use!</h2>
            <div id ="testimonialsDiv">
                <p>
                    "A friend recommended SimplyHealth to me, but I was concerned that 
                    it would be too time consuming, but it's so easy to use! After a few
                    days, it's just a couple of clicks and you're done! If you're serious
                    about fitness, weight loss or even just eating healthier, SimplyHealth
                    is an excellent way to keep you in check and on track."
                </p>
                <h3>Gavin Crawley (SpaceCowboy)</h3>
            </div>
            <br /><br /><br /><br /><br />
            <span id="randomBanner2">

                <%

                    String[] banners2 = new String[4];

                    banners2[0] = "<a href = 'http://www.vfestival.co.uk'><img src='Images/banner0.jpg' alt='image'/></a>";
                    banners2[1] = "<a href = 'http://www.facebook.com/SkateandSurfFest'><img src='Images/banner1.jpg' alt='image'/></a>";
                    banners2[2] = "<a href = 'http://www.nhs.uk/Pages/HomePage.aspx'><img src='Images/banner2.png' alt='image'/></a>";
                    banners2[3] = "<a href = 'http://www.redcross.org/news/event/Red-Cross-For-the-Love-of-Chocolate-Festival'><img src='Images/banner3.jpg' alt='image'/></a>";
                    index = random.nextInt(4);


                %>
                <%= banners2[index]%>
            </span>  
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
                Welcome back administrator <%= memberBean.getUserName()%>.
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
                            <li><a href="goals.jsp">GOALS</a></li>
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
                    <li><a href="food.jsp">EXERCISES<span style="color: red; background: #000;"></span></a>
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

            <h1>Hello <%= memberBean.getFirstName()%> (ADMIN)</h1>

            <p>
                Use the navigation bar or the links below to begin any administration
                tasks that need to be done.
            </p>

            <div id ="adminDiv">
                <table>
                    <tr><h2>ADMINISTRATION</h2></tr>	
                    <tr><h3><a href="profile.jsp">USERS</a></h3></tr>
                    <tr><h3><a href="goal.jsp">GOALS</a></h3></tr>
                    <tr><h3><a href="groups.jsp">GROUPS</a></h3></tr>
                    <tr><h3><a href="messages.jsp">MESSAGES</a></h3></tr>
                    <tr><h2>FOODS/EXERCISES</h2></tr>
                    <tr><h3><a href="food.jsp">ADD/EDIT FOODS</a></h3></tr>
                    <tr><h3><a href="exercises.jsp">ADD/EDIT EXERCISES</a></h3></tr>
                </table>
            </div>
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
        <% } else if (memberBean.getAccessType().equals("user")) {

            session.getAttribute("indexGoals");

            String message = (String) session.getAttribute("msg");
            if (message != null) {
        %>
        <script>showMsg('<%= message%>');</script>
        <%
                session.removeAttribute("msg");
            }
        %>
        <jsp:useBean id="indexGoals" type="ArrayList<GoalBean>" scope="session" />
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

            <h1>Welcome back <%= memberBean.getFirstName()%>!</h1>
            <br />
            <h2>Latest News</h2>
            <p>We have some new.....</p>
            <br /><br /><br />

            <%
                if (indexGoals != null) {
                    Calendar calLocal = new GregorianCalendar();
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                    String localDateFormatted = dateFormatter.format(calLocal.getTime());
                    java.sql.Date localDate = java.sql.Date.valueOf(localDateFormatted);
                    final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

                    for (int i = 0; i < indexGoals.size(); i++) {
                        GoalBean tempGoal = new GoalBean();
                        tempGoal = indexGoals.get(i);
                        Date startDate = localDate;
                        Date endDate = tempGoal.getGoalEndDate();
                        int days = (int) ((endDate.getTime() - startDate.getTime()) / DAY_IN_MILLIS);
            %>
            <h2>Your Current Goals</h2>
            <p>Here are your current goals, and the progress you are making towards completing them! Keep it up!</p>

            <table id="adminTableOne">

                <tr><td><h3>Goal Number</h3></td><td><h3>Goal Description</h3></td><td><h3>Time Left</h3></td><td><h3>Progress</h3></td></tr>
                <tr id="goalInProgress">
                    <td><%=i + 1%></td>
                    <td>Your goal is to <%=tempGoal.getCategory()%> <%=tempGoal.getAim()%> kg of <%=tempGoal.getType()%>.</td>
                    <td>You have <%=days%> days left!</td>
                    <td>Your current progress is <%=tempGoal.getGoalProgress()%>%</td>
                </tr> 
            </table>
            <%
                    }
                }
            %>

        </div>
        <div id = "footer">
            <br />
            <br />   
            <table id = "footerTable">
                <tr>
                    <td><a href="index.jsp">HOME</a></td>
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
