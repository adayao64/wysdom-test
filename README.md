All codes of project in wysdom-test folder. It is root folder.

## Running the app

1. Open the terminal, From the root folder, run this command to build the app: ./gradlew build

2. Open the terminal, From the root folder, Run the app: 
   java -jar build/libs/wysdom-test-0.0.1-SNAPSHOT.jar worldcup julie
   (Note: worldcup julie are search key, you can enter multiple search keys, please use space to split them)
   
   or from the root folder using springBoot: ./gradlew bootRun
   
3. test the app:
   postman:
   
   choose GET
   http://localhost:8080/rest/v1/searchWikipedia/worldcup*julie*kids*zara*club 
   
   or
   access below url from web browser
   
   http://localhost:8080/rest/v1/searchWikipedia/worldcup*julie*kids*zara*club
   
   or
   
   curl http://localhost:8080/rest/v1/searchWikipedia/worldcup*julie*kids*zara*club |json_pp
   
   Note:
   Please put search keys in the end of endpoint and use * to split them
   
