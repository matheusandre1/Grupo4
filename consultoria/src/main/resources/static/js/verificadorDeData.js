document.addEventListener('DOMContentLoaded', function () {
    const dataConsultaInput = document.getElementById('dataConsulta');
    const form = dataConsultaInput.closest('form');
    const errorContainer = document.createElement('div');
    errorContainer.classList.add('text-danger');
    dataConsultaInput.parentNode.appendChild(errorContainer);

    dataConsultaInput.addEventListener('blur', function () {
        validarData();
    });

    form.addEventListener('submit', function (event) {
        if (!validarData()) {
            event.preventDefault();
        }
    });

    function validarData() {
        const dataConsultaValue = new Date(dataConsultaInput.value);
        const today = new Date();
        today.setHours(0, 0, 0, 0); // zerar horas, minutos, segundos e milissegundos

        if (dataConsultaValue < today) {
            errorContainer.textContent = 'A data deve ser igual ou posterior à data atual';
            dataConsultaInput.classList.add('is-invalid');
            return false;
        } else {
            errorContainer.textContent = '';
            dataConsultaInput.classList.remove('is-invalid');
            return true;
        }
    }
});
