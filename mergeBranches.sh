branches = ("Server" "Client" "Gui")

git pull
git checkout main

for i in {0..2}; do
  git checkout main
  git merge $(branches[i])
done

for i in {0..2}; do
  git checkout main
  git branche $(branches[i])
done