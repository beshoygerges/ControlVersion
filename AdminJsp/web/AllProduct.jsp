<%@page import="java.sql.ResultSet"%>
<%@page import="utilities.Database"%>
<%@include file="AdminHead.jsp" %>
<script>
    function deletep(id)
    {
      
         var xmlhttp = new XMLHttpRequest();// to create new object from XMLHTTPReqest 
        xmlhttp.open("GET", "servletDeleteQunatity?id=" + id, true);
        xmlhttp.send();
        xmlhttp.onreadystatechange = function()
        {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
            {
                        document.getElementById(id).remove();
                        document.getElementById("done").style.visibility = "visible";

            }
        }


    }

</script>

<%@include file="AdminUp.jsp" %>
<table class="table table-hover">
    <tr>
        <td>Product</td>
        <td>Quantity</td>
        <td>sale</td>
        <td><a>update</a></td>
        <td><a>delete</a></td>
        
    </tr>
    <%

                Database logic = new Database();
                ResultSet rs = logic.ShowAllProduct();
                while (rs.next()) {
                    String id= rs.getString(1);
            %>
            <tr id="<%= id %>">
                <td><%= rs.getString(2)%></td>
                <td><%= rs.getString(5)%></td>
                <td><%= rs.getString(6)%></td>
                <td><a href="updateProduct.jsp?id=<%= id %>">update</a></td>
                <td onclick="deletep(<%= id %>);">delete</td>
            
            </tr>
            <% }%>

</table>
            
        <div class="form-group">
<div class="alert alert-success alert-dismissable" id="done">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
				<h4>
					done!
				</h4>  your product has been deleted . <a href="#" class="alert-link"></a>
			</div>

				
				</div>
<%@include  file="AdminDown.jsp" %>