<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=path %>/resources/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/js/bootstrap.js"></script>


<title>index</title>
</head>
<body>
   <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="./index.html">Netty project</a>
          <ul class="nav">
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                News<span class="caret"></span>
              </a>
              <ul class="dropdown-menu">
                <li>
                  <a href="./news/index.html">
                    <i class="icon-briefcase"></i>
                    Archive
                  </a>
                </li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="./downloads.html">
                Downloads
              </a>
              <ul class="dropdown-menu">
                <li>
                  <a href="http://netty.googlecode.com/files/netty-4.0.0.CR2.tar.bz2">
                    <i class="icon-download"></i>
                    4.0.0.CR2
                    <small>&dash; 08-May-2013</small>
                  </a>
                </li>
                <li>
                  <a href="http://netty.googlecode.com/files/netty-3.6.6.Final-dist.tar.bz2">
                    <i class="icon-download"></i>
                    3.6.6.Final
                    <small>&dash; 15-May-2013</small>
                  </a>
                </li>
                <li>
                  <a href="http://www.tldrlegal.com/l/APACHE2">
                    <i class="icon-legal"></i>
                    Apache License 2.0
                  </a>
                </li>
                <li>
                  <a href="http://code.google.com/p/netty/downloads/list">
                    <i class="icon-briefcase"></i>
                    Previous Releases
                  </a>
                </li>
                <li>
                  <a href="http://ci.motd.kr/view/Netty/">
                    <i class="icon-beaker"></i>
                    Nightly Builds
                  </a>
                </li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="./wiki/index.html">
                Documentation
              </a>
              <ul class="dropdown-menu">
                <li>
                  <a href="./wiki/all-documents.html">
                    <i class="icon-list"></i>
                    All Documents
                  </a>
                </li>
                <li>
                  <a href="./wiki/related-articles.html">
                    <i class="icon-bookmark"></i>
                    Related Articles
                  </a>
                </li>
                <li>
                  <a href="./wiki/related-projects.html">
                    <i class="icon-bookmark"></i>
                    Related Projects
                  </a>
                </li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="./community.html">
                Get Involved
              </a>
              <ul class="dropdown-menu">
                <li>
                  <a href="https://github.com/netty/netty">
                    <i class="icon-github"></i>
                    Github
                  </a>
                </li>
                <li>
                  <a href="http://stackoverflow.com/questions/tagged/netty">
                    <i class="icon-question-sign"></i>
                    StackOverflow
                  </a>
                </li>
                <li>
                  <a href="https://twitter.com/netty_project">
                    <i class="icon-twitter-sign"></i>
                    @netty_project
                  </a>
                </li>
                <li>
                  <a href="./wiki/developer-guide.html">
                    <i class="icon-cogs"></i>
                    Developer Guide
                  </a>
                </li>
              </ul>
            </li>
            <li>
              <a href="http://feeds.feedburner.com/netty_project">
                <i class="icon-rss"></i>
              </a>
            </li>
          </ul>
          <form action="./search.html" class="navbar-search pull-right" method="GET" onsubmit="return validateGlobalSearchQuery()">
            <input class="search-query" id="global-search-query" name="q" placeholder="Search" type="text">
          </form>
        </div>
      </div>
    </div>
</body>
</html>