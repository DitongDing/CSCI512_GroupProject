Given /^add border to '(.+)'$/ do |id|
  page.execute_script "
     style=document.getElementById('#{id}').style;
     borderColor=style.borderColor;
  "
  page.execute_script "
    if(borderColor!='') {
      if(borderColor!='red')
        style.borderColor='red';
      else
        style.borderColor='black';
    } else
      style.border='1px solid red';
  "
  save_screenshot '../image/original.png'
  page.execute_script "style.borderColor='yellow';"
  save_screenshot '../image/border.png'
end

def add_border_class(classname, basedir)
end

def add_border_id(id, basedir)
end

def add_border_tag(tagname, basedir)
end

def add_original_color
  page.execute_script "
      if(borderColor!='') {
        if(borderColor!='red')
          style.borderColor='red';
        else
          style.borderColor='black';
      } if(borderColor=='')
        style.border='1px solid black';
    "
end

def save_screenshot(filename)
  page.save_screenshot filename
end