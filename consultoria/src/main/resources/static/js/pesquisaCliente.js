const pesquisar = document.getElementById('searchInput');

pesquisar.addEventListener('keyup', () => {
    var entrada = document.getElementById('searchInput').value.toLowerCase();
    var linha = document.getElementById('clientesTable').getElementsByTagName('tr');
    for (var i = 0; i < linha.length; i++) {
        var celulaCliente = linha[i].getElementsByTagName('td')[0];
        if (celulaCliente) {
            var texto = celulaCliente.textContent;
            linha[i].style.display = texto.toLowerCase().indexOf(entrada) > -1 ? '' : 'none';
        }
    }
});