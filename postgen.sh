rm src/test/testData/*.txt
git checkout gen/intellij/unison/language/psi/UnisonTypes.java
sbt t
sbt t
./error_counts.sh
