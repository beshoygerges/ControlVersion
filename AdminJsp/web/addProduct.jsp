<%@include file="AdminHead.jsp" %>
<%@include file="AdminUp.jsp" %>
	<div class="row clearfix">
            <div class="col-md-12 column">
                    <form role="form" enctype="multipart/form-data"  method="post" action="servletAddProduct">
				<div class="form-group">
                                    <label for="exampleInputEmail1">Product Name</label><input id="name" name="name" type="text" class="form-control" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Product Description </label>
                                         <textarea name="description" id="description" rows="10" class="form-control" id="exampleInputPassword1"></textarea>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Product Price </label><input type="text" name="price" class="form-control" id="price" />
				</div>
                            
				<div class="form-group">
                                    <label for="exampleInputFile">image</label><input type="file" name="file"  id="file" />
				
				</div>
                            <button type="submit"  class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
        
<%@include file="AdminDown.jsp" %>
