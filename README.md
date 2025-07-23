# IntelliJ IDEA Plugin for [Unison](https://www.unison-lang.org/)

Extended documentation on the build features such as packaging the artifact, uploading to a plugin marketplace, 
etc. is covered by the [sbt-idea-plugin](https://github.com/JetBrains/sbt-idea-plugin) readme

## Example plugin components

- `PopupDialogAction` creates an action under the "Tools" menu
- `SimpleCompletionContributor` adds the "HELLO" completion item to the values of the properties files
- `FileOpenedListener` shows a popup when a file is opened in the editor
- `ApplicationHelloService` and `ProjectHelloService` show examples of IJ platform service components
- `MyToolWindowFactory` creates a new ToolWindow at the bottom of the window
