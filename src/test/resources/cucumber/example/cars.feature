Feature: CarTest

  @test
  Scenario Outline: Note
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
    Then I make a note about '<Type>' type and '<Style>' style

    Examples:
      | Make      | Model     | Year | Type              | Style                       |
      | Acura     | CL        | 2003 | Type S (2 styles) | 2dr Cpe 3.2L Type S 6-Speed |
      | Chevrolet | Avalanche | 2013 | LS (2 styles)     | 2WD Crew Cab LS             |

  @test
  Scenario: Compare

    When I go to the site 'https://www.cars.com/'
    Then Main Page is open

    When I go to the Research page
    Then Research page is open

    When I go to the Compare Page
    Then Compare Page is open

    When I add the first model:
      | Make  | Acura                       |
      | Model | CL                          |
      | Year  | 2003                        |
      | Type  | Type S (2 styles)           |
      | Style | 2dr Cpe 3.2L Type S 6-Speed |

    Then First model appears:
      | Make  | Acura                       |
      | Model | CL                          |
      | Year  | 2003                        |
      | Type  | Type S (2 styles)           |
      | Style | 2dr Cpe 3.2L Type S 6-Speed |

    When I add the second model:
      | Make  | Chevrolet       |
      | Model | Avalanche       |
      | Year  | 2013            |
      | Type  | LS (2 styles)   |
      | Style | 2WD Crew Cab LS |

    Then Second model appears:
      | Make  | Chevrolet       |
      | Model | Avalanche       |
      | Year  | 2013            |
      | Type  | LS (2 styles)   |
      | Style | 2WD Crew Cab LS |
