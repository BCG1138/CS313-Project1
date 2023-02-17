git pull
git checkout main
git pull

git merge Client
git checkout main
git merge Gui
git checkout main
git merge Server
git checkout main

echo "all branches merged"

git branch --delete Client
git branch --delete Gui
git branch --delete Server

echo "all brancher deleted"

git branch Client
git checkout main
git branch Gui
git checkout main
git branch Server
git checkout main
git push -u origin main
echo "all branches reinstated"

