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
-- term declaration (term binding)

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

* [MultiplePatterns](./src/test/testData/MultiplePatterns.u)
```unison
zs = match 2 Nat.+ 2 with
  4 -> "Matches"
  _ -> "Doesn't match"
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

go2 : Boolean
go2 = false
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

c2 : Char
c2 = ?,

c3 : Char
c3 = ?\s
```

* [TermBindingBasicTypesFloat](./src/test/testData/TermBindingBasicTypesFloat.u)
```unison
f1 : Float
f1 = 3.0e-3

f2 : Float
f2 = -99.0

f3 : Float
f3 = 1.6777216e7
```

* [TermBindingBasicTypesInt](./src/test/testData/TermBindingBasicTypesInt.u)
```unison
minInt : Int
minInt = -9223372036854775808
maxInt = +9223372036854775807

i1 : Int
i1 = +0

i2 : Int
i2 = -0

i3 : Int
i3 = +9001

i4 : Int
i4 = -16777216

hexadecimalInt : Int
hexadecimalInt = +0xdeadbeef

octalInt : Int
octalInt = -0o5446

binaryInt : Int
binaryInt = +0b101010
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

boolId : Boolean -> Boolean
boolId x = x

natId : Nat -> Nat
natId x = x

asPi : Bytes -> Double
asPi b = 3.14

toPi : Float -> Text
toPi f = "3.14"
```

* [TermBindingMultilineText](./src/test/testData/TermBindingMultilineText.u)
```unison
multi1 : Text
multi1 = """This is a multiline text"""

multi2 : Text
multi2 =
  """
    This is a
    multiline text
  """
```

* [TermBindingTuples](./src/test/testData/TermBindingTuples.u)
```unison

t1 : (Nat, Text)
t1 = (1, "Two")

t2 : (Int, Text, Boolean)
t2 = (-4, "Yes", false)

dessertOrder : (Text, Text, Nat)
dessertOrder = ("Alice", "Blueberry pie", 5)
```
