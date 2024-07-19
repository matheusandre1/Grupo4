const pesquisar = document.getElementById('searchInput');

pesquisar.addEventListener('keyup', () => {
    var entrada = document.getElementById('searchInput').value.toLowerCase();
    var linha = document.getElementById('consultoresTable').getElementsByTagName('tr');
    for (var i = 0; i < linha.length; i++) {
        var celulaConsultor = linha[i].getElementsByTagName('td')[0];
        if (celulaConsultor) {
            var texto = celulaConsultor.textContent;
            linha[i].style.display = texto.toLowerCase().indexOf(entrada) > -1 ? '' : 'none';
        }
    }
});