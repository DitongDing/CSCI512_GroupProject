# Please use '/' for all paths.

# test framework base directory
TestBaseDir="D:/Workspace/__GitLocalDatabase/CSCI512/CSCI512_Fall_2015_GrouProject/template"
# TestBaseDir="/Users/Ditong/Documents/Programming/__GitDatabase/CSCI512_GroupProject/CSCI512_Fall_2015_GrouProject/template"
# TestBaseDir="/home/std/Desktop/template"

# result directory path
ResultBase="#{TestBaseDir}/result"

# image base directory for class/id based visual invariants
ImageBase="#{TestBaseDir}/image"

# sub image directory for sikuli
SikuliBase="#{TestBaseDir}/sikuli_windows"
# SikuliBase="#{TestBaseDir}/sikuli_os_x"

# if continue when encounter fail
Continue=false

# if delete selector image
DeleteImage=true

Dict=Hash.new
# Add component definition here.
# Dict["name"]="full path"
Dict["bing tool bar"]="#{SikuliBase}/bingtoolbar.png"
Dict["G icon"]="#{SikuliBase}/G.png"
Dict["Google bottom"]="#{SikuliBase}/googlebottom.png"
Dict["search box"]="#{SikuliBase}/searchbox.png"
Dict["sign in button"]="#{SikuliBase}/signinbtn.png"
Dict["stackoverflow header"]="#{SikuliBase}/stackoverflowheader.png"
Dict["stackoverflow header tool bar"]="#{SikuliBase}/stackoverflowheadertoolbar.png"
Dict["stackoverflow icon"]="#{SikuliBase}/stackoverflowicon.png"
Dict["twitter icon"]="#{SikuliBase}/twittericon.png"

# jar file path. DO NOT CHANGE
JarFile="#{TestBaseDir}/jar/VISL-1.0.jar"

Before do
  if !File.exists? ImageBase
    FileUtils.mkdir ImageBase
  end
  if !File.exists? ResultBase
    FileUtils.mkdir ResultBase
  end
end

After do
  if DeleteImage
    FileUtils.rm_r ImageBase
  end
end