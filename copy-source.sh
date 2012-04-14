#!/bin/bash
if [ $# -ge 2 ]
then
    #Aliases for clarity
    projectName=$1 #relative
    
    mcpDir="/media/My_Book/Games/Minecraft/Modding/mcp62"
    targetDir="$projectName/src/minecraft/net/minecraft/src"
    mkdir -p $targetDir
    
    argNum=0
    for fileName in "$@"
    do
        argNum=`expr $argNum + 1` #Increment arg counter
        if [ $argNum -gt 1 ] #Ignore first two arguments
        then
            srcFile="$mcpDir/src/minecraft/net/minecraft/src/$fileName.java"
            targetFile="$targetDir/$fileName.java"
            cp -r $srcFile $targetFile
            echo $targetFile
        fi
    done
    
else
    echo "Command requires two or more parameters: project name, ... files."
fi
