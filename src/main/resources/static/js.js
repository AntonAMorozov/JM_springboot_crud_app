document.getElementById('main-form').addEventListener('submit', checkForm);

function checkForm(event) {
    //event.preventDefault();
    var el = document.getElementById('main-form')
    var id = el.id.value;
    if (id === "") {
        alert("Creating new user!");
    }
    return true;
}