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

let url = 'http://localhost:9898/users/register';
form.addEventListener('submit', function (e) {
    e.preventDefault()
    let username = document.getElementById('username').value
    let email = document.getElementById('email').value
    let password = document.getElementById('password').value
    let spinner = document.getElementById('spinner');

    fetch(url, {
        method: 'POST',
        body: JSON.stringify({
            username: username,
            email: email,
            password: password
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
             document.location.href = 'http://localhost:9898/main_page'
        }
})

