var
   s1,s2:string;
   fl:boolean;
   i,j:word;
   a:array[1..12] of string;

function sdwir(a1,a2,a3,a4:word):string;
begin
   sdwir:=s2[a1]+s2[a2]+s2[a3]+s2[a4];
end;

begin
   readln(s1);
   readln(s2);
   a[1]:=sdwir(2,3,1,4);
   a[2]:=sdwir(2,1,4,3);
   a[3]:=sdwir(2,4,3,1);
   a[4]:=sdwir(1,2,3,4);
   a[5]:=sdwir(1,3,4,2);
   a[6]:=sdwir(1,4,2,3);
   a[7]:=sdwir(3,2,4,1);
   a[8]:=sdwir(3,4,1,2);
   a[9]:=sdwir(3,1,2,4);
   a[10]:=sdwir(4,2,1,3);
   a[11]:=sdwir(4,1,3,2);
   a[12]:=sdwir(4,3,2,1);
   for i:=1 to 12 do
      if s1=a[i] then
      begin
         fl:=true;
         break;
      end;
   if fl
      then writeln('equal')
      else writeln('different');
end.