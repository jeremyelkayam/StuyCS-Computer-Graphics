#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <fcntl.h>
#include <unistd.h>
#include <math.h>

int main(){
    int rgb, x, y, file;
    char line[256];
    file = open("pic.ppm", O_CREAT | O_TRUNC | O_WRONLY, 0644);
    if (file < 0){
        printf("%s\n", strerror(errno));
    }
    write(file, "P3 500 500 255", 14);
    for (x = 0; x < 500; x++){
        for (y = 0; y < 500; y++){
          int temp = (int)floor((cos(x) * cos(x) + sin(y) + sin(y)) * 255);
   				rgb = abs(temp) % 255;
         	sprintf(line, "%d %d %d ", rgb, x, y); 
         	write(file, line, strlen(line));
        }
    }
    close(file);
    
    return 0;
}
