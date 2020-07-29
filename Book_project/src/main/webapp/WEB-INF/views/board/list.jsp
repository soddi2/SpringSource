<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>

<head>
  <title>Free HTML5 Templates</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="/assets/css/board/css/style.css" />
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="/assets/js/board/js/modernizr-1.5.min.js"></script>
</head>
<body>
  <div id="main">
    
	<header>
	  
	  <div id="header_section">	  
	    
		<div id="welcome">
			<a href="/board/list">
				<h2>Board List</h2>
			</a>
	    </div><!--close welcome-->			  	
	  
	    <nav>
          <ul id="nav">
            <li class="current"><a href="/index.jsp">Home</a></li>
            <li><a href="ourwork.html">Our Work</a></li>
            <li><a href="testimonials.html">Testimonials</a></li>
            <li><a href="projects.html">Projects</a></li>
            <li><a href="contact.html">Contact Us</a></li>
          </ul>
        </nav>
      
	  </div>		
	
	</header>

<h2>board list</h2>

	<table>

		<colgroup>

			<col style="width:5%;" />

			<col style="width:auto;" />

			<col style="width:15%;" />

			<col style="width:10%;" />

			<col style="width:10%;" />

		</colgroup>

		<thead>

			<tr>

				<th>NO</th>

				<th>글제목</th>

				<th>작성자</th>

				<th>조회수</th>

				<th>작성일</th>

			</tr>

		</thead>

		<tbody>

			<c:choose>

				<c:when test="${empty boardList }" >

					<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>

				</c:when> 

				<c:when test="${!empty boardList}">

					<c:forEach var="list" items="${boardList}">

						<tr>

							<td><c:out value="${list.bid}"/></td>

							<td><c:out value="${list.title}"/></td>

							<td><c:out value="${list.reg_id}"/></td>

							<td><c:out value="${list.view_cnt}"/></td>

							<td><c:out value="${list.reg_dt}"/></td>

						</tr>

					</c:forEach>

				</c:when>

			</c:choose>

		</tbody>

	</table>
  
    <footer>
	  <a href="index.html">Home</a> | <a href="ourwork.html">Our Work</a> | <a href="testimonials.html">Testimonials</a> | <a href="projects.html">Projects</a> | <a href="contact.html">Contact</a><br/><br/>
	  website template by <a href="http://www.freehtml5templates.co.uk">Free HTML5 Templates</a>
    </footer> 
  
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="/assets/js/board/js/jquery.min.js"></script>
  <script type="text/javascript" src="/assets/js/board/js/image_slide.js"></script>
  
</body>
</html>
