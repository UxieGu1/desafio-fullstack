
let currentPage = 0;

async function buscarProdutos() {
    try {
        const response = await fetch(`/api/v1/products?page=${currentPage}&size=10`);

        if (!response.ok) {
            throw new Error(`Erro na rede: ${response.status}`);
        }
        const data = await response.json();

        desenharTabela(data.content);
        atualizaBotoesPaginacao(data);

    }
    catch (e) {
        console.error('Houve um problema com a requisição:', e);
    }
}

function desenharTabela(produtos) {
    const tbody = document.querySelector("#tabela-produtos");
    tbody.innerHTML = "";

    produtos.forEach(produto => {
        const linha = document.createElement("tr");

        const tdNome = document.createElement("td");
        const tdPreco = document.createElement("td");
        const tdData = document.createElement("td");

        tdNome.textContent = produto.name;
        tdPreco.textContent = `R$ ${produto.price.toFixed(2)}`;

        tdData.textContent = new Date(produto.createdAt).toLocaleDateString('pt-BR');

        linha.appendChild(tdNome);
        linha.appendChild(tdPreco);
        linha.appendChild(tdData);

        tbody.appendChild(linha);
    });
}

function atualizaBotoesPaginacao(dadosPaginacao) {
    const btnAnterior = document.querySelector("#btn-anterior");
    const btnProximo = document.querySelector("#btn-proximo");
    const infoPagina = document.querySelector("#info-pagina");

    infoPagina.textContent = `Página ${dadosPaginacao.pageNumber + 1} de ${dadosPaginacao.totalPages}`;
    btnAnterior.disabled = dadosPaginacao.first;

    btnProximo.disabled = dadosPaginacao.last;
}

document.querySelector("#btn-anterior").addEventListener("click", () => {
    if (currentPage > 0) {
        currentPage--;
        buscarProdutos();
    }
});

document.querySelector("#btn-proximo").addEventListener("click", () => {
    currentPage++;
    buscarProdutos();
});

buscarProdutos();
