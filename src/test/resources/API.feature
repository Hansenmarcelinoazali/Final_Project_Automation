@API
Feature: API

  @GetListofTags
  Scenario: Get List of Tags
    Given the API endppint  is "https://dummyapi.io/data/v1/tag"
    And header "app-id" with value "66353e8e83f17c4485d71495"
    Then http status response should be 200

  @GetUsersByID
  Scenario: Get Users By ID
    Given the API endpoint is "https://dummyapi.io/data/v1/user/"
    And header to get by id is "app-id" with value "66353e8e83f17c4485d71495"
    And get user with id  "60d0fe4f5311236168a109ca"
    Then data type should be same with json schema
    Then i should get http status code response 200 for get user by id

  @UpdateUsers
  Scenario: Update User By ID
    Given the API endpoint for update user is "https://dummyapi.io/data/v1/user/"
    And header to update user by id is "app-id" with value "66353e8e83f17c4485d71495"
    And i update first name to "Hansen" and last name "JayJay" for user with id "60d0fe4f5311236168a109ca"
    Then  i should get response 200 for update users

  @CreateUser
  Scenario: create User
    Given the API endpoint for create user is "https://dummyapi.io/data/v1/user/create"
    And header to create user by id is "app-id" with value "66353e8e83f17c4485d71495"
    And create user with json file
    Then i should get status code 200 for create data

    @DeleteUsers
    Scenario:
      Given the API endpoint for delete user data is "https://dummyapi.io/data/v1/user/"
      And header for delete is "app-id" with value "66353e8e83f17c4485d71495"
      And i delete user with id "60d0fe4f5311236168a109d2"
      Then i should get response 200 for delete date

