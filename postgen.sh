rm src/test/testData/*.txt
rm src/test/testData/wip/*.txt
git checkout gen/intellij/unison/language/psi/UnisonTypes.java
sbt t
sbt t
./error_counts.sh
