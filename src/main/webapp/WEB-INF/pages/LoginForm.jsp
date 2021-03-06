<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row text-center">
	<div class="col-xs-6 col-xs-offset-3">
		<div class="text-center">
			<form name="loginForm" action="/TutorialsManager/login" method="POST">

				<div class="form-group">
					<label>login</label> <input class="form-control" type="text"
						name="username" required />
				</div>

				<div class="form-group">
					<label>password</label> <input class="form-control" type="password"
						name="password" required />
				</div>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<div class="form-group">
					<input class="btn btn-success" name="submit" type="submit"
						value="Login" />
				</div>

			</form>
		</div>

		<br /> <a href="/TutorialsManager/create-account"><button
				class="btn">
				<i class="glyphicon glyphicon-plus"></i> | create-account
			</button></a> <a href="${pageContext.request.contextPath}/auth/facebook"><button
				class="btn btn-social btn-facebook">
				<span class="fa fa-facebook"></span>sign in with facebook
			</button></a> <a href="${pageContext.request.contextPath}/auth/twitter"><button
				class="btn btn-social btn-twitter">
				<span class="fa fa-twitter"></span>sign in with twitter
			</button></a>

		<c:if test="${param.error ne null}">
			<br />
			<div class="alert alert-danger">login or password are not
				correct</div>
		</c:if>

		<c:if test="${param.logout ne null}">
			<br />
			<div class="alert alert-success">logout was successful</div>
		</c:if>

	</div>
</div>