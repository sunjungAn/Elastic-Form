document.getElementsByTagName("h1")[0].style.fontSize = "6vw";

function start_btn()
{
    var name = document.getElementById("name").value
    var email = document.getElementById("email").value
    var age = document.getElementById("age").value
    var gender = document.getElementById("gender").value
    // var purpose = document.getElementById("purpose-1").value - RADIO에서 데이터 받기 오류

    localStorage.setItem("name", name)
    localStorage.setItem("email", email)
    localStorage.setItem("age", age)
    localStorage.setItem("gender", gender)
    // localStorage.setItem("purpose", purpose)
    
    // JSON 형식으로 데이터 전송
    // var data = { 
    //     "Name" : name, 
    //     "Email" : email
    // }    
    // localStorage.setItem("data", JSON.stringify(data));
    
    location.href='hello.html'
}   

document.getElementById("result_name").innerHTML += localStorage.getItem('name')
document.getElementById("result_email").innerHTML += localStorage.getItem('email') 
document.getElementById("result_age").innerHTML += localStorage.getItem('age') 
document.getElementById("result_gender").innerHTML += localStorage.getItem('gender') 
// document.getElementById("result_purpose").innerHTML = localStorage.getItem('purpose') 