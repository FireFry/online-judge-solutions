var
   m,n,k:word;
   otv:longint;
   s:string;

begin
   read(n);
   readln(s);
   k:=length(s)-1;
   m:=0;
   otv:=1;
   while m*k<N do
   begin
      otv:=otv*(n-m*k);
      inc(m);
   end;
   writeln(otv);
end.