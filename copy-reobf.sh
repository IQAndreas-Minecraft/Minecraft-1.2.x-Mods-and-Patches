#!/bin/bash
if [ $# -lt 1 ]; then
    echo "Command requires the project name."
elif [ ! -e $1 ]; then
    echo "Cannot find project $1."
else

    #Aliases for clarity
    projectName=$1 #relative
    
    mcpDir="/media/My_Book/Games/Minecraft/Modding/mcp62"
    curDir="/media/My_Book/Programming/GIT/Projects/Minecraft-Mods-and-Patches"
    
    #if [ $2 == "-r" ]; then
    if [ $# -ge 2 ]; then #just check for ANYTHING in parameter 2 as a temporary fix
        echo "Recompiling and reobfuscating source"
        cd $mcpDir
        #$mcpDir/recompile.sh
        #$mcpDir/reobfuscate.sh
        
        #Switch back to the repository directory
        cd $curDir
    fi
    
    reobfSrc="$mcpDir/reobf/*"
    tgtDir="$projectName/reobf"
    
    mkdir -p $tgtDir
    cp -r $reobfSrc $tgtDir
    
    echo "Successfully copied reobfuscated classes for $projectName."
fi
