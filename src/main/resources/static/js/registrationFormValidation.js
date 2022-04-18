const form = document.getElementById('form');
const submitBtn = document.getElementById('submitBtn');
const firstname = document.getElementById('firstName');
const lastname = document.getElementById('lastName')
const username = document.getElementById('username');
const email = document.getElementById('email');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');


submitBtn.addEventListener('click', e => {
    if(checkInputs()){
        form.submit();
    }
});




function checkInputs() {
    // trim to remove the whitespaces
    const passwordValue = password.value.trim();
    const password2Value = password2.value.trim();

    let firstNameInputValid = validFirstName();
    let lastNameInputValid = validLastName();
    let usernameInputValid = validUsername();
    let emailInputValid = validEmail();
    let passwordValueValid = validPassword(passwordValue);
    let password2ValueValid = validPassword(password2Value);
    let bothPasswordMatch = matchPassword(passwordValue, password2Value);


    if(firstNameInputValid && lastNameInputValid
        && usernameInputValid && emailInputValid
        && passwordValueValid && password2ValueValid
        && bothPasswordMatch){
        return true;
    }

    return false;
}

function validFirstName(){
    const firstnameValue = firstname.value.trim();
    if(firstnameValue === '') {
        return setErrorFor(firstname, 'First Name cannot be blank');
    } else {
        return setSuccessFor(firstname);
    }
}

function validLastName(){
    const lastnameValue = lastname.value.trim();
    if(lastnameValue === '') {
        return setErrorFor(lastname, 'Last Name cannot be blank');
    } else {
        return setSuccessFor(lastname);
    }
}

function validUsername(){
    const usernameValue = username.value.trim();
    if(usernameValue === '') {
        return setErrorFor(username, 'Username cannot be blank');
    } else {
        return setSuccessFor(username);
    }
}

function validEmail() {
    const emailValue = email.value.trim();
    if(emailValue === '') {
        return setErrorFor(email, 'Email cannot be blank');
    } else {
        return setSuccessFor(email);
    }

}

function validPassword(passwordValue) {
    if(passwordValue === '') {
        return setErrorFor(password, 'Password cannot be blank');
    } else {
        return setSuccessFor(password);
    }

}

function matchPassword(passwordValue, password2Value) {
    if(passwordValue !== password2Value) {
        return setErrorFor(password2, 'Passwords do not match');
    } else{
        return setSuccessFor(password2);
    }
}


function setErrorFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    formControl.className = 'form-control error';
    small.innerText = message;
    return false;
}

function setSuccessFor(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-control success';
    return true;
}

