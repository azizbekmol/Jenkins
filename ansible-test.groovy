node {
    withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master-key', keyFileVariable: 'SSH_KEY', passphraseVariable: '', usernameVariable: 'SSH_USERNAME')]) {
        stage('Install Prerequests'){
            sh """
                export ANSIBLE_HOST_KEY_CHECKING=False
                ansible-playbook -i \"157.230.14.40,\" --private-key $SSH_KEY -u $SSH_USERNAME -b test.yml
            """
        }
    }
}

