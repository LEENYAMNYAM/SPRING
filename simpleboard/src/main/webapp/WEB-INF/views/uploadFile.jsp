<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<div class="container mt-3">
    <form action="fileUpload" method="post" enctype="multipart/form-data">
        <div class="mb-3 mt-3">
            <label for="file1">File1:</label>
            <input type="file" class="form-control" id="file1" placeholder="Enter file" name="uploads">
        </div>

        <div class="mb-3 mt-3">
            <label for="file2">File2:</label>
            <input type="file" class="form-control" id="file2" placeholder="Enter file" name="uploads">
        </div>

        <div class="mb-3 mt-3">
            <label for="file3">File1:</label>
            <input type="file" class="form-control" id="file3" placeholder="Enter file" name="uploads">
        </div>

        <div class="mt-3">
            <button type="submit" class="btn btn-primary">FileSubmit</button>
        </div>
    </form>
</div>

</body>
</html>
