# File Changes

**Models files** – represents the structure of a certain entity. They can be compared to database tables as they contain the attributes. The PetType enum file was edited to include the 2 pets that were created.

**Repositories** – are responsible for interacting with the database. They extend the JpaRepository, enabling users to perform CRUD operations on the database.

**Controllers** – handles the URL routing and utilizes the created services to call the repositories, which are the ones who interact with the database itself. For example, in the SnailController file “/snail” retrieves all existing snail records. 

**Service** – acts as the bridge between the repositories and the controllers, it gets data from the repositories and perform the processes then sends it to the controllers.

**Pets.sql** – creates the tables and the necessary attributes, which were based off the models for the pets in the furry friends database. 

**Furrydb.sql** – inserts the records for every furry friend. The tables are locked when inserting records so the insertions can be completed with no unnecessary disruptions during the session.

🐌  🟡🐟
