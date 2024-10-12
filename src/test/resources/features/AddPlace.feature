Feature: Verify all api functionality with google api

  Scenario Outline: Verify user able to add new place through AddAPI
    Given User can add payloads "<name>" "<language>" "<address>"
    When User can call "AddPlace" with "POST" http method
    Then Api call call got success with status code is "OK"

    Examples: 
      | name          | language | address                          |
      | VinothKumar   | Tamil    | 1-64 Aruvizhimangalam Thiruvarur |
      | Sathish Kumar | French   | 29 Cross street freanse          |
