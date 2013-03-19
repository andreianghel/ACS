#!/bin/bash

# Constants

# Class path
CPATH="./bin/"

# Main class name
MAINCLASS="Main"

#Time limit for stress test 1
TLIM1=100

#Time limit for stress test 2
TLIM2=200

#Heap args
HEAP="-Xmx2048m"

# Starting grade is 0
grade=0

# IT'S A TRAP!
trap 'echo -e "\n\nUser interrupt. Current grade is $grade"; make clean &> /dev/null; exit 1' SIGINT SIGTERM SIGQUIT

# Clear output and error directories
rm -rf out
rm -rf err

mkdir -p out
mkdir -p err
mkdir -p bin

# Check for JDK
java -version &> /dev/null
rc=$?
if [[ $rc != 0 ]];
	then
		echo -e "Missing JDK."
		echo -e "I find your lack of JDK disturbing..."
		exit 1
fi


# Compile sources
make
rc=$?
if [[ $rc != 0 ]];
	then
		echo -e "\n\nCompiling failed!\n"
		exit 1
	else
		echo -e "\n\nSources compiled! Running Tests\n"
fi

# Start Testing
for i in {1..6}
do
	echo -e "==========TEST $i=========="
	java $HEAP -cp $CPATH $MAINCLASS "./in/dict/dict$i" < "./in/query/in$i" > "out/out$i" 2> "err/err$i"
	rc1=$?
	if [[ $rc1 != 0 ]];
		then
			echo -e "FAILED! Runtime error"
		else
			java $HEAP -cp . CompareOutputs "./res/res$i" "./out/out$i"
			rc2=$?
			if [[ $rc2 != 0 ]];
				then
					echo -e "FAILED! Incorrect output!"
				else
					echo -e "PASSED!"
					let grade=$grade+10
			fi
	fi
	echo -e "Current grade $grade \n"
done


# Stress tests (so hardcore)
echo -e "==========TEST 7=========="
START=$(date +%s)
java $HEAP -cp $CPATH $MAINCLASS "./in/dict/dict7" < "./in/query/in7" > "out/out7" 2> "err/err7"
rc1=$?
END=$(date +%s)
DIFF=$(($END-$START))
echo "Elapsed time for test is $DIFF seconds"
if [ $rc1 != 0 ] || [ $DIFF -gt $TLIM1 ];
	then
		if [ $DIFF -gt $TLIM1 ];
			then
				echo -e "FAILED! Time exceeded! Limit is $TLIM1 s"
			else
				echo -e "FAILED! Runtime error"
		fi
	else
		java $HEAP -cp . CompareOutputs "./res/res7" "./out/out7"
		rc2=$?
		if [[ $rc2 != 0 ]];
			then
				echo -e "FAILED! Incorrect output!"
			else
				echo -e "PASSED!"
				let grade=$grade+10
		fi
fi
echo -e "Current grade $grade \n"

echo -e "==========TEST 8=========="
START=$(date +%s)
java $HEAP -cp $CPATH $MAINCLASS "./in/dict/dict8" < "./in/query/in8" > "out/out8" 2> "err/err8"
rc1=$?
END=$(date +%s)
DIFF=$(($END-$START))
echo "Elapsed time for test is $DIFF seconds"
if [ $rc1 != 0 ] || [ $DIFF -gt $TLIM2 ];
	then
		if [ $DIFF -gt $TLIM2 ];
			then
				echo -e "FAILED! Time exceeded! Limit is $TLIM2 s"
			else
				echo -e "FAILED! Runtime error"
		fi
	else
		java $HEAP -cp . CompareOutputs "./res/res8" "./out/out8"
		rc2=$?
		if [[ $rc2 != 0 ]];
			then
				echo -e "FAILED! Incorrect output!"
			else
				echo -e "PASSED!"
				let grade=$grade+10
		fi
fi
echo -e "Current grade $grade \n"

# Show final grade
if [[ $grade -eq 80 ]];
	then
		echo -e "\n\nCONGRATS! Grade is 80/80\n"
	else
		echo -e "\n\nFinal grade is: $grade/80\n"
fi

# Clean up
echo -e "Cleanup\n"
make clean &> /dev/null

exit 0
