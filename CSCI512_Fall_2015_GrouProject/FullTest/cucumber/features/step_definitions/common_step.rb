# encoding: UTF-8
# Contains all open page function and all reuseable function

Given /^open url "(.*)"$/ do |url|
	visit url
	
end

Given /^add border to "(.*)"$/ do |id|
	page.execute_script "
		var style=document.getElementById('#{id}').style;
		var borderColor=style.borderColor;
		if(borderColor!='') {
			if(borderColor!='red')
				style.borderColor='red';
			else
				style.borderColor='black';
		} else
			style.border='1px solid red';
	"
	step "save to \"../image/original.png\""
	page.execute_script "document.getElementById('#{id}').style.borderColor='yellow';"
	step "save to \"../image/border.png\""
end

Given /^save to "(.*)"$/ do |name|
	page.save_screenshot name
end

When /^fill "(.*)" to "(.*)"$/ do |content, place|
	fill_in place, :with => content
end

When /^click "(.*)" button$/ do |buttonName|
	click_button(buttonName)
end

When /^click "(.*)" link$/ do |linkName|
	click_link(linkName)
end

When /^accept alert$/ do
	page.driver.browser.switch_to.alert.accept
end

Then /^I should see "(.*)"$/ do |content|
	page.should have_content(content)
end

Then /^I should not see "(.*)"$/ do |content|
	page.should_not have_content(content)
end
