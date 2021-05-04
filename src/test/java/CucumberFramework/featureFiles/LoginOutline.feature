Feature: login into account
  Existing user wants to login to account using different creadentials

  Scenario Outline: Login to account using a table of creadentials
    Given user navigates to expertest website
      And user fly over on the Espace abonné button
      And user clicks on the Mon compte button
      And user enters an "<email>" adress
      And user enters a "<password>"
     When user clicks on the Identification button
     Then user should receive a message "<message>"

    Examples: 
      | email         | password  | message                                                                                                                          |
      | aaa@gmail.com | soft.2019 | Déconnexion                                                                                                                      |
      | aaaaaaaaaaa   | soft.2019 | ERREUR : identifiant non valide. Mot de passe oublié ?                                                                           |
      | aaa@gmail.com | aaaaaa    | ERREUR : le mot de passe que vous avez saisi pour l’adresse e-mail saida.ayari.me@gmail.com est incorrect. Mot de passe oublié ? |
