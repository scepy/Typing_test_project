<html>
  <head>
    <title>User details form</title>
  </head>
  <body>
    <h1>User Details Form</h1>
    <form action="LoginServlet" method="post">
      <label for="name">Username:</label>
      <input type="text" name="name" id="name" required><br>
      <label for="email">Email:</label>
      <input type="email" name="email" id="email" required><br>
      <button type="submit">Login</button>
      <button type="submit">Register</button>
    </form>
  </body>
</html>