Feature: Sample feature for using test framework

Scenario: Position invariants
	Given open url 'http://www.google.com'
	Then component 'search box' should be in the horizontal center
	Then element with class 'jsb' should be in the horizontal center
	Then element with class 'jsb' should not be in the vertical center
	Then component 'sign in button' should be in the right
	Then component 'Google bottom' should be in the bottom
	Given open url 'http://stackoverflow.com/'
	Then component 'stackoverflow header' should be in the top
	
	### the following will fail
	# Given open url 'http://www.google.com'
	# Then element with tag 'input' should be in the left
	# Then element with tag 'div' should be in the center

Scenario: Color invariants
	Given open url 'http://stackoverflow.com/'
	Then component 'stackoverflow header tool bar' should be black
	Then component 'stackoverflow header tool bar' should not be white
	Then component 'stackoverflow header tool bar' should not be fFfFfF
	
	### the following will fail
	# Then component 'stackoverflow header tool bar' should be FFa223

Scenario: Existence invariants
	Given open url 'http://www.google.com'
	Then element with tag 'input' should exist
	Then element with ID 'DLL' should not exist
	
Scenario: Size invariants
	Given open url 'http://www.google.com'
	Then component 'sign in button' should not be larger than 120 in height
	Then component 'sign in button' should be larger than 10 in width
	Then component 'sign in button' should be equal to 2695 in area
	
	### the following will fail
	# Then component 'sign in button' should be smaller than 10 in area