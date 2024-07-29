# Resumo do Capítulo 08 - Projeto Final Angular/Spring

## Projeto Final - Cadastro de Vendedores:
### Backend
  Criar uma aplicação para gerenciar Vendedores, permitindo cadastrar, listar, editar e remover vendedores. 
  Um vendedor possui: código, nome, sexo (masculino e feminino), salário e percentual de bonificação (de 0% à 100%).
  A aplicação deverá garantir que todo vendedor tenha:
  
  Proprieade   | Tipo
  --------- | ------
  Id | Long
  name | String
  salary | Double
  gender | Integer

  
  Informações sobre o vendedor:
  +  Id chave primária
  + Gênero (Masculino e Feminino) 
  + Nome com no mínimo 5 caracteres
  + Salário maior que zero
  + Percentual de bonificação de 0 à 100
  
  No backend implementar os seguintes endpoints para os vendedores (/sellers) usando: Java, Spring, JPA, DTO, Tratamento de Exceções, Validação e o banco  H2.
  
  Ação | Método | Endpoint
  -----|-----|----
  Recupera todos os vendedores | GET |  /sellers
  Recupera um vendedor pelo id | GET | /sellers/{id}
  Atualiza um vendedor | PUT | /sellers/{is}
  Cria um vendedor | POST | /sellers
  Remove um vendedor | DELETE | /sellers/{id}

### Frontend
  No frontend implementar os seguintes componentes usando Angular e BootStrap: 
  
  * Header com NavBar (home e vendedores);
  * Footer;
  * Home;
  * Sellers (Lista todos os vendedores) (Esse componente é pai de SellerForm);
  * SellerForm (formulário para cadastrar ou editar um vendedor) (Esse componente é filho de Sellers). Usar formulário reativo.
