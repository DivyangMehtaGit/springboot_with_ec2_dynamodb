pipeline {
    agent any

    stages {
        stage ('Compile Stage') {
            steps {
                echo 'compiling start'
                withMaven(maven : 'maven_3.8.6') {
                    script {
                        if (isUnix()) {
                            sh "mvn clean compile"
                        }else {
                            bat "mvn clean compile"
                        }
                    }
                    echo 'compiling done'
                }
            }
        }

        stage ('Testing Stage') {
            steps {
                withMaven(maven : 'maven_3.8.6') {
                    script {
                        if (isUnix()) {
                         sh "mvn test"
                        }else {
                            bat "mvn test"
                        } 
                    }
                }
            }
        }


        // stage ('Deployment Stage') {
        //     steps {
        //         withMaven(maven : 'maven_3.8.6') {
        //             script {
        //                 if (isUnix()) {
        //                     sh "mvn deploy"
        //                 } else {
        //                     bat "mvn deploy"
        //                 } 
        //             }
        //         }
        //     }
        // }
    }
}
