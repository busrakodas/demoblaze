Feature:

  Scenario: get available and assert expected result
      Given send the get request
      Then status code should be 200
      And deserialize response data to java
      Then validates actual result

  Scenario Outline: Post a new available pet to the store. Assert new pet added.
      Given set the necessary path params
      And set the expected data <id>, <categoryId>, "<categoryName>", "<name>", "<status>"
      When send the post request
      Then validate that new pet added

    Examples:
      | id | categoryId | categoryName | name | status |
      | 1600 | 1550 | dog | pet | available |

  Scenario Outline: Update this pet status to "sold". Assert status updated.
      Given set the necessary path params
      And set the expected data <id>, <categoryId>, "<categoryName>", "<name>", "<status>"
      When send the put request
      Then validate that the status is updated

    Examples:
      | id | categoryId | categoryName | name | status |
      | 1600 | 1550 | dog | pet | sold |

  Scenario: Delete this pet. Assert deletion.
      Given set the necessary path params for id 1600
      When send the delete request
      Then validate that the pet is deleted for id "1600"



