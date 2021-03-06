def add_border_class(classname, basedir)
  `mkdir "#{basedir}/bordered"`
  page.execute_script "
    elements=document.getElementsByClassName('#{classname}');
  "
  add_border basedir
end

def add_border_id(id, basedir)
  `mkdir "#{basedir}/bordered"`
  page.execute_script "
    elements=new Array();
    element = document.getElementById('#{id}');
    if(element != null)
      elements.push(element);
  "
  add_border basedir
end

def add_border_tag(tagname, basedir)
  `mkdir "#{basedir}/bordered"`
  page.execute_script "
    elements=document.getElementsByTagName('#{tagname}');
  "
  add_border basedir
end

def add_border(basedir)
  length=page.evaluate_script("elements.length")
  originalBorder=Array.new

  for index in 0...length do
    page.execute_script "
      style=elements[#{index}].style;
      borderColor=style.borderColor;
    "
    originalBorder << page.evaluate_script("style.border")
    original_color
  end
  save_screenshot "#{basedir}/original.png"

  for index in 0...length do
    page.execute_script "
      style=elements[#{index}].style;
    "
    bordered_color
    save_screenshot "#{basedir}/bordered/bordered_#{index}.png"
    original_color
  end

  for index in 0...length do
    page.execute_script "
      elements[#{index}].style.border='#{originalBorder[index]}';
    "
  end
end

def original_color
  page.execute_script "
    if(borderColor=='')
      style.border='1px solid white';
    else if(borderColor=='black')
      style.borderColor='white';
  "
end

def bordered_color
  page.execute_script "
    style.borderColor='black';
  "
end