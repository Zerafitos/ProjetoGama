function validaLogin(){

    let userTxt = localStorage.getItem("userLogged");

    if(!userTxt){
        window.location = "index.html";
    }

    let jsonUser = JSON.parse(userTxt);
    if(jsonUser.gestor == 1){
        loginAprovado(jsonUser);
    }else{
        window.location = "index.html";
    }
}

function loginAprovado(user){
    
    document.getElementById("user").innerHTML = `${user.nome_usuario} <br> ${user.racf} ` ;
    document.getElementById("imgUser").innerHTML = `<img src ="${user.link_foto}">`;
    // <img src ="..\imagens\tiopatinhas.jpg"></img>
    obterAtividades();
}

function obterAtividades() {
    fetch("http://localhost:8080/ocorrencias")
        .then(res => res.json())
        .then(result => preencheAtividades(result));
}

function preencheAtividades(resposta) {
    let atividades = '';

    for (let index = 0; index < resposta.length; index++) {
        atividades = atividades + `<option value = ${resposta[index].id}> ${resposta[index].descricao} </option>`;
    }

    document.getElementById("sel_atividades").innerHTML = atividades;
}


function filtrar(){
    let status = document.getElementById("sel_status");
    let statusId = status[status.selectedIndex].value; 
    let link;

    fetch("http://localhost:8080/ocorrencias/status/" + statusId)
    .then(res => res.json())
    .then(result => preencheRespostaGestor(result));
}

function preencheRespostaGestor(resposta){
    console.log(resposta);
    let chamados = '<table class = "table"> <tr>  <th>Data</th> <th>Colaborador</th>  <th>Descrição</th>   </tr>';
    // let chamados = '<table class = "table"> <tr> <th>#chamado</th> <th>descrição</th> <th>data</th> <th>Técnico</th> <th>status</th> </tr>';

    for (let index = 0; index < resposta.length; index++) {
        chamados = chamados + `<tr> 
                                <td> ${resposta[index].data_oc} </td>
                                <td> ${resposta[index].usuario.nome_usuario} </td> 
                                <td> ${resposta[index].descricao} </td>
                                  </tr>`;
                                 
    }
    // <td> ${resposta.chamados[index].status ==0?'Pendente':'Atendido'} </td>

    chamados = chamados + '</table>';

    document.getElementById("tableResposta").innerHTML = chamados;
}

