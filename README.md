# IntelliJ IDEA Plugin for [Unison](https://www.unison-lang.org/)
[![Scala CI](https://github.com/dancewithheart/intellij-unison/actions/workflows/scala.yml/badge.svg?branch=main)](https://github.com/dancewithheart/intellij-unison/actions/workflows/scala.yml?query=branch%3Amain)

## Playing with Unison samples

There are Unison snippets in [./src/test/testData](./src/test/testData) you can run play around with them (see [offical docs for hello world in Unison](https://www.unison-lang.org/docs/#hello-world)):

```shell
ucm
project.create samples
load Hello.u
update
run hello
```

## Supported features
* [CommentsMultiline](./src/test/testData/CommentsMultiline.u)
* [Comments](./src/test/testData/Comments.u)
* [LiteralPatterns](./src/test/testData/LiteralPatterns.u)
* [Literals](./src/test/testData/Literals.u)
* [MultiplePatterns](./src/test/testData/MultiplePatterns.u)
* [NamespaceDeclaration](./src/test/testData/NamespaceDeclaration.u)
* [NumericalExpression3](./src/test/testData/NumericalExpression3.u)
* [StructuralType1](./src/test/testData/StructuralType1.u)
* [StructuralType2](./src/test/testData/StructuralType2.u)
* [StructuralTypePoly1](./src/test/testData/StructuralTypePoly1.u)
* [StructuralTypePoly2](./src/test/testData/StructuralTypePoly2.u)
* [TermBindingBasicTypesBoolean](./src/test/testData/TermBindingBasicTypesBoolean.u)
* [TermBindingBasicTypesBytes](./src/test/testData/TermBindingBasicTypesBytes.u)
* [TermBindingBasicTypesChar](./src/test/testData/TermBindingBasicTypesChar.u)
* [TermBindingBasicTypesFloat](./src/test/testData/TermBindingBasicTypesFloat.u)
* [TermBindingBasicTypesInt](./src/test/testData/TermBindingBasicTypesInt.u)
* [TermBindingBasicTypesText](./src/test/testData/TermBindingBasicTypesText.u)
* [TermBindingFunction](./src/test/testData/TermBindingFunction.u)
* [TermBindingMultilineText](./src/test/testData/TermBindingMultilineText.u)
* [TermBindingTuples](./src/test/testData/TermBindingTuples.u)
* [TopLevelTermDeclaration](./src/test/testData/TopLevelTermDeclaration.u)
* [UseClauseOperator](./src/test/testData/UseClauseOperator.u)
* [UseClause](./src/test/testData/UseClause.u)
