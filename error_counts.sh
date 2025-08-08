grep Error src/test/testData/*.txt

grep BAD_CHARACTER src/test/testData/*.txt

echo BAD_CHARACTER $(grep BAD_CHARACTER src/test/testData/*.txt | wc -l)
echo Errors $(grep Error src/test/testData/*.txt | wc -l)
