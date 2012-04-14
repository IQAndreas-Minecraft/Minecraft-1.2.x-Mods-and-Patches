#!/bin/bash
if [ $# -lt 1 ]; then
    echo "Command requires the project name."
elif [ ! -e $1 ]; then
    echo "Cannot find project $1."
else

    #Aliases for clarity
    projectName=$1 #relative
    
    mcpDir="/media/My_Book/Games/Minecraft/Modding/mcp62"
    
    if [ $2 == "-r" ]; then
        
        echo "WARNING: Problem with the code. Please recompile and reobfuscate manually."
        
        #recompile="$mcpDir/recompile.sh"
        #reobfuscate="$mcpDir/reobfuscate.sh"
        
        #Execute commands
        #$recompile
        #$reobfuscate
    fi
    
    reobfSrc="$mcpDir/reobf/*"
    tgtDir="$projectName/reobf"
    
    mkdir -p $tgtDir
    cp -r $reobfSrc $tgtDir
    
    echo "Successfully copied reobfuscated classes for $projectName."
fi
