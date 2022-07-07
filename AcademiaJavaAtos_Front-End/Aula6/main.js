// Exemplo 1
function exibirAlerta() {
    alert('O botão foi pressionado!')
}

document.getElementById('btn-alerta').onclick = exibirAlerta


// Exemplo 2
document.getElementById('btn-substitui-p-texto').onclick = function () {
    document.getElementById('p-texto').innerHTML = 'O texto do parágrafo <b>foi substituído</b>.'
}

// Exemplo 3
document.getElementById('btn-ocultar-exemplo-3').onclick = function () {
    document.getElementById('exemplo-3').style.display = 'none'
}

// Exemplo 4
document.getElementById('liga-lampada').onclick = function () {
    document.querySelector('.lampada').src = 'imagens/lamp-on.png'
}
document.getElementById('desliga-lampada').onclick = function () {
    document.querySelector('.lampada').src = 'imagens/lamp-off.png'
}

// Exemplo 5
console.log('A área do círculo é: ' + Math.PI * Math.pow(3,2))

// Exemplo 6
const data = new Date()
const dia = ['Domingo', 'Segunda-feira', 'Terça-feira', 'Quarta-feira', 'Quinta-feira', 'Sexta-feira', 'Sábado']
document.querySelector('.dia-semana').innerText = dia[data.getDay()]


// Exemplo 7
document.getElementById('converter-temperatura').onclick = function () {
    const celsius = document.querySelector('input[type=number]').value
    const farenheit = document.querySelector('input[type=text]')
    const temperaturaConvertida = celsius * 1.8 + 32
    farenheit.value = temperaturaConvertida
}