from sys import stdin

s = stdin.readline().strip()
f = [len(s) * [-1] for x in range(len(s))]
m = [len(s) * [None] for x in range(len(s))]


def solve(start, end):
    if end < start:
        return 0, ''
    elif start == end:
        return 1, match(s[start])
    elif f[start][end] >= 0:
        return f[start][end], m[start][end],
    min = 1000 # too large to be an answer
    out = None
    if s[start] == '(' and s[end] == ')' or s[start] == '[' and s[end] == ']':
        min, out = solve(start + 1, end - 1)
        if s[start] == '(':
            out = '(' + out + ')'
        else:
            out = '[' + out + ']'
    for k in range(start, end):
        s1, o1 = solve(start, k)
        s2, o2 = solve(k + 1, end)
        v = s1 + s2
        if v < min:
            min = v
            out = o1 + o2
    f[start][end] = min
    m[start][end] = out
    return min, out


def match(c):
    if c in '()':
        return '()'
    else:
        return '[]'


print solve(0, len(s) - 1)[1]