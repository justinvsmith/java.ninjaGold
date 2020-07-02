<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ninja Gold</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/ninja_gold.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <p>Your Gold</p>
            <div class="gold_amount"><c:out value="${earned}" /></div>
        </div>
        <div class="row">
            <div class="boxes">
                <h3>Farm</h3>
                <h5>(earns 10-20 golds)</h5>
                <form action="/process" method="post">
                <input type="hidden"  value="farm" name="location">
                <button type="submit"  >Find Gold</button>
                </form>
            </div>
            <div class="boxes">
                <h3>Cave</h3>
                <h5>(earns 5-10 golds)</h5>
                <form action="/process" method="post">
                <input type="hidden"  value="cave" name="location">
                <button type="submit">Find Gold</button>
                </form>
            </div>
            <div class="boxes">
                <h3>House</h3>
                <h5>(earns 2-5 golds)</h5>
                <form action="/process" method="post">
                <input type="hidden"  value="house" name="location">
                <button type="submit">Find Gold</button>
                </form>
            </div>
            <div class="boxes">
                <h3>Casino</h3>
                <h5>(earns/takes 0-50 golds)</h5>
                <form action="/process" method="post">
                <input type="hidden"  value="casino" name="location">
                <button type="submit">Find Gold</button>
                </form>
            </div>
        </div>
        <p>Activities</p>
        <div class="activities row">
        	<ul>
        
        		<c:forEach items="${responses}" var="listItem">
  
        		<li><c:out value="${listItem}" /></li>
        		</c:forEach>
        	</ul>
        </div>
    </div>
</body>
</html>