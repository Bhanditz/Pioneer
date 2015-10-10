# How we work
We work with feature branches ([read it up](https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow/)), this means that we solely add changes by creating seperate branches.

To start a new branch

``` bash
git checkout master # Go to master branch
git pull # Pull last changes

git checkout -b ivh_my_feature_branch # Create feature branch with your own initials (in this case Ives van Hoorne)

#--Make your changes + commits--

git push
```
After you're done making changes, create a pull request using Github. You cannot merge the branch into master yourself until you've received a LGTM (Looks Good To Me) from someone else in the comments.


PS: Try to use this: https://github.com/reenhanced/gitreflow, makes life much easier.
