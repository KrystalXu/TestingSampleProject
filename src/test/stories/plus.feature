Feature:  plus algorithm

Scenario: plus

Given I have a plus calculator with existed number 3
When plus "5"
Then I will get "8"

Given I have a plus calculator with existed number 3
When plus "6"
Then I will get "9" 