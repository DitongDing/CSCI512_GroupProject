Given /^open url '(.+)'$/ do |url|
  visit url
end

When /^fill '(.+)' to '(.+)'$/ do |content, place|
  fill_in place, :with => content
end

When /^click '(.+)'$/ do |clickable|
  click_on(clickable)
  sleep 100
end

When /^accept alert$/ do
  page.driver.browser.switch_to.alert.accept
end

Then /^I should( not)? see '(.+)'$/ do |reversed, content|
  if reversed == nil
    expect(page).to have_content(content)
  else
    expect(page).to_not have_content(content)
  end
end