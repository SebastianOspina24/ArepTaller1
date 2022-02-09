

let url = "https://areptaller1.herokuapp.com/Temperatura/Fahrenheit/66"

function consumirapi(){
  fetch(url)
  .then(res=>res.json)
  .then(data => {
    console.log(data)
  })
}