const maxn=1001;

type stringtype=array [1..1001] of char;

var n,m,i:integer;
s:stringtype;
f:array [1..1001] of integer;

procedure delete(var s:stringtype; index:integer; i:byte);
begin
s[index]:=#0;
end;

procedure insert(sub:char; var s:stringtype; index:integer);
var i:integer;
begin
for i:=n-1 downto index do
s[i+1]:=s[i];
s[index]:=sub;
end;

procedure work;
var i:integer;
count:word;

procedure task1;
var i:integer;
begin
if (count)mod(n+1)=0 then exit;
for i:=1 to n do
if (s[i]='1')and( (count-i)mod(n+1)=0 )
then begin
s[i]:='0';
exit;
end;
end;

procedure task2;
var i:integer;

function specialcheck(p:integer):boolean;
var i:integer;
hh:word;
begin
hh:=count;
{for i:=p+1 to n+1 do
if s[i]='1' then dec(hh);}
dec(hh,f[p]);
if ((hh mod(n+1)=0)and(s[p]='0'))or(((hh-p)mod(n+1)=0)and(s[p]
='1'))
then specialcheck:=true
else specialcheck:=false;
end;

begin
for i:=1 to n+1 do
if specialcheck(i)
then begin
delete(s,i,1);
exit;
end;
end;

procedure task3;
var i:integer;
real:boolean;
procedure specialcheck(p:integer);
var hh:word;
i:integer;
begin
hh:=count;
{for i:=p to n-1 do
if s[i]='1'
then inc(hh);}
inc(hh,f[p]);
if s[p]='1'
then inc(hh);
if hh mod(n+1)=0
then begin
insert('0',s,p);
real:=true;
end;
if (hh+p)mod(n+1)=0
then begin
insert('1',s,p);
real:=true;
end;
end;
begin
if count mod(n+1)=0
then begin
insert('0',s,m+1);
exit;
end;
real:=false;
for i:=1 to n do
begin
specialcheck(i);
if real then exit;
end;
end;

begin
count:=0;
for i:=1 to m do
if s[i]='1'
then inc(count,i);
if m=n
then begin
task1; exit;
end;
if m=n+1
then begin
task2; exit;
end;
if m=n-1
then begin
task3; exit;
end;
end;

begin
{assign(input,'input.txt');
reset(input);}
readln(n);
while not eof(input) do
begin
m:=0;
fillchar(s,sizeof(s),0);
fillchar(f,sizeof(f),0);
while not eoln(input) do
begin
inc(m);
read(s[m]);
if s[m]=' '
then begin
s[m]:=#0;
dec(m);
break;
end;
if s[m]='1'
then for i:=m-1 downto 1 do
inc(f[i]);
end;
readln;
work;
for i:=1 to n+1 do
if s[i]<>#0 then write(s[i]);
writeln;
end;
{close(input);}
end.