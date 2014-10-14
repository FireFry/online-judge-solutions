var a:string;
    la,i:byte;
    m,t:array[1..111] of byte;
begin
  readln(a);
  la:=length(a);
  for i:=1 to la do
  m[i]:=ord(a[i])-97;
  if (m[1]-5)<0 then t[1]:=m[1]+21 else t[1]:=m[1]-5;
  for i:=2 to la do t[i]:=(m[i]-m[i-1]+26) mod 26;
  for i:=1 to la do
  write(chr(t[i]+97));
end.