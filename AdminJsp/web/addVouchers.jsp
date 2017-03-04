<%@include file="AdminHead.jsp" %>
<script>
   function addCategory()
   {
       var n = document.getElementById("Number").value;
       var d = document.getElementById("Value").value;
    
      var xmlhttp = new XMLHttpRequest();// to create new object from XMLHTTPReqest 
        xmlhttp.open("GET", "AddVouchers?Number="+n+"&Value="+d, true);
            xmlhttp.send();
            xmlhttp.onreadystatechange = function()
            {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                {
                    document.getElementById("done").style.visibility = "visible";
                    alert(xmlhttp.responseText);
                }
            }
          
      
   }
    
</script>
<%@include file="AdminUp.jsp" %>
	<div class="row clearfix">
            <div class="col-md-12 column">
                    <form role="form"   method="post" action="servletAddProduct">
				<div class="form-group">
                                    <label for="exampleInputEmail1">Voucher Number</label>
                                    <input id="Number" name="name" type="text" class="form-control" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Voucher  Value </label>
                                         <input name="description" id="Value" class="form-control" />
				</div>
                        <button type="button" onclick="addCategory()"  class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
        <div class="form-group">
<div class="alert alert-success alert-dismissable" id="done">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					done!
				</h4>  your product has been added . <a href="#" class="alert-link"></a>
			</div>

				
				</div>
<%@include file="AdminDown.jsp" %>
