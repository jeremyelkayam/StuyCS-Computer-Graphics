#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "ml6.h"
#include "display.h"
#include "draw.h"

int main() {

  screen s;
  color c;
 

  
  c.red = 256;
  c.green = 0;
  
  clear_screen(s);

  int z;
  for(z=0;z<256;z++){
    c.blue = z;
    c.green = (z+150)%256;
    draw_line( 0, YRES-z, XRES + z*z, 0, s, c);
    draw_line( 0, YRES-z*z, XRES - z, 0, s, c);
    draw_line( 0, YRES+z, XRES + z*z, 0, s, c);
    draw_line( 0, YRES+z*z, XRES - z, 0, s, c);
  }
  
  display(s);
  save_extension(s, "lines.png");
}  
