pipeline{

    agent any {
        label 'windows'
    }

    environment {

        JAVA_HOME='C:\Program Files\Java\jdk-17'
        MAVEN_HOME='D:\software\apache-maven-3.8.6-bin\apache-maven-3.8.6'
        PATH=${JAVA_HOME}\\bin;${MAVEN_HOME}\\bin;${env.PATH}

    }
        stages{
            stage('checkout'){

                steps {

                    git url: 'https://github.com/Samraj10/mf.git', branch: 'master'

                }

            }
            stage('build'){

                steps {

                    bat 'mvn clean package'
                }
            }
            stage('test'){

                steps {

                    bat 'mvn test'
                }

            }
        }   

}