# Pioneer
The start of a top-down survival RPG.

For developers: [Read up on how to contribute](DEV.md)

[Slack](https://pioneergame.slack.com)
[Trello](https://trello.com/pioneer19)

## Managing Pioneer

Start sbt in project root:

    $ sbt
Run the desktop project:
```
> desktop/run
Package the desktop project into single jar:

> assembly
Create Android package in debug mode:

> android:package-debug
Visit android-sdk-plugin for a more in-depth guide to android configuration and usage.
```

### Using with popular IDEs

In most cases you will be able to open and edit each sub-project (like common, android or desktop), but you still need to use SBT to build the project.

See [here](https://github.com/ajhager/libgdx-sbt-project.g8/wiki/IDE-Plugins) for details about sbt plugins for each editor.
