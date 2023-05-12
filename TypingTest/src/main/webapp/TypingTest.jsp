<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Typing Test</title>
    <script>
        function startTypingTest() {
            document.getElementById("startButton").style.display = "none";
            document.getElementById("typingArea").style.display = "block";
            document.getElementById("startTime").value = new Date().getTime();
            document.getElementById("typedText").focus();
        }
    </script>
</head>
<body>
    <h1>Typing Test</h1>
    <p>Start typing the following passage:</p>
    <p><%= request.getAttribute("text") %></p>
    <div id="startButton">
        <button onclick="startTypingTest()">Start</button>
    </div>
    <div id="typingArea" style="display: none">
        <form method="post" action="typingtest">
            <input type="hidden" id="startTime" name="startTime">
            <textarea id="typedText" name="typedText" rows="5" cols="50"></textarea>
            <br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>