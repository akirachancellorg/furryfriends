# File Changes

**Models files** – represents the structure of a certain entity. They can be compared to database tables as they contain the attributes. The PetType enum file was edited to include the 2 pets that were created.

**Repositories** – are responsible for interacting with the database. They extend the JpaRepository, enabling users to perform CRUD operations on the database.

**Controllers** – handles the URL routing and utilizes the created services to call the repositories, which are the ones who interact with the database itself. For example, in the SnailController file “/snail” retrieves all existing snail records. 

**Service** – acts as the bridge between the repositories and the controllers, it gets data from the repositories and perform the processes then sends it to the controllers.

**Pets.sql** – creates the tables and the necessary attributes, which were based off the models for the pets in the furry friends database. 

**Furrydb.sql** – inserts the records for every furry friend. The tables are locked when inserting records so the insertions can be completed with no unnecessary disruptions during the session.

🐌  🟡🐟

## Clone this Repository
- Open your powershell/terminal and run:
    ```
    git clone https://github.com/Meteornkr/furryfriends.git
    ```
- Open your project in IntelliJ

## Set up MySQL in Docker
### Requirement: Docker Desktop
### Open your powershell/terminal
- Pull MySQL image from DockerHub
    ```
    docker pull mysql
    ```
- Configure and Run MySQL in Docker
    ```
    docker run -p 3307:3306 --name mysqlcontainer -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=furry_friends_db -d mysql
    ```
### Open the terminal in IntelliJ and run the following
- Configure Network project's network
    ```
    docker network create networkmysql
    ```
    Note: If you see an error like this `Error response from daemon: network with name networkmysql already exists`. This means that there is an existing connection with the container. You can solve this by disconnecting the previous connection `docker network disconnect networkmysql mysqlcontainer` or by nuking the network entirely `docker network prune`
- Connect project and mysql
    ```
    docker network connect networkmysql mysqlcontainer
    ```

## Add Data Source in Project
- Open IntelliJ
- Open the "Database" on the top-right side pane
- Click the '+' icon
- Click Data Source > MySQL
- Configure the following:
    - User: `root`
    - Password: `root`
    - URL: `jdbc:mysql://localhost:3307/furry_friends_db`
- Test the connection, apply changes on success

## Initialize the Schema and Data of the Project
- Open furrydb.sql under `src/main/resources/`
- Connect to the data source `furry_friends_db@localhost`
- Run furrydb.sql
