pipeline{

    agent {
        label 'ubuntu'
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

            stage('deploy to ansible server'){

                steps{
                    script{

                        def warFile='target/mf.war'
                        def remoteUser='samra'
                        def remoteHost='192.168.59.111'
                        def remotePath='/home/samra/work'
                        def privateKey='/home/samra/.ssh/samra'

                       

                          sh "scp -i ${privateKey} ${warFile} ${remoteUser}@${remoteHost}:${remotePath}"
                      
                        

                          sh "ssh -i ${privateKey} ${remoteUser}@${remoteHost}"
                   

                    }

                }
            }





        }   

}