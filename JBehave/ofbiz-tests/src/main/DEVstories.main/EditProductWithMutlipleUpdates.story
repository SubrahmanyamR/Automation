
Scenario: Multiple Edit Product in ofbiz

Given that I logged into ofbiz site
When I click "Add" link
Then I see Add Product
And I enter "NiteshTest#1" as "Name"
And I enter the supplier as "Crazy April Fool Experiences (APR)"
And I select "Experience" as "Product Type"
And I select "Bronze Voucher" as "Voucher Level"
And I enter the "Driving Experiences > Classic Car Hire" as "Primary Category"
And I type Rich text "A hydrophone is available for you to use to tune into whale songs" as "Description"
And I type "Oceanic nature tour" as the "summary"
And I type Rich text "dolphins, whales, sharks and the wandering albatross" as "Market Description"
And I type Rich text "waters off the coast of Sydney are teeming with wildlife" as "Print Description"
And I enter the "Manly" as "Location Description"
And I enter the "3" as "How many people"
And I click the "Venue"
And I click the "How to get there"
And I click the "Session Length"
And I click the "Guidelines"
And I click the "Dress Code"
And I click the "Other Info"
And I click the "Weather"
And I click the "Numbers on the day"
And I click the "Spectators"
And I click the "Cancellation Policy"
And I click the "Accessibility"
And I click save button
And I see Congratulations. You just added a new product

And I change the value of "Name" as "NiteshTest#2"
And I enter the supplier as "World Expeditions (WES)"
And I select "Experience" as "Product Type"
And I select "Bronze Voucher" as "Voucher Level"

And I enter the "Driving Experiences > Sports & Luxury Car Hire" as "Primary Category"
And I type Rich text "TestSpecialChars~!@#$%^&*()-+" as "Description"
And I type Rich text "dolphins, whales, sharks" as "Market Description"

And I type "Oceanic nature tour summary" as the "summary"
And I enter "South Australia" as "Location"
And I enter the "Neutral Bay" as "Location Description"
And I enter the "5" as "How many people"
And I click the "Venue"
And I click the "How to get there"
And I click the "Session Length"
And I click the "Guidelines"
And I click the "Dress Code"
And I click the "Other Info"
And I click the "Weather"
And I click the "Numbers on the day"
And I click the "Spectators"
And I click the "Cancellation Policy"
And I click the "Accessibility"
And I click save button
And I see Your changes have been recorded successfully
And I verify the value of "Name" as "NiteshTest#2"
And I verify the value of "Supplier" as "World Expeditions"
And I verify the dropdown value of "Product Type" as "Experience"
And I verify the dropdown value of "Voucher Level" as "Bronze Voucher"
And I must see the "Oceanic nature tour summary" as "summary"
And I verify the rich text value of "Market Description" as "dolphins, whales, sharks"
And I verify the rich text value of "Print Description" as "TestSpecialChars~!@#$%^&*()-+"
And I check the value "Location Description" as "Neutral Bay"
And I verify the value of "How many people" as "5"

And I change the value of "Name" as "NiteshTest#3"
And I enter the supplier as "Beautyworld (BTW)"
And I select "Gift Certificate" as "Product Type"
And I select "Gold Voucher" as "Voucher Level"

And I enter the "Getaways > Sightseeing & Touring" as "Primary Category"
And I type Rich text "Test Description" as "Description"
And I type "Test Summary" as the "summary"
And I type Rich text "Test Market Description" as "Market Description"
And I type Rich text "Test Print Description" as "Print Description"
And I enter "New South Wales" as "Location"
And I enter the "Bay" as "Location Description"
And I enter the "10" as "How many people"
And I click save button
And I see Your changes have been recorded successfully
And I verify the value of "Name" as "NiteshTest#3"
And I verify the value of "Supplier" as "Beautyworld"
And I verify the dropdown value of "Product Type" as "Gift Certificate"
And I verify the dropdown value of "Voucher Level" as "Gold Voucher"

And I must see the "Test Summary" as "summary"
And I verify the rich text value of "Market Description" as "Test Market Description"
And I verify the rich text value of "Print Description" as "Test Print Description"
And I check the value "Location Description" as "Bay"
And I verify the value of "How many people" as "10"

