#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>

char* concat(char* str1, char* str2) {
    char* ans = malloc(strlen(str1) + strlen(str2) + 1);
    ans[0] = '\0';
    strcat(ans, str1);
    strcat(ans, str2);
    return ans;
}

int64_t a;
int64_t b;
char* c;
char* d;

int main() {
	a = 5 + 5;
	b = 3;
	a;
	c = "text1";
	d = concat(c, " text2");
	printf("%s\n", d);
	while (a > b) {
		b = b + 1;
		printf("%ld\n", b);
	};
	if (a == b) {
		printf("%s\n", c);
	};
	if (strcmp("a", "b") > 0) {
		printf("%s\n", "text3");
	};
}