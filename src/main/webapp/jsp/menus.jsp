<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title>Menus</title>
</head>
<body>
<%--<h2>Restaurant Name: <b><bean:write name="Rname" property="restaurantname"/> </b></h2>--%>

<logic:iterate name="menus" id="menuid">
    <p>
        Id : <bean:write name="menuid" property="strId"/> ,
        Name :  <bean:write name="menuid" property="foodname"/> ,
        Price : <bean:write name="menuid" property="strPrice"/>
        <html:form action="/restaurants/deleteM">
            <html:hidden name="menuid" property="strId"/>
            <html:submit>Delete</html:submit>
        </html:form>
    </p>
</logic:iterate>

<br>
<h3>Edit Menu</h3>
<html:form action="/restaurants/editM" >
    <html:errors/>
    Id : <html:text name="menu" property="strId" value=""/>
    Name : <html:text name="menu" property="foodname" value=""/>
    Price : <html:text name="menu" property="strPrice" value=""/>
    <br>
    <html:submit>Submit</html:submit>
<%--    <html:reset>Reset</html:reset>--%>
</html:form>

<br>
<h3>Add Menu</h3>
<html:form action="/restaurants/addM" >
    <html:errors/>
    Name : <html:text name="menu" property="foodname" value=""/>
    Price : <html:text name="menu" property="strPrice" value=""/>
    <br>
    <html:submit>Submit</html:submit>
<%--    <html:reset>Reset</html:reset>--%>
</html:form>

<html:link action="/restaurants.do">Back to Restaurants</html:link>
</body>
</html>
