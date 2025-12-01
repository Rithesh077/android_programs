#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    float x;
    float y;
} Point;

Point *detect_first_point_of_convex_hull(Point *points, int num_points);

int main()
{
    // Example usage
    Point points[] = {{0, 0}, {1, 1}, {2, 2}};
    Point *first_point = detect_first_point_of_convex_hull(points, 3);
    if (first_point)
    {
        printf("First point of convex hull: (%f, %f)\n", first_point->x, first_point->y);
    }
    return 0;
}