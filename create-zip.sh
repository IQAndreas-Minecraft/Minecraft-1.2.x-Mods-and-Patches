#!/bin/bash
if [ "$#" == 2 ]
then
    
    #aliases for clarity
    projectName=$1
    projectVersion=$2
    
    #Assume single player mod!
    reobfDir="$projectDir/reobf/minecraft/*"
    zipDir="$projectName/zip"
    zipName="$zipDir/$projectName-$projectVersion.zip"
    
    mkdir -p $zipDir    #Make sure the target folder exists
    rm $zipName         #Make sure zip file does not already exist
    
    mkdir -p zip-temp
        cp -r $reobfDir zip-temp
        cp "$projectName/INSTALLATION" zip-temp
        cp "$projectName/LICENSE" zip-temp
        cp "$projectName/README" zip-temp
        zip -r $zipName zip-temp/*
    rm -r zip-temp
    
else
    echo "Command requires the project name and the project version."
fi
