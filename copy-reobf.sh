#!/bin/bash
if [ $# == 1 ]
then
    #Aliases for clarity
    projectName=$1 #relative
    
    mcpDir="/media/My_Book/Games/Minecraft/Modding/mcp62"
    
    if [ $2 -eq "-r" ]
    then
        recompile="$mcpDir/recompile.sh"
        reobfuscate="$mcpDir/reobfuscate.sh"
        
        $recompile
        $reobfuscate
    fi
    
    reobfSrc="$mcpDir/reobf/*"
    tgtDir="$projectName/reobf"
    
    mkdir -p $tgtDir
    cp -r $reobfSrc $tgtDir
else
    echo "Command requires the project name."
fi
