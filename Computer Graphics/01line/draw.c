#include <stdio.h>
#include <stdlib.h>

#include "ml6.h"
#include "display.h"
#include "draw.h"


void oct1(int x,int x1,int y,int a,int b,screen s,color c){
  int d;
  d=2*a+b;
  while(x<=x1){
    plot(s,c,x,y);
    if(d>0){
      y++;
      d+=2*b;
    }
    x++;
    d+=2*a;
  }
}

void oct2(int x,int y,int y1,int a,int b,screen s,color c){
  int d;
  d=a+2*b;
  while(y<=y1){
    plot(s,c,x,y);
    if(d<0){
      x++;
      d+=2*a;
    }
    y++;
    d+=2*b;
  }
}

void oct8(int x,int x1,int y,int a,int b,screen s,color c){//not finished
  //printf("hi\n");
  int d;
  d=2*a-b;
  while(x<=x1){
    plot(s,c,x,y);
    if(d>0){
      y--;
      d+=2*b;
    }
    x++;
    d-=2*a;
  }
}

void oct7(int x,int y,int y1,int a,int b,screen s,color c){//not started
  printf("hi\n");
  int d;
  d=a-2*b;
  while(y>=y1){
    plot(s,c,x,y);
    if(d<0){
      x++;
      d-=2*a;
    }
    y--;
    d+=2*b;
  }
}

//Insert your line algorithm here
void draw_line(int x0, int y0, int x1, int y1, screen s, color c) {

  //converting octants 3-6 to workable ones
  int tmp;
  if(x0>x1){
    tmp=x0;
    x0=x1;
    x1=tmp;
    
    tmp=y0;
    y0=y1;
    y1=tmp;
  }
	  
  int a,b;
  a=y1-y0;//delta y
  b=x1-x0;//delta x
  
  double slope=(1.0*a)/b;
  printf("%f\n",slope);
  //octant switching

  b*=-1;
  if(0<=slope && slope<=1){//octant 1 (also 5)
    oct1(x0,x1,y0,a,b,s,c);
  }else if(1<slope){//octant 2 (also 6)
    oct2(x0,y0,y1,a,b,s,c);
  }else if(-1<=slope && slope<0){//octant 8 (also 4)
    oct8(x0,x1,y0,a,b,s,c);
  }else if(slope<-1){//octant 7 (also 3)
    oct7(x0,y0,y1,a,b,s,c);
  }
}

