Given /^open url '(.+)'$/ do |url|
  visit url
end

When /^fill '(.+)' to '(.+)'$/ do |content, place|
  fill_in place, :with => content
end

When /^click '(.+)' button$/ do |buttonName|
  click_button(buttonName)
end

When /^click '(.+)' link$/ do |linkName|
  click_link(linkName)
end

When /^accept alert$/ do
  page.driver.browser.switch_to.alert.accept
end

Then /^I should see '(.+)'$/ do |content|
  page.should have_content(content)
end

Then /^I should not see '(.+)'$/ do |content|
  page.should_not have_content(content)
end
