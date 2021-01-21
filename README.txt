# Retrieving the Product Details Using the Product ID

## Description
A simple application that populates product data into your mysql database and then when launched on a tomcat server, shows you an input where you can search for products by their id number

## Steps
1. Run the App.java file in the src/main/java folder that will populate your mysql database. It will also create a database called "productretrieval" and a table within that db called "product"
2. run 'mvn package' to install all the dependencies
3. If running on docker, build the container with 'docker build . -t product-retrieval-tomcat' and then open the server with 'docker run -p 8081:8080 -t product-retrieval-tomcat'
3. Otherwise, just launch on your tomcat server
4. go to http://localhost:8081/products/products to view and use the application


## Requirements
- Eclipse as the IDE
- Apache Tomcat as the web server
- MySQL Connector for JDBC functionality
- Create an HTML page to take in a product ID
- Set up JDBC to work with the application
- Create a servlet that will take the product ID and use JDBC to query the database for the product
- If the product is found, the servlet will display the product details, otherwise it will show an error message
- Document the step-by-step process involved in completing this task