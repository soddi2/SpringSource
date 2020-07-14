<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
  <div class="row">
    <div class="col-md-12">
      <h1 class="page-header">Partner Register</h1>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="panel panel-default">
        <div class="panel-body">
          <form action="" method="post" role="form">
            <div class="form-group">
              <label>회사명</label>
              <input class="form-control" name="name" />
            </div>
            <div class="form-group">
              <label>ceo 명</label>
              <input class="form-control" name="ceo" />
            </div>
            <div class="form-group">
              <label>연락처</label>
              <input class="form-control" name="contact" />
            </div>
            <div class="form-group">
              <label>주소</label>
              <input class="form-control" name="address" />
            </div>
            <button type="submit" class="btn btn-primary">submit</button>
            <button type="reset" class="btn btn-warning">reset</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
