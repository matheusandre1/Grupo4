$(document).ready(function () {
    console.log("jQuery is working!");
    $('#telefone').mask('(00) 00000-0000');
    $('#cnpj').mask('00.000.000/0000-00');

    $('#idConsultor').on('blur', function() {
        validateRequiredField(this);
    });

    $('#nomeEmpresa').on('blur', function() {
        validateRequiredField(this);
    });

    $('#nomeResponsavel').on('blur', function() {
        validateRequiredField(this);
    });

    $('#cnpj').on('blur', function() {
        validateCnpj(this);
    });

    $('#telefone').on('blur', function() {
        validateTelefone(this);
    });

    $('#email').on('blur', function() {
        validateEmail(this);
    });

    $('#senha').on('blur', function() {
        validateRequiredField(this);
    });
});

function validateRequiredField(field) {
    if (!field.value.trim()) {
        showError(field, 'Este campo é obrigatório.');
    } else {
        clearError(field);
    }
}

function validateCnpj(field) {
    const cnpjPattern = /^\d{2}\.\d{3}\.\d{3}\/\d{4}-\d{2}$/;
    if (!cnpjPattern.test(field.value.trim())) {
        showError(field, 'O CNPJ deve estar no formato 00.000.000/0000-00.');
    } else {
        clearError(field);
    }
}

function validateTelefone(field) {
    const telefonePattern = /^\(\d{2}\) \d{5}-\d{4}$/;
    if (!telefonePattern.test(field.value.trim())) {
        showError(field, 'O telefone deve estar no formato (XX) XXXXX-XXXX.');
    } else {
        clearError(field);
    }
}

function validateEmail(field) {
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!emailPattern.test(field.value.trim())) {
        showError(field, 'Por favor, insira um e-mail válido.');
    } else {
        clearError(field);
    }
}

function showError(field, message) {
    const errorDiv = $(field).next('.error');
    if (errorDiv.length === 0) {
        $(field).after('<div class="error text-danger">' + message + '</div>');
    } else {
        errorDiv.text(message);
    }
    $(field).addClass('is-invalid');
}

function clearError(field) {
    const errorDiv = $(field).next('.error');
    if (errorDiv.length > 0) {
        errorDiv.remove();
    }
    $(field).removeClass('is-invalid');
}