When /^add border to '(.+)'$/ do |id|
  add_border_tag("div", "../image")
end

# position invariants
Then /^((element with (class|ID|tag) '(.+)')|(component '(.+)')) should( not)? ((be in the (left|right|top|bottom|vertical center|horizontal center|center))|(be (red|green|blue|yellow|black|white|[0-9A-Fa-f]{6}))|(exist)|(be (smaller than|larger than|equal to) (\d+) in (width|height|area)))$/ do |selector, elementSelector, elementSelectorType, elementSelectorValue, componentSelector, componentSelectorName, reversed, rule, positionRule, positionProperty, colorRule, colorProperty, existenceRule, sizeRule, sizeDirection, sizeDatum, sizeMetric|
  # initialize image directory
  invariantName=formatPath("#{selector} should#{reversed} #{rule}")
  baseDir="#{ImageBase}/#{invariantName}"
  if File.exists? baseDir
    FileUtils.rm_r baseDir
  end
  FileUtils.mkdir baseDir

  # declare jar arguments
  original="#{baseDir}/original.png"
  selector=nil
  type=nil
  property=nil
  result="#{ResultBase}/#{invariantName}"
  reversed_arg=reversed != nil ? "reversed" : ""

  # initialize selector
  if elementSelector != nil
    case elementSelectorType
    when "class" then add_border_class(elementSelectorValue, baseDir)
    when "ID" then add_border_id(elementSelectorValue, baseDir)
    when "tag" then add_border_tag(elementSelectorValue, baseDir)
    end
    selector="#{baseDir}/bordered"
  elsif componentSelector != nil
    expect(Dict[componentSelectorName]).not_to be nil
    save_screenshot "#{baseDir}/original.png"
    selector=Dict[componentSelectorName]
  else
    puts "selector error: #{selector}"
  end

  # initialize rule
  if positionRule != nil
    type="position"
    property=positionProperty
  elsif colorRule != nil
    type="color"
    property=colorProperty
  elsif existenceRule != nil
    type="existence"
    property=""
  elsif sizeRule != nil
    type="size"
    property="#{sizeDirection[0...sizeDirection.index(" ")]}, #{sizeDatum}, #{sizeMetric}"
  else
    puts "rule error: #{rule}"
  end

  # execute jar to check invariant
  result=`java -jar #{JarFile} "#{original}" "#{selector}" "#{type}" "#{property}" "#{result}" #{reversed_arg}`
  result=result.include?("VISL_passed") ? "passed" : "failed"
  if !Continue
    expect(result).to eq "passed"
  end
end

def formatPath(path)
  path.gsub(/"|\?|:|\\|\/|\*|<|>|\|| /,"_")
end