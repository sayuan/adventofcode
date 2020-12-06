import re
ans = 0
for line in open('input').readlines():
    a, b, c, d = re.split('[ :-]+', line)
    if (d[int(a)-1] == c) ^ (d[int(b)-1] == c):
        ans += 1
print(ans)
