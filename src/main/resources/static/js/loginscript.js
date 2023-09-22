window.onload = function () {
    let eyeIcon = document.querySelectorAll(".eye-icon");
    let pwField = document.querySelectorAll(".password")
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
}
