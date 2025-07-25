# IntelliJ IDEA Plugin for [Unison](https://www.unison-lang.org/)

## Running locally

Thanks to [sbt-idea-plugin](https://github.com/JetBrains/sbt-idea-plugin) you can run

```shell
sbt runIDE
```

## Development notes

* Compile

```shell
sbt clean compile
```

[Tutorial how to build IntelliJ language plugin](https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html).

Grammar definition in [Unison.bnf](./src/main/scala/intellij/unison/language/Unison.bnf)
Manually re-generate files in [gen](./gen) using [Grammar-Kit](https://github.com/JetBrains/Grammar-Kit) is IntelliJ Plugin
( [tutorial](https://github.com/JetBrains/Grammar-Kit/blob/master/TUTORIAL.md) ).
