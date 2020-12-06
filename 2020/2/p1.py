import re
ans = 0
for line in open('input').readlines():
    a, b, c, d = re.split('[ :-]+', line)
    count = d.count(c)
    if count >= int(a) and count <= int(b):
        ans += 1
print(ans)
