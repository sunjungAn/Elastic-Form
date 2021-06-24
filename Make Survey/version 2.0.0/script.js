function plus_btn()
{
    // create element
    var form = document.createElement('form')
    var br = document.createElement('br')

    var div1 = document.createElement('div')
    var input1 = document.createElement('input')
    var text1 = document.createTextNode("Title: ")

    var div2 = document.createElement('div')
    var input2 = document.createElement('input')
    var text2 = document.createTextNode("Content: ")

    // set attribute
    div1.setAttribute("class", "form-control")
    input1.setAttribute("placeholder", "Enter a tilte")
  
    div2.setAttribute("class", "form-control")
    input2.setAttribute("placeholder", "Enter a content")

    // append input (to form) 
    form.appendChild(div1)
    div1.appendChild(text1)
    div1.appendChild(input1)

    form.appendChild(div2)
    div2.appendChild(text2)
    div2.appendChild(input2)
 
    // append form (to body) 
    document.body.appendChild(br)
    document.body.appendChild(form)
}   
