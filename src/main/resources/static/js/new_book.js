let form = document.getElementById("form")
var check = function () {
    if (document.getElementById('password').value ==
        document.getElementById('confirmPassword').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'matching';
    } else {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'not matching';
    }
}
// {addEventListener}

let url = 'http://localhost:9898/register';
addEventListener('submit', function (e) {
    e.preventDefault()
    // form.addEventListener('submit', function (e) {
    //     e.preventDefault()
    let name = document.getElementById('name').value
    let author = document.getElementById('author').value;
    let price = document.getElementById('price').value;


    fetch(url, {
        method: 'POST',
        body: JSON.stringify({
            name: name,
            author: author,
            price: price,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(function (response) {
            if (response.ok) {
                spinner.classList.add('spinner-grow')
                return response.text()
            } else {
                spinner.innerText += "ошибка";
            }
        })
        .then(function (data) {
            console.log(data)
        })

    setTimeout(test, 1500);

    function test() {
        document.location.href = 'http://localhost:9898/register'
    }
})