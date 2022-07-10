const form = document.getElementById('form')

const nome = document.getElementById('nome')
const sobrenome = document.getElementById('sobrenome')
const login = document.getElementById('login')
const email = document.getElementById('email')
const senha = document.getElementById('senha')
const cep = document.getElementById('cep')
const endereco = document.getElementById('endereco')
const complemento = document.getElementById('complemento')
const bairro = document.getElementById('bairro')
const cidade = document.getElementById('cidade')
const estado = document.getElementById('estado')
const github = document.getElementById('github')
const academia = document.getElementById('academia')
const professor = document.getElementById('professor')
const termoslegais = document.getElementById('termoslegais')
const info = document.getElementById('quero-info')
const btn = document.getElementById('btn-enviar')

//* MONTA LOGIN */
var loginl = ''
var login2 = ''

nome.addEventListener('input' , function(){ 

    login1 =  nome.value
    login.value = login1 + '.' + login2
})
sobrenome.addEventListener('input' , function(){ 

    login2 =  sobrenome.value
    login.value = login1 + '.' + login2
})
//* MONTA LOGIN */

/** FORMULARIO ENVIADO */
btn.addEventListener('click' , function(e){ 
    e.preventDefault()

    exibirAlerta()

    document.getElementById('nome-enviado').innerText  = nome.value
    document.getElementById('sobrenome-enviado').innerText = sobrenome.value
    document.getElementById('email-enviado').innerText = email.value
    document.getElementById('login-enviado').innerText = login.value
    document.getElementById('senha-enviado').innerText = senha.value
    document.getElementById('cep-enviado').innerText = cep.value
    document.getElementById('endereco-enviado').innerText = endereco.value
    document.getElementById('complemento-enviado').innerText = complemento.value
    document.getElementById('bairro-enviado').innerText = bairro.value
    document.getElementById('cidade-enviado').innerText = cidade.value
    document.getElementById('estado-enviado').innerText = estado.value
    document.getElementById('github-enviado').innerText = github.value
    document.getElementById('academia-enviado').innerText = academia.value
    document.getElementById('professor-enviado').innerText = professor.value
    document.getElementById('termoslegais-enviado').innerText = termoslegais.value
    document.getElementById('info-enviado').innerText = document.querySelector('input[name=info-email]:checked').value


    document.querySelector('#nome').value = ''
    document.querySelector('#sobrenome').value = ''
    document.querySelector('#email').value = ''
    document.querySelector('#login').value = ''
    document.querySelector('#senha').value = ''
    document.querySelector('#cep').value = ''
    document.querySelector('#endereco').value = ''
    document.querySelector('#complemento').value = ''
    document.querySelector('#bairro').value = ''
    document.querySelector('#cidade').value = ''
    document.querySelector('#estado').value = ''
    document.querySelector('#github').value = ''
    document.querySelector('#academia').value = ''
    document.querySelector('#professor').value = ''

}});
/** FORMULARIO ENVIADO */

//* ALERTA QUANDO ENVIAR FORMULARIO */
function exibirAlerta(){
    alert('Enviado!')
}
//* ALERTA QUANDO ENVIAR FORMULARIO */
