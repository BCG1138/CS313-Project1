branches=("Server" "Client" "Gui")

git pull
git checkout main

for i in branches; do
  git checkout main
  git merge $(branches[i])
done

for i in branches; do
  git checkout main
  git branch $(branches[i])
done