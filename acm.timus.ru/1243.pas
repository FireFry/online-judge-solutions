var
   a:array[1..100]of byte;
   i,N:word;
   s:string;
begin
   readln(s);
   for i:=1 to length(s) do
      val(s[i],a[i],N);
   N:=a[1] mod 7;
   for i:=2 to length(s) do
   begin
      N:=(N*10+a[i])mod 7;
   end;
   writeln(N);
end.