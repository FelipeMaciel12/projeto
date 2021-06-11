
function validaLogin(id) {
    let userTxt = localStorage.getItem("userLogged")

    if (!userTxt) {
        window.location = "index.html"
    }

    let user = JSON.parse(userTxt)

    document.getElementById("dadosUser").innerHTML = `<b>${user.nome} (${user.racf})</b>`
    document.getElementById("imgUser").innerHTML = `<img src="${user.linkFoto}">`
    //listarUser()

    if (id == 1) {
        listaAlarme()
    }

    if (id == 2) {
        listaEvento()
    }
}


function logout() {
    localStorage.removeItem("userLogged")
    window.location = "index.html"
}


function relAlarme(event) {
    event.preventDefault()
    window.location = "alarmes.html"


}

function relEvento(event) {
    event.preventDefault()
    window.location = "evento.html"


}

function paginaRel() {
    window.location = "interna.html"
}

function listaAlarme() {
    let url = `http://localhost:8080/alarme/todos`
    fetch(url)
        .then(res => res.json())
        .then(res => exibirAlarme(res));
}


function exibirAlarme(lista) {
    let tabelaAlarmes = `<table class="table table-sm table-bordered"> <tr> <th>Id_Alarme</th> <th>Alarme</th> <th>Descrição</th> </tr>`;

    for (i = 0; i < lista.length; i++) {
        tabelaAlarmes = tabelaAlarmes + `<tr>
                            <td> ${lista[i].idAlarme} </td>
                            <td> ${lista[i].nome} </td>
                            <td> ${lista[i].descricao} </td>
                        </tr>`;
    }

    tabelaAlarmes += "</table>"
    document.getElementById("tabela").innerHTML = tabelaAlarmes;

}

function listaEvento() {
    let dataInicio = document.getElementById("dataInicio").value;
    let dataFim = document.getElementById("dataFim").value;

    let dataMsg = {
        dt1: dataInicio,
        dt2: dataFim,
    }

    let msg = {
        method: 'POST',
        body: JSON.stringify(dataMsg),
        headers: {
            'Content-type': 'application/json'
        }
    }

    fetch("http://localhost:8080/evento/data", msg)
        .then(res => res.json())
        .then(res => preencheEventos(res));

}


function preencheEventos(res) {
    // console.log(res);
    let tabelaEventos = '<table class="table table-sm"> <tr> <th>Hostname do Equipamento</th> <th>Tipo do Alarme</th> <th>Data do Evento</th> </tr>';

    for (i = 0; i < res.length; i++) {
        let dataAtual = new Date(res[i].dataevt).toLocaleDateString("pt-BR", { timeZone: 'UTC' })

        tabelaEventos = tabelaEventos + `<tr> 
                            <td> ${res[i].equipamento.hostname}
                            <td> ${res[i].alarme.descricao}
                            <td> ${dataAtual} </td> 
                        </tr>`;
    }

    tabelaEventos += '</table>';
    document.getElementById("tabelaEV").innerHTML = tabelaEventos;


}