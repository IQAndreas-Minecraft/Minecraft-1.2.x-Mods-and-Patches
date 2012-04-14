#!/bin/bash
if [ $# -lt 1 ]; then
    echo "Command requires a project name parameter."
elif [ ! -e $1 ]; then
    echo "Cannot find project $1."
else
    #Aliases for clarity
    projectName=$1 #relative
    
    mcpDir="/media/My_Book/Games/Minecraft/Modding/mcp62"
    #mcpSrcDir="$mcpDir/src/minecraft"
    #targetSrcDir="$projectName/src/minecraft"
    mcpSrcDir="$mcpDir/src/minecraft/net/minecraft/src"
    targetSrcDir="$projectName/src/minecraft/net/minecraft/src"
    
    #Should I also delete the existing source?
    mkdir -p $targetSrcDir
    
    srcFileList="$projectName/src/src-files-minecraft"
    #srcFileList="$projectName/src/src-files-minecraft-server"
    
    exec<$srcFileList
    while read fileName
    do
        srcFile="$mcpSrcDir/$fileName.java"
        if [ -e $srcFile ]; then
            targetFile="$targetSrcDir/$fileName.java"
            cp -r $srcFile $targetFile
            echo "Copying $fileName.java"
        else
            echo "ERROR: Could not find $fileName.java."
        fi
    done
fi
