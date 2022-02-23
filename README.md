# GenesysAssignment

# Problem Statement
Please find the problem statement available in the same directory as in README.md file.

# Authentication Request & Response
![image](https://user-images.githubusercontent.com/18740271/155318240-2614606d-bddd-49da-bf75-3951c4639301.png)

As you might have noticed from the above image, we use two operators 'EQUALS' & 'BETWEEN' to seperate range based and non-range based filter criteria.



# Filter Params Request Structure
![image](https://user-images.githubusercontent.com/18740271/155315826-78f07c7b-64cc-47b1-86cf-6f1443871b11.png)

# Filter Response Response Structure
![image](https://user-images.githubusercontent.com/18740271/155315944-feacd8df-69ff-4473-aa22-641f82c96d55.png)

# NoSQL Solutiuon
Upon analyzing the input data given as part of the assignment, a document store like MongoDB would be a right choice of solutiuon rather than having a Column database like Cassandra or a Key-Value database like DynamoDB.
![image](https://user-images.githubusercontent.com/18740271/155319933-ecaa549d-427f-45b9-8894-a68fcc800ce6.png)




# Spring Security
One of the main requirements of this assignment is to have this service secured. The services actually creates a session for the user upon successfull authentication and hence JWT would be a right fit for this scenario. 

The first request to the service will be an authentication request and the response will be a JWT token. This token will be used as a token of identification for the subsequent requests from the user. Also, the token will be valid only for certain period of time and expires after that.




