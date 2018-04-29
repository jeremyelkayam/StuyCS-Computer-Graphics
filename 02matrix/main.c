#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "ml6.h"
#include "display.h"
#include "draw.h"
#include "matrix.h"

int main(){

    
  //struct matrix *test1,*test2;

  
  /*  
    test1 = new_matrix(2, 2);
    test2 = new_matrix(2, 2);
    
    test1->m[0][0]=4;
    test1->m[0][1]=8;
    test1->m[1][0]=0;
    test1->m[1][1]=2;
    test2->m[0][0]=5;
    test2->m[0][1]=2;
    test2->m[1][0]=9;
    test2->m[1][1]=4;
    
    print_matrix(test1);
    print_matrix(test2);
    
    matrix_mult(test1,test2);
    
    print_matrix(test2);

  */
  
  /*
    
    test1 = new_matrix(4, 4);
    test2 = new_matrix(4, 4);
    
    print_matrix(test1);
    printf("cols:%d,lastcol:%d\n",test1->cols,test1->lastcol);
    add_point(test1,102,4,36);
    ident(test1);
    scalar_mult(323,test1);
    print_matrix(test1);
  */

  //test1=make_rotZ(3.1415926535);
  //print_matrix(test1);
  
  //free_matrix(test1);
  //free_matrix(test2);

  
  

  screen s;
  struct matrix *edges;
  struct matrix *transform;

  edges = new_matrix(4, 4);
  transform = new_matrix(4, 4);

  add_edge(edges,
	   0,0,0,
	   2,0,0);
  add_edge(edges,
	   2,0,0,
	   2,2,0);
  add_edge(edges,
	   2,2,0,
	   0,2,0);
  add_edge(edges,
	   0,2,0,
	   0,0,0);

  color g;
  g.red=0;
  g.blue=0;
  g.green=0;
  
  //draw_lines(edges,s,g);

  transform=make_translate(1,1,0);
  matrix_mult(transform,edges);
  int z,b;
  for(b=0;b<100;b++){
    for(z=0;z<1000;z++){
      transform=make_rotZ(.0031415926535);
      matrix_mult(transform,edges);
      g.red+=1;
      g.blue+=2;
      g.green+=3;
      
      if(g.red>255){
	g.red=0;
      }
      if(g.blue>255){
	g.blue=0;
      }
      if(g.green>255){
	g.green=0;
      }
      
      draw_lines(edges,s,g);
    }
    scalar_mult(1.1,edges);
    
  }
  save_extension(s, "matrix.png" );
  
  free_matrix( transform );
  free_matrix( edges );
  

}  
