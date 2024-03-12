folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools')
}

freeStyleJob('/Tools/clone-repository') {
    displayName('clone-repository')

    parameters {
        stringParam('GIT_REPOSITORY_URL', '', 'Git URL of the repository to clone')
    }
    steps {
        shell("git clone \${GIT_REPOSITORY_URL} .")
    }
    wrappers {
        preBuildCleanup {
            preBuildCleanup()
        }
    }
}
