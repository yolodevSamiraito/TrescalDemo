Exercice technique


Microservice de Gestion de Produits
Contexte : Vous travaillez pour une entreprise de commerce en ligne et on vous charge de développer un microservice pour gérer l'inventaire des produits.

Objectif : Construire un microservice en utilisant Spring Boot qui expose une API REST pour ajouter, supprimer, mettre à jour et récupérer des informations sur les produits.

Contraintes :

Configuration du projet :

Créez un projet Spring Boot avec les dépendances nécessaires (Spring Web, Spring Data JPA, H2 Database).

Définition du modèle de données :

Définissez une entité Produit avec les attributs suivants : id (clé primaire), nom, quantité en stock, et prix.

Création des API REST : Développez un contrôleur REST avec les endpoints nécessaire pour effectuer les opérations suivantes :
- Ajouter un nouveau produit.
- Récupérer la liste de tous les produits.
- Récupérer un produit spécifique par son ID.
- Mettre à jour un produit existant.
- Supprimer un produit >> sécuriser cette partie avec une authentification basic


Authentification utilisée
- user / password
- admin / admin
  
Acces point:  Http://localhost:8080/merchant
en utilisant postman:
- Get http://localhost:8080/merchant/fetchAllProducts
- Get http://localhost:8080/merchant/fetchById/{id}
- Post http://localhost:8080/merchant/addProduct
- Put http://localhost:8080/merchant/updateProduct
- Delete with basic auth http://localhost:8080/merchant/deleteProduct/{id}
