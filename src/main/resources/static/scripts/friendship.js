const protocol = window.location.protocol;
const hostname = window.location.hostname;
const port = window.location.port;

const url = protocol + "//" + hostname + ":" + port;

document.getElementById('add-new-friend').addEventListener('click', function () {
    let object = {
        method: "add",
        srcEmail: "a@b.c",
        srcHost: url,
        desEmail: document.getElementById('destionation-mail').value,
        desHost: document.getElementById('destionation-domain').value,
        version: 1
    }

    fetch(baseUrl, {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(object)
    })
        .then(response => {
            if(response.status === 200){
                console.log("200!")
                console.log(response)
                alert("Friend request send")
            }
        })
})