

let url = "https://areptaller1.herokuapp.com/Temperatura/"

function consumirapi(){
  fetch(url+document.getElementById("tempe").value+"?value="+document.getElementById("value").value)
  .then(response => response.json())
  .then(data => {
    console.log(data.celsius)
    document.getElementById("celsius").innerHTML = data.celsius
    document.getElementById("fahrenheit").innerHTML = data.fahrenheit
  })
}