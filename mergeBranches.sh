branches=("Server" "Client" "Gui")

git pull
git checkout main

for i in $(branches[@]); do
  git checkout main
  git merge ${i}
done
echo "all branches merged"
for i in $(branches[@]); do
  git checkout main
  git branch ${i}
done
echo "all branches reinstated"