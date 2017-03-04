<%@page import="java.sql.ResultSet"%>
<%@page import="utilities.Database"%>
<%@include file="AdminHead.jsp" %>
<%@include file="AdminUp.jsp" %>
			<div class="page-header">
				<h1>
					User info 
				</h1>
			</div>

<table class="table table-hover">
    <%
                        int r_id=Integer.parseInt(request.getParameter("id"));

                Database logic = new Database();
                ResultSet rs = logic.getUserById(r_id);
                while (rs.next()) {
                    String id= rs.getString(1);
            %>
            <tr>
                <td>Name</td>
                <td><%= rs.getString(2)%></td>
            </tr>
                
            <tr>
                <td>Address</td>
                <td><%= rs.getString(5)%></td>
            </tr>
                
            <tr>
                <td>Email</td>
                <td><%= rs.getString(4)%></td>
            </tr>
            <tr>
                <td>Credit</td>
                <td><%= rs.getString(6)%></td>
            </tr>
            <tr>
                <td>Mobile</td>
                <td><%= rs.getString(8)%></td>
            </tr>
            
            <% }%>

</table>
            			<div class="page-header">
				<h1>
					User history 
				</h1>
			</div>
<table class="table table-hover">
    <tr>
                
                <td>Name</td>
                <td>Price</td>
                <td>Quantity</td>
            </tr>
            
            <% 
                 rs = logic.getHistoryByUserId(r_id);
                while (rs.next()) {
                    
            %>
            <tr>
                
                <td><%= rs.getString(6)%></td>
                <td><%= rs.getString(3)%></td>
                <td><%= rs.getString(4)%></td>
            </tr>
            
            <% }%>

</table>
            			<div class="page-header">
				<h1>
					User Cart 
				</h1>
			</div>
<table class="table table-hover">
    <tr>
                
                <td>Name</td>
                <td>Quantity</td>
                
            </tr>
            <% 
                 rs = logic.getcartByUserId(r_id);
                while (rs.next()) {
                    
            %>
            <tr>
                
                <td><%= rs.getString(5)%></td>
                <td><%= rs.getString(2)%></td>
                
            </tr>
            
            <% }%>

</table>
            
        

            

<%@include  file="AdminDown.jsp" %>