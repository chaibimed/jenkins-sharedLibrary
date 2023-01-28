def call(){
    pipeline {
        agent any
        environment {
            MODULE='m4'
        }
        
        stages {
            stage('Test'){
                steps {
                    echo 'this is a fake test..****'
                }
            }
            stage('Verify'){
                steps {
                       sh '''
                          git --version
                          docker --version
                          dotnet --list-sdks
                        '''
                }
            }
        }
    }
}
