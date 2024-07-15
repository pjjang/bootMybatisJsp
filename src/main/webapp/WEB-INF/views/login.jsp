<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-4">
        <h4>Welcome, Guest Rewards: 0</h4>
    </div>
    <div class="col-8">
        <form class="form-inline" action="/shopping/login">
            <label for="customerId">아이디:</label>
            <input type="text" class="form-control" placeholder="이메일 아이디" id="customerId" name="customerId">
            <label for="pwd">패스워드:</label>
            <input type="password" class="form-control" placeholder="패쓰워드" id="pwd" name="pwd">
            <button type="submit" class="btn btn-primary">로그인</button>
        </form>
    </div>
</div>
