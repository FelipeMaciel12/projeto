
function validaLogin() {
    let userTxt = localStorage.getItem("userLogged")

    if(!userTxt) {
        window.location = "index.html"
    }

    let user = JSON.parse(userTxt)

    document.getElementById("dadosUser").innerHTML = `${user.nome} (${user.racf})`

    listarUser()
}

function logout() {
    localStorage.removeItem("userLogged")
    window.location = "index.html"
}

function listarUser() {
    let url = `http://localhost:8080/user/all` 

    fetch(url)
    .then(res => res.json())
    .then(res => exibirLista(res))
}


function exibirLista(lista) {
    let tabela = "<table> <tr> <th>Nome</th> <th>email</th> </tr>"

    for(i=0; i < lista.length ; i++) {
        tabela += `<tr> <td>${lista[i].nome}</td> <td>${lista[i].email}</td> </tr>`
    }

    tabela += "</table>"
    document.getElementById("tabela").innerHTML = tabela
}


function listaAlarme() {
    let url = `http://localhost:8080/alarme/todos` 

    fetch(url)
    .then(res => res.json())
    .then(res => exibirAlarme(res))
    window.location = "alarmes.html"
}

function exibirAlarme(lista){
    let tabela = "<table> <tr> <th>IdAlarme</th> <th>nome</th> <th>descricao</th> </tr>"

    for(i=0; i < lista.length ; i++) {
        tabela += `<tr> <td>${lista[i].idAlarme}</td> <td>${lista[i].nome}</td> <td>${lista[i].descricao}</td> </tr>`
    }

    tabela += "</table>"
    document.getElementById("tabela").innerHTML = tabela
    
}
