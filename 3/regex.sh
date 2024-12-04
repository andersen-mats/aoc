grep -oE 'mul\([1-9][0-9]{0,2}\,[1-9][0-9]{0,2}\)' data.txt > matches.txt
grep -oE '[1-9][0-9]{0,2},[1-9][0-9]{0,2}' matches.txt > matches2.txt

