window.onload = function () {
    let eyeIcon = document.querySelectorAll(".eye-icon");
    let pwField = document.querySelectorAll(".passCheck");
    for(let i = 0; i < eyeIcon.length; i++){
        eyeIcon[i].addEventListener("click", function (){
            if(pwField[i].type == "password"){
                pwField[i].type = "text";
                eyeIcon[i].classList.replace("bx-hide", "bx-show")
            } else {
                pwField[i].type = "password";
                eyeIcon[i].classList.replace("bx-show", "bx-hide")
            }
        })
    }

    let registerForm = document.getElementById("register_form");
    registerForm.addEventListener("submit", function (e){
        let pwField1 = document.getElementById("password").value;
        let pwField2 = document.getElementById("check_password").value;
        let errorMessage = document.getElementById("checkpass_message");
        if(pwField1 !== pwField2){
            e.preventDefault();
            errorMessage.style.display = "unset";
        } else {
            errorMessage.style.display = "none";
        }
    })
}