

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

function loginAprovado(user){
    
    document.getElementById("user").innerHTML = `${user.nome_usuario} <br> ${user.racf} ` ;
    document.getElementById("imgUser").innerHTML = `<img src ="${user.link_foto}">`;
    document.getElementById("idLogado").value = user.id;
    obterChamados();
}


function obterChamados(){
    let radioAtendido = document.getElementById("radioPendente");
    let id = document.getElementById("idLogado").value;
    let consulta;
    consulta = "http://localhost:8080/ocorrencias";
   
   

/*     console.log(consulta);
    debugger; */
    fetch(consulta)
    .then(res => res.json())
    .then(result => preencheRespostaTecnico(result));
}


function filtrar(){
    let atividade = document.getElementById("sel_atividades");
    let atividadeId = atividade[atividade.selectedIndex].value; 

    fetch("http://localhost:8080/atividade/"+atividadeId)
    .then(res => res.json())
    .then(result => preencheRespostaTecnico(result));
}

function preencheRespostaTecnico(resposta){
    let atividades = '<table class = "table"> <tr> <th>Data/Hora</th>   <th>Qtd horas</th> <th>Pendente/Justificada</th> </tr>';
    
    let btnStatusOff = '<button class="btn btn-sm btn-secondary">Justificado</button>'

    for (let index = 0; index < resposta.length; index++) {
        let btnStatusOn = `<button class="btn btn-sm btn-primary" onclick="atender(${resposta[index].num_seq})">Justificar</button>`;

        atividades = atividades + `<tr> 
                                  <td> ${resposta[index].data_oc} </td>
                                 
                                  <td> ${resposta[index].num_horas} </td> 
                                  <td> ${resposta[index].status == 0? btnStatusOn
                                    :btnStatusOff} </td>
                                  </tr>`;
    }

    atividades = atividades + '</table>';

    document.getElementById("tableResposta").innerHTML = atividades;
}

function atender(num_seq) {

    window.location = "atendimento.html?numChamado="+num_seq;
}