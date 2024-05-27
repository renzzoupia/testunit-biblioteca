pipeline {
	agent any
	tools {
	    maven 'MAVEN'
	    nodejs 'NodeJS'
	}
	
	stages {
	    stage('Preparation') {
    	   steps {
   	      		git 'https://github.com/renzzoupia/testunit-biblioteca.git'
   	       		echo 'Pulled from github successfully'
   	    	}
    	}
    	//Compila el codigo en formato ejecutable
	    stage('Compile the code to executable format'){
            steps{
                sh 'mvn clean compile'
                echo 'Convirtió el código legible por humanos a legible por máquina'
            }
        }
        //compila los test y los ejecuta
	    stage('Testing the code') {
    	   steps {
				sh 'mvn test'
			  	echo 'Unit Test successfully'
   	    	}
    	}
    	//Revisa la calidad de código
    	stage('Code review to check quality of code'){
            steps{
                sh 'mvn pmd:pmd'
                echo 'Code review done'
            }
        }
        //Revisa la calidad de código con SonarQube
        stage('Analysis SonarQube') {
           steps {
               	 sh 'mvn sonar:sonar -Dsonar.login=squ_226882aa0cf0b01435b2cf62114d44707ab4770b -Dsonar.projectKey=sqape -Dsonar.projectName="SQAPE BackEnd" -Dsonar.host.url=http://172.19.231.56:9000'
               	 echo 'SonarQube Code review done'
           }
        }
    	//Empaqueta el proyecto y lo dejará en taget/project-1.0-SNAPSHOT.jar
    	stage('Build') {
	       steps {
			   sh 'mvn package -DskipTests'
			   echo 'Packaging project'
			}
       	}

	}
}