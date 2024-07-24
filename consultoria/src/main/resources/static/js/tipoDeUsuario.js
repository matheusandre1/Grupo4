document.querySelectorAll('input[name="tipoDeUsuario"]').forEach((radio) => {
    radio.addEventListener('change', (event) => {
        const tipoDeUsuario = event.target.value;
        localStorage.setItem('tipoDeUsuario', tipoDeUsuario);
    });
});