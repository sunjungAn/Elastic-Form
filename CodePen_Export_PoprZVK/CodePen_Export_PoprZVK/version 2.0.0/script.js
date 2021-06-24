document.getElementsByTagName("h1")[0].style.fontSize = "6vw";

// Some random colors
const colors = ["#FED10A", "#7DE2D1", "#EF5098", "#17A8E0", "#93C83E", "#FED10A", "#7DE2D1", "#EF5098", "#17A8E0", "#93C83E","#FED10A", "#7DE2D1", "#EF5098", "#17A8E0", "#93C83E"];

const numBalls = 15;
const balls = [];

for (let i = 0; i < numBalls; i++) {
  let ball = document.createElement("div");
  ball.classList.add("ball");
  ball.style.background = colors[i];
  ball.style.left = `${Math.floor(Math.random() * 100)}vw`;
  ball.style.top = `${Math.floor(Math.random() * 100)}vh`;
  ball.style.transform = `scale(${Math.random()})`;
  ball.style.width = `${Math.random()*20}em`;
  ball.style.height = ball.style.width;
  
  balls.push(ball);
  document.body.append(ball);
}

// Keyframes
balls.forEach((el, i, ra) => {
  let to = {
    x: Math.random() * (i % 2 === 0 ? -0.5 : 0.5),
    y: Math.random() * 2
  };

  let anim = el.animate(
    [
      { transform: "translate(0, 0)" },
      { transform: `translate(${to.x}rem, ${to.y}rem)` }
    ],
    {
      duration: (Math.random() + 1) * 2000, // random duration
      direction: "alternate",
      fill: "both",
      iterations: Infinity,
      easing: "ease-in-out"
    }
  );
});

function start_btn()
{
    var name = document.getElementById("name").value
    var email = document.getElementById("email").value
    var age = document.getElementById("age").value
    var gender = document.getElementById("gender").value

    var obj_length = document.getElementsByName("recommend").length;  
    for (var i=0; i<obj_length; i++)
        if (document.getElementsByName("recommend")[i].checked == true)
            var purpose = document.getElementsByName("recommend")[i].value
           
    localStorage.setItem("name", name)
    localStorage.setItem("email", email)
    localStorage.setItem("age", age)
    localStorage.setItem("gender", gender)
    localStorage.setItem("purpose", purpose)
    
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
document.getElementById("result_purpose").innerHTML += localStorage.getItem('purpose')