pipeline {
    agent any
    stages {
        stage('Test'){
    	    steps {
    	        sh 'mvn clean install test'
    	    }
    	    post {
    	        always {
    	            junit 'target/surefire-reports/*xml'
    	        }

    	    }

    	}
    }


}