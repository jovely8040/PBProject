<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="modal" role="dialog" id="loginDialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Sign in</h5>
				<button class="close" data-dismiss="modal" aria-label="close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!-- form 컴포넌트 사용 -->
				<form id="joinform" action="<%=request.getContextPath()%>/con" method="post" onsubmit="return checkForm()">
					<input type="hidden" value="add" name="a" />
					<!-- form row -->
					<div class="form-row row">
						<label for="name">이름</label>
						<input type="text" class="form-control" id="name" name="name">
					</div>
					<div class="form-row row">
						<label for="hp">휴대전화</label>
						<input type="text" class="form-control" id="hp" name="hp">
					</div>
					<div class="form-row row">
						<label for="tel">집전화</label>
						<input type="text" class="form-control" id="tel" name="tel">
					</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" data-dismiss="modal">close</button>
						<button type="submit" class="btn btn-primary">submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>