const baseUrl = "http://localhost:8080";

document.getElementById('create-user-button').addEventListener('click', createUser);

function createUser(){
    const name  = document.getElementById('user-email').value;
    const email = document.getElementById('user-email').value;

    const user = {
        name:name,
        email:email
    }

    fetch(baseUrl + "/users", {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(user)
    })
        .then(response => {
        if(response.status === 200){
            console.log(response.status + "ok")
        }else{
            console.log(response.status + "nope");
        }
    });
}