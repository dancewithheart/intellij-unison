# IntelliJ IDEA Plugin for [Unison](https://www.unison-lang.org/)
[![Scala CI](https://github.com/dancewithheart/intellij-unison/actions/workflows/scala.yml/badge.svg?branch=main)](https://github.com/dancewithheart/intellij-unison/actions/workflows/scala.yml?query=branch%3Amain)

## Running locally

Thanks to [sbt-idea-plugin](https://github.com/JetBrains/sbt-idea-plugin) you can run separate instance of IntelliJ IDEA with this plugin installed:

```shell
sbt r
```

## Supported features

```sbt
grep -L Error src/test/testData/*.txt
```

## Playing with Unison samples

Similar to [hello world from Unison](https://www.unison-lang.org/docs/#hello-world) there is []()

```shell
ucm
project.create samples
load Hello.u
update
run hello
```

## Development notes

[Enable internal](https://plugins.jetbrains.com/docs/intellij/explore-api.html#internalMode) tools in IntelliJ `Help \ Edit Custom Properties ...`
```properties
idea.is.internal=true
```

* Clean and compile code

```shell
sbt c
```

* Format code ([.scalafmt.conf](./.scalafmt.conf)) using Scalafmt ([configuration docs](https://scalameta.org/scalafmt/docs/configuration.html))

```shell
sbt f
```

* Clean up sample output files from compilations and re-create them
```shell
rm src/test/testData/*.txt
sbt t
```

* Check errors and unrecognized characters:
```shell
./error_counts.sh
```

* [Tutorial](https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html) how to build IntelliJ language plugin and write [tests](https://plugins.jetbrains.com/docs/intellij/writing-tests-for-plugins.html)  for it.

* [PEG](https://en.wikipedia.org/wiki/Parsing_expression_grammar) BNF Grammar

Parser is generated from [Unison.bnf](./src/main/scala/intellij/unison/language/Unison.bnf)
manually (right mouse click on bnf file \ `Generate Parser Code`), using [Grammar-Kit](https://github.com/JetBrains/Grammar-Kit) IntelliJ Plugin ([tutorial](https://github.com/JetBrains/Grammar-Kit/blob/master/TUTORIAL.md)).

* Lexer

Lexer is generated from [Unison.flex](./intellij/unison/language/Unison.flex) using modified [JFlex](https://www.jflex.de/) modified [by IntelliJ](https://github.com/JetBrains/intellij-deps-jflex):
```shell
sbt lexer
```

[Example lexer](https://jflex.de/manual.html) from jflex docs for part of Java.