Este projeto é uma aplicação backend desenvolvida em Java com Spring Boot para gerenciar custos pessoais. A aplicação permite o cadastro do salário do usuário e o gerenciamento dinâmico de categorias (como despesas, casa, carro, entre outras), onde o usuário pode criar, listar e apagar categorias conforme sua necessidade.
🚀 Funcionalidades

✅ Cadastro do salário do usuário
✅ Criação de categorias de custo personalizadas
✅ Listagem de categorias cadastradas
✅ Exclusão de categorias
✅ Registro de custos vinculados a categorias
✅ Persistência dos dados em banco de dados relacional
🛠 Tecnologias utilizadas

    Java 17 (ou versão compatível)

    Spring Boot 3.x

    Spring Data JPA

    Lombok (para reduzir o boilerplate)

💻 Como executar o projeto

Clone o repositório:

git clone https://github.com/geanrabelo/CostManagament.git
cd CostManagement
No cmd rode - docker-compose up -d (Certifique-se de que a porta 15432 e 5432 da sua máquina estejam livres)
Vá no navegador e digite - "localhost:15432"
Credenciais de acesso -> admin@admin.com - admin
Clique com o botão direito em "Servers" e clique em register.
Clique em "Server..."
  - General -> Coloque o nome que desejar.
  - Connection -> hostname -> "Veja o nome do container postgres lá no Docker"
  - Connection -> username -> postgres
  - Connection -> Password -> postgres
- Agora vá na pasta do CostManagement e abra o arquivo "bancodedados.txt" e copie tudo.
- Voltando ao navegador, entre em "Databases" e "costs", abra o costs e clique com o botão direito, "Query Tool", cole tudo o que você pegou do arquivo "bancodedados.txt" e aperte "F5".
- Observação: Não usei o FlyWay Migration que automatizaria esse processo pois ele não está compatível com a versão do PostgreSQL atualizada.
- Vá no postman/insomnia e use os dados abaixos para efetuar as requisições
  - User
    - Post - create - "http://localhost:8080/v1/cost/user"
    - Put - AddSalary - "http://localhost:8080/v1/cost/user"
    - Get - Calculate - "http://localhost:8080/v1/cost/user/calculate?id=1"
    - Get - FindAll - "http://localhost:8080/v1/cost/user"
    - Get - FindById - "http://localhost:8080/v1/cost/user/id?id=1"
    - Delete - Delete - "http://localhost:8080/v1/cost/user?id=1"
   
Em breve, colocarei mais instruções...

