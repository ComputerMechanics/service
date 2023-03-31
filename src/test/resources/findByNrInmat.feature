Feature: correct car is displayed on calling find car by number plate
  Scenario: client makes call to GET /numar-inmatriculare?numar=B123ACS
    When the client calls /numar-inmatriculare?numar=B123ACS
    Then the client receives status code of 200
    And the client receives response {"id":"6425cf81a8077d68aab7e997","numarInmatriculare":"B123ACS","valabilitateParcare":"50","marca":"BMW","model":"X3","parcarePlatita":false}