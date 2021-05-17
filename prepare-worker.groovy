node {
    withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master-key', keyFileVariable: 'SSH_KEY', passphraseVariable: '', usernameVariable: 'SSH_USERNAME')]) {
        stage('Install Prerequests'){
            sh " ssh -o StrictHostKeyChecking=no -i $SSH_KEY $SSH_USERNAME@167.172.147.52 'yum install epel-release -y' "
        }
        stage('Install Java'){
            sh " ssh -o StrictHostKeyChecking=no -i $SSH_KEY $SSH_USERNAME@167.172.147.52 'yum install java-1.8.0-openjdk-devel -y' "
        }
        stage('Install git'){
            sh " ssh -o StrictHostKeyChecking=no -i $SSH_KEY $SSH_USERNAME@167.172.147.52 'yum install git -y' "
        }
    }
}
