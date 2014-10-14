from sys import stdin, stdout

if int(stdin.read()) < 7:
    stdout.write('NO\n')
else:
    stdout.write('YES\n')