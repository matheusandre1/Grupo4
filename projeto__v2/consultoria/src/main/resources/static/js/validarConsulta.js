$(document).ready(function () {
    console.log("jQuery is working!");
    
    
    $('#consultores').on('blur', function() {
        validateRequiredField(this);
    });

    $('#clientes').on('blur', function() {
        validateRequiredField(this);
    });

    $('#dataConsulta').on('blur', function() {
        validateRequiredField(this);
    });

    $('#horaConsulta').on('blur', function() {
        validateHora(this);
    });

});

function validateRequiredField(field) {
    if (!field.value.trim()) {
        showError(field, 'Este campo é obrigatório.');
    } else {
        clearError(field);
    }
}

function validateHora(field) {
    const horaPattern = /^([01]\d|2[0-3]):([0-5]\d)$/;
    if (!horaPattern.test(field.value.trim())) {
        showError(field, 'A hora deve estar no formato HH:MM (24 horas).');
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