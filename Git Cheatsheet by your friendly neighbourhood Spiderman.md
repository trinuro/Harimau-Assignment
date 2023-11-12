# Commit a change in Git

1. To learn about current status (for example, is there a chance that is not committed yet?) 
```sh
git status
```
2. To flag a file for committing (usually for new files that were not there),
```sh
git add <file-name>
```
3. To save your changes in local repo,
```sh
git commit -m "commit message"
```
4. To save changes in remote repo, like GitHub
```sh
git push origin main
git push -u origin main
# set origin main as default
```
`origin` refers to the the remote repo we want to push to while `main` refers to the branch we want to push to
5. To download changes from remote repo, 
```sh
git pull origin <branch-name>
```
6. To initialise Git repository in local directory,
```shell
git init
```
7. To connect a local directory to a remote directory (initially),
```sh
git remote add origin <remote-uri>
```
8. To check which remote server a directory is connected to,
```sh
git remote -v
```

# Git Branch Navigation

1. To view all branches,
```sh
git branch
```
Current branch is denoted by `*`
2. To change branch,
```sh
git switch <branch-name>
```
