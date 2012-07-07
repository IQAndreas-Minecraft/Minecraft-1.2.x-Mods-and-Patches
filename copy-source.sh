#!/bin/bash
if [ $# -lt 1 ]; then
    echo "Command requires a project name parameter."
elif [ ! -e $1 ]; then
    echo "Cannot find project $1."
else
    #Aliases for clarity
    projectName=$1 #relative
    
    copySourceFiles()
    {
        # Dictates whether minecraft single player or multi-player (or even other)
        version=$1

        # NOTE: Make sure to create a link to the MCP directory in the current one
        mcpDir="MCP"

        # By default, all classes should be in the package "net.minecraft.src.*"        
        #mcpSrcDir="$mcpDir/src/$version"
        #targetSrcDir="$projectName/src/$version"

        mcpSrcDir="$mcpDir/src/$version/net/minecraft/src"
        targetSrcDir="$projectName/src/$version/net/minecraft/src"
        srcFileList="$projectName/src-files-$version"
        
        #Ignore if the 'src-files' file does not exist
        if [ ! -e $srcFileList ]; then 
            echo "Skipping source for $version"
        else
        
            echo "Copying source for $version"
        
            # Should I also delete the existing source?
            mkdir -p $targetSrcDir
            
            exec<$srcFileList
            while read fileName
            do
                srcFile="$mcpSrcDir/$fileName.java"
                if [ -e $srcFile ]; then
                    targetFile="$targetSrcDir/$fileName.java"
                    cp -r $srcFile $targetFile
                    echo "   Copying $fileName.java"
                else
                    echo "ERROR: Could not find $fileName.java."
                fi
            done
            
        fi
    }
    
    # Single player
    copySourceFiles 'minecraft' 
    
    # Multi-player
    copySourceFiles 'minecraft_server'
    
fi
