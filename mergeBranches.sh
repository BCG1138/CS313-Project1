git pull
git checkout main

git merge Client
git checkout main
git merge Gui
git checkout main
git merge Server
git checkout main

echo "all branches merged"

git branch Client
git checkout main
git branch Gui
git checkout main
git branch Server
git checkout main

echo "all branches reinstated"