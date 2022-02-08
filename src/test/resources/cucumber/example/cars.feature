Feature: CarTest

  @test
  Scenario Outline: First
    When I go to the site 'https://www.cars.com/'
    Then Main Page is open

    When I go to the Research page
    Then Research page is open

    When I search for a car according to such criteria:
      | Make  | <Make>  |
      | Model | <Model> |
      | Year  | <Year>  |
    Then '<Year> <Make> <Model>' will be found

    When I go to the trim comparison page
    Then '<Year> <Make> <Model>' trim comparison page is open

    When I want note down specifications the car
    Then I make a note

    Examples:
      | Make  | Model | Year |
      | Acura | CL    | 2003 |
