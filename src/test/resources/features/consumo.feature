Feature: Consumir Agregacion single para motores

  @motores
  Scenario Outline: Consumir Agregacion para motores persona natural
    Given Se cargan los datos necesarios
      | dataSources  | dataSourcesPayload  |key  |value  |
      | <dataSources>| <dataSourcesPayload>|<key>|<value>|
    When Se envian el Post
    Then Se valida el Schema y el status code 201

    Examples:

      | dataSources  | dataSourcesPayload  |key  |value  |
    ##@externaldata@./src/test/resources/data/Prueba.xlsx@Sheet1@
   |IntCreditBureau   |   |ExtCreditBureau   |{"lastName":"Garcia","officeId":"9281"}|
   |ExtCreditBureau   |   |   ||

  
  


