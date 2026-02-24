# Development notes

## Run fast tests

```shell
sbt 'testOnly intellij.unison.LexerTokenTest'
```

## Running locally

Thanks to [sbt-idea-plugin](https://github.com/JetBrains/sbt-idea-plugin) you can run separate instance of IntelliJ IDEA with this plugin installed:

```shell
sbt r
```

## Resources

* [Tutorial](https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html) how to build IntelliJ language plugin and write [tests](https://plugins.jetbrains.com/docs/intellij/writing-tests-for-plugins.html) for it.

* [PEG](https://en.wikipedia.org/wiki/Parsing_expression_grammar) BNF Grammar

Parser is generated from [Unison.bnf](src/main/jflex/Unison.bnf)
manually (right mouse click on bnf file \ `Generate Parser Code`), using [Grammar-Kit](https://github.com/JetBrains/Grammar-Kit) IntelliJ Plugin.

* Lexer

Lexer is generated from [Unison.flex](./intellij/unison/language/Unison.flex) manually - right mouse click on flex file \ `Run JFlex Generator` or using modified [JFlex](https://www.jflex.de/) modified [by IntelliJ](https://github.com/JetBrains/intellij-deps-jflex):
```shell
sbt lexer
```

* [Example lexer](https://jflex.de/manual.html) from jflex docs for part of Java
* [Example grammars at JFlex](https://github.com/jflex-de/jflex/wiki/External-JFlex-Grammars)
* ([Tutorial How to read Grammars from Grammar-Kit](https://github.com/JetBrains/Grammar-Kit/blob/master/TUTORIAL.md))

## List snippets without parse errors

```sbt
grep -L Error src/test/testData/*.txt
```

Event without reported errors there could be errors in parsing the content. We need better tests for this!

## Enable PSI viewer

[Enable internal](https://plugins.jetbrains.com/docs/intellij/explore-api.html#internalMode) tools in IntelliJ `Help \ Edit Custom Properties ...`
```properties
idea.is.internal=true
```

## Working with source code

* Clean and compile code

```shell
sbt c
```

* Format code ([.scalafmt.conf](./.scalafmt.conf)) using Scalafmt ([configuration docs](https://scalameta.org/scalafmt/docs/configuration.html))

```shell
sbt f
```

* Clean up sample output files (`drop.sh`) generated during tests and re-create them

```shell
rm src/test/testData/*.txt
rm src/test/testData/wip/*.txt
sbt t
```

* Check errors and unrecognized characters:

```shell
./error_counts.sh
```
