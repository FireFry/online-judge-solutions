var
   k,n,i:word;
   a:array[0..10000]of word;

procedure umn(x:word);
var
   i,bufer:word;
begin
   i:=1;
   a[1]:=a[1]*x;
   bufer:=a[1] div 10;
   a[1]:=a[1] mod 10;
   for i:=2 to a[0]+2 do
   begin
      a[i]:=a[i]*x+bufer;
      bufer:=a[i] div 10;
      a[i]:=a[i] mod 10;
   end;
   while a[i]=0 do
      dec(i);
   a[0]:=i;
end;

procedure writesol;
var
   i:word;
begin
   for i:=a[0] downto 1 do
      write(a[i]);
   writeln;
end;

begin
   readln(k);
   a[1]:=1;
   a[0]:=1;
   for i:=1 to k-1 do
   begin
      umn(55);
   end;
   umn(36);
   writesol;
end.