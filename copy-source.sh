#!/bin/bash
if [ $# -lt 2 ]; then
    echo "Command requires two or more parameters: project name, ... files."
elif [ ! -e $1 ]; then
    echo "Cannot find project $1."
else
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
            #Assume all files are in the package `net.minecraft.src.*` (as most of them are)
            srcFile="$mcpDir/src/minecraft/net/minecraft/src/$fileName.java"
            if [ -e $srcFile ]; then
                targetFile="$targetDir/$fileName.java"
                cp -r $srcFile $targetFile
                echo "Copying $fileName.java"
            else
                echo "ERROR: Could not find $fileName.java."
            fi
        fi
    done
fi
