from sys import stdin, stdout

n = int(stdin.read())

if n == 1:
	res = "14"
elif n == 2:
	res = "155"
else:
	res = "1575" + ("0" * (n - 3))

stdout.write(res + "\n")