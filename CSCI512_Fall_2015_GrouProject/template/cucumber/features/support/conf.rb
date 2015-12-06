# Please use '/' for all paths.

# test framework base directory
TestBaseDir="D:/Workspace/__GitLocalDatabase/CSCI512/CSCI512_Fall_2015_GrouProject/template"

# result directory path
ResultBase="#{TestBaseDir}/result"

# image base directory for class/id based visual invariants
ImageBase="#{TestBaseDir}/image"

# sub image directory for sikuli
SikuliBase="#{TestBaseDir}/sikuli"

# if continue when encounter fail
Continue=false

# if delete selector image
DeleteImage=true

Dict=Hash.new
# Add component definition here.
# Dict["name"]="full path"
Dict["search box"]="#{SikuliBase}/searchbox.png"
Dict["sign in button"]="#{SikuliBase}/signinbtn.png"

# jar file path. DO NOT CHANGE
JarFile="#{TestBaseDir}/jar/VISL-1.0.jar"

Before do
  if !File.exists? ImageBase
    FileUtils.mkdir ImageBase
  end
end

After do
  if DeleteImage
    FileUtils.rm_r ImageBase
  end
end