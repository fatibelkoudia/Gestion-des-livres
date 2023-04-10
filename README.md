# Application de Gestion des livres

Il s'agit d'une application web Java pour la gestion d'une bibliothèque. Elle utilise Servlets-JSP-Filters-MVC et nécessite une base de données MySQL avec un schéma spécifique et des utilisateurs requis pour l'authentification.

## Installation

1.  Créer une base de données MySQL en utilisant le fichier gr1Tp1Db.sql fourni situé dans le répertoire racine de ce projet.
2.  Exécuter le script SQL pour créer les utilisateurs requis pour l'authentification.
3.  Cloner ce dépôt sur votre machine locale.
4.  Importer le projet dans votre IDE préféré.
5.  Builder et lancer l'application sur votre machine locale.

## Utilisation

Une fois l'application en cours d'exécution, vous pouvez y accéder en naviguant vers [http://localhost:8080/gr1Tp1](http://localhost:8080/gr1Tp1) dans votre navigateur web.

L'application vous permet d'effectuer les tâches suivantes :

-   CRUD sur la liste des livres
-   Rechercher des livres par auteur, par date d’édition ou par titre.
-   CRUD sur la liste des auteurs.

L’accès à certaines ressources de l’applicationest géré par des rôles. Il y a deux rôles : Admin ou Visiteur. Le rôle « Admin » permet toute opération sur l’application alors que le rôle « Visiteur » ne permet à l’utilisateur que la consultation de la liste des livres.

## Crédits

Cette application a été créée par Fatima-ezzahra Belkoudia en tant que TP pour MST Informatique Décisionnelle.
Université Sultan Moulay Slimane Faculté Des Sciences Et Techniques Béni Mellal