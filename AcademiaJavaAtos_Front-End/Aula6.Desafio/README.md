# Desafio Front-End-03 06-07:

## Criar um formulário com os seguintes campos:
- Nome
- Sobrenome
- E-mail
- Login
- Senha
- CEP
- Endereço
- Complemento
- Bairro
- Cidade
- Estado
- Perfil do Github
- Academia (lista com as academias)
- Professor (lista com os professores)
- Aceite de termos (utilizar textarea para exibir os termos)
- Opção de receber ou não receber informativos


## Regras do formulário:
### Campos de preenchimento obrigatório:
- Nome
- Sobrenome
- E-mail
- Login
- Senha
- Perfil
- Academia
- Professor
- Aceite dos termos

### Campo dinâmico:
- O login deve ser preenchido automaticamente com o "nome"."sobrenome" (Não pode haver espaços nem caracteres especiais)

### Ao submeter o formulário:
- O usuário deve receber uma resposta de que o formulário foi enviado
- Os dados devem aparecer em algum local no final da página, simulando o envio para o backend
- O formulário deve ser limpo, ficando pronto para um novo cadastro

### Bônus:
- Preencher os campos do endereço dinamicamente ao informar o CEP (https://viacep.com.br/)
- O usuário deve receber a informação no caso do CEP não ser encontrado
- Adicionar máscara a campos pertinentes
- Liberar checkbox dos termos somente quando o usuário chegar ao fim do texto

### Dicas para possíveis utilizações
- Element.addEventListener() - https://developer.mozilla.org/pt-BR/docs/Web/API/EventTarget/addEventListener
- Arrow functions - https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Functions/Arrow_functions
- fetch() - https://developer.mozilla.org/pt-BR/docs/Web/API/Fetch_API/Using_Fetch
- Function async - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/async_function
- Operador await - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/await