# Android Test 01
### Project Overview

Criar um aplicativo para consultar a API do GitHub e trazer os repositórios mais populares de Kotlin. Seguir o procedimento abaixo:

Deve conter
Lista de repositórios. Exemplo de chamada na API: https://api.github.com/search/repositories?q=language:Kotlin&sort=stars&page=1 
Paginação na tela de lista, com endless scroll / scroll infinito (incrementando o parâmetro page).
Cada repositório deve exibir Nome do repositório, Descrição do Repositório, Nome / Foto do autor, Número de Stars, Número de Forks
Ao tocar em um item, deve levar a lista de Pull Requests do repositório
Deve conter o item de favoritar repositórios e deve ser possível acessar as informações offline.
Incluir campo de busca de repositório.
Pull Requests de um repositório. Exemplo de chamada na API: https://api.github.com/repos/<criador>/<repositório>/pulls
Pull Requests deve ser separados em duas tabs por status (Abertos e Fechados)
Cada item da lista deve exibir Nome / Foto do autor do PR, Título do PR, Data do PR e Body do PR
Ao tocar em um item, deve abrir no browser a página do Pull Request em questão
A solução DEVE conter
Versão mínima do SDK: 21
Arquivo .gitignore
Mapeamento json -> Objeto . Ex: GSON
Ganha + pontos se conter
Arquitetura MVVM
Testes unitários no projeto.
Cache de Imagens
Aplicação que permite consultar lista de repositórios offline com base na última consulta.
Utilizar SQLite ao implementar o item anterior.

Observações
Qualquer biblioteca fornecida como exemplo é apenas um guideline, fiquem a vontade para usar outras  diferentes e nos surpreenderem. O importante de fato é que os objetivos macros sejam atingidos.
O layout da aplicação é livre mas deve seguir os princípios de design, UI e UX do Android.

**Developed by Agnaldo Rodrigues de Carvalho Netto**
