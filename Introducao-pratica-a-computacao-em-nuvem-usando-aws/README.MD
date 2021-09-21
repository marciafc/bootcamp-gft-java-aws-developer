# Introdução prática a computação em nuvem usando AWS

  - Durante o curso foi desenvolvida uma API HTTP/REST com AWS API Gateway, Configuração de permissões com AWS IAM e Banco de dados NoSQL com AWS DynamoDB

  - [Amazon Cognito](https://aws.amazon.com/pt/cognito/)
    - É composto por grupos de usuários e grupos de identidades, componentes que integram os mecanismos de autorização e autenticação.
	
  - [Amazon DynamoDB](https://aws.amazon.com/pt/dynamodb/)
    - Banco de dados não relacional (NoSQL), com suporte a chave-valor e documentos, que oferece alto desempenho em qualquer escala, além de ser totalmente gerenciado.

  - Pilares da AWS
    - Segurança, Eficiência/Performance, Confiabilidade, Excelência Operacional e Otimização de Custos.
	

## Criar tabela Products no DynamoDB na AWS

```
id String - key
  
Para inserir: "Create item" e adicionar novos atributos com respectivos valores
  name String 
  price Number
  
```

## Criar função lambda na AWS


Código NodeJS:

```
const AWS = require("aws-sdk");

const dynamo = new AWS.DynamoDB.DocumentClient();

exports.handler = async (event, context) => {
  let body;
  let statusCode = 200;
  const headers = {
    "Content-Type": "application/json"
  };
  
  
  let requestJSON;

  try {
    switch (event.routeKey) {
      case "POST /items":
        requestJSON = JSON.parse(event.body);
        await dynamo
          .put({
            TableName: "Products",
            Item: {
              id: requestJSON.id,
              price: requestJSON.price,
              name: requestJSON.name
            }
          })
          .promise();
        body = `Put item ${requestJSON.id}`;
        break;
      case "DELETE /items/{id}":
        console.log(event.pathParameters.id)
        await dynamo
          .delete({
            TableName: "Products",
            Key: {
              id: event.pathParameters.id
            }
          })
          .promise();
        body = `Deleted item ${event.pathParameters.id}`;
        break;
      case "GET /items/{id}":
        body = await dynamo
          .get({
            TableName: "Products",
            Key: {
              id: event.pathParameters.id
            }
          })
          .promise();
        break;
      case "GET /items":
        body = await dynamo.scan({ TableName: "Products" }).promise();
        break;
      case "PUT /items/{id}":
         requestJSON = JSON.parse(event.body);
        await dynamo
          .update({
            TableName: "Products",
            Key: {
              id: event.pathParameters.id
            },
            UpdateExpression: 'set price = :r',
            ExpressionAttributeValues: {
             ':r': requestJSON.price,
            },
          })
          .promise();
        body = `Put item ${event.pathParameters.id}`;
        break;
      default:
        throw new Error(`Unsupported route: "${event.routeKey}"`);
    }
  } catch (err) {
    statusCode = 400;
    body = err.message;
  } finally {
    body = JSON.stringify(body);
  }

  return {
    statusCode,
    body,
    headers
  };
};

```
  
## Criar API Gateway 

  - Acessar em "API Gateway \ APIs \ HTTP API"

## Criar rotas e integrá-las a função lambda

  - Acessar "API Gateway \ clicar no nome da api criada no passo anterior \ Develop \ Routes" 
  
  - Criar cada uma das rota (GET, POST, etc...)
  
    - A primeira rota  
	
	```
	POST /items
	
	Clicar no verbo http \ "Attach integration \ Create and attach an integration \  selecionar "Integration type" com "Lambda function" \ AWS Region = mesma onde está o lambda \ Informar o Lambda function (nome da função lambda criada)"
	
	```
  
   - A partir da segunda rota, não precisar criar integração, pode selecionar "Attach integration" e selecionar integração existente \ Attach integration
   
	```   
  	DELETE /items/{id} 
  	GET /items/{id}
  	GET /items
  	PUT /items/{id}
	
	```	  

## Incluir política de permissão para a função lambda acessar o DynamoDB
  
    - Acessar a função lambda \ aba Configuration \ Permissions (menu à esquerda) \ clicar no Role name \ Attach policies \ Pesquisar e selecionar AmazonDynamoDBFullAccess (não usar em PROD) \ Attach policies

    - Erro caso não tenha essa permissão: (...) is not authorized to perform: dynamodb:Scan on resource: arn:aws:dynamodb: (...)

## Chamadas via Postman 

  - Obter o host para testar no Postman: API Gateway \ acessar a API Gateway criada \ campo "Invoke URL"

```
GET /items
Response
{
    "Items": [
        {
            "price": 10,
            "id": "1",
            "name": "Produto"
        }
    ],
    "Count": 1,
    "ScannedCount": 1
}

```

```
GET /items/1
Response
{
    "Item": {
        "price": 10,
        "id": "1",
        "name": "Produto"
    }
}

```

```
PUT /items/1
Request
{"price": 5599.12} 

Response
"Put item 1"

```

```
POST /items
Request
{
    "id": "2",
    "price": 3.99,
    "name": "Produto do 1.99"
}

Response
"Put item 2"

```

```
DELETE /items/1
Response
"Deleted item 1"

```

## Referência

  - [Código NodeJS](https://github.com/cassianobrexbit/dio-live-coding-aws/blob/master/source/index.js)