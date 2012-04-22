#!/bin/bash
if [ $# -lt 2 ]; then
    echo "Command requires the project name and a version string."
elif [ ! -e $1 ]; then
    echo "Cannot find project $1."
else

    #Aliases for clarity
    projectName=$1 #relative
    projectVersion=$2
    
    ./copy-source.sh $projectName
    ./copy-reobf.sh $projectName -r
    ./create-zip.sh $projectName $projectVersion
    
fi
