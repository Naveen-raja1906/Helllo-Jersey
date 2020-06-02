<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title>Restaurants</title>
</head>
<body>

<logic:iterate name="restaurants" id="restaurantsid">
    <p>
        Id : <bean:write name="restaurantsid" property="strId"/> ,
        Name :  <bean:write name="restaurantsid" property="name"/> ,
        Location : <bean:write name="restaurantsid" property="location"/>,
        Cuisine : <bean:write name="restaurantsid" property="cuisine"/>
        <html:form action="/delete">
            <html:hidden name="restaurantsid" property="strId"/>
            <html:submit>Delete</html:submit>
        </html:form>
        <html:form action="/restaurants/menus">
            <html:hidden name="restaurantsid" property="strId"/>
            <html:submit>Menu</html:submit>
        </html:form>
    </p>
</logic:iterate>

<%--<br>
<h3>Delete Restaurant</h3>
<html:form action="/delete">
    Restaurant ID : <html:text name="restaurant" property="strId"/>
    <html:submit>Delete</html:submit>
</html:form>--%>

<br>
<h3>Edit Restaurant</h3>
<html:form action="/edit" >
    <html:errors/>
    Id : <html:text name="restaurant" property="strId" value=""/>
    Name : <html:text name="restaurant" property="name" value=""/>
    Location : <html:text name="restaurant" property="location" value=""/>
    Cuisine : <html:text name="restaurant" property="cuisine" value=""/>
    <br>
    <html:submit>Submit</html:submit>
<%--    <html:reset>Reset</html:reset>--%>
</html:form>

<br>
<h3>Add Restaurant</h3>
<html:form action="/add" >
    <html:errors/>
    Name : <html:text name="restaurant" property="name" value=""/>
    Location : <html:text name="restaurant" property="location" value=""/>
    Cuisine : <html:text name="restaurant" property="cuisine" value=""/>
    <br>
    <html:submit>Submit</html:submit>
<%--    <html:reset>Reset</html:reset>--%>
</html:form>
</body>
</html>
