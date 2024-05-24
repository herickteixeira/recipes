# Recipes Application
This is a Spring Boot application for managing recipes. It allows users to add, edit, and view recipes, search for recipes by ingredients and categories, and add user reviews. The application uses MongoDB for data storage and Redis for caching.
# Prerequisites
Before getting started, make sure you have the following installed in your development environment:

* Java JDK 17
* Maven
* Docker
* MongoDB
* Redis
  
# Installation and Execution
1. Clone the repository:
```bash
git clone https://github.com/your-username/recipes-redis-clean-arch.git
```
Or download and extract the project manually.

2. Navigate to the project directory:
```bash
cd recipes
```
3. Run the project using Maven:
```bash
mvn spring-boot:run
```
The application will start and be accessible at http://localhost:8080.

# API Endpoints
The application exposes the following endpoints:

* POST /api/recipes: Add a new recipe.
  * Request Body:
```json
        {
          "name": "Spaghetti Carbonara",
          "description": "A classic Italian pasta dish.",
          "ingredients": [
              "spaghetti",
              "eggs",
              "parmesan cheese",
              "bacon"
          ],
          "instructions": "Boil the spaghetti. Fry the bacon. Mix eggs with cheese. Combine everything.",
          "category": "Italian",
          "reviews": [
              {
                  "user": "john_doe",
                  "rating": 5,
                  "comment": "Delicious!"
              }
          ]
      }
```
  * Response: 201 Created

* GET /api/recipes: Get all recipes.
  * Response: 200 OK, List of Recipe JSON objects

* GET /api/recipes/{id}: Get a recipe by ID.
  * Path Variable: id (String)
  * Response: 200 OK, Recipe JSON object

* DELETE /api/recipes/{id}: Delete a recipe by ID.
  * Path Variable: id (String)
  * Response: 200 OK

* GET /api/recipes/ingredients: Search recipes by ingredient.
  * Request Parameter: ingredient (String)
  * Response: 200 OK, List of Recipe JSON objects

* GET /api/recipes/categories: Search recipes by category.
  * Request Parameter: category (String)
  * Response: 200 OK, List of Recipe JSON objects

# Configuration
The application's settings can be found in the application.properties file. Make sure to configure the properties related to Redis and the database according to your environment.
```yml
spring:
  application:
    name: recipes
```

# Contributing
If you wish to contribute to this project, follow these steps:

1. Fork the project.
2. Create a branch for your feature: git checkout -b feature-new-feature.
3. Make your changes and commit them: git commit -m 'Add a new feature'.
4. Push to the branch: git push origin feature-new-feature.
5. Submit a pull request.
