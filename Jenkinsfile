pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        build(job: 'abc', wait: true)
        mail(subject: 'test-joker', body: '20230524', to: '547402844@qq.com')
      }
    }

    stage('git') {
      steps {
        git(url: 'git@github.com:jokerRens/Joker-cloudLin.git', branch: 'master', changelog: true, credentialsId: '213', poll: true)
      }
    }

    stage('end') {
      steps {
        sleep(time: 5000, unit: 'SECONDS')
      }
    }

  }
}