<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<button class="modalbtn">Modal</button>


<div class="modal" id='registerModal' tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="movePage()">Close</button>
			</div>
		</div>
	</div>
</div>


<script>


function movePage(){
	//alert("movePage")
	self.location = "/board/list";
}



function sendAjax(data){
	console.log("sendAjax....", data);
	
	return fetch("/board/register", {method:'POST',
		headers: {'Content-Type': 'application/json'},
		body: JSON.stringify(data)})
		.then(res => {
			if(!res.ok){
				throw new Error(res);
			}
		  return res.text();
		  })
		
		.catch(error => {
			console.log("catch------------------------")
			console.log(error)})
}

const data = {title:"한글 제목", content:"게시물 내용", writer:"user00"};

const fnResult = sendAjax(data);

fnResult.then(result => {
	console.log("result : " + result);
	$("#registerModal").modal('show');
})

const btn = document.querySelector(".modalbtn")

    
    btn.addEventListener("click",$("#registerModal").modal('show'))


</script>

<%@include file="../includes/footer.jsp"%>
