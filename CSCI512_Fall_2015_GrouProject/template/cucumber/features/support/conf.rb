# Please use '/' for all paths.

# test framework base directory
BaseDir="D:/Workspace/__GitLocalDatabase/CSCI512/CSCI512_Fall_2015_GrouProject/template"

# result directory path
ResultBase="#{BaseDir}/result"

# image base directory for class/id based visual invariants
ImageBase="#{BaseDir}/image"

# sub image directory for sikuli
SikuliBase="#{BaseDir}/sikuli"

# if continue when encounter fail
Continue=true

# if delete selector image
DeleteImage=true

Dict=Hash.new
# Add component definition here.
# Dict["name"]="full path"
Dict["search box"]="#{SikuliBase}/searchbox.png"
Dict["sign in button"]="#{SikuliBase}/signinbtn.png"

# jar file path. DO NOT CHANGE
JarFile="#{BaseDir}/jar/VISL-1.0.jar"