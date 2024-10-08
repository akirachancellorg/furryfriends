## Open Command Prompt/Windows Powershell as Admin
- open cmd/win ps
- type CD and put the location of your directory where you want to clone
    ```
  [eg. cd C:\Users\<your username>\Documents\...]
    ```
- Hit Enter

## Install Git (skip this part if you have Git on your Local Machine(s)
- Download the **Git Installer**, copy the link below:
  ```
  https://gitforwindows.org
  ```
- Ensure that **Git PATH** is properly configured on your Local Machine so that you can run git commands on respective terminals.

  # For MacOS
  - If you are using **MacOS**, follow these steps:
    Open Terminal
    Run the command:
    ```
    brew install git
    ```
  - Or as an alternative, you can also download the Git Installer on their official website

## Configuring Git using Git Bash
### Requirements: Git 
- Set up your username
```
git config --global user.name "<username>"
```
- Set up your E-mail
```
git config --global user.email "<your_email@.git.com>"
```
- (Optional) Checking Configurations
To ensure the username and e-mail are added, run this command:
```
git config --list
```

## Clone this Repository
- Open your Command Prompt/Windows Powershell as Administrator
- Make sure you are on the right directory where you want to clone the repository
- Run the command below:
    ```
    git clone [https://github.com/dadan041100/queencard-furryfriends.git]
    ```
- Open your project in IntelliJ
  
## Set up MySQL in Docker
### Requirement: Docker Desktop  
- If you do not have **Docker Desktop**, kindly download it and set the respective paths to ensure that it is working.
# Link
```
https://www.docker.com/products/docker-desktop/
```
- Make sure that **Docker PATH** is properly configured
- Log-in or Register with your GitHub or Personal Account
  
### Open your powershell/terminal
- Pull MySQL image from DockerHub  
    ```
    docker pull mysql
    ```
- Configure and Run MySQL in Docker  
    ```
    docker run -p 3307:3306 --name mysqlcontainer -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=qcard_furryfriends_db -d mysql
    ```
### Open the terminal in IntelliJ and run the following
- Pull MySQL image from DockerHub  
- Configure Network project's network  
    ```
    docker network create networkmysql
    ```
- Pull MySQL image from DockerHub  
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
  - URL: `jdbc:mysql://localhost:3307/qcardfurry_friends_db`
- Test the connection, apply changes on success

## Initialize the Schema and Data of the Project
- Open furrydb.sql under `src/main/resources/`
- Connect to the data source `qcard_furry_friends_db@localhost`

## Reference:
- For setting **MySQL in Docker Desktop**, i would like to thank **DANZIEL CEMPRON** for giving out clear instructions on how to do it.
# Check out his GitHub Profile 
```
https://github.com/Dnzldotexe
```

  
