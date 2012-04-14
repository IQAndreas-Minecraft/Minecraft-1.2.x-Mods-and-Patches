#!/bin/bash
if [ $# -lt 2 ]; then
    echo "Command requires the project name and the project version."
elif [ ! -e $1 ]; then
    echo "Cannot find project $1."
else
    #aliases for clarity
    projectName=$1
    projectVersion=$2
    
    #Assume single player mod!
    reobfDir="$projectName/reobf/minecraft/*"
    zipDir="$projectName/zip"
    zipName="$zipDir/$projectName-$projectVersion.zip"
    
    mkdir -p $zipDir    #Make sure the target folder exists
    rm $zipName         #Make sure zip file does not already exist
    
    installationFile="$projectName/INSTALLATION"
    licenseFile="$projectName/LICENSE"
    readmeFile="$projectName/README"
    
    #If said files are not found, default to files found in root directory
    if [ ! -e $installationFile ]; then   installationFile="INSTALLATION"; fi
    if [ ! -e $licenseFile ]; then        licenseFile="LICENSE"; fi
    if [ ! -e $readmeFile ]; then         readmeFile="README"; fi
    
    mkdir -p zip-temp
        cp -r $reobfDir zip-temp
        cp $installationFile zip-temp
        cp $licenseFile zip-temp
        cp $readmeFile zip-temp
        zip -rj $zipName zip-temp/*
    rm -r zip-temp
    
    echo "Successfully created zip file $zipName"
fi
