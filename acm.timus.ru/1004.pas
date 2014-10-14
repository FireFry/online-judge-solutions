program ural1004;
const
maxn=100;
inf=65535;
var
p:array[1..maxn,1..maxn]of word;
n,x,y:shortint;
m,i,l,ans:word;
route:ansistring;
procedure dijkstra(src:byte);
var
s:set of 1..maxn;
dist:array[1..maxn]of word;
sec,pre:array[1..maxn]of byte;
newadd,i,j,u,v:byte;
min:word;
t:string;
begin
fillchar(dist,sizeof(dist),255);
s:=[src];newadd:=src;dist[src]:=0;
repeat
for i:=1 to n do
if p[newadd,i]<inf then
if dist[newadd]+p[newadd,i]<dist[i] then begin
dist[i]:=dist[newadd]+p[newadd,i];
if newadd=src then sec[i]:=i else sec[i]:=sec[newadd];
pre[i]:=newadd;
end;

min:=inf;
for i:=1 to n do
if not (i in s) and (dist[i]<min) then begin
min:=dist[i];
newadd:=i;
end;
if min=inf then break;
s:=s+[newadd];
until false;

min:=inf;
for i:=1 to n do
if (i<>src) and (i in s) then
for j:=1 to n do
if (j<>src) and (j in s) and (sec[i]<>sec[j]) then
if dist[i]+dist[j]+p[i,j]<min then begin
min:=dist[i]+dist[j]+p[i,j];
u:=i;v:=j;
end;

if min<ans then begin
ans:=min;
str(u,route);
repeat
u:=pre[u];
str(u,t);
route:=t+' '+route;
until u=src;
repeat
str(v,t);
route:=route+' '+t;
v:=pre[v];
until v=src;
end;
end;
begin
repeat
read(n);
if n=-1 then halt;
fillchar(p,sizeof(p),255);
read(m);
for i:=1 to m do begin
read(x,y,l);
if l<p[x,y] then begin
p[x,y]:=l;
p[y,x]:=l;
end;
end;
ans:=inf;
for i:=1 to n do
dijkstra(i);
if ans=inf then writeln('No solution.') else writeln(route);
until false;
end.