#!/bin/bash
if [ $# -lt 1 ]; then
    echo "Command requires the project name."
elif [ ! -e $1 ]; then
    echo "Cannot find project $1."
else

    #Aliases for clarity
    projectName=$1 #relative
    
    # NOTE: Make sure to create a link to the MCP directory in the current one
    mcpDir="MCP"
    
    # Save the current directory so we can switch back to it later
    curDir=`pwd`
    
    #if [ $2 == "-r" ]; then
    if [ $# -ge 2 ]; then #just check for ANYTHING in parameter 2 as a temporary fix
        echo "Recompiling and reobfuscating source"
        cd $mcpDir
        $mcpDir/recompile.sh
        $mcpDir/reobfuscate.sh
        
        #Switch back to the repository directory
        cd $curDir
    fi
    
    reobfSrc="$mcpDir/reobf/*"
    tgtDir="$projectName/reobf"
    
    mkdir -p $tgtDir
    cp -r $reobfSrc $tgtDir
    
    echo "Successfully copied reobfuscated classes for $projectName."
fi
