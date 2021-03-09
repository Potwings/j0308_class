
<%@include file="../includes/header.jsp" %>


<ul>
<c:forEach items="${list }" var="board">

<li>
<span><a class="listA" href="<c:out value="${board.bno }"/>"><c:out value="${board.bno }"/></a></span>
<c:out value="${board.title }"></c:out>
<c:out value="${board.content }"></c:out>
<c:out value="${board.writer }"></c:out>
<c:out value="${board.regdate }"></c:out>
</li>

</c:forEach>
</ul>


<h3>${pageMaker}</h3>


  <ul class="pagination">
  <c:if test="${pageMaker.prev}">
    <li class="page-item">
      <a class="page-link" href="${pageMaker.start - 1 }" tabindex="-1">Previous</a>
    </li>
    </c:if>
    
    <c:forEach begin="${pageMaker.start }" end="${pageMaker.end }" var="num">
    <li class="page-item ${num == pageMaker.pageInfo.page? "active" : "" }"><a class="page-link" href="${num }">${num }</a></li>
    </c:forEach>
    
    <c:if test="${pageMaker.next }">
    <li class="page-item">
      <a class="page-link" href="${pageMaker.end + 1 }">Next</a>
    </li>
    </c:if>
  </ul>
  
  <form class="actionForm" action="/board/list" method="get">
  	<input type="hidden" name="page" value="${pageDTO.page }">
  	<input type="hidden" name="perSheet" value="${pageDTO.perSheet}">
  </form>
  
  <script>
  document.querySelectorAll('.listA').forEach(a => {
	a.addEvnetListener("click", function(){
		e.preventDefault();
		const bno = e.target.getAttribute("href");
		
		const actionForm =  document.querySelector(".actionForm")
		actionForm.setAttribute("action","/board/read");
		actionForm.innerHTML += "<input type='hidden' name='bno' value='"+bno+"'>";
		
		
	},false);  
  })
  
 document.querySelector(".pagination").addEventListener("click", e => {
	e.preventDefault();
	const target = e.target;
	
	const pageNum = target.getAttribute("href");
	
	console.log(pageNum);
	
	document.querySelector(".actionForm input[name='page']").value = pageNum;

	document.querySelector(".actionForm").submit();
	
},false);
  
  </script>

<%@include file="../includes/footer.jsp" %>
