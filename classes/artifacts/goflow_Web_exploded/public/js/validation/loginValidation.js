// flag: invalid - invalid credentials
window.onload = function invalidCred() {
    const urlParams = new URLSearchParams(window.location.search);

    if (urlParams.has('flag')) {
        const flag = urlParams.get('flag');
        if (flag === "invalid") {
            var email = document.getElementById("email");
            var password = document.getElementById("password");
            var pwError = document.getElementById("error-pw");

            email.classList.add("input-error");
            password.classList.add("input-error");
            pwError.innerHTML = "Invalid email or password<br><br>";
        }
    }
}


// login form validation function
function formValidation() {

    // elements
    var email = document.getElementById("email");
    var password = document.getElementById("password");
    var emailError = document.getElementById("error-email");
    var pwError = document.getElementById("error-pw");

    // element initialize
    email.classList.remove("input-error");
    password.classList.remove("input-error");
    emailError.innerHTML = "";
    pwError.innerHTML = "";

    // check if email is empty
    if (email.value.trim() === "") {
        email.classList.add("input-error");
        emailError.innerHTML = "Email is required<br><br>";
        return false;
    }

    // check if email is valid
    if (!isValidEmail(email.value)) {
        email.classList.add("input-error");
        emailError.innerHTML = "Invalid email address<br><br>";
        return false;
    }

    // check if password is empty
    if (password.value.trim() === "") {
        password.classList.add("input-error");
        pwError.innerHTML = "Password is required<br><br>";
        return false;
    }

    return true; // return true (no error)
}


// regex email validation function
function isValidEmail(email) {
    var pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // regex pattern
    return pattern.test(email);
}



