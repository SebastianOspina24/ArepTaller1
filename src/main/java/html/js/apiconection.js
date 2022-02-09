

let url = "https://areptaller1.herokuapp.com/Temperatura/Fahrenheit?value=66"

function consumirapi(){
  fetch(url)
  .then(res=>console.log(res))
}