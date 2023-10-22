function formValidation() {

    var email = document.getElementById("email");
    var password = document.getElementById("password");

    email.classList.remove("input-error");
    password.classList.remove("input-error");
    document.getElementById("error-email").innerHTML = "";
    document.getElementById("error-pw").innerHTML = "";

    if (email.value.trim() === "") {
        email.classList.add("input-error");
        document.getElementById("error-email").innerHTML = "Email is required<br><br>";
        return false;
    }

    if (!isValidEmail(email.value)) {
        email.classList.add("input-error");
        document.getElementById("error-email").innerHTML = "Invalid email address<br><br>";
        return false;
    }

    if (password.value.trim() === "") {
        password.classList.add("input-error");
        document.getElementById("error-pw").innerHTML = "Password is required<br><br>";
        return false;
    }

    return true;
}


function isValidEmail(email) {
    var pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // regex pattern
    return pattern.test(email);
}
