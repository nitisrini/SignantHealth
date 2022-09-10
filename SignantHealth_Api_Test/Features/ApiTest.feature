Feature: Feature file for user registration, user information retreival and updation

    Background: Register new user
        Given Set header for Content-Type with application/json value
        And Set the url with Users api
        When Make POST call and retrieve response
        Then Validate status code as 201
        And Validate the value for message as Created in response
        Given Set the url with Token api
        And Set basic authentication with username and password
        When Make GET call and retrieve response
        Then Validate status code as 200
        And Validate the value for status as SUCCESS in response
        And Get token from response

    Scenario: Review user registered in system
        Given Set the url with Users api
        And Set token in header
        And Set no authentication
        When Make GET call and retrieve response
        Then Validate status code as 200
        And Validate the value for status as SUCCESS in response
        And Validate the username in response list

    Scenario: Get personal information of user and validate
        Given Set the url with Users api
        And Update the url with path parameter username
        And Set token in header
        And Set no authentication
        When Make GET call and retrieve response
        Then Validate status code as 200
        And Validate the user value for firstname as random in response
        And Validate the user value for lastname as random in response
        And Validate the user value for phone as random in response

    @update_user
    Scenario: Update user details and validate them
        Given Set header for Content-Type with application/json value
        And Set the url with Users api
        And Update the url with path parameter username
        And Set token in header
        And Set no authentication
        When Make PUT call and retrieve response
        Then Validate status code as 201
        And Validate the value for message as Updated in response
        When Make GET call and retrieve response
        Then Validate status code as 200
        And Validate the user value for firstname as updated in response
        And Validate the user value for lastname as updated in response
        And Validate the user value for phone as updated in response