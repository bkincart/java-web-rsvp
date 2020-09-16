<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Add a New RSVP</title>
  </head>
  <body>
    <form action="/rsvps" method="post">
      <div>
        <label for="firstName">First Name</label>
        <input required type="text" id="firstName" name="firstName" value="" />
      </div>
      <div>
        <label for="lastName">Last Name</label>
        <input required type="text" id="lastName" name="lastName" value="" />
      </div>
      <div>
        <label for="email">Email</label>
        <input required type="text" id="email" name="email" value="" />
      </div>
      <div>
        <label for="phoneNumber">Phone Number</label>
        <input required type="text" id="phoneNumber" name="phoneNumber" value="" />
      </div>

      <div>
        <p>Specify your preferred style of contact</p>
        <label for="phone">Phone</label>
        <input required type="radio" id="phone" name="contactStyle" value="phone" />
        <label for="text">Text</label>
        <input required type="radio" id="text" name="contactStyle" value="text" />
      </div>

     <input type="submit" value="Save RSVP" />
    </form>
  </body>
</html>