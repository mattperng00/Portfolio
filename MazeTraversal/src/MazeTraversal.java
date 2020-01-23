/**
 * class that traverses a 12 by 12 maze
 */

public class MazeTraversal {

    /**
     * Create a 12 by 12 maze and find the end point
     * @param maze 2d char array
     * @param x integer coodrinate
     * @param y integer coodrinate
     * @param start boolean that checks if it's first move
     * @return
     */
    public static char[][] traverse(char[][] maze, int x, int y,boolean start)
    {
        maze[x][y] = 'x';

        if(x==11 || y == 11 || x==0 || y==0)
        {
            if(start)
            {
                start= false;
                if(x==11)
                {
                    if(maze[x][y+1] == '.')
                    {
                        maze[x][y+1] = 'x';
                        y+=1;
                    }
                    //go left
                    else if(maze[x][y-1] == '.')
                    {
                        maze[x][y-1] = 'x';
                        y+=-1;
                    }
                    //go up
                    else if (maze[x-1][y] == '.')
                    {
                        maze[x-1][y] = 'x';
                        x+=-1;
                    }
                }
                else if(y == 11)
                {
                    if(maze[x+1][y] == '.' && x != 11)
                    {
                        maze[x+1][y] = 'x';
                        x+=1;
                    }
                    else if(maze[x][y-1] == '.' && y !=0)
                    {
                        maze[x][y-1] = 'x';
                        y+=-1;
                    }
                    else if (maze[x-1][y] == '.' && x!=0)
                    {
                        maze[x-1][y] = 'x';
                        x+=-1;
                    }
                }
                else if(y==0)
                {
                    //go down
                    if(maze[x+1][y] == '.' && x != 11)
                    {
                        maze[x+1][y] = 'x';
                        x+=1;
                    }
                    //go right
                    else if(maze[x][y+1] == '.' && y !=11)
                    {
                        maze[x][y+1] = 'x';
                        y+=1;
                    }
                    //go up
                    else if (maze[x-1][y] == '.' && x!=0)
                    {
                        maze[x-1][y] = 'x';
                        x+=-1;
                    }
                }
                else
                {
                    if(maze[x+1][y] == '.' && x != 11)
                    {
                        maze[x+1][y] = 'x';
                        x+=1;
                    }
                    //go right
                    else if(maze[x][y+1] == '.' && y !=11)
                    {
                        maze[x][y+1] = 'x';
                        y+=1;
                    }
                    //go left
                    else if(maze[x][y-1] == '.' && y !=0)
                    {
                        maze[x][y-1] = 'x';
                        y+=-1;
                    }
                }

            }
            else
            {
                for (int i=0;i <12;i++)
                {
                    for (int j=0;j < 12;j++)
                    {
                        if(maze[i][j] == 'o')
                        {
                            maze[i][j] = '.';
                        }
                    }
                }
                return maze;
            }
        }
        //go down
        else if(maze[x+1][y] == '.' && x != 11)
        {
            maze[x+1][y] = 'x';
            x+=1;
        }
        //go right
        else if(maze[x][y+1] == '.' && y !=11)
        {
            maze[x][y+1] = 'x';
            y+=1;
        }
        //go left
        else if(maze[x][y-1] == '.' && y !=0)
        {
            maze[x][y-1] = 'x';
            y+=-1;
        }
        //go up
        else if (maze[x-1][y] == '.' && x!=0)
        {
            maze[x-1][y] = 'x';
            x+=-1;
        }
        //dead end, go backwards
        else
        {
            maze[x][y] = 'o';
            //go down
            if (maze[x + 1][y] == 'x') {
                maze[x + 1][y] = 'o';
                x += 1;
            }
            //go right
            else if (maze[x][y + 1] == 'x') {
                maze[x][y + 1] = 'o';
                y += 1;
            }
            //go left
            else if (maze[x][y - 1] == 'x') {
                maze[x][y - 1] = 'o';
                y += -1;
            }
            //go up
            else if (maze[x - 1][y] == 'x') {
                maze[x - 1][y] = 'o';
                x += -1;
            }
        }

        print(maze);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("wrong");
        }
        return traverse(maze,x,y,start);
    }

    /**
     * prints the maze
     * @param maze 2d char array
     */
    public static void print(char maze[][])
    {
        for (int i=0;i <12;i++)
        {
            for (int j=0;j < 12;j++)
            {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println(' ');
        }
        System.out.println("--------------------------");
    }

}





