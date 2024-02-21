# Weather_App

Contexte du projet En tant que développeur back-end, vous devez créer
une application java console permettant aux utilisateurs de consulter
les prévisions météorologiques actuelles et passées pour différentes
villes. L\'application comprendra deux principales classes : Menu, City
et CityHistory.

​

\*\*Classe City (ville)

sera responsable de stocker les informations actuelles de la météo pour
une ville donnée.

Les fonctionnalités de cette classe incluent :

​

Attributs :

1 \--cityId : Identifiant unique pour la ville. 2 ​ 3 \--cityName : Nom
de la ville. 4 ​ 5 \--currentTemperature : Température actuelle. 6 ​ 7
\--currentHumidity : Taux d\'humidité actuelle. 8 ​ 9
\--currentWindSpeed : Vitesse du vent actuelle. ​

Méthodes : \*\*Création d\'un Enregistrement ville: Cette méthode
permettra d\'ajouter un nouvel enregistrement ville dans la base de
données en utilisant JDBC.

​

\*\*Lecture des villes : Cette méthode récupérera les enregistrements ou
bien un enregistrement ville spécifique à partir de la base de données
en utilisant JDBC.

​

\*\*Mise à Jour d\'un Enregistrement ville: Permettra de mettre à jour
les détails d\'un enregistrement ville existant dans la base de données
en utilisant JDBC.

​

\*\*Suppression d\'un Enregistrement ville: Cette méthode sera utilisée
pour supprimer un enregistrement ville spécifique de la base de données
en utilisant JDBC.

​

​

\*\*Classe CityHistory (ville histrorique)

sera responsable de stocker l\'historique des données météorologiques
pour une ville donnée.

Les fonctionnalités de cette classe incluent :

​

Attributs :

1 \--historicalDataId : Identifiant unique pour les données historiques.
2 ​ 3 \--cityId : Identifiant de la ville associée. 4 ​ 5 \--eventDate :
Date de l\'événement météorologique historique. 6 ​ 7 \--temperature :
Température historique. ​

​

Méthodes : \*\*Création d\'un Enregistrement Historique : Cette méthode
permettra d\'ajouter un nouvel enregistrement historique dans la base de
données en utilisant JDBC.

​

\*\*Lecture de l\'Historique :Cette méthode récupérera l\'historique
complet d\'une ville à partir de la base de données en utilisant JDBC.

​

\*\*Mise à Jour d\'un Enregistrement Historique : Permettra de mettre à
jour les détails d\'un enregistrement historique existant dans la base
de données en utilisant JDBC.

​

\*\*Suppression d\'un Enregistrement Historique : Cette méthode sera
utilisée pour supprimer un enregistrement historique spécifique de la
base de données en utilisant JDBC.

​

​

\*\*Class Menu

L\'application comprendra une interface utilisateur conviviale
permettant aux utilisateurs de :

\--Rechercher et sélectionner une ville spécifique. Afficher les
prévisions météorologiques actuelles pour la ville sélectionnée. Accéder
à l\'historique météorologique pour la ville sélectionnée.

​

\*\*Connexion à la Base de Données Utilisation de MySQL avec JDBC :

\--Les données météorologiques actuelles et historiques seront stockées
dans une base de données MySQL. Utilisation de JDBC (Java Database
Connectivity) pour établir la connexion entre l\'application et la base
de données.

​

​

\*\*Bonus :

\--la création des deux autres diagrammes UML (séquence + cas
d\'utilisation).

​

​

\*\*Remarques\*\* :

\-- il faut utiliser StreamAPI pour les manipulations des listes.

\-- il faut utiliser l\'encapsulation pour les deux classes.

\--Assurez-vous que le menu est intuitif et facilite la navigation dans
l\'application.

