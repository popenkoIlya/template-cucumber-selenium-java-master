Feature: CarTest

  @test
    Scenario: First
    When I go to the site 'https://www.cars.com/'
    Then Main Page is open

    When I go to the Research page
    Then Research page is open

    When I search for a car according to such criteria:
      | Make  |  | Acura |
      | Model |  | CL    |
      | Year  |  | 2003  |
    Then '2003 Acura CL' will be found

    When I go to the '2003 Acura CL' trim comparison page

    Then '2003 Acura CL' trim comparison page is open

    When I go to the site 'https://www.cars.com/'
    Then Main Page is open

