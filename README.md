# IntelliJ IDEA Plugin for [Unison](https://www.unison-lang.org/)
[![Scala CI](https://github.com/dancewithheart/intellij-unison/actions/workflows/scala.yml/badge.svg?branch=main)](https://github.com/dancewithheart/intellij-unison/actions/workflows/scala.yml?query=branch%3Amain)

WIP This is very early stages of the work. No artifact is published. Some key features are under development: e.g. abilities, non-trivial expressions.
See #22 for known issues. 

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


* [NamespaceDeclaration](./src/test/testData/NamespaceDeclaration.u)
```unison
namespace models.User
```

* [UseClauseOperator](./src/test/testData/UseClauseOperator.u)
```unison
use List +: :+
```

* [Comments](./src/test/testData/Comments.u)
```unison
-- comments https://www.unison-lang.org/docs/language-reference/comments/
```

* [CommentsMultiline](./src/test/testData/CommentsMultiline.u)
```unison
{-
https://www.unison-lang.org/docs/language-reference/term-declarations/

name : Type
name p_1 p_2 … p_n = expression
-}
```

* [Literals](./src/test/testData/Literals.u)
```unison
x = 1
str = "hello"
xs = [1, 2, 3]
```

* [NumericalExpression3](./src/test/testData/NumericalExpression3.u)
```unison
z = 2 Nat.+ 2
```

* [StructuralTypePoly1](./src/test/testData/StructuralTypePoly1.u)
```unison
structural type Optional a = Some a | None
```

* [TermBindingBasicTypesBoolean](./src/test/testData/TermBindingBasicTypesBoolean.u)
```unison
go1 : Boolean
go1 = true
```

* [TermBindingBasicTypesBytes](./src/test/testData/TermBindingBasicTypesBytes.u)
```unison
db : Bytes
db = 0xsdeadbeef
```

* [TermBindingBasicTypesChar](./src/test/testData/TermBindingBasicTypesChar.u)
```unison
c1 : Char
c1 = ?H
```

* [TermBindingBasicTypesFloat](./src/test/testData/TermBindingBasicTypesFloat.u)
```unison
f2 : Float
f2 = -99.0
```

* [TermBindingBasicTypesInt](./src/test/testData/TermBindingBasicTypesInt.u)
```unison
minInt : Int
minInt = -9223372036854775808
maxInt = +9223372036854775807
```

* [TermBindingBasicTypesText](./src/test/testData/TermBindingBasicTypesText.u)
```unison
pie : Text
pie = "Apple pie"

hi : Text
hi = "Hello, \"world\"!"
```

* [TermBindingFunction](./src/test/testData/TermBindingFunction.u)
```unison
boolFun : [Boolean]
boolFun = [true, false]

natId : Nat -> Nat
natId x = x
```

* [TermBindingMultilineText](./src/test/testData/TermBindingMultilineText.u)
```unison
multi2 : Text
multi2 =
  """
    This is a
    multiline text
  """
```

* [TermBindingTuples](./src/test/testData/TermBindingTuples.u)
```unison
t2 : (Int, Text, Boolean)
t2 = (-4, "Yes", false)
```

* [MultiplePatterns](./src/test/testData/MultiplePatterns.u)
```unison
zs = match 2 Nat.+ 2 with
  4 -> "Matches"
  _ -> "Doesn't match"
```

* [PatternMatchGuards](./src/test/testData/PatternMatchGuards1.u)
```unison
matchNum1 : Nat -> Text
matchNum1 num = match num with
  one | one === 1 -> "one"
  three | three === 3 -> "three"
  _ -> "no match"
```

* [StructuralTypePoly](./src/test/testData/StructuralTypePoly1.u)
```unison
structural type Optional a = Some a | None
```

* [PolymorphicTypes](./src/test/testData/PolymorphicTypes.u)
```unison
id1 : forall t. t -> t
id1 x = x
```

## Contributions

Help welcome :)
* [good first issue](https://github.com/dancewithheart/intellij-unison/issues?q=is%3Aissue%20state%3Aopen%20label%3A%22good%20first%20issue%22)
* [dev notes](./DEV_NOTES.MD)
