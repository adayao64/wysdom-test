All codes of project in wysdom-test folder. It is root folder.

## Running the app

1. Open the terminal, From the root folder, run this command to build the app: ./gradlew build

2. Open the terminal, From the root folder, Run the app: 
   java -jar build/libs/wysdom-test-0.0.1-SNAPSHOT.jar worldcup julie
   (Note: "worldcup julie" are search key, you can enter multiple search keys, please use space to split them)
   You will see search results showing in terminal if you provide search key. Below is output in my environment.
      2018-07-13 13:15:27.859  INFO 31076 --- [pool-1-thread-1] com.wysdom.WysdomTestApplication         : World Cup||https://en.wikipedia.org/wiki/World_Cup
      search results+0==>World Cup||https://en.wikipedia.org/wiki/World_Cup
      2018-07-13 13:15:27.862  INFO 31076 --- [pool-1-thread-1] com.wysdom.WysdomTestApplication         : ICC World Twenty20||https://en.wikipedia.org/wiki/ICC_World_Twenty20
      search results+1==>ICC World Twenty20||https://en.wikipedia.org/wiki/ICC_World_Twenty20
      2018-07-13 13:15:27.863  INFO 31076 --- [pool-1-thread-1] com.wysdom.WysdomTestApplication         : 2006 FIFA World Cup||https://en.wikipedia.org/wiki/2006_FIFA_World_Cup
      search results+2==>2006 FIFA World Cup||https://en.wikipedia.org/wiki/2006_FIFA_World_Cup
     ...................
   
3. test the app:
   postman:
   
   choose GET
   http://localhost:8080/rest/v1/searchWikipedia/worldcup*julie*kids*zara*club 
   
   or
   
   curl http://localhost:8080/rest/v1/searchWikipedia/worldcup*julie*kids*zara*club |json_pp
   
   Note:
   Please put search keys in the end of endpoint and use * to split them
   
