Feature: Como usuario deseo consumir los servicios de banco de bogota

  @Getcities
  Scenario: Como usuario deseo consultar las diferentes ciudades disponibles
    Given El usuario desea consultar las ciudades disponibles
    When El usuario consulta
    Then El servicio debara responder con un status code 200

  @Getkey
  Scenario: Como usuario deseo consultar clave segura
    Given El usuario envia la peticion
    When El usuario ve el response 200
    Then valida el schema


