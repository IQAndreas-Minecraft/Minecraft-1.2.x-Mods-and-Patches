#!/bin/bash
if [ $# -lt 2 ]; then
    echo "Command requires the project name and the project version."
elif [ ! -e $1 ]; then
    echo "Cannot find project $1."
else

    createZipFile()
    {

		#aliases for clarity
		projectName=$1
		projectVersion=$2
		minecraftVersion=$3
		
		#Assume single player mod!
		reobfDir="$projectName/reobf/$minecraftVersion/*"
		includesFile="$projectName/includes"
		zipDir="$projectName/zip"
		zipName="$zipDir/$projectName-$projectVersion.zip"
		
		mkdir -p $zipDir    #Make sure the target folder exists
		rm -f $zipName      #Make sure zip file does not already exist
		
		installationFile="$projectName/INSTALLATION"
		licenseFile="$projectName/LICENSE"
		readmeFile="$projectName/README"
		
		#If said files are not found, default to files found in root directory
		if [ ! -e $installationFile ]; then   installationFile="INSTALLATION"; fi
		if [ ! -e $licenseFile ]; then        licenseFile="LICENSE"; fi
		if [ ! -e $readmeFile ]; then         readmeFile="README"; fi
		
		rm -f zip-temp
		mkdir -p zip-temp
		
		    # Include other mod files 
		    #   TODO: Give a warning in case any files are overridden
		    if [ -e $includesFile ]; then
		        exec<$includesFile
		        while read includedProject
		        do
		            if [ -e $includedProject ]; then
		                echo "Adding classes for $includedProject"
		                includedReobfDir="$includedProject/reobf/$minecraftVersion/*"
		                cp -r $includedReobfDir zip-temp
		            else
		                echo "Cannot find and include project $includedProject"
		            fi
		        done
		    fi
		
		    # Include help files
		    echo "Adding help files"
		    cp $installationFile zip-temp
		    cp $licenseFile zip-temp
		    cp $readmeFile zip-temp
		    
		    # Then include the actual mod classes
		    echo "Adding classes for $projectName"
		    cp -r $reobfDir zip-temp
		
		echo "Building zip file"
		zip -rj $zipName zip-temp/*
		rm -r zip-temp
		
		echo "Successfully created zip file $zipName"
	}
	
	clientSourceFiles="$1/src-files-minecraft"
	if [ -e $clientSourceFiles ]; then
		echo " === CLIENT ==="
		createZipFile $1 $2 minecraft
	fi
	
	serverSourceFiles="$1/src-files-minecraft_server"
	if [ -e $serverSourceFiles ]; then
		echo " === SERVER ==="
		createZipFile $1 $2-server minecraft_server
	fi
	
	
fi
