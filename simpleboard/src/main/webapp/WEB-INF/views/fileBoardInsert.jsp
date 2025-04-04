<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<div class="container mt-3">
    <form action="fileInsert" method="post" enctype="multipart/form-data">
        <div class="mb-3 mt-3">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
        </div>
        <div class="mb-3 mt-3">
            <label for="writer">Writer:</label>
            <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
        </div>
        <div class="mb-3 mt-3">
            <label for="content">Content:</label>
            <textarea class="form-control" id="content" name="content" rows="5"></textarea>
        </div>
        <div class="mb-3 mt-3">
            <label for="file">File:</label>
            <input type="file" class="form-control" id="file" name="upload">
        </div>
        <div class="mt-3">
            <button type="submit" class="btn btn-primary">FileSubmit</button>
        </div>
    </form>
</div>

</body>
</html>
