# IntelliJ IDEA Plugin for [Unison](https://www.unison-lang.org/)

## Running locally

Thanks to [sbt-idea-plugin](https://github.com/JetBrains/sbt-idea-plugin) you can run

```shell
sbt runIDE
```

## Development notes

Enable development tools in IntelliJ `Help \ Edit Custom Properties ...`
```properties
idea.is.internal=true
```

* Clean and compile code

```shell
sbt r
```

* Format code ([.scalafmt.conf](./.scalafmt.conf)) using Scalafmt ([configuration docs](https://scalameta.org/scalafmt/docs/configuration.html))

```shell
sbt fmt
```

[Tutorial how to build IntelliJ language plugin](https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html).

* [PEG](https://en.wikipedia.org/wiki/Parsing_expression_grammar) BNF Grammar

Parser is generated from [Unison.bnf](./src/main/scala/intellij/unison/language/Unison.bnf)
manually, using [Grammar-Kit](https://github.com/JetBrains/Grammar-Kit) IntelliJ Plugin ([tutorial](https://github.com/JetBrains/Grammar-Kit/blob/master/TUTORIAL.md)).

* Lexer

Lexer is generated from [Unison.flex](./intellij/unison/language/Unison.flex) using modified [JFlex](https://www.jflex.de/) modified [by IntelliJ](https://github.com/JetBrains/intellij-deps-jflex):
```shell
sbt lexer
```
