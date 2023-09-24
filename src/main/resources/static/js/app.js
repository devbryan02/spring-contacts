const form = document.getElementsByName('contact');

form.addEventListener('submit', function(event){
  
  const name = document.getElementById('name').value;
  const phone = document.getElementById('phone').value;

  if(name === ""){
    alert("Ingrese su nombre");
  } else if(!phone.length === 9){
    alert("Numero invalido")
  }
})