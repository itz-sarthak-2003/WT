<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Validation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #ffffff;
        }
        div form {
            width: 80%;
            margin: 5% auto;
            padding: 20px;
            background-color: #73b2dc98;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        td {
            padding: 20px;
        }
        button {
            display: block;
            margin: 20px auto;
            padding: 12px;
            background: #e671f1;
            color: white;
            border: 2px solid white;
            border-radius: 6px;
            font-size: 17px;
            cursor: pointer;
        }

        button:hover{
            background-color: rgb(240, 232, 232);
            color: black;
            transform: scale(1.05);
        }
        .error {
            color: red;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
    <div>
        <form action="" id="contactForm">
            <table>
                <caption>Registration Form</caption>
                <tr>
                    <td><label for="name1">Username:</label></td>
                    <td><input type="text" name="username" id="name1" required></td>
                </tr>
                <tr>
                    <td><label for="email1">Enter email:</label></td>
                    <td><input type="text" name="email" id="email1" required></td>
                </tr>
                <tr>
                    <td><label for="number1">Contact Number:</label></td>
                    <td><input type="text" name="contact" id="number1" required></td>
                </tr>
                <tr>
                    <td><label for="pass">Pasword Number:</label></td>
                    <td><input type="password" name="pass" id="pass" required></td>
                </tr>
                <tr>
                    <td><label for="pass2">Re-Enter Pasword Number:</label></td>
                    <td><input type="password" name="pass2" id="pass2" required></td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>
            <div class="error" id="errorMessages"></div>
        </form>
    </div>
    <div>
        <script>
            const form = document.getElementById('contactForm');
            form.addEventListener('submit', function(event) {
                // Prevent form submission until validation
                event.preventDefault();

                const name = document.getElementById('name1').value;
                const email = document.getElementById('email1').value;
                const contact = document.getElementById('number1').value;
                const pass1 = document.getElementById("pass").value;
                const pass2 = document.getElementById("pass2").value;
                const errorMessages = document.getElementById('errorMessages');
                errorMessages.innerHTML = ''; // Clear previous error messages

                let hasError = false;

                // Validate name (should only contain alphabetic characters)
                if (!/^[a-zA-Z]+$/.test(name)) {
                    errorMessages.innerHTML += 'Name should only contain alphabetic characters.<br>';
                    hasError = true;
                }
                if (name.length<8) {
                    errorMessages.innerHTML += 'Name should have length greater then 8.<br>';
                    hasError = true;
                }

                // Validate email format
                if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
                    errorMessages.innerHTML += 'Invalid email format.<br>';
                    hasError = true;
                }

                // Validate contact number (should be exactly 10 digits)
                if (!/^\d{10}$/.test(contact)) {
                    errorMessages.innerHTML += 'Invalid contact number format. It should be exactly 10 digits.<br>';
                    hasError = true;
                }
                
                // Validate password (should be exactly Uppercase,Lowercase, Specia character, length > 8 digits)
                if (pass1.length<8) {
                    errorMessages.innerHTML += 'Length Should Greater Than 8.<br>';
                    hasError = true;
                }    
                if (!(/[A-Z]/.test(pass1))) {
                    errorMessages.innerHTML += 'Should have Uppercase letter.<br>';
                    hasError = true;
                }
                if (!(/[a-z]/.test(pass1))) {
                    errorMessages.innerHTML += 'Should have lowercase letter.<br>';
                    hasError = true;
                }

                if (!(pass1==pass2)){
                    errorMessages.innerHTML += 'Password Should be Same...<br>';
                    hasError = true;
                }
                // If no errors, submit the form
                if (!hasError) {
                    form.submit(); // Proceed with form submission if valid
                }


            });
        </script>
    </div>
</body>
</html>
