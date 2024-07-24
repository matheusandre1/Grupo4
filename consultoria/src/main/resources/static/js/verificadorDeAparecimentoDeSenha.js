document.addEventListener('DOMContentLoaded', function () {
    const tipoDeUsuario = localStorage.getItem('tipoDeUsuario');
    const senhaElement = document.querySelector('.senha');

    if (senhaElement) {
        if (tipoDeUsuario === 'consultor' || tipoDeUsuario === 'cliente') {
            senhaElement.textContent = '*****';
        } else {
            // Se necessário, você pode adicionar código para mostrar a senha real para outros tipos de usuário
            // senhaElement.textContent = ''; // ou outra lógica se necessário
        }
    }
});