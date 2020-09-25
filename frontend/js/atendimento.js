
function validaLogin(){

    let userTxt = localStorage.getItem("userLogged");

    if(!userTxt){
        window.location = "index.html";
    }

    let jsonUser = JSON.parse(userTxt);
    if(jsonUser.gestor == 0){
        loginAprovado(jsonUser);
    }else{
        window.location = "index.html";
    }
}

function loginAprovado(){
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const numChamado = urlParams.get('numChamado');
    
    fetch("http://localhost:8080/ocorrencia/"+numChamado)
    .then(res => res.json())
    .then(result => preencheDados(result));

}

function preencheDados(resposta){
    // document.getElementById("txtUser").value = resposta.usuario.id;
    // document.getElementById("txtChamado").value = resposta.numChamado;
    document.getElementById("txtData").value = resposta.data_oc;
    document.getElementById("txtHoras").value = resposta.num_horas;
}

function atualizarChamado(evento){

    evento.preventDefault();

    let objChamado = {
        // numChamado: document.getElementById("txtChamado").value,
        descricao: document.getElementById("txtDescricao").value,
        dataAgendamento: document.getElementById("txtData").value,
        horasGastas:document.getElementById("txtHoras").value,
        troca: document.getElementById("radioTroca").checked ? 1:0,
        status:1,
        usuario:{
            id:document.getElementById("txtUser").value
        },
        atividade:{
            id:document.getElementById("txtAtividadeId").value
        }
    }

    let cabecalho = {
        method: 'POST',
        body: JSON.stringify(objChamado),
        headers:{
            'Content-type':'application/json'
        }
    }

    fetch("http://localhost:8080/ocorrencia/update", cabecalho)
    .then(res => res.json())
    // .then(result => console.log(result));

    window.location = "atend_tecnico.html";
}


