echo "====================== Features:"
grep -L Error src/test/testData/*.txt

echo
echo "====================== WIP ERRORS:"
grep Error src/test/testData/wip/*.txt

echo
grep BAD_CHARACTER src/test/testData/wip/*.txt

echo
echo "====================== ERRORS:"
grep Error src/test/testData/*.txt

echo
grep BAD_CHARACTER src/test/testData/*.txt

echo
echo "====================== New features:"
grep -L Error src/test/testData/wip/*.txt

echo
echo "====================== Summary:"
echo WIP BAD_CHARACTER $(grep BAD_CHARACTER src/test/testData/wip/*.txt | wc -l)
echo WIP Errors $(grep Error src/test/testData/wip/*.txt | wc -l)
echo BAD_CHARACTER $(grep BAD_CHARACTER src/test/testData/*.txt | wc -l)
echo Errors $(grep Error src/test/testData/*.txt | wc -l)
