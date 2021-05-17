node {
    stage('Install Prerequests'){
        withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master-key', keyFileVariable: 'SSH_KEY', passphraseVariable: '', usernameVariable: 'SSH_USERNAME')]) {
            sh " ssh -o StrictHostKeyChecking=no -i $SSH_KEY $SSH_USERNAME@167.172.147.52 'yum install epel-release -y' "
        }
    }
}
