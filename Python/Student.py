# Student Result Program

sub1 = float(input("Enter marks of Subject 1: "))
sub2 = float(input("Enter marks of Subject 2: "))
sub3 = float(input("Enter marks of Subject 3: "))

total = sub1 + sub2 + sub3
average = total / 3

print("\nTotal Marks:", total)
print("Average Marks:", average)

if average >= 35:
    print("Result: PASS")
    print("🎉 Congratulations! You have passed the exam.")
else:
    print("Result: FAIL")
    print("😔 Sorry! You have failed the exam. Better luck next time.")