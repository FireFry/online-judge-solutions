const
   osn=1000;
type
   TLongint=array[0..5000]of longint;
   Ftab=array[1..2,1..2]of TLongint;
   Vector=array[1..2]of TLongint;
var
   N:longint;
   A,D,x,y:FTab;
   B,F:Vector;
   Pl1,Pl2:TLongint;

{Tlong}

procedure Norm(var x:TLongint);
var
   i:integer;
begin
   i:=1;
   while i<=x[0] do
   begin
      if (i=x[0]) and (x[i] div osn>0) then
         inc(x[0]);
      inc(x[i+1],x[i] div osn);
      x[i]:=x[i] mod osn;
      inc(i);
   end;
end;

procedure Mult(var z:Tlongint; x,y:Tlongint);
var
   i,j:integer;
begin
   fillchar(z,sizeof(z),0);
   z[0]:=y[0]+x[0]-1;
   for i:=1 to x[0] do
   begin
      for j:=1 to y[0] do
         inc(z[j+i-1],x[i]*y[j]);
   end;
   Norm(z);
end;

procedure Plus(var z:Tlongint; x,y:TLongint);
var
   i:integer;
begin
   fillchar(z,sizeof(z),0);
   if x[0]>y[0] then
      z[0]:=x[0] else
      z[0]:=y[0];
   for i:=1 to z[0] do
      z[i]:=x[i]+y[i];
   Norm(z);
end;

procedure Writelong(x:Tlongint);
var
   i,j:longint;
begin
   for i:=x[0] downto 1 do
   begin
      j:=osn div 10;
      if i<x[0] then
      while (x[i] div j=0) and (j>1) do
      begin
         write(0);
         j:=j div 10;
      end;
      write(x[i]);
   end;
   writeln;
end;

procedure Long(var X:TLongint; y:longint);
begin
   X[0]:=1;
   X[1]:=y;
   Norm(X);
end;

{Fibon}

{procedure MatrixMult(var z:FTab; x,y:Ftab);
var
   Pl1,Pl2:TLongint;
begin

   Mult(PL1,x[1,1],y[1,1]);
   Mult(PL2,x[1,2],y[2,1]);
   Plus(z[1,1],PL1,PL2);

   Mult(PL1,x[2,1],y[1,1]);
   Mult(PL2,x[2,2],y[2,1]);
   Plus(z[2,1],PL1,PL2);

   Mult(PL1,x[1,1],y[1,2]);
   Mult(PL2,x[1,2],y[2,2]);
   Plus(z[1,2],PL1,PL2);

   Mult(PL1,x[2,1],y[1,2]);
   Mult(PL2,x[2,2],y[2,2]);
   Plus(z[2,2],PL1,PL2);

end;}

procedure TabStep(var D:FTab; A:FTab; n:longint);
var
   b:array[1..32]of byte;
   j,k,i:longint;
begin

   {D - Edinichnaya matritsa}
   Long(D[1,1],1); Long(D[1,2],0);
   Long(D[2,1],0); Long(D[2,2],1);

   {B[1..k] - Binarnoe N}
   i:=1;
   k:=1;
   while 2*i<=n do
   begin
      inc(k);
      i:=i*2;
   end;
   for j:=k downto 1 do
   begin
      if i<=n then
      begin
         b[j]:=1;
         n:=n-i;
      end else b[j]:=0;
      i:=i div 2;
   end;

   {Vozwedenie}
   for i:=k downto 1 do
   begin

      {MatrixMult(d,d,d);}
      x:=d;
      y:=d;

      Mult(PL1,x[1,1],y[1,1]);
      Mult(PL2,x[1,2],y[2,1]);
      Plus(d[1,1],PL1,PL2);

      Mult(PL1,x[2,1],y[1,1]);
      Mult(PL2,x[2,2],y[2,1]);
      Plus(d[2,1],PL1,PL2);

      Mult(PL1,x[1,1],y[1,2]);
      Mult(PL2,x[1,2],y[2,2]);
      Plus(d[1,2],PL1,PL2);

      Mult(PL1,x[2,1],y[1,2]);
      Mult(PL2,x[2,2],y[2,2]);
      Plus(d[2,2],PL1,PL2);


      if b[i]=1 then
      begin
         {MatrixMult(d,d,a);}
         x:=d;
         y:=a;

         Mult(PL1,x[1,1],y[1,1]);
         Mult(PL2,x[1,2],y[2,1]);
         Plus(d[1,1],PL1,PL2);

         Mult(PL1,x[2,1],y[1,1]);
         Mult(PL2,x[2,2],y[2,1]);
         Plus(d[2,1],PL1,PL2);

         Mult(PL1,x[1,1],y[1,2]);
         Mult(PL2,x[1,2],y[2,2]);
         Plus(d[1,2],PL1,PL2);

         Mult(PL1,x[2,1],y[1,2]);
         Mult(PL2,x[2,2],y[2,2]);
         Plus(d[2,2],PL1,PL2);

      end;
   end;
end;
{
procedure VectorMult(var F:Vector; A:FTab; B:Vector);
var
   PL1,PL2:TLongint;
begin

   Mult(PL1,A[1,1],B[1]);
   Mult(PL2,A[1,2],B[2]);
   Plus(F[1],PL1,PL2);

   Mult(PL1,A[2,1],B[1]);
   Mult(PL2,A[2,2],B[2]);
   Plus(F[2],PL1,PL2);

end;
}


begin
  {assign(output,'1462.out');
   rewrite(output);}
   readln(N);

   {Main}
   if N=1 then writeln(1) else if N=2 then writeln(3) else
   begin
      dec(N);

      {Tablitsa dlya vozwedeniya}
      Long(A[1,1],1); Long(A[1,2],1);
      Long(A[2,1],1); Long(A[2,2],2);

      {Vozwedenie}
      TabStep(D,A,n div 2);

      {B - Vector pervih chisel Fibonachi}
      Long(B[1],1);
      Long(B[2],3);

      {VectorMult(F,D,B);}
      Mult(PL1,D[1,1],B[1]);
      Mult(PL2,D[1,2],B[2]);
      Plus(F[1],PL1,PL2);

      Mult(PL1,D[2,1],B[1]);
      Mult(PL2,D[2,2],B[2]);
      Plus(F[2],PL1,PL2);


      {Vivod}
      Writelong(F[N mod 2+1]);

      inc(N);
   end;
  {close(output);}
end.
