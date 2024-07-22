

document.addEventListener('DOMContentLoaded', function () {
    const tipoDeUsuario = localStorage.getItem('tipoDeUsuario');
    const botoesDeletar = document.querySelectorAll(".deletar-btn");
    const botoesEditar = document.querySelectorAll(".editar-btn");
    const novo = document.querySelector(".novo-btn");
    console.log("entrando na função")
    if (tipoDeUsuario === 'cliente') {

        botoesDeletar.forEach(botao => {
            botao.style.display = 'none';
        });

        botoesEditar.forEach(botao => {
            botao.style.display = 'none';
        });

        if (novo) {
            novo.style.display = 'none';
        }
        const intervalId = setInterval(checkAndHideElements, 250); // Verifica a cada 500ms

    }else if(tipoDeUsuario === 'consultor'){
        botoesDeletar.forEach(botao => {
            botao.style.display = 'none';
        });
    }
});