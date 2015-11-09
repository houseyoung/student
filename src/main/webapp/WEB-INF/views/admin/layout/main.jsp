<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!doctype html>
<html>
<head>
  <title><tiles:insertAttribute name="title"/></title>
  <tiles:insertAttribute name="head"/>
  <tiles:insertAttribute name="extendHead"/>
</head>
<body>
<tiles:insertAttribute name="header"/>
<div id="page clearfix">
  <tiles:insertAttribute name="sidebar"/>
  <div class="holder">
    <div class="container">
      <tiles:insertAttribute name="body"/>
    </div>
  </div>
</div>
<tiles:insertAttribute name="footer"/>
<tiles:insertAttribute name="script"/>
</body>
</html>